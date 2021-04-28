package com.bankapi.bankapi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.*;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.ApprovalProcessEventDetailsService;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import com.bankapi.bankapi.utils.AesUtils;
import com.bankapi.bankapi.utils.BankReplyMessage;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    ApprovalProcessEventDetailsService approvalProcessEventDetailsService;

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


    @Value("${KEY}")
    public static String key;

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
    public Object bankParam(@RequestBody JSONObject json) {

        //获取加密字符串
        String aesStr = (String) json.get("aesStr");

        //解密字符串 并转为json格式的文件
        JSONObject jsonObject = JSONObject.parseObject(aesStr);

        /*请求传递的数据*/
        //流水号
        String platformId = (String) jsonObject.get("platformId");
        //流水号
        String paltformSeqId = (String) jsonObject.get("paltformSeqId");

        //交易码
        String transCode = (String) jsonObject.get("transCode");

        //签名
        String sign = (String) jsonObject.get("sign");

        //批次id
        String batchID = jsonObject.getString("batchID");

        //部门号
        String subsidyCode = jsonObject.getString("subsidyCode");

        //部门id
        String departmentId = jsonObject.getString("departmentId");

        //交易日期
        String date = (String) jsonObject.get("date");

        //时间
        String time = (String) jsonObject.get("time");

        //文件校验和
        String md5 = (String) jsonObject.get("md5");

        //发放的数量
        int succCount = (int) jsonObject.get("succCount");

        //发放的金额
        int succAmt = (int) jsonObject.get("amt");

        String dataString = (String) jsonObject.get("dataString");

        String signChek = platformId+paltformSeqId+date+time+transCode+key+dataString;



        char status;


        /*更新批次状态*/
        int approvalProcessEventtatus = approvalProcessEventDaoServiceIml.statusUpdat(batchID, "2", "1");

        int approvalProcessEventDetails = approvalProcessEventDetailsService.statusUpdate(batchID, "0");

        boolean saveParameter = bankGetDataParamServiceIml.DataParamSave(new BankGetDataParam(
                1L, platformId, subsidyCode, departmentId, batchID, new Date(), '0'
        ));

        if (approvalProcessEventtatus == 1 && approvalProcessEventDetails == 1 && saveParameter
        ) {
            status = '1';
        } else {
            status = '0';
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
