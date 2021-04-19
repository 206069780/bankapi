package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.StockRoomDao;
import com.bankapi.bankapi.model.dormatsys.StockRoom;
import com.bankapi.bankapi.sevice.StockRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice.iml
 * @program: bankapi
 * @className: StockRoomServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  20:53
 * @description: TODO
 **/
public class StockRoomServiceIml implements StockRoomService {

    @Autowired
    StockRoomDao stockRoomDao;

    @Override
    public List<StockRoom> getAllStockRooms() {
        return stockRoomDao.getallStockRooms();
    }
}
