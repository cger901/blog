<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>咸鱼博客</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#rerfush").on("click", function() {
			var target = $("input[name=target_id]");
			if (target.val() != null && target.val() > 0) {
				$("#content").text();
				$.ajax({
					url : "getarticlelist.sf",
					data : {
						target_id : $("input[name=target_id]").val()
					},
					success : function(result) {
						if (result == true) {
							$("#titleList").text("刷新成功");
						} else {
							$("#titleList").text("刷新失败");
						}
						window.location.href = "index.jsp";
					}
				})
			}
		})
		function getArticle(articleId) {
			$.ajax({
				url : "getarticle.sf",
				data : {
					article_id : articleId
				},
				success : function(result) {
					if (result == true) {
						$("#content").text(result);
					} else {
						$("#content").text();
					}
				}
			})
		}
	})
</script>
</head>
<body>
	当前登录用户：
	<c:choose>
		<c:when test="${user!=null}">${user.nick_name}</c:when>
		<c:otherwise>
			<a href="login.jsp">登录</a>
		</c:otherwise>
	</c:choose>
	<br /> 目标用户ID：
	<input type="text" name="target_id" />
	<a id="rerfush">获取文章列表</a>
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
							<td><a href="">${title.title}</a></td>
							<td>${title.editer_name}</td>
							<td>${title.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<div id="content"></div>
</body>
</html>