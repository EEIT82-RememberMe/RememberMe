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
<%@ page import="news.model.MusicBean" %>
<%@ page import="news.model.MusicService" %>
<%
    String num = request.getParameter("num");
	String currentPage = request.getParameter("page");
    int number = Integer.parseInt(num);
    MusicBean bean = new MusicBean();
    MusicService musicService = new MusicService();
    MusicBean result = musicService.select(number);
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
				<span class="head">修改演唱資料</span>		
			</header>
			<div class="module_content">
				<article class="stats_overview">
					<div class="module_content">
<!--------------------------------------title-------------------------------------------------------->
					<form action="../news.controller/ModMusic" method="POST" enctype="multipart/form-data">
						<fieldset>
							<label>主題</label>
							<input type="text" name="title" value="${select.title}" maxlength="35">
						</fieldset>
<!--------------------------------------description-------------------------------------------------------->
						<fieldset>
							<label>附註</label>
							<input type="text" name="description" value="${select.description}" maxlength="50">
						</fieldset>
<!--------------------------------------performer-------------------------------------------------------->
						<fieldset>
							<label>演唱者</label>
							<input type="text" name="performer" value="${select.performer}" maxlength="30">
						</fieldset>
<!--------------------------------------musicContent-------------------------------------------------------->
						<fieldset>
							<label>內容</label>
							<textarea rows="6" style="font-size:20px" name="musicContent">${select.musicContent}
							</textarea>
						</fieldset>
<!--------------------------------------photo-------------------------------------------------------->
						<fieldset style="width:25%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>圖片</label>
							<div class="form-group">
                                      <input type="file" accept="image/*" name="photo" value="${select.photo}">
                            </div>
						</fieldset>
<!--------------------------------------blogLink-------------------------------------------------------->
						<fieldset style="width:60%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>部落格/臉書 連結</label>
							<input type="text" style="width:92%;" name="blogLink" value="${select.blogLink}" maxlength="50">
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