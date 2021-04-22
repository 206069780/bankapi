package com.bankapi.bankapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.bean.ParamResponseBean;
import com.bankapi.bankapi.bean.ParamResponseMessage;
import com.bankapi.bankapi.bean.RequestMessageBean;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.ApprovalProcessEventDetailsService;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.BankGetDataParamServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * @throws ParseException
     */
    @RequestMapping(value = "param", method = RequestMethod.POST)
    @ResponseBody
    public Object bankParam(@RequestBody JSONObject jsonObject) throws ParseException {

        String platformId = (String) jsonObject.get("platformId");
        String paltformSeqId = (String) jsonObject.get("paltformSeqId");
        String transCode = (String) jsonObject.get("transCode");
        String sign = (String) jsonObject.get("sign");
        String batchID = jsonObject.getString("batchID");
        String subsidyCode = jsonObject.getString("subsidyCode");
        String departmentId = jsonObject.getString("departmentId");

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat timeFormat = new SimpleDateFormat("HHmmss");
        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
        char status;

        System.out.println(batchID);
        int approvalProcessEventtatus =
                approvalProcessEventDaoServiceIml.statusUpdat(batchID);

        int approvalProcessEventDetails = approvalProcessEventDetailsService.statusUpdate(batchID);

        int saveParameter = bankGetDataParamServiceIml.DataParamSave(new BankGetDataParam(
                1L, platformId, subsidyCode, departmentId, batchID, new Date(), '0'
        ));
        if (approvalProcessEventtatus == 1
                && approvalProcessEventDetails == 1
                && saveParameter == 1
        ) {
            status = '1';
            return JSONObject.toJSON(
                    new ParamResponseBean(
                            platformId, paltformSeqId, date, time, transCode, sign,
                            new ParamResponseMessage(
                                    batchID,
                                    status
                            )
                    )
            );
        } else {
            status = '0';
            return
                    JSONObject.toJSON(
                            new ParamResponseBean(
                                    platformId, paltformSeqId, date, time, transCode, sign,
                                    new ParamResponseMessage(
                                            batchID,
                                            status
                                    )
                            )
                    );
        }
    }

}
