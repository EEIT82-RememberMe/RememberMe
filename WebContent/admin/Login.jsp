<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/label-form.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	
<!--     <script src="../js/fb-login.js" type="text/javascript"></script> -->
<!--     <script src="../js/fb-login2.js" type="text/javascript"></script> -->
    
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
    <style>
    #form-element
    {
    		margin-left:70px;
    		margin-right:auto;
    }
    .actions
    {
   		 margin-left:70px;
    		margin-right:auto;s
    }
    
    </style>
</head>

  <body id="body_sub" >

	<div class="container">

		<div id="main">
			<div class="inner">
				<h3 class="page-title">管理者專用登入區<hr></h3>
				<div class="simple-form-wrapper">
					<form class="input" action= "${pageContext.request.contextPath}/admin/Login.controller" method="POST">
						<div class="form-row">
							<label class="form-head" for="form-username">帳號</label>
							<div class="form-content">
								<input type="text" name="adminId" value="${id}" placeholder="帳號" autofocus>
							</div>
							<span class="error">${errors.adminId}</span>
						</div>
						<div class="form-row">
							<label class="form-head" for="form-password">密碼</label>
							<div class="form-content">
								<input type="password" name="adminPassword" value="${pass}" placeholder="密碼">
							</div>
							<span class="error">${errors.adminPassword}</span>
						</div>
						<div class="form-row">
							<label class="form-head" for="form-remember"></label>
							
						<div class="submit-row form-row">
							<label class="form-head" for="form-element">&nbsp;</label>
							<div class="form-content">
								<input value="登入" type="submit" id="form-element">
							</div>
        <!-- custom login button -->
						</div>
						<div class="form-row">
							<label class="form-head"></label>
						</div>
					</form>
					<div class="actions">
					 <a href="/tw/forgot-password/">忘記密碼？</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
