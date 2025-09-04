package com.nan19.controller;

import com.nan19.pojo.Article;
import com.nan19.pojo.PageBean;
import com.nan19.pojo.Result;
import com.nan19.service.ArticleService;
import com.nan19.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
//TODO: ArticleController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // TODO 新增文章
    @PostMapping
    public Result add(@RequestBody @Validated Article article)  {
        articleService.add(article);
        return Result.success();
    }

    // TODO: 文章分类列表查询
    @GetMapping
    public Result<PageBean<Article>> list (
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pageBean = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pageBean);
    }





    /*@GetMapping("/list")
    public Result<String> list(*//*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*//*) {
        // TODO: token校验（拦截器WebConfig + LoginInterceptor）
        *//*try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success("article list");
        } catch (Exception e) {
            // http状态码 401
            response.setStatus(401);
            return Result.error("未登录");
        }*//*
        return Result.success("article list");
    }*/
}
