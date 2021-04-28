package com.bankapi.bankapi.controller;


import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.*;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventDetailsServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import com.bankapi.bankapi.utils.AesUtils;
import com.bankapi.bankapi.utils.BankReplyMessage;
import com.bankapi.bankapi.utils.SignUtil;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.controller
 * @ProjectName bankapi
 * @ClassName BankController
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 上午11:12
 * @Description 银行请求接口
 */


@Log4j2
@Controller
@RequestMapping("tp/bank/")
public class BankController {

    /*获取受理数据*/
    @Autowired
    private APIDataServiceIml apiDataServiceIml;

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventDaoServiceIml;

    @Autowired
    ApprovalProcessEventDetailsServiceIml approvalProcessEventDetailsServiceIml;

    @Autowired
    BankGetDataParamServiceIml bankGetDataParamServiceIml;

    @Autowired
    BankReplyMessage bankReplyMessage;

    /**
     * 银行获需要处理的批次条目
     *
     * @return
     */
    @RequestMapping(value = "api", method = RequestMethod.GET)
    @ResponseBody
    public RequestMessageBean getapiData() throws IOException {

        List<ApiData> apiDataList = apiDataServiceIml.getApiDataList();

        return new RequestMessageBean("查询成功！", true, apiDataList);
    }


    @Value("${AESKEY}")
    private String key;

    /**
     * 银行受理接口
     * 请求方式 POST
     * 请求参数 String 加密字符串
     *
     * @param json json数据
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "param", method = RequestMethod.POST)
    @ResponseBody
    public Object bankParam(@RequestBody JSONObject json) throws Exception {

        //获取加密字符串
        String aesStr = (String) json.get("aesStr");

        //解密字符串 并转为json格式的文件
        JSONObject jsonObject = JSONObject.parseObject(AesUtils.Decrypt(aesStr, key));

        /*请求传递的数据*/

        //交易日期
        String date = (String) jsonObject.get("platformTransDate");

        //流水号
        String platformId = (String) jsonObject.get("platformId");
        //流水号
        String paltformSeqId = (String) jsonObject.get("platformSeqId");

        //交易码
        String transCode = (String) jsonObject.get("transCode");

        //签名
        String sign = (String) jsonObject.get("sign");

        //时间
        String time = (String) jsonObject.get("platformTransTime");

        //dataString
        String dataString = (String) jsonObject.get("dataString");

        /*生成签名*/
        String signstr = SignUtil.getSign(platformId + paltformSeqId + date + time + transCode + key + dataString);
        //签名比较
        if (!signstr.equals(sign)) {
            return "签名错误";
        }

        //将 dataString 转为json格式
        JSONObject dataStringJson = JSONObject.parseObject(dataString);

        //批次id
        String batchID = dataStringJson.getString("batchId");

        //部门号
        String subsidyCode = dataStringJson.getString("subsidyCode");

        //部门id
        String departmentId = dataStringJson.getString("deptId");

        //文件校验和
        String md5 = (String) dataStringJson.get("md5");

        //发放的数量
        int succCount = (int) dataStringJson.get("succCount");

        //发放的金额
        int succAmt = (int) dataStringJson.get("amt");

        if (date.isEmpty() || date == null || platformId.isEmpty() || platformId == null ||
                paltformSeqId.isEmpty() || paltformSeqId == null || transCode.isEmpty() ||
                transCode == null || sign == null || sign.isEmpty() || time.isEmpty() ||
                time == null || dataString == null || dataString.isEmpty() || batchID == null ||
                batchID.isEmpty() || subsidyCode == null || subsidyCode.isEmpty() ||
                departmentId == null || departmentId.isEmpty() || md5 == null || md5.isEmpty()
        ) {
            return "参数不完全";
        }

        int status = 0;

        /*更新 APV_APPROVAL_BATCH 状态：  2 系统受理 ，审批中 1 */
        if (approvalProcessEventDaoServiceIml.findByid(batchID)) {

            //查询 batchID 的状态
            Map<String, String> statusMap = approvalProcessEventDaoServiceIml.getStatus(batchID);

            //如果批次已被受理，直接返回
            if (statusMap.get("BANK_NOTICE_TYPE").equals("2") && statusMap.get("STATUS").equals("1")) {
                return "批次已被受理，请勿重新提交";
            }

            //更新 APV_APPROVAL_BATCH 的状态
            approvalProcessEventDaoServiceIml.statusUpdat(batchID, "2", "1");
            log.info(batchID + " 已由系统受理，当前状态 审批中");

            /* APV_APPROVAL_BATCH_DETAIL 状态更新：  3 发放成功  4 发放失败 */
//            int approvalProcessEventDetails = approvalProcessEventDetailsServiceIml.statusUpdate(batchID, "0");

            /*判断 B_BANK_PARAMETER 是否存在该条记录*/
            if (bankGetDataParamServiceIml.findByid(batchID)){
                return "B_BANK_PARAMETER 已存在该批次";
            }

            /* B_BANK_PARAMETER 受理进度 0：已受理；1：已反馈；2：发放异常 */
            if (bankGetDataParamServiceIml.DataParamSave(
                    new BankGetDataParam(
                            1L, platformId, subsidyCode, departmentId, batchID, new Date(), '0')
            )) {
                status = 1;
                log.info(batchID + " save B_BANK_PARAMETER");
            } else {
                log.info("B_BANK_PARAMETER 无法存储: " + batchID);
            }
        } else {
            log.error("系统无法受理该批次[无法搜索到该批次]");
            status = 105;
        }
        return JSONObject.toJSON(
                new ParamResponseBean(
                        platformId, paltformSeqId, date, time, transCode, sign,
                        new ParamResponseMessage(
                                batchID,
                                status
                        )
                )
        );
    }

    @RequestMapping(value = "getParam", method = RequestMethod.GET)
    @ResponseBody
    public List<BankGetDataParam> getParam() {
        return bankGetDataParamServiceIml.getParam();
    }

    @RequestMapping(value = "finish", method = RequestMethod.GET)
    @ResponseBody
    public List<BankGetDataParam> getfinish() {
        return bankGetDataParamServiceIml.getfinish();
    }

    /**
     * 银行反馈文件提交
     *
     * @param file 提交的文件
     * @return
     */
    @RequestMapping(value = "postfile", method = RequestMethod.POST)
    @ResponseBody
    public Object postfile(@RequestBody MultipartFile file) {

        if (file == null) {
            return "文件上传错误";
        }
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String path = "/home/kali/IdeaProjects/bankapi/src/main/java/com/bankapi/bankapi/controller/";
            File dest = new File(path + fileName);
            try {
                file.transferTo(dest);
                JSONObject jsonObject = bankReplyMessage.readTxt(dest.getAbsolutePath());
                int status = (int) jsonObject.get("status");
                switch (status) {
                    case 1:
                        return "{\n" +
                                "\"status\":200,\n" +
                                "\"message\":\"资金发放结果反馈成功！\"\n" +
                                "}";
                    case 2:
                        log.error("发放失败" + jsonObject.get("fail") + "\n" + "失败原因：" + jsonObject.get("cause"));
                        return "{\n" +
                                "\"status\":200,\n" +
                                "\"message\":\"资金发放失败！\"\n" +
                                "}";
                }
            } catch (IOException e) {
                log.error("文件保存出现异常");
                return e.getMessage();
            }
        } else {
            log.error("文件上传错误");
            return "文件上传错误";
        }
        return "出现未知错误！请稍后访问";
    }
}
