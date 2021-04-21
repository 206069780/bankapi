package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.bean.ApiData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName APIDataDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 上午9:29
 * @Description 银行获取需要需要受理的批次信息 数据持久化接口
 */

@Mapper
public interface APIDataDao {

    public List<ApiData> getApiDataList();
}
