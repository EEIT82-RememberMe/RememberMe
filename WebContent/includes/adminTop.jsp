<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel="stylesheet" href="<c:url value='/styles/main.css'/> "> --%>

<!-- <script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
<script>
	$(window).load(function() {
		today = new Date();
		hours = today.getHours();

		if (hours < 12) {
			$("#hi").text("早安")
		}
		else {
			if ((hours > 12) && (hours < 18)) {
				$("#hi").text("午安");
			} else {
				$("#hi").text("晚安")
			}
		}
	});
</script>
<style type="text/css">
#adminTop {
	position: absolute;
	top: 0;
	height: 100px;
	width: 100%;
	background: #E0E0E3 url(../images/bg.jpg) repeat;
	border-bottom: 1px solid #5a5a5a;
	color: #bbb;
}

.headImg {
	height: 40px;
	width: 40px;
	border-radius: 20px;
	margin-top: -27%;
}
.headmenu li{
	float: right;
	list-style-type: none;
	padding-right: 15px;
	border-bottom:4px;
	font-size: 20px;
}
</style>
</head>
<body>
	<header id="adminTop">
	<h1>
		<a href="../admin/admin.jsp">Remember Me</a>
		<a href="<c:url value='/index.jsp'/>">view home</a>
	</h1>

	<div class="headmenu">

<!-- 		<li><a -->
<%-- 			href="${pageContext.request.contextPath}/admin/register.jsp">註冊</a></li> --%>
		<c:if test="${empty admin}">
			<li><a
				href="${pageContext.request.contextPath}/admin/Login.controller">登入</a></li>
		</c:if>
		<c:if test="${!empty admin}">
			<li><a
				href="${pageContext.request.contextPath}/admin/Logout.controller">登出</a></li>
			<c:if test="${!empty img}">
				<li class="imgLi"><a href="${pageContext.request.contextPath}/admin/modifyAdmin.jsp"><img src="data:image/png;base64,${img}" class="headImg"></a></li>
			</c:if>
			<c:if test="${empty img}">
				<li><a href="${pageContext.request.contextPath}/admin/modifyAdmin.jsp"><img src="/testHibernate0115/WebContent/images/cafeNight.jpg"></a></li>
			</c:if>
			<%-- 		<li>${admin.photo}</li> --%>
			<li><a href="${pageContext.request.contextPath}/admin/modifyAdmin.jsp">${admin.name}</a></li>
			<li><h9 id="hi"><h9></li>
		</c:if>
	</div>


	</header>
	<!-- end of header bar -->


</body>
</html>