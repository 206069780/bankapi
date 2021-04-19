package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.UserStockRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.dao.dormatsysdao
 * @program: bankapi
 * @className: UserStockRoomDao
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  23:23
 * @description: UserStockRoomDao
 **/

@Mapper
public interface UserStockRoomDao {

    public List<UserStockRoom> getUserStockRoom();
}
