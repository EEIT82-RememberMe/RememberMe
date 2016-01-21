<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>演唱Concert</title>
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/music.css" rel="stylesheet">
	<style>
		.test { width:337px; margin:0 10px;}	
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/masonry/3.3.2/masonry.pkgd.min.js"></script>
</head>
<body id="body_sub">
<jsp:include page="/includes/header.jsp" />
	<div id="div_notice" class="container" >
		<div class="row"></div>	<!-- end row -->
	   
	   <nav>
			  <ul class="pager">
			    <li class="previous"><a href="javascript:;"><span aria-hidden="true">&larr;</span> Older</a></li>
			    <li class="next"><a href="javascript:;">Newer <span aria-hidden="true">&rarr;</span></a></li>
			  </ul>
		</nav>
	   	
	</div>
</body>


<!-- ajax  -->
<script>
	

	$(function(){
		
		var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		var pageNumber = getUrlParameter("page");
		if (pageNumber == 1){
			$(".next").hide();
		}
		var getNoticeData = function(n){
			$.ajax({
				url: "${pageContext.request.contextPath}/news.controller/ProcessNews",//?action=music
				method : "POST",
				data: {"page" : pageNumber,"action" : 'music'},
				success: function(data, textStatus, jqXHR ){
					console.log(JSON.stringify(data));
					console.log(textStatus)
					console.log(jqXHR)
					$.tmpl($('#test'), data).appendTo("#div_notice > div.row");
					
					setTimeout(function(){
						
						var a = $('.row').masonry({
							  // set itemSelector so .grid-sizer is not used in layout
							  itemSelector: '.test',
							  percentPosition: true
							});
						
					}, 500);
					
					$.each(data, function(){
						if (this.lastData == "true"){
							$(".previous").hide();
						}
					});
					
				},
				error: function(jqXHR,textStatus,errorThrown){
					console.log(errorThrown);
				}
			});
		};
		
		getNoticeData(getUrlParameter(pageNumber));
		$("body").on("click", ".previous", function(){
			location.href ="${pageContext.request.contextPath}/pages/music.jsp?page=" + (parseInt(pageNumber) + 1);
		});
		
		$("body").on("click", ".next", function(){
			if (parseInt(pageNumber) > 1){
				location.href ="${pageContext.request.contextPath}/pages/music.jsp?page=" + (parseInt(pageNumber) - 1);
			}
		});
				
		
		
	});

</script>
<script id="test" type="text/x-jQuery-tmpl">
		<div class="test">
		    <div class="thumbnail">
		      <div class="caption">
		        	<h4>{{= title}}</h4>
					<h6>{{= description}}</h6>	
					
		        <img class="img1" src="../images/{{= photo}}" />
		        <p>	
						<h2>{{= performer}}</h2>
						{{html musicContent}}
		        </p>
		        <p>
		        	<a href="{{= blogLink}}" target="_blank" class="btn btn-primary" role="button">facebook</a>
		            <a href="#" class="btn btn-default" role="button">Read More</a>
		        </p>
		      </div>
		    </div>
  		 </div>
	</script>
</html>