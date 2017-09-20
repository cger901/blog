package com.saltedfish.blog.pojo;

/**
 * 文章类别表
 * @author cc 2017/9/20
 */
public class Category {

	private long category_id;
	private String category_name;
	private String category_description;
	
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
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	
}
