package com.nan19.springbootmybatis.service.Impl;

import com.nan19.springbootmybatis.mapper.UserMapper;
import com.nan19.springbootmybatis.pojo.User;
import com.nan19.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findNameById(Integer id) {
        return userMapper.findNameById(id);
    }
}
