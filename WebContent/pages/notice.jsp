<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<!-- bootstrap.js & css -->
<title>公告Notice</title>
<meta name="viewport"
	content="width=device-width, minimum-scale= 1.0, initial-scale= 1.0">

<!-- stylesheets -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link
	href='http://fonts.googleapis.com/css?family=Dosis:300,400,500,600,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../styles/notice.css">
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../js/jquery.tmpl.js"></script>
</head>
<jsp:include page="/includes/header.jsp" />
<body id="body_sub">
	<div class="container">
		<div id="timeline">
			<!--waiting to be filled in-->
		</div>
	</div>
</body>

<script>
	$(function() {
		var page = 1;
		callAPI(page);
 		$(window).scroll(function() {
			if($(window).scrollTop() + $(window).height() == $(document).height()) {
				page = page + 1;
				console.log(page)
			    callAPI(page);
			}
		});
		function callAPI (pageNumber){
			var rdata;
			$.ajax({
				url: "${pageContext.request.contextPath}/news.controller/ProcessNews",//?action=notice
				method : "POST",
				data: {"page" : pageNumber,"action":'notice'},
				success: function(data, textStatus, jqXHR ){	
					console.log(222);
					$.tmpl($('#test'), data).appendTo("#timeline");
				},
				error: function(jqXHR,textStatus,errorThrown){
					console.log(errorThrown);
				}
			});	
		}
	});
</script>

<script id="test" type="text/x-jQuery-tmpl">
		<div class="timeline-item">
				<div class="timeline-icon">
				    <p class="notice_date">{{= date}}</p>
				</div>
				<div class="timeline-content">
					<h2>{{= title}}</h2>
					
					<p class="notice_content">
						{{html noticeContent}}		
					</p>
					
				</div>
			</div>
</script>
</html>