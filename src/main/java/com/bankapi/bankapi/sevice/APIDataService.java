package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.dao.dormatdao.APIDataDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName APIDataDaoService
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 上午11:15
 * @Description APIData 服务层 获取批次数据
 */
public interface APIDataService {

    public List<ApiData> getApiDataList() throws IOException;
}
