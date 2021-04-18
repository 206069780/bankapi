package com.bankapi.bankapi.controller;

import com.bankapi.bankapi.model.User;
import com.bankapi.bankapi.sevice.iml.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET)
    public List<User> getAllUsers(){

        return userServiceIml.findAllUsers();
    }
}
