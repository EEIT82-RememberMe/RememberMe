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
    .title
    {
    	color:white;
    	font-size:50px;
    }
    </style>
</head>

  <body id="body_sub" >
<%
	String path= request.getContextPath();
    response.setHeader("Refresh", "3");
    response.addHeader("Refresh", path+"/admin/admin.jsp");
%>
	<div class="container">

		<div id="main">
			<div class="inner">
				<h1 class="title">很抱歉 你無此權限<hr></h1>
				<div class="simple-form-wrapper">
					<img alt="" src="../icons/sorry.png">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>