package com.saltedfish.blog.service.api;

import java.util.List;

import com.saltedfish.blog.vo.ArticleVo;
import com.saltedfish.blog.vo.TitleVo;

public interface IArticleService {

	/**
	 * 根据用户编号获取文章标题列表
	 * @param user_id 目标用户编号
	 * @param is_open 是否公开：0表示非公开/1表示公开
	 * @return 返回查询到的文章标题列表
	 */
	List<TitleVo> getListByUID(long user_id, int is_open);
	
	/**
	 * 根据文章编号获取文章
	 * @param article_id 目标文章编号
	 * @return 返回操作结果：获取成功返回查询到的文章实体/获取失败（文章不存在返回null）/获取失败（权限不足返回内容为null的文章实体）
	 */
	ArticleVo getArticle(long article_id);
	
	/**
	 * 根据文章编号和用户编号获取文章
	 * @param article_id 目标文章编号
	 * @param user_id 查询用户编号
	 * @return 返回操作结果：获取成功返回查询到的文章实体/获取失败（文章不存在返回null）/获取失败（权限不足返回内容为null的文章实体）
	 */
	ArticleVo getArticle(long article_id, long user_id);
	
	/**
	 * 添加新文章
	 * @param article 待添加的文章
	 * @return 返回操作结果：添加成功返回true/添加失败返回false
	 */
	long newArticle(ArticleVo article);
	
	boolean updateArticle(ArticleVo article);
	
	
	
}
