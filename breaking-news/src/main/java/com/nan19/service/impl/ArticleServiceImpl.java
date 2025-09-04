package com.nan19.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nan19.mapper.ArticleMapper;
import com.nan19.pojo.Article;
import com.nan19.pojo.PageBean;
import com.nan19.service.ArticleService;
import com.nan19.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        // 补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum, pageSize);

        // 3.调用Mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> articles = articleMapper.list(userId, categoryId, state);

        // Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        // 4.封装PageBean对象
        PageBean<Article> pageBean = new PageBean<>();
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setItems(pageInfo.getList());
        return pageBean;
    }
}
