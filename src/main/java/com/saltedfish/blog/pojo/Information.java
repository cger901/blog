package com.saltedfish.blog.pojo;

import java.util.Date;

/**
 * 用户详情表
 * @author cc 2017/9/20
 */
public class Information {

	private long info_id;
	private long user_id;
	private String nick_name;
	private String real_name;
	private Date birthday;
	private String email;
	private String qq;
	private String mobile;
	
	public long getInfo_id() {
		return info_id;
	}
	public void setInfo_id(long info_id) {
		this.info_id = info_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
