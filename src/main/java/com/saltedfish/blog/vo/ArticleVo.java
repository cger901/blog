package com.saltedfish.blog.vo;

import java.util.Date;

/**
 * 文章视图对象
 * @author cc 2017/9/20
 */
public class ArticleVo {

	private long article_id; // 编号
	private long category_id; // 类别编号
	private String category_name; // 类别名
	private String article_type; // 类型（关键字）
	private long author_id; // 作者编号
	private String author_name; // 作者名
	private String title; // 标题
	private boolean open; // 是否公开
	private boolean bold; // 标题是否加粗
	private boolean top; // 文章是否置顶
	private String contents; // 正文
	private long visit_count; // 浏览次数
	private Date create_time; // 创建时间
	private Date update_time; // 最后修改时间
	
	public long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(long article_id) {
		this.article_id = article_id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getArticle_type() {
		return article_type;
	}
	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}
	public long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isBold() {
		return bold;
	}
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	public boolean isTop() {
		return top;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public long getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(long visit_count) {
		this.visit_count = visit_count;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
}
