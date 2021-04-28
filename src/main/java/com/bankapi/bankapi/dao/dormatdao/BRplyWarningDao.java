package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.BRplyWarning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @packageName: com.bankapi.bankapi.dao.dormatdao
 * @program: bankapi
 * @className: BRplyWarningDao
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-28  20:42
 * @description: 反馈预警数据持久化操作
 **/

@Mapper
public interface BRplyWarningDao {
    public int save(BRplyWarning bRplyWarning);

    public int getLastestId();

    public String getUserId(@Param("id") String batch_id);
}
