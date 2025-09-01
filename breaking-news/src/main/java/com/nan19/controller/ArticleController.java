package com.nan19.controller;

import com.nan19.pojo.Result;
import com.nan19.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
//TODO: ArticleController
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
        // TODO: token校验（拦截器WebConfig + LoginInterceptor）
        /*try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success("article list");
        } catch (Exception e) {
            // http状态码 401
            response.setStatus(401);
            return Result.error("未登录");
        }*/
        return Result.success("article list");
    }
}
