package com.nan19.service;

import com.nan19.pojo.Article;
import com.nan19.pojo.PageBean;

public interface ArticleService {
    // 新增文章
    void add(Article article);

    // 文章分类列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
