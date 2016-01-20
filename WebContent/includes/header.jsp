<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 最新編譯和最佳化的 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <!-- 選擇性佈景主題 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <!-- 最新編譯和最佳化的 JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <!-- bootstrap.js & css -->
<link rel="stylesheet" href="<c:url value='/styles/header.css'/> ">
</head>
<body>
	<div id="header">
		<div class="hd-bg">
			<div class="container">
				<div class="row">
					<nav class="navbar navbar-inverse" role="navigation">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="<c:url value='/index.jsp'/>">Remember Me</a>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<!--li class="active"-->
								<li><a href="<c:url value='/pages/about.jsp'/>">簡介about <span class="sr-only">(current)</span></a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-expanded="false">消息news
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="<c:url value='/pages/notice.jsp'/>">公告notice</a></li>
<!-- 										<li><a href="#">文章article</a></li> -->
										<li><a href="<c:url value='/pages/music.jsp?page=1'/>">演唱concert</a></li>
									</ul></li>
								<!-- .dropdown -->
								<li><a href="<c:url value='/pages/menu.jsp'/>">餐點menu</a></li>
								<li><a href="<c:url value='/pages/products.jsp'/>">產品goods</a></li>
								<li><a href="${pageContext.request.contextPath}/message.controller/ProcessMessage">聯絡contact</a></li>	
							</ul>
							<!-- .nav .navbar-nav -->
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid --> </nav>
					<div id="functions">
						<ul class="">
							<li id="cart"><a href="<c:url value='/pages/cart.jsp'/>"><img src="../images/cart.png"> <strong></strong> <span>0</span>
							</a></li>
							<%
								if (session.getAttribute("user") == null) {
							%>
							<li><a href="<c:url value='/pages/login.jsp'/>">登入</a></li>
							<li><a href="<c:url value='/pages/register.jsp'/>"> 註冊</a></li>
							<%
								} else {
							%>
							<li><a href="${pageContext.request.contextPath}/orders.controller/OrdersMember" class="navbar-link">${user.name}</a></li>
							<li><a
								href="${pageContext.request.contextPath}/member.controller/ProcessLogout">登出</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>