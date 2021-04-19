package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.UserStockRoom;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice
 * @program: bankapi
 * @className: UserStockRoomService
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  23:35
 * @description: UserStockRoomService interface
 **/
public interface UserStockRoomService {

    public List<UserStockRoom> getUserStockRooms();
}
