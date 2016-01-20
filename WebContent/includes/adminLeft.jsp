<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<aside id="sidebar" class="column">
		<h3><span class="side_menu">上稿管理區</span></h3>
			<ul class="toggle">
				<li class="icn_photo"><a href="<c:url value='/news.controller/NewsQueryList?action=notice&page=1' />">公告管理 Notice</a></li>
			    <li class="icn_edit_article"><a href="<c:url value=''/>">文章管理 Article</a></li>
				<li class="icn_audio"><a href="<c:url value='/news.controller/NewsQueryList?action=music&page=1' />">演唱管理 Concert</a></li>
			</ul>
		<h3><span class="side_menu">餐點管理區</span></h3>
			<ul class="toggle">
				<li class="icn_categories"><a href="<c:url value='/admin/menuList.jsp'/>">餐點管理 Manage Menu </a></li>
				<li class="icn_edit_article"><a href="<c:url value='/admin/createFoodData.jsp'/>">新增餐點 Create Menu</a></li>
			</ul>
		<h3><span class="side_menu">產品管理區</span></h3>
			<ul class="toggle">
				<li class="icn_folder"><a href="<c:url value='/products.controller/ProductManager?page=1'/>">產品 Products</a></li>
				<li class="icn_photo"><a href="#">Gallery</a></li>
				<li class="icn_audio"><a href="#">Audio</a></li>
				<li class="icn_video"><a href="#">Video</a></li>
			</ul> 
		<h3><span class="side_menu">訂單管理區</span></h3>
			<ul class="toggle">
				<li class="icn_categories"><a name="action" href="<c:url value='/orders.controller/OrdersManager'/>">訂單管理</a></li>
			</ul>
		<h3><span class="side_menu">留言板管理區</span></h3>
			<ul class="toggle">
				<li class="icn_insert_message"><a href="${pageContext.request.contextPath }/admin/createMessage.jsp">新增留言</a></li>
				<li class="icn_resply_message"><a href="${pageContext.request.contextPath }/message.controller/MessageServlet">留言管理</a></li>
			</ul>
		<h3><span class="side_menu">會員與管理者</span></h3>
		<ul class="toggle">
		<c:if test="${state<3}">
		<li class="icn_settings"><a
			href="${pageContext.request.contextPath}/admin/register.jsp">新增管理者</a></li>
		</c:if>	
		<c:if test="${state==3}">
		<li class="icn_security">
			<a href="${pageContext.request.contextPath}/admin/stateTooLow.jsp">管理使用者</a>
		</li>
		</c:if>
		<c:if test="${state<3}">
		<li class="icn_security"><a
			href="${pageContext.request.contextPath}/admin/AdminListServlet.controller">管理使用者</a></li>
		</c:if>
		
		<li class="icn_jump_back"><a
			href="${pageContext.request.contextPath}/admin/Logout.controller">Logout</a></li>
	</ul>
	</aside><!-- end of sidebar -->
</body>
</html>