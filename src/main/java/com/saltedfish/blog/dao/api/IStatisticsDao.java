package com.saltedfish.blog.dao.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.saltedfish.blog.pojo.Statistics;

@Repository
public interface IStatisticsDao {

	Statistics getStatistics(@Param("article_id") long article_id);

	boolean appendStatistics(Statistics statistics);

}
