<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>咸鱼博客</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#rerfush").on("click", function() {
			var target = $("input[name=target_id]");
			if (target.val() != null && target.val() > 0) {
				$("#titleList").text("查询中，请稍候……");
				$("#content").text();
				window.location.href = "getarticlelist.sf?target_id=" + $("input[name=target_id]").val();
			}
		})
	})
	function getArticle(articleId) {
		$("#content").text("查询中，请稍候……");
		$.ajax({
			url : "read.sf",
			data : {
				article_id : articleId
			},
			success : function(result) {
				if (result == null) {
					$("#content").text("文章不存在或已经删除！");
				} else if (result.contents == null) {
					$("#content").text("您的访问权限不足！");
				} else {
					$("#content").text(result.contents);
				}
			}
		})
	}
	function doEdit(articleId) {
		window.location.href = "doedit.sf?article_id=" + articleId;
	}
</script>
</head>
<body>
	当前登录用户：
	<c:choose>
		<c:when test="${user!=null}">${user.nick_name} <a
				href="logout.sf">注销</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">登录</a>
		</c:otherwise>
	</c:choose>
	<br /> 目标用户ID：
	<input type="text" name="target_id" />
	<button id="rerfush">获取文章列表</button>
	<br />
	<div id="titleList">
		<c:if test="${titleList!=null}">
			<table>
				<thead>
					<tr>
						<td>类别</td>
						<td>类型</td>
						<td>标题</td>
						<td>作者</td>
						<td>访问次数</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${titleList}" var="title">
						<tr>
							<td>${title.category_name}</td>
							<td>${title.article_type}</td>
							<td>
								<c:choose>
									<c:when test="${title.bold}">
										<b><a href="javascript:getArticle(${title.article_id})">${title.title}</a></b>
									</c:when>
									<c:otherwise>
										<a href="javascript:getArticle(${title.article_id})">${title.title}</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td>${title.author_name}</td>
							<td>${title.visit_count}</td>
							<c:if test="${user!=null && user.user_id==title.author_id}">
								<td><button onclick="doEdit(${title.article_id})">编辑</button></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<br />
	<div id="content"></div>
</body>
</html>