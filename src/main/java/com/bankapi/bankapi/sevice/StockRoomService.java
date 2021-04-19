package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.StockRoom;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice
 * @program: bankapi
 * @className: StockRoomService
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  20:51
 * @description: TODO
 **/
public interface StockRoomService {

    /**
     * 获取所有股室
     */
    public List<StockRoom> getAllStockRooms();
}
