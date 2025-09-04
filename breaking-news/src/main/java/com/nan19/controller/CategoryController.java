package com.nan19.controller;

import com.nan19.pojo.Category;
import com.nan19.pojo.Result;
import com.nan19.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // TODO: 新增分类
    @PostMapping
    public Result addCategory(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success();
    }

    // TODO: 获取分类列表
    @GetMapping
    public Result<List<Category>> list() {
        List<Category> categories = categoryService.list();
        return Result.success(categories);
    }

    @GetMapping("/detail")
    // TODO: 获取文章分类详情
    public Result<Category> detail(Integer id) {
        Category category = categoryService.findById(id);
        return Result.success(category);
    }

    @PutMapping
    // TODO: 更新文章分类
    public Result updateCategory(@RequestBody @Validated(Category.Update.class) Category category){
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping
    // TODO: 删除文章分类
    public Result deleteCategory(Integer id) {
        categoryService.delete(id);
        return Result.success();
    }

}
