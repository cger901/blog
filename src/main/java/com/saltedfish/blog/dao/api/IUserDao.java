package com.saltedfish.blog.dao.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.saltedfish.blog.pojo.User;

@Repository
public interface IUserDao {

	User getUser(@Param("username") String username, @Param("password") String password);

}
