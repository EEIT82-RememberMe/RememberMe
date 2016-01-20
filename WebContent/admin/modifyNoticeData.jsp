<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="../styles/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
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
<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
    <script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
</head>
<%@ page import="news.model.NoticeBean" %>
<%@ page import="news.model.NoticeService" %>
<%
    String num = request.getParameter("num");
	String currentPage = request.getParameter("page");
    int number = Integer.parseInt(num);
    NoticeBean bean = new NoticeBean();
    NoticeService noticeService = new NoticeService();
    NoticeBean result = noticeService.select(number);
    result.setNumber(number);
    request.setAttribute("select", result);
    request.setAttribute("currentPage", currentPage);
%>
<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
		<section id="main" class="column"> 
 			 
 			<article class="module width_full">
			<header>
				<span class="head">修改公告資料</span>		
			</header>
			<div class="module_content">
				<article class="stats_overview">
					<div class="module_content">
<!--------------------------------------title-------------------------------------------------------->
					<form action="../news.controller/ModNotice" method="POST">
						<fieldset>
							<label>公告標題</label>
							<input type="text" maxlength="50" name="title" value="${select.title}">
						</fieldset>

<!--------------------------------------noticeContent-------------------------------------------------------->
						<fieldset>
							<label>公告內容</label>
							<textarea rows="4" maxlength="100" style="font-size:25px" name="noticeContent">${select.noticeContent}</textarea>
						</fieldset>
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>公告日期</label>
							<input type="text" style="width:92%;" name="date" value="${select.date}" maxlength="6">
						</fieldset><div class="clear"></div>
						
						<input type="hidden" value="${currentPage}" name="page">
						<input type="hidden" value="${select.number}" name="number">
						<input type="submit" value="更新" name="action">
					</form>
				</div>
				</article>	
				<div class="clear"></div>
			</div>		
		</article><!-- end of stats article -->
	 	</section> 
</body>
</html>