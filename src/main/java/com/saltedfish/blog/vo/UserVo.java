package com.saltedfish.blog.vo;

import java.util.Date;

/**
 * 用户视图对象
 * @author cc 2017/9/20
 */
public class UserVo {

	private long user_id;
	private String nick_name;
	private String real_name;
	private Date birthday;
	private String email;
	private String qq;
	private String mobile;
	
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
	
	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", nick_name=" + nick_name + ", real_name=" + real_name + ", birthday="
				+ birthday + ", email=" + email + ", qq=" + qq + ", mobile=" + mobile + "]";
	}
	
}
