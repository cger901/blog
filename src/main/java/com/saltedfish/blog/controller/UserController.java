package com.saltedfish.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saltedfish.blog.common.Const;
import com.saltedfish.blog.service.api.IUserService;
import com.saltedfish.blog.vo.UserVo;

@Controller
public class UserController {

	@Resource
	private HttpSession session;
	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "login", params = {"username", "password"})
	@ResponseBody
	public boolean login(String username, String password) {
		UserVo user = userService.login(username, password);
		if (user!=null) session.setAttribute(Const.CURRENT_USER, user);
		return user!=null? true: false;
	}
	
	@RequestMapping(value = "logout")
	public String logout() {
		if (session.getAttribute(Const.CURRENT_USER) != null) {
			session.removeAttribute(Const.CURRENT_USER);
		}
		return "index";
	}
	
}
