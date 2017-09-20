package com.saltedfish.blog.dao.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.saltedfish.blog.pojo.Category;

@Repository
public interface ICategoryDao {

	Category getCategory(@Param("category_id") long category_id);

}
