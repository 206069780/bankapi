package com.bankapi.bankapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.BankRecode;
import com.bankapi.bankapi.dao.dormatdao.ApprovalBatchReplyDao;
import com.bankapi.bankapi.dao.dormatdao.ApprovalProcessTaskBatchDao;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.iml.ApprovalBatchReplyServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessTaskBatchServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
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
    ApprovalBatchReplyServiceIml approvalBatchReplyDao;

    @Autowired
    ApprovalProcessTaskBatchServiceIml approvalProcessTaskBatchDao;

    @Autowired
    BankGetDataParamServiceIml bankGetDataParamServiceIml;

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventDaoServiceIml;

    public boolean readTxt(String fileName) {

        File file = new File(fileName);
        try {
            boolean res1, res2, res3;
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                line = line.trim();
                String[] lineArr = line.split(",");
                Map<BigDecimal, BigDecimal> map = approvalBatchReplyDao.getapprovalId(lineArr[0], lineArr[2]);
                ApprovalBatchReply approvalBatchReply = new ApprovalBatchReply(
                        12321,
                        String.valueOf(map.get("APPROVAL_ID")), //批次id
                        lineArr[0], //批次明细id
                        String.valueOf(map.get("ID")),
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
                System.out.println(approvalBatchReply.getBatchId());
                approvalBatchReplyDao.approvaDateSave(approvalBatchReply);

                // 保存文件数据
                res1 = bankGetDataParamServiceIml.DataParamUpDataParam(approvalBatchReply.getReplyStatus(), approvalBatchReply.getBatchId());

                // 更新明细状态
                res2 = approvalProcessEventDaoServiceIml.statusUpdat(approvalBatchReply.getBatchId(), "2", "2") > 0;

                // 发放状态
                res3 = approvalProcessTaskBatchDao.updateStatus(approvalBatchReply.getBatchId(), "2");

                return res3 && res1 && res2;
            }


        } catch (IOException e) {
            return false;
        }
        return false;
    }

}
