package com.nan19.springbootmybatis.service;

import com.nan19.springbootmybatis.pojo.User;

public interface UserService {
    public User findNameById(Integer id);
}
