package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName BankGetDataParamDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午3:43
 * @Description 银行获取数据  传递的参数 数据持久化
 */
@Mapper
public interface BankGetDataParamDao {

    /**
     * 保存银行受理的批次信息
     * @param bank 批次相关信息
     * @return 增加的数据行数
     */
    public int DataParamSave(BankGetDataParam bank);
}
