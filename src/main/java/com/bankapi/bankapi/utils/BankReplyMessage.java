package com.bankapi.bankapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.iml.ApprovalBatchReplyServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessTaskBatchServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
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
 * @Description 读取 txt文件
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

            String line = "";
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                line = line.trim();
                String[] lineArr = line.split(",");

                Map<BigDecimal, BigDecimal> map = approvalBatchReplyServiceIml.getapprovalId(lineArr[0], lineArr[2]);
//                log.info(map.toString());
                String DTID = String.valueOf(map.get("ID"));
                String BTCHID = String.valueOf(map.get("APPROVAL_ID"));

                /* 判断 detailid 是否存在 */
                boolean hasDId = approvalBatchReplyServiceIml.findByDtilId(Integer.parseInt(DTID));

                //不存在->保存 存在->返回
                if (!hasDId) {
                    ApprovalBatchReply approvalBatchReply = new ApprovalBatchReply(
                            12321,
                            BTCHID, //批次id
                            lineArr[0], //批次明细id
                            DTID,
                            //银行流水单号
                            lineArr[6],
                            "",
                            lineArr[1],
                            "",
                            lineArr[3],
                            lineArr[7],
                            lineArr[4],
                            lineArr[5], //备注
                            "",
                            new Date()
                    );

                    /*将文件内容存入 APV_APPROVAL_BATCH_REPLY*/
                    if (approvalBatchReplyServiceIml.approvaDateSave(approvalBatchReply) > 0) {
                        log.info(approvalBatchReply.getDetailId()+" "+line + "发放成功");
                        if (bankGetDataParamServiceIml.DataParamUpDataParam(approvalBatchReply.getReplyStatus(), approvalBatchReply.getBatchId())) {
                            log.info("Update B_BANK_PARAMETER status ");
                            if (approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0) {
                                log.info("Update APV_APPROVAL_BATCH status");
                                //成功数据
                                sessuList.add(line);
                            }
                        }
                    }
                    // B_BANK_PARAMETER Status 更新
//                    res1 = bankGetDataParamServiceIml.DataParamUpDataParam(approvalBatchReply.getReplyStatus(), approvalBatchReply.getBatchId());

                    // 更新 APV_APPROVAL_BATCH 明细状态 type:银行处理方式 人工和系统 ，status 处理进度
//                    res2 = approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0;

                    // 发放状态
//                    res3 = approvalProcessTaskBatchDao.updateStatus(approvalBatchReply.getBatchId(), "2");
                } else {
                    //获取反馈失败的数据
                    log.error(line + "【已发放，请勿重复发放！！！】");
                    failList.add(line);
                }
            }
            log.info("【文件解析结束】");
            return failList.size() > 0 ? JSON.parseObject("{status:2,fail:\"" + failList + "\" ,cause:\"已发放，请勿重新发放 \",sessu:" + sessuList + "}") : JSON.parseObject("{status:1,sessu:" + sessuList + "}");

        } catch (IOException e) {
//            log.error("文件解析异常");
            return JSON.parseObject("{status:2,message:\"文件解析异常\"}");
        }

    }

}
