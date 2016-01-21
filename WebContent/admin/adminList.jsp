<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../styles/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="../js/hideshow.js" type="text/javascript"></script>
	<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
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
    $(function(){
        $('.column').equalHeight();
    });
</script>
</head>
<body>
	<jsp:include page="/includes/adminTop.jsp" />	
    <jsp:include page="/includes/adminLeft.jsp" />
		
		<section id="main" class="column"> 
		
		<article class="module width_full">
			<header>
				<span class="head">管理者管理區</span>
			</header>
					
<div class="module_content">
				<hr>				
<c:if test="${not empty select}">	
<div id="wrap_table">	
<table>
	<thead>
	<tr>
<!-- 		<th>編號</th> -->
		<th>管理者帳號</th>
		<th>管理者名稱</th>
		<th>Email</th>
		<th>權限</th>
		<c:if test="${admin.state==1}">
			<th></th>
		</c:if>
		<th>建立時間</th>
		<th>修改時間</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="element" items="${select}">
	<c:url value="/admin/modifyAdmin.jsp" var="path">
							<c:param name="adminId" value="${element.adminId}" />
							<c:param name="adminPassword" value="${element.adminPassword}" />
							<c:param name="name" value="${element.name}" />
							<c:param name="email" value="${element.email}" />
						</c:url>
	<tr class="tb_tr">
		<c:if test="${admin.adminId==element.adminId}">
			<td><a href="${path}">${element.adminId}</a></td>
		</c:if>
		<c:if test="${admin.adminId!=element.adminId}">
			<td>${element.adminId}</a></td>
		</c:if>
		<td>${element.name}</td>
		<td>${element.email}</td>
		<td>
			<c:if test="${admin.state==1}"><!--如果最高權限者進入才有update按鈕-->
				<c:if test="${element.state!=1}"><!---->
					<form action="${pageContext.request.contextPath}/admin/AdminManager.controller?action=UpdateNum" method="GET">
						<input type="number" max="3" min="2" name="state"
							   value="${element.state}"> 
					    <input type="submit" name="action" value="修改"> 
					    <input type="hidden" name="Id" value="${element.adminId}">
					</form>
				</c:if>
			<c:if test="${element.state==1}">
			${element.state}
			</c:if>
		</c:if>
	<c:if test="${admin.state!=1}">
		${element.state}
	</c:if>
</td>
<c:if test="${admin.state==1}">
		<td>
			<c:if test="${admin.adminId!=element.adminId}">
				<a href="${pageContext.request.contextPath}/admin/AdminManager.controller?action=Delete&Id=${element.adminId}">
				<button name="action" value="Delete">刪除</button></a>
			</c:if>
		</td>
</c:if>
<c:set var="cd" value="${element.createDate}"/>
<c:set var="createDate" value="${fn:substring(cd,0,10)}"/>
<c:set var="ud" value="${element.updateDate}"/>
<c:set var="updateDate" value="${fn:substring(ud,0,10)}"/>
<td>${createDate}</td>
<td>${updateDate}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>	
</c:if>

<c:if test="${not empty pages}">
			  <ul class="pager">
			    
<%--  			    <c:set var="i" scope="session" value="${pages}"/>  --%>
<%-- 			  	<c:if test="${i != 1}"> --%>
<!-- 			   		 <li class="previous"><a href="javascript:;"><span aria-hidden="true"></span>上一頁</a></li> -->
<%-- 				</c:if> --%>
				
				<c:forEach var="j" begin="1" end="${pages}">
					<li class="pg_num">
						<a href="../news.controller/NewsQueryList?action=music&page=${j}">
							<c:out value="${j}"/>
						</a>
					</li>	
  				
  				</c:forEach>
  					
<%--   				<c:if test="${i != pages}"> --%>
<!-- 			    		<li class="next"><a href="javascript:;">下一頁<span aria-hidden="true"></span></a></li> -->
<%-- 			    </c:if> --%>
			 
			  </ul>
</c:if>
	</article>
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
				
				<div class="clear"></div>
				
				<nav>
			  
		</nav>
				
				
			</div>
		</article><!-- end of stats article -->	 
	 	</section> 
	 	
</body>

</html>