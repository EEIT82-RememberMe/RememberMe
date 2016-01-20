<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/label-form.css" rel="stylesheet">
	<link href="../styles/about.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	<script src="../js/googlemap.js"></script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Remember Me</title>

    <!-- Bootstrap CSS -->    
    <link href="../styles/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="../styles/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    
    <!-- Custom styles -->
    <link href="../styles/style.css" rel="stylesheet">
    <link href="../styles/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

  <body id="body_sub" >
<jsp:include page="/includes/header.jsp" />

	<div class="container">

		<div id="main">
			<div class="inner">
				<h3 class="page-title"><span id="about_title">簡介 ABOUT THE Remember me．Café ：</span><hr></h3>
				<div class="row">
  					<div class="col-md-6" id="about_left">
							  						
							<p>
							每到假日總是一來一往的傳送LINE訊息，永遠第一句話總是「今天要去哪裡？」亦或是「好無聊喔，怎麼沒地方可以去。」
							三五個好朋友始終沒有一個固定可以相約小聚聊是非的地方，也只能仰賴這個一個沒有溫度和感情談吐的社群軟體工具。
							</p>
							記得，卻遺忘…<br>
							心中是否有些深刻又難以忘記的事情？<br>
							而這些事情卻又難以啟齒，想忘掉卻時時徘徊？<br><br>
							
							事物或地方，也許具體或者抽象<br>
							人生和故事，可能淒涼不然狂顛<br>
							孤單亦寂寞，好像獨善卻又奔放<br>
							快樂與嘻笑，怎麼容易又那麼難<br>
							顛沛則流離，需要安定然而習慣<br><br>
							
							在這裡販售的不只是咖啡<br>
							更是每一個人情感堆疊的人生經歷與故事<br>
							期待，你我能共同描繪<br>
							完整絢爛又華麗人生藍圖<br>  					
  					</div>
  					<div class="col-md-6">
  						<img src="../images/about_pic.jpg"/>
  					</div>
				</div>
				<h3 class="page-title"><span id="about_title">我們的家</span><hr></h3>
				<div class="row">
					  <div class="col-md-9">
					 	 <div id="floating-panel">
      						<input type="button" value="Toggle Street View" onclick="toggleStreetView();"></input>
   						 </div>
    						 <div id="map"></div>		  
					  </div>
					  <div class="col-md-3s" id="map_left">
					  台北市松山區南京東路四段133巷4弄16號<br><br>
					  如搭乘捷運可至台北小巨蛋5號出口步行約3-5分鐘喔<br><br>
				     	電話:(02)-25471517<br><br>
						營業時間12:00-22:00<br>
						(20:30最後點餐～21:00飲品最後點餐)<br>
					  </div>
				</div>
				<h3 class="page-title"><span id="about_title">Instagram</span><hr></h3>
			</div>
		</div>
	</div>
	
	<script
        src="https://maps.googleapis.com/maps/api/js?signed_in=true&callback=initMap"
        async defer>
    </script>
</body>
</html>
