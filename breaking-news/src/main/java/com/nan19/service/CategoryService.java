package com.nan19.service;

import com.nan19.pojo.Category;

import java.util.List;

public interface CategoryService {
    // TODO: 新增分类
    void add(Category category);

    // TODO: 获取分类列表
    List<Category> list();

    // TODO: 获取文章分类详情
    Category findById(Integer id);

    // TODO: 更新文章分类
    void update(Category category);

    // TODO: 删除文章分类
    void delete(Integer id);
}
