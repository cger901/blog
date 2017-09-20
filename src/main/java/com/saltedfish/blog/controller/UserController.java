package com.saltedfish.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saltedfish.blog.service.api.IUserService;
import com.saltedfish.blog.vo.UserVo;

@RestController
public class UserController {

	@Resource
	private HttpSession session;
	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "login", params = {"username", "password"})
	public boolean login(String username, String password) {
		UserVo user = userService.login(username, password);
		if (user!=null) session.setAttribute("user", user);
		return user!=null? true: false;
	}
	
}
