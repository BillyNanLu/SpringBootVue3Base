package com.nan19.controller;

import com.nan19.pojo.Result;
import com.nan19.pojo.User;
import com.nan19.service.UserService;
import com.nan19.utils.JwtUtil;
import com.nan19.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //TODO 注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        User user = userService.findByName(username);
        if (user == null) {
            // 没有占用
            // 注册
            userService.register(username, password);
            return Result.success();
        } else {
            // 占用
            return Result.error("用户名已存在");
        }
    }

    //TODO 登录
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByName(username);
        // 判断用户名是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确     loginUser对象中的password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 密码正确 生成jwt令牌 登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    // username: billy
    // password: billy123
}
