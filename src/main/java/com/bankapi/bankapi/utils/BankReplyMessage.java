package com.bankapi.bankapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.iml.ApprovalBatchReplyServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessTaskBatchServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    private List<String> list;
    public JSONObject readTxt(String fileName) {

        File file = new File(fileName);
        try {
            boolean res1=false, res2=false;
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            list = new ArrayList<String>();
            String line = "";
            while (bufferedReader.readLine()!=null) {
                line = bufferedReader.readLine();
                line = line.trim();
                String[] lineArr = line.split(",");
                Map<BigDecimal, BigDecimal> map = approvalBatchReplyServiceIml.getapprovalId(lineArr[0], lineArr[2]);
                String DTID = String.valueOf(map.get("ID"));
                String BTCHID = String.valueOf(map.get("APPROVAL_ID"));

                boolean hasDId = approvalBatchReplyServiceIml.findByDtilId(Integer.parseInt(DTID));
//                System.out.println(DTID);
//                System.out.println(hasDId);
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
                    System.out.println(line);

                    //判断 APV_APPROVAL_BATCH_REPLY 中是否存在该条反馈数据


                    /*将文件内容存入 APV_APPROVAL_BATCH_REPLY*/
                    approvalBatchReplyServiceIml.approvaDateSave(approvalBatchReply);

                    // 保存文件数据
                    res1 = bankGetDataParamServiceIml.DataParamUpDataParam(approvalBatchReply.getReplyStatus(), approvalBatchReply.getBatchId());

                    // 更新 APV_APPROVAL_BATCH 明细状态 type:银行处理方式 人工和系统 ，status 处理进度
                    res2 = approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0;

                    // 发放状态
//                    res3 = approvalProcessTaskBatchDao.updateStatus(approvalBatchReply.getBatchId(), "2");
                }
                //获取反馈失败的数据
                list.add(line);
            }
            return list.size() > 0 ? JSON.parseObject("{status:2,message:\""+new String(String.valueOf(list))+" 已发放，请勿重新发放 \"}") : JSON.parseObject("{status:1}");

        } catch (IOException e) {
            return JSON.parseObject("{status:2,message:\"文件解析异常\"}");
        }

    }

}
