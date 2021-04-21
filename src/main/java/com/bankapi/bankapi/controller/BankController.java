package com.bankapi.bankapi.controller;

import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.bean.RequestMessageBean;
import com.bankapi.bankapi.dao.dormatdao.APIDataDao;
import com.bankapi.bankapi.sevice.iml.APIDataServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    APIDataServiceIml apiDataServiceIml;

    /**
     * 银行获需要处理的批次条目
     **/
    @RequestMapping(value = "api", method = RequestMethod.GET)
    @ResponseBody
    public RequestMessageBean getapiData() {

        List<ApiData> apiDataList = apiDataServiceIml.getApiDataList();

        return new RequestMessageBean("查询成功！", true, apiDataList);
    }


}
