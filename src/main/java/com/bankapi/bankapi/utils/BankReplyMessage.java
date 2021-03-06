package com.bankapi.bankapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.model.dormat.BRplyWarning;
import com.bankapi.bankapi.sevice.iml.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName BankReplyMessage
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 上午10:50
 * @Description
 *              1、读取 txt文件
 *
 */

@Log4j2
@Component
public class BankReplyMessage {

    @Autowired
    ApprovalBatchReplyServiceIml approvalBatchReplyServiceIml;

    @Autowired
    ApprovalProcessTaskBatchServiceIml approvalProcessTaskBatchDao;

    @Autowired
    BankGetDataParamServiceIml bankGetDataParamServiceIml;

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventDaoServiceIml;

    @Autowired
    BRplyWarningServiceIml bRplyWarningServiceIml;

    private List<String> failList;
    private List<String> sessuList;

    public JSONObject readTxt(String fileName) {

        failList = new ArrayList<>();
        sessuList = new ArrayList<>();

        File file = new File(fileName);
        try {
//            boolean res1 = false, res2 = false;
            //输入流
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));

            //转为计算机可识别的格式
            BufferedReader bufferedReader = new BufferedReader(reader);

            /*受理条件入口标识*/
//            boolean isSL = true;
            String line = "";
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                line = line.trim();
                String[] lineArr = line.split(",");

                Map<BigDecimal, BigDecimal> map = approvalBatchReplyServiceIml.getapprovalId(lineArr[0], lineArr[2]);
//                log.info(map.toString());
                String DTID = String.valueOf(map.get("ID"));
                String APPROVAL_ID = String.valueOf(map.get("APPROVAL_ID"));

                /*优先判断该该批次是否完成受理？进行反馈流程:返回 105*/
                /*批次id*/
                String BATCH_ID = lineArr[0];
         /*       if (isSL) {
                    if (approvalBatchReplyServiceIml.findByBatchId(BATCH_ID)) {
                        log.error("系统未受理，无法进行反馈");
                        return JSON.parseObject("{status:2,message:\"批次 " + BATCH_ID + "未受理，先完成受理流程\"}");
                    } else {
                        isSL = false;
                    }
                }*/

                /*优先判断该该批次是否完成受理？进行反馈流程:返回 105*/
                /*批次id*/
                if (approvalBatchReplyServiceIml.findByBatchId(BATCH_ID)) {
                    log.error("系统未受理，无法进行反馈");
                    return JSON.parseObject("{status:2,message:\"批次 " + BATCH_ID + "未受理，先完成受理流程\"}");
                }

                // 判断 detailid 是否存在 不存在->保存 存在->返回
                if (!approvalBatchReplyServiceIml.findByDtilId(Integer.parseInt(DTID))) {

                    String getStrId = approvalBatchReplyServiceIml.getLastestId();
                    int id = getStrId == null ? 0 : Integer.parseInt(getStrId) + 1;

                    /*姓名*/
                    String name = lineArr[1];

                    //银行流水
                    String BRN = lineArr[6];

                    /*事发金额*/
                    String reAmt = lineArr[3];

                    /*发放时间*/
                    String reDate = lineArr[7];

                    /*发放状态*/
                    String reStatus = lineArr[4];

                    /*备注*/
                    String remark = lineArr[5];

                    /*实例化对象 -> 反馈数据的*/
                    ApprovalBatchReply approvalBatchReply = new ApprovalBatchReply(id, APPROVAL_ID, BATCH_ID, DTID, BRN, "", name,
                            "", reAmt, reDate, reStatus, remark, "", new Date());

                    /*将文件内容存入 APV_APPROVAL_BATCH_REPLY*/
                    if (approvalBatchReplyServiceIml.approvaDateSave(approvalBatchReply) > 0) {
                        log.info(line + " insert  into APV_APPROVAL_BATCH_REPLY");
                    } else {
                        log.error(line + " un insert  into APV_APPROVAL_BATCH_REPLY");
                    }

                    String getID = bRplyWarningServiceIml.getlastest();
                    int ID = Integer.parseInt(getID == null ? "0" : getID);

                    String CREATE_USER_ID = bRplyWarningServiceIml.getUserId(BATCH_ID);
                    if (reStatus.equals("02")) {
                        if (bRplyWarningServiceIml.save(new BRplyWarning(ID + 1, BATCH_ID, DTID, id, "0", remark, String.valueOf(CREATE_USER_ID), new Date()))) {
                            log.error(line + "反馈失败");
                            sessuList.add(line);
                        }
                    } else if (reStatus.equals("01")) {
                        log.info(line + "反馈成功");
                        //成功数据
                        sessuList.add(line);
                    } else {
                        log.info("未知错误");
                    }

                    /* B_BANK_PARAMETER 受理结果状态更新 */
                    if (bankGetDataParamServiceIml.DataParamUpDataParam("1", approvalBatchReply.getBatchId())) {
                        log.info("Update B_BANK_PARAMETER status ");
                    } else {
                        log.error("un Update B_BANK_PARAMETER status ");
                    }
                    if (approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0) {
                        log.info("Update APV_APPROVAL_BATCH status");
                    } else {
                        log.info("Un Update APV_APPROVAL_BATCH status");
                    }

                    // B_BANK_PARAMETER Status 更新
//                    res1 = bankGetDataParamServiceIml.DataParamUpDataParam(approvalBatchReply.getReplyStatus(), approvalBatchReply.getBatchId());

                    // 更新 APV_APPROVAL_BATCH 明细状态 type:银行处理方式 人工和系统 ，status 处理进度
//                    res2 = approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0;

                    // 发放状态
//                    res3 = approvalProcessTaskBatchDao.updateStatus(approvalBatchReply.getBatchId(), "2");
                } else {
                    //获取反馈失败的数据
                    log.error("【已反馈，请勿重复反馈！！！】" + line);
                    failList.add(line);
                }
            }
            log.info("【文件解析结束】");
            return failList.size() > 0 ? JSON.parseObject("{status:2,fail:\"" + failList + "\" ,cause:\"已反馈，请勿重新反馈 \",sessu:\"" + sessuList + "\"}") : JSON.parseObject("{status:1,sessu:\"" + sessuList + "\"}");

        } catch (IOException e) {
//            log.error("文件解析异常");
            return JSON.parseObject("{status:2,message:\"文件解析异常\"}");
        }

    }

}
