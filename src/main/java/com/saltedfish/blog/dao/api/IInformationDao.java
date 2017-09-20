package com.saltedfish.blog.dao.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.saltedfish.blog.pojo.Information;

@Repository
public interface IInformationDao {

	Information getInfo(@Param("user_id") long user_id);

}
