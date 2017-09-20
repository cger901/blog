package com.saltedfish.blog.pojo;

/**
 * 用户信息表
 * @author cc 2017/9/20
 */
public class User {

	private long user_id;
	private String username;
	private String password;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
