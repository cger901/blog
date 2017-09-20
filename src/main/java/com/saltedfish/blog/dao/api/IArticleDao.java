package com.saltedfish.blog.dao.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.saltedfish.blog.pojo.Article;

@Repository
public interface IArticleDao {

	List<Article> getListByUID(@Param("user_id") long user_id, @Param("is_open") int is_open);

	Article getArticle(@Param("article_id") long article_id);
	
}
