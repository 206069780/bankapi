package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.bean.BankIssuedData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName BankIssuedDataDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 下午5:40
 * @Description BankIssuedData 获取数据
 */

@Mapper
public interface BankIssuedDataDao {

    public List<BankIssuedData> getBankIssuedDataList();
}
