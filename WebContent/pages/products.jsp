<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link  rel="stylesheet" href="../styles/notice.css">
	<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	
	
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title></title>

    <!-- Bootstrap CSS -->    
    <link href="../styles/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="../styles/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="../styles/elegant-icons-style.css" rel="stylesheet" />
    <link href="../styles/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="../styles/style.css" rel="stylesheet">
    <link href="../styles/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
$(document).ready(function() {
	
	$.ajax({
		url: "${pageContext.request.contextPath}/products.controller/PopulateProducts",
		method : "GET",
		// [{ value:"1", text:"coffee" }, {value:"2", text: "cake"}, {}, {}, {}]
		//data: {"page" : pageNumber,"action" : 'music'},
		success: function(data, textStatus, jqXHR ){
			//alert( "xxxxx");
			console.log(JSON.stringify(data));
			console.log(textStatus)
			console.log(jqXHR)
			//$.tmpl($('#test'), data).appendTo(".prod_nav > gallery");
			$.tmpl($('#test'), data).appendTo("#gallery_ul");
			filterSearch();
		},
		error: function(jqXHR,textStatus,errorThrown){
			console.log(errorThrown);
		}
	});      
  });
</script>
</head>


<body id="body_sub" class="login-img3-body">
	<jsp:include page="/includes/header.jsp" />

	<div class="container">
		<div id="search">
			<input type="text" placeholder="filter by search" id="filter-search" />
		</div>
<!-- 		<div> -->
<!-- 			<nav class="prod_nav"> -->
<!-- 			<ul>筆類</ul><ul>工具</ul> -->
<!-- 			</nav> -->
<!-- 		</div> -->
		
		<div id="gallery">	
			<ul id="gallery_ul" class="img-list">
			
			<ul>
		</div>
<!-- 		<script src="../js/jquery.js"></script> -->
	</div>
	
	<script id="test" type="text/x-jQuery-tmpl">
	<li data-desc="{{= productNameUs}} {{= productNameTw}} {{= productPrice}}">
		<a href="<c:url value='/products.controller/ProcessSingleProduct?productId={{= productId}}'/>">
 		<img class="img_prod" src="../imageProducts/{{= productImage}}"/> 			
		<span class="text-content"><span>{{= productNameTw}}<br>{{= productNameUs}}<br>NT {{= productPrice}}</span></span>        
		</a>	
	</li>
	</script>
	<script src="../js/filter-search.js"></script>   		
</body>
</html>
