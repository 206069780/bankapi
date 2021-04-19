package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.UserStockRoomDao;
import com.bankapi.bankapi.model.dormatsys.UserStockRoom;
import com.bankapi.bankapi.sevice.UserStockRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice.iml
 * @program: bankapi
 * @className: UserStockRoomServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  23:37
 * @description: TODO
 **/

@Service
public class UserStockRoomServiceIml implements UserStockRoomService {

    @Autowired
    UserStockRoomDao userStockRoomDao;

    @Override
    public List<UserStockRoom> getUserStockRooms() {
        return userStockRoomDao.getUserStockRoom();
    }
}
