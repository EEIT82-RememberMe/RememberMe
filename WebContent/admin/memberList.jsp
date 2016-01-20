<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	
	<link rel="stylesheet" href="../styles/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="../js/hideshow.js" type="text/javascript"></script>
	<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	<script type="text/javascript">

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

</head> 
<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
	
		<section id="main" class="column"> 
		
		<article class="module width_full">
			<header>
				<span class="head">會員管理區</span> 
				<span class="sub1">目前總資料筆數: ${fn:length(select)}</span>
				<span class="sub2">上次更動日期 : 2015/12/12</span>
				<a class="button" href="<c:url value='/admin/createProductData.jsp'/>">新增資料</a>
			</header>
			<div class="module_content">
<hr>				
<c:if test="${not empty select}">			
<table>
	<thead>
	<tr>
		<th>帳號</th>
		<th>名字</th>
		<th>電話</th>
		<th>信箱</th>
<!-- 		<th>點數</th> -->
		<th>狀態</th>
		<th>修改時間</th>
		<th>註冊時間</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="element" items="${select}">

	<tr class="tb_tr">
<%-- 	    <a href="${path}">${element.number}</a> --%>		
		<td class="getNum">${element.memberId}</td>
		<td>${element.name}</td>
		<td>${element.phone}</td>
		<td>${element.email}</td>
<%-- 		<td>${element.point}</td> --%>
		<td>${element.status}</td>	
		<td></td><td></td>
		<td>
		
    		<a>  		
  			<button class="delete">刪除</button>
   		</a> 
    		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
	
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
				
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->	 
	 	</section> 
</body>

</html>