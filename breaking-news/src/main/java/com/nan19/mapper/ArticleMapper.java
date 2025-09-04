package com.nan19.mapper;

import com.nan19.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    // 新增文章
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user ,create_time, update_time)" +
            "values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    // 文章分类列表查询
    List<Article> list(Integer userId, Integer categoryId, String state);
}
