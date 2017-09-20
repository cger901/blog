package com.saltedfish.blog.pojo;

import java.util.Date;

/**
 * 文章内容表
 * @author cc 2017/9/20
 */
public class Article {

	private long article_id;
	private long category_id;
	private long user_id;
	private String article_type;
	private String title;
	private String contents;
	private int is_open;
	private int is_bold;
	private int is_top;
	private int is_deleted;
	private Date create_time;
	private Date update_time;
	
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
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getArticle_type() {
		return article_type;
	}
	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getIs_open() {
		return is_open;
	}
	public void setIs_open(int is_open) {
		this.is_open = is_open;
	}
	public int getIs_bold() {
		return is_bold;
	}
	public void setIs_bold(int is_bold) {
		this.is_bold = is_bold;
	}
	public int getIs_top() {
		return is_top;
	}
	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}
	public int getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
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
