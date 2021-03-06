package com.saltedfish.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.saltedfish.blog.dao.api.IArticleDao;
import com.saltedfish.blog.dao.api.ICategoryDao;
import com.saltedfish.blog.dao.api.IInformationDao;
import com.saltedfish.blog.dao.api.IStatisticsDao;
import com.saltedfish.blog.pojo.Article;
import com.saltedfish.blog.pojo.Category;
import com.saltedfish.blog.pojo.Information;
import com.saltedfish.blog.pojo.Statistics;
import com.saltedfish.blog.service.api.IArticleService;
import com.saltedfish.blog.vo.ArticleVo;
import com.saltedfish.blog.vo.TitleVo;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Resource
	private IArticleDao articleDao;
	@Resource
	private ICategoryDao categoryDao;
	@Resource
	private IStatisticsDao statisticsDao;
	@Resource
	private IInformationDao informationDao;

	/**
	 * 创建文章视图对象
	 * @param category 文章类别对象
	 * @param article 文章内容对象
	 * @param statistics 统计数据对象
	 * @param information 用户详情对象
	 * @return 返回包装后的文章视图对象
	 */
	private ArticleVo getArticleVo(Category category, Article article, Statistics statistics, Information information) {
		ArticleVo result = null;
		if (category!=null && article!=null && statistics!=null && information!=null && category.getCategory_id()==article.getCategory_id() && statistics.getArticle_id()== article.getArticle_id() && article.getUser_id()==information.getUser_id()) {
			result = new ArticleVo();
			result.setArticle_id(article.getArticle_id());
			result.setCategory_id(category.getCategory_id());
			result.setCategory_name(category.getCategory_name());
			result.setArticle_type(article.getArticle_type());
			result.setTitle(article.getTitle());
			result.setEditer_name(information.getNick_name());
			result.setContents(article.getContents());
			result.setIs_top(article.getIs_top()==1? true: false);
			result.setIs_bold(article.getIs_bold()==1? true: false);
			result.setCount(statistics.getVisit_count());
			result.setCreate_time(article.getCreate_time());
			result.setUpdate_time(article.getUpdate_time());
		}
		return result;
	}

	/**
	 * 创建标题视图对象
	 * @param category 文章类别对象
	 * @param article 文章内容对象
	 * @param statistics 统计数据对象
	 * @param information 用户详情对象
	 * @return 返回包装后的标题视图对象
	 */
	private TitleVo getTitleVo(Category category, Article article, Statistics statistics, Information information) {
		TitleVo result = null;
		if (category!=null && article!=null && information!=null && category.getCategory_id()==article.getCategory_id() && article.getUser_id()==information.getUser_id()) {
			result = new TitleVo();
			result.setArticle_id(article.getArticle_id());
			result.setCategory_id(category.getCategory_id());
			result.setCategory_name(category.getCategory_name());
			result.setArticle_type(article.getArticle_type());
			result.setTitle(article.getTitle());
			result.setEditer_name(information.getNick_name());
			result.setIs_top(article.getIs_top()==1? true: false);
			result.setIs_bold(article.getIs_bold()==1? true: false);
			// 若当前文章没有统计信息，则为其创建一条新统计
			if (statistics==null || statistics.getArticle_id()!= article.getArticle_id()) {
				statistics = new Statistics();
				statistics.setStatistics_id(0);
				statistics.setArticle_id(article.getArticle_id());
				statistics.setVisit_count(0);
				statisticsDao.appendStatistics(statistics);
				System.out.println("为文章编号" + article.getArticle_id() + "自动创建了一条新统计" + statistics);
			}
			result.setCount(statistics.getVisit_count());
			result.setCreate_time(article.getCreate_time());
			result.setUpdate_time(article.getUpdate_time());
		}
		return result;
	}

	/**
	 * 更新文章访问次数
	 * @param article_id 目标文章编号
	 */
	private void visitArticle(long article_id) {
		Statistics statistics = statisticsDao.getStatistics(article_id);
		if (statistics!=null) {
			statistics.setVisit_count(statistics.getVisit_count() + 1);
		}
	}

	@Override
	public List<TitleVo> getListByUID(long user_id, int is_open) {
		// 创建结果集
		List<TitleVo> response = new ArrayList<>();
		// 根据用户编号获取用户详情
		Information information = informationDao.getInfo(user_id);
		// 根据用户编号查询文章列表
		List<Article> articles = articleDao.getListByUID(user_id, is_open);
		for (Article article : articles) {
			long article_id = article.getArticle_id();
			Category category = categoryDao.getCategory(article.getCategory_id());
			Statistics statistics = statisticsDao.getStatistics(article_id);
			response.add(getTitleVo(category, article, statistics, information));
		}
		return response;
	}

	@Override
	public ArticleVo getArticle(long article_id) {
		ArticleVo response = null;
		// 获取文章
		if (article_id > 0) {
			Article article = articleDao.getArticle(article_id);
			Category category = categoryDao.getCategory(article.getCategory_id());
			Statistics statistics = statisticsDao.getStatistics(article_id);
			// 若当前文章没有统计信息，则为其创建一条新统计
			if (statistics==null || statistics.getArticle_id()!= article.getArticle_id()) {
				statistics = new Statistics();
				statistics.setStatistics_id(0);
				statistics.setArticle_id(article.getArticle_id());
				statistics.setVisit_count(0);
				statisticsDao.appendStatistics(statistics);
				System.out.println("为文章编号" + article.getArticle_id() + "自动创建了一条新统计" + statistics);
			}
			Information information = informationDao.getInfo(article.getUser_id());
			response = getArticleVo(category, article, statistics, information);
		}
		// 更新访问次数
		visitArticle(article_id);
		return response;
	}

	@Override
	public ArticleVo getArticle(long article_id, long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean newArticle(ArticleVo article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(ArticleVo artcle) {
		// TODO Auto-generated method stub
		return false;
	}

}
