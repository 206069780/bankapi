package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.StockRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.dao.dormatsysdao
 * @program: bankapi
 * @className: StockRoomDao
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  20:38
 * @description: StockRoomDao
 **/

@Mapper
public interface StockRoomDao {

    public List<StockRoom> getallStockRooms();
}
