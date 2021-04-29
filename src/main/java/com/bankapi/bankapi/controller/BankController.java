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
import com.bankapi.bankapi.utils.ParamUtils;
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

    @Autowired
    ParamUtils paramUtils;

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


        //交易码
        String transCode = (String) jsonObject.get("transCode");
        String date = (String) jsonObject.get("platformTransDate");

        //流水号
        String platformId = (String) jsonObject.get("platformId");
        //流水号
        String paltformSeqId = (String) jsonObject.get("platformSeqId");

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
            return "{status:105,message:\"签名错误\"}";
        }
        JSONObject dataStringJson = JSONObject.parseObject(dataString);

        /*判断受理 反馈 */
        if (transCode.equals("P2210002")) {

            //将 dataString 转为json格式

            return paramUtils.param1(dataStringJson, transCode, key, platformId, paltformSeqId, date, time, signstr);

        }
        if (transCode.equals("P2210003")) {

            return paramUtils.pram2(dataStringJson);
        }

        System.out.println(transCode + "4");
        return null;
    }

    /**
     * 银行反馈文件提交
     *
     * @param file 提交的文件
     * @return
     */
/*    @RequestMapping(value = "postfile", method = RequestMethod.POST)
    @ResponseBody
    public Object postfile(@RequestBody MultipartFile file) {

        *//* 判断 file 查看文件是否成功上传 *//*
        if (file == null) {
            log.error("文件上传失败");
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
                                "\"message\":\"反馈成功！\"\n" +
                                "}";
                    case 2:
                        log.error("反馈失败" + jsonObject.get("fail") + "\n" + "失败原因：" + jsonObject.get("cause"));
                        return "{\n" +
                                "\"status\":105,\n" +
                                "\"message\":\"反馈失败！\"\n" +
                                "}";
                }
            } catch (IOException e) {
                log.error(e.getMessage());
                return "文件上传异常";
            }
        } else {
            log.error("文件上传错误");
            return "文件上传错误";
        }
        return "出现未知错误！请稍后访问";
    }*/
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
}
