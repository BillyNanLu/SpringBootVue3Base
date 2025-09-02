package com.nan19.service;

import com.nan19.pojo.User;

public interface UserService {
    // 根据用户名查询
    User findByName(String username);

    // 注册
    void register(String username, String password);

    // 更新用户信息
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
