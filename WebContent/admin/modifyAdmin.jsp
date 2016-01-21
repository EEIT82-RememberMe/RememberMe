
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>RememberMe後台管理系統</title>

<link rel="stylesheet" href="../styles/layout.css" type="text/css"
	media="screen" />

<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="../js/hideshow.js" type="text/javascript"></script>
<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".tablesorter").tablesorter();
	});
	$(document).ready(function() {

		//When page loads...
		$(".tab_content").hide(); //Hide all content
		$("ul.tabs li:first").addClass("active").show(); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
		$("ul.tabs li").click(function() {

			$("ul.tabs li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content

			var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active ID content
			return false;
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$('.column').equalHeight();
	});
</script>
<style>
.register {
	/* * 		position:relative;z-index:9;  */
/* 	background-image: url(../images/greybg.jpg); */
background-color:black !important;
}

.regbody {
	position: absolute;
	top: 130px;
	margin: 0px 0px 100px 600px;
	text-align: center;
}

input.input {
	padding: 7px 15px 7px 45px;
	font-size: 16px;
	background-color: rgba(35, 37, 35, 0.4);
	border-radius: 4px;
	border: 1px solid rgba(185, 185, 185, 0.35);
	color: #bbb;
	margin: 10px;
	height: 30px;
	width: 250px;
	/* 	box-shadow: 0 1px 0 #fff; */
}
.field {
	overflow: hidden;
}
input.sub {
	font-size: 16px;
/* 	background-color: rgba(250, 255, 244, 0.08); */
	border-radius: 5px;
	border: 1px solid rgba(185, 185, 185, 0.35);
	color: black;
	text-align: center;
	margin: 10px 40px 0 30px;
	cursor: pointer;
/* 	font-weight: bold; */
	box-shadow: 0 1px 0 #fff;
}
.err{
color:red;}
.page-title
{
	color:burlywood;
}
.a
{
	color:burlywood;
}
</style>
</head>


<body class="register">

	
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />

	<div class="regbody">
		<h2 class="page-title">修改個人資料<hr></h2>
		<c:if test="${empty admin}">
			<c:redirect url="/admin/Login.jsp"></c:redirect>
		</c:if>

		<form action="${pageContext.request.contextPath}/AdminChange"
			method="POST" class="input" enctype="multipart/form-data">
			<div class="field">
				<input type="hidden" name="adminId" value="${admin.adminId}">
<%-- 				<p>您的舊密碼為：${admin.adminPassword}</p> --%>
				<input type="hidden" class="input" placeholder="OldPassword"
					name="oldPass" value="${admin.adminPassword}" /><span>${errors.adminPassword}</span><br>
				<input type="password" class="input" placeholder="Password"
					name="newPass" value="${admin.adminPassword}" /><span>${errors.newPass}</span><br> <input
					type="password" class="input" placeholder="再次輸入密碼" name="confirmPass" value="${admin.adminPassword}"/><span>${errors.confirmPass}</span><span>${errors.passEqual}</span><br>
				<input type="text" class="input" placeholder="Name" name="name"
					value="${admin.name}" /><span>${errors.name}</span><br> <input
					type="email" class="input" placeholder="Email" name="email"
					value="${admin.email}" /><br> <input type="file" class="input"
					placeholder="照片" name="photo" /><br> <label></label><input
					type="submit" value="送出" class="sub" /> <label></label><input
					type="reset" value="重填" class="sub" />
			</div>
		</form>
	</div>

</body>

</html>

