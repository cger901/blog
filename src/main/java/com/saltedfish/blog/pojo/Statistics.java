package com.saltedfish.blog.pojo;

/**
 * 统计数据表
 * @author cc 2017/9/20
 */
public class Statistics {

	private long statistics_id;
	private long article_id;
	private long visit_count;
	
	public long getStatistics_id() {
		return statistics_id;
	}
	public void setStatistics_id(long statistics_id) {
		this.statistics_id = statistics_id;
	}
	public long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(long article_id) {
		this.article_id = article_id;
	}
	public long getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(long visit_count) {
		this.visit_count = visit_count;
	}
	
}
