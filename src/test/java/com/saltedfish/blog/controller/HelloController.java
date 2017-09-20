package com.saltedfish.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "hello")
	public String hello() {
		String str = "做一条有梦想的咸鱼！";
		return str;
	}
	
}
