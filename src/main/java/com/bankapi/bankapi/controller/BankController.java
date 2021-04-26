package com.bankapi.bankapi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.*;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.ApprovalProcessEventDetailsService;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import com.bankapi.bankapi.utils.BankReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("tp/bank/")
public class BankController {

    @Autowired
    private APIDataServiceIml apiDataServiceIml;

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventDaoServiceIml;

    @Autowired
    ApprovalProcessEventDetailsService approvalProcessEventDetailsService;

    @Autowired
    BankGetDataParamServiceIml bankGetDataParamServiceIml;

    /**
     * 银行获需要处理的批次条目
     *
     * @return
     */
    @RequestMapping(value = "api", method = RequestMethod.GET)
    @ResponseBody
    public RequestMessageBean getapiData() {

        List<ApiData> apiDataList = apiDataServiceIml.getApiDataList();

        return new RequestMessageBean("查询成功！", true, apiDataList);
    }

    /**
     * post json 接收参数
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "param", method = RequestMethod.POST)
    @ResponseBody
    public Object bankParam(@RequestBody JSONObject jsonObject) {

        /*请求传递的数据*/
        String platformId = (String) jsonObject.get("platformId");
        String paltformSeqId = (String) jsonObject.get("paltformSeqId");
        String transCode = (String) jsonObject.get("transCode");
        String sign = (String) jsonObject.get("sign");
        String batchID = jsonObject.getString("batchID");
        String subsidyCode = jsonObject.getString("subsidyCode");
        String departmentId = jsonObject.getString("departmentId");

        /*生成时间*/
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat timeFormat = new SimpleDateFormat("HHmmss");
        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
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


    @Autowired
    BankReplyMessage bankReplyMessage;

    @RequestMapping(value = "postfile", method = RequestMethod.POST)
    @ResponseBody
    public Object postfile(@RequestBody MultipartFile file) {

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String path = "/home/kali/IdeaProjects/bankapi/src/main/java/com/bankapi/bankapi/controller/";
            File dest = new File(path + fileName);
            try {
                file.transferTo(dest);
                if (bankReplyMessage.readTxt(dest.getAbsolutePath())) {
                    return "{\n" +
                            "\"status\":200,\n" +
                            "\"message\":\"资金发放结果反馈成功！\"\n" +
                            "}";
                } else return "false";
            } catch (IOException e) {
                return "false";
            }
        } else {
            return "文件上传失败";
        }

    }
}
