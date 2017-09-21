package com.saltedfish.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saltedfish.blog.service.api.IArticleService;
import com.saltedfish.blog.vo.ArticleVo;
import com.saltedfish.blog.vo.TitleVo;
import com.saltedfish.blog.vo.UserVo;

@Controller
public class ArticleController {

	@Resource
	private HttpSession session;
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "getarticlelist", params = "target_id")
	public String getArticleList(long target_id, Model model) {
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
			model.addAttribute("titleList", list);
		}
		if (list.isEmpty()) model.addAttribute("titleList", null);
		return "index";
	}
	
	@RequestMapping(value = "read", params = "article_id")
	@ResponseBody
	public ArticleVo getArticle(long article_id) {
		UserVo user = (UserVo) session.getAttribute("user");
		return user!= null? articleService.getArticle(article_id, user.getUser_id()): articleService.getArticle(article_id);
	}
	
	@RequestMapping(value = "doedit", params = "article_id")
	public String doEdit(long article_id, Model model) {
		UserVo user = (UserVo) session.getAttribute("user");
		if (user != null) {
			ArticleVo article = articleService.getArticle(article_id, user.getUser_id());
			if (article.getContents() != null) {
				model.addAttribute("article", article);
				System.out.println("开始编辑状态");
			}
		}
		return "edit";
	}
	
}
