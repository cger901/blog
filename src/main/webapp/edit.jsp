<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8"
	src="utf8/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="utf8/ueditor.all.min.js">
	
</script>
<script type="text/javascript" charset="utf-8"
	src="utf8/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>编辑</title>
</head>
<body>
	标题：
	<input id="title" name="title" type="text" value="${article.title}" />
	<input type="radio" name="open" value="true"
		<c:if test="${article==null||article.open==true}">checked="checked"</c:if> />公开
	<input type="radio" name="open" value="false"
		<c:if test="${article!=null||article.open==false}">checked="checked"</c:if> />保密
	<select title="类别" name="category_id"><option value="1">未分类</option></select>
	<input type="text" name="article_type" value="${article.article_type}" />
	<input type="checkbox" name="bold"
		<c:if test="${article!=null&&article.bold}">checked="checked"</c:if> />加粗
	<input type="checkbox" name="top"
		<c:if test="${article!=null&&article.top}">checked="checked"</c:if> />置顶
	<script id="editor" name="content" type="text/plain">${article.contents}</script>
	<div id="btns">
		<button id="commit">保存提交并修改</button>
		<button id="drop">放弃修改并清空草稿箱</button>
	</div>
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
		$(function() {
			$("#commit").on("click", function() {
				if (UE.getEditor('editor').hasContents()) {
					setDisabled();
					$.ajax({
						url : "commit.sf",
						method : "post",
						data : {
							article_id : <c:choose><c:when test="${article!=null}">${article.article_id}</c:when><c:otherwise>0</c:otherwise></c:choose>,
							category_id : $("select").val(),
							article_type : $("input[name='article_type']").val(),
							author_id : <c:choose><c:when test="${user!=null}">${user.user_id}</c:when><c:otherwise>0</c:otherwise></c:choose>,
							title : $("input[name='title']").val(),
							open : $("input[name='open']:checked").val(),
							bold : $("input[name='bold']").prop('checked'),
							top : $("input[name='top']").prop('checked'),
							contents : UE.getEditor('editor').getContent()
						},
						success : function(result) {
							if (result == 0) {
								alert("提交失败！");
							} else {
								alert("文章编号：" + result + "，提交成功！");
								window.location.href = "getarticlelist.sf?target_id=" + <c:choose><c:when test="${user!=null}">${user.user_id}</c:when><c:otherwise>0</c:otherwise></c:choose>;
							}
						}
					})
					setEnabled();
				} else
					alert("正文不能为空！");
			})
		})
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}
		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}
	</script>
</body>
</html>