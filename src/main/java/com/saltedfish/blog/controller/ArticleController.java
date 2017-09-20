package com.saltedfish.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saltedfish.blog.service.api.IArticleService;
import com.saltedfish.blog.vo.TitleVo;
import com.saltedfish.blog.vo.UserVo;

@RestController
public class ArticleController {

	@Resource
	private HttpSession session;
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "getarticlelist", params = "target_id")
	public boolean getArticleList(long target_id) {
		UserVo user = (UserVo) session.getAttribute("user");
		List<TitleVo> list = null;
		if (target_id > 0) {
			// 目标编号与登录用户编号相符时，查询本人所有文章（未删除）
			if (user != null && user.getUser_id() == target_id) {
				System.out.println("self");
				list = articleService.getListByUID(user.getUser_id(), 0);
			}
			// 否则执行公开查询
			else {
				System.out.println("public");
				list = articleService.getListByUID(target_id, 1);
			}
			session.setAttribute("titleList", list);
		}
		if (list.isEmpty()) session.removeAttribute("titleList");
		return list!=null && !list.isEmpty()? true: false;
	}
	
}
