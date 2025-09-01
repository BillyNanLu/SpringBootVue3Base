package com.nan19.mapper;

import com.nan19.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户信息
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user(username, password, create_time, update_time)" +
            "values(#{username}, #{password}, now(), now())")
    void add(String username, String password);
}
