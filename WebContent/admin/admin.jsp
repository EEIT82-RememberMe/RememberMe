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
<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
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
<style type="text/css">
body.adminbody{
background-image: url(../images/greybg.jpg); 
}
</style>
</head>


<body class="adminbody">
	<jsp:include page="/includes/adminTop.jsp" />

	<c:if test="${empty admin}">
		<c:redirect url="/admin/Login.jsp"></c:redirect>
	</c:if>

	<section id="main" class="column"> 
	<jsp:include page="/includes/adminLeft.jsp" /> 
	 </section>
</body>

</html>
