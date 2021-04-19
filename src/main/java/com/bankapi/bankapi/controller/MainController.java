package com.bankapi.bankapi.controller;

import com.bankapi.bankapi.model.dormatsys.Role;
import com.bankapi.bankapi.model.dormatsys.User;
import com.bankapi.bankapi.model.dormat.Department;
import com.bankapi.bankapi.model.dormatsys.UserStockRoom;
import com.bankapi.bankapi.sevice.iml.DepartmentServiceIml;
import com.bankapi.bankapi.sevice.iml.RoleServiceIml;
import com.bankapi.bankapi.sevice.iml.UserServiceIml;
import com.bankapi.bankapi.sevice.iml.UserStockRoomServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.controller
 * @program: bankapi
 * @className: MainController
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-18  22:42
 * @description: TODO
 **/

@Controller
@RequestMapping(value = "user")
public class MainController {

    @Autowired
    UserServiceIml userServiceIml;

    @Autowired
    DepartmentServiceIml departmentServiceIml;

    @ResponseBody
    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userServiceIml.findAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "getalldepartment", method = RequestMethod.GET)
    public List<Department> getDepartmentServiceIml() {
        return departmentServiceIml.getDepartmentList();
    }

    @RequestMapping(value = "UID", method = RequestMethod.GET)
    @ResponseBody
    public String UID() {
        Long uid = System.currentTimeMillis();
        if (uid % 2 == 0) {
            return uid + "L";
        } else {
            return "-" + uid + "L";
        }

    }

    @Autowired
    UserStockRoomServiceIml userStockRoomServiceIml;

    @ResponseBody
    @RequestMapping(value = "getUserStockRoom", method = RequestMethod.GET)
    public List<UserStockRoom> getUserStockRooms() {
        return userStockRoomServiceIml.getUserStockRooms();
    }

    @Autowired
    RoleServiceIml roleServiceIml;

    @ResponseBody
    @RequestMapping(value = "getAllRoles", method = RequestMethod.GET)
    public List<Role> getAllRoles(){
        return roleServiceIml.getALlRoles();
    }
}
