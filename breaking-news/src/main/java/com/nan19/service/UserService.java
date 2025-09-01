package com.nan19.service;

import com.nan19.pojo.User;

public interface UserService {
    // 根据用户名查询
    User findByName(String username);

    // 注册
    void register(String username, String password);
}
