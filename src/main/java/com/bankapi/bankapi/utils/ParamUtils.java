package com.bankapi.bankapi.utils;

import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.ParamResponseBean;
import com.bankapi.bankapi.bean.ParamResponseMessage;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventDetailsServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName ParamUtils
 * @Email fudaopin@gamil.com
 * @date 2021/4/29 下午4:07
 * @Description 受理 反馈
 */

@Log4j2
@Component
public class ParamUtils {

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventDaoServiceIml;

    @Autowired
    ApprovalProcessEventDetailsServiceIml approvalProcessEventDetailsServiceIml;

    @Autowired
    BankGetDataParamServiceIml bankGetDataParamServiceIml;

    @Autowired
    BankReplyMessage bankReplyMessage;

    public Object param1(JSONObject dataString, String transCode, String key, String platformId, String paltformSeqId, String date, String time, String sign) {

        //批次id
        String batchID = dataString.getString("batchId");

        //部门号
        String subsidyCode = dataString.getString("subsidyCode");

        //部门id
        String departmentId = dataString.getString("deptId");

        //文件校验和
        String md5 = (String) dataString.get("md5");

        //发放的数量
        int succCount = (int) dataString.get("succCount");

        //发放的金额
        int succAmt = (int) dataString.get("amt");

        int status = 0;

        /*判断是否存在该批次*/
        if (approvalProcessEventDaoServiceIml.findByid(batchID)) {

            //查询 batchID 的状态
            Map<String, String> statusMap = approvalProcessEventDaoServiceIml.getStatus(batchID);

            //如果批次已被受理，直接返回
            if (statusMap.get("BANK_NOTICE_TYPE").equals("2") && statusMap.get("STATUS").equals("1")) {
                return "{status:105,message:\"批次已被受理,请勿重复提交受理\"}";
            }

            /*判断 B_BANK_PARAMETER 是否存在该条记录*/
            if (bankGetDataParamServiceIml.findByid(batchID)) {

                return "{status:105,message:\"批次已被受理,请勿重复提交受理\"}";
            }

            /*更新 APV_APPROVAL_BATCH 状态：  2 系统受理 ，审批中 1 */
            approvalProcessEventDaoServiceIml.statusUpdat(batchID, "2", "1");
            log.info(batchID + " 已由系统受理，当前状态 审批中");

            /* B_BANK_PARAMETER 受理进度 0：已受理；1：已反馈；2：发放异常 */
            if (bankGetDataParamServiceIml.DataParamSave(new BankGetDataParam(1L, platformId, subsidyCode, departmentId, batchID, new Date(), '0'))) {
                status = 200;
                log.info(batchID + " save B_BANK_PARAMETER 等待银行反馈");

            } else {
                log.info("B_BANK_PARAMETER 无法存储: " + batchID);
                return "{status:105,message:\"受理异常中断\"}";
            }

        } else {
            log.error("系统无法受理该批次[无法搜索到该批次]");
            status = 105;
        }
        return JSONObject.toJSON(new ParamResponseBean(platformId, paltformSeqId, date, time, transCode, sign,
                new ParamResponseMessage(batchID, status)));
    }


    public Object pram2(JSONObject dataString) throws IOException {

        String fileName = dataString.getString("fileName");
        String filePath = "/home/kali/IdeaProjects/bankapi/src/main/java/com/bankapi/bankapi/controller/test.txt";
        File dest = new File(filePath);

        //文件校验和
        String md5 = (String) dataString.get("md5");

        if (!CheckSum.fileCS(filePath).equals(md5)) {
            log.error("文件校验和不匹配");
            return "{status:105,message:\"文件检验和不匹配\"}";
        }
        String batchID = dataString.getString("batchId");
        String subsidyCode = dataString.getString("subsidyCode");
        //部门id
        String departmentId = dataString.getString("deptId");

        int count = dataString.getIntValue("count");
        int amt = dataString.getIntValue("amt");
        //发放的数量
        String succCount = dataString.getString("succCount");
        //发放的金额
        String succAmt =  dataString.getString("amt");

        JSONObject jsonObject = bankReplyMessage.readTxt(filePath);
        int status = (int) jsonObject.get("status");
        switch (status) {
            case 1:
                return "{\n" +
                        "\"status\":200,\n" +
                        "\"message\":\"反馈成功！\"\n" +
                        "}";
            case 2:
                log.error("反馈失败" + jsonObject.get("fail") + "\n" + "失败原因：" + jsonObject.get("cause"));
                return "{\n" +
                        "\"status\":105,\n" +
                        "\"message\":\"反馈失败！\"\n" +
                        "}";
        }
        return "";
    }

}
