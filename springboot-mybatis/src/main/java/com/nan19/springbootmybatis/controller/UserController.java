package com.nan19.springbootmybatis.controller;

import com.nan19.springbootmybatis.pojo.User;
import com.nan19.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findNameById")
    public User findNameById(Integer id) {
        return userService.findNameById(id);
    }
}
