package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.dao.dormatdao.APIDataDao;
import com.bankapi.bankapi.sevice.APIDataService;
import com.bankapi.bankapi.utils.CheckSum;
import com.bankapi.bankapi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName APIDataServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 上午11:16
 * @Description implements APIDataService
 */

@Service
public class APIDataServiceIml implements APIDataService {


    @Autowired
    APIDataDao apiDataDao;

    @Autowired
    StringUtils stringUtils;

    @Override
    public List<ApiData> getApiDataList() {

        List<ApiData> list = apiDataDao.getApiDataList();
        list.forEach(apiData -> apiData.setPlatFormId(stringUtils.getRandomString()));
        return list;
    }

}
