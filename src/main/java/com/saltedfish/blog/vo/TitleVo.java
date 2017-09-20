package com.saltedfish.blog.vo;

import java.util.Date;

/**
 * 标题视图对象
 * @author cc 2017/9/20
 */
public class TitleVo {

	private long article_id; // 编号
	private long category_id; // 类别编号
	private String category_name; // 类别名
	private String article_type; // 类型（关键字）
	private String editer_name; // 作者名
	private String title; // 标题
	private boolean is_bold; // 标题是否加粗
	private boolean is_top; // 文章是否置顶
	private long count; // 浏览次数
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
	public String getEditer_name() {
		return editer_name;
	}
	public void setEditer_name(String editer_name) {
		this.editer_name = editer_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isIs_bold() {
		return is_bold;
	}
	public void setIs_bold(boolean is_bold) {
		this.is_bold = is_bold;
	}
	public boolean isIs_top() {
		return is_top;
	}
	public void setIs_top(boolean is_top) {
		this.is_top = is_top;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
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
	
	@Override
	public String toString() {
		return "TitleVo [article_id=" + article_id + ", category_id=" + category_id + ", category_name=" + category_name
				+ ", article_type=" + article_type + ", editer_name=" + editer_name + ", title=" + title + ", is_bold="
				+ is_bold + ", is_top=" + is_top + ", count=" + count + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}
	
}
