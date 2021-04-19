package com.bankapi.bankapi.controller;

import com.bankapi.bankapi.model.dormatsys.User;
import com.bankapi.bankapi.model.dormat.Department;
import com.bankapi.bankapi.sevice.iml.DepartmentServiceIml;
import com.bankapi.bankapi.sevice.iml.UserServiceIml;
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
    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userServiceIml.findAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "getalldepartment",method = RequestMethod.GET)
    public List<Department> getDepartmentServiceIml() {
        return departmentServiceIml.getDepartmentList();
    }
}
