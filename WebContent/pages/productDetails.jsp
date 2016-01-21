<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/notice.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Login Page 2 | Creative - Bootstrap 3 Responsive Admin Template</title>

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
</head>
<body id="body_sub" class="login-img3-body" >
<jsp:include page="/includes/header.jsp" />
    <div class="container" id="prod_contain" style="margin-top:150px">
		<div class="row">
            <div class="col-md-7">   
<!--                    <img class="img-responsive" src="http://placehold.it/800x500" alt="">              -->
				   <img class="img-responsive" src="../imageProducts/${product.productImage}" alt="">
            </div>
			<div class="col-md-5">
                    
                        <h4 class="pull-right">${product.productPrice} NT</h4>
                        <h3 class="prod_title">${product.productNameTw} ${product.productNameUs}</h3>                      
                        <p class="prod_desc">${product.productDescription}</p>                         
                        <p class="prod_remark">${product.remarks}</p>  
                        <p>
                        <form id="product_form" action="../products.controller/ProcessCart?productId=${product.productId}" method="post">
  						<span class="prod_num" style="color:white">數量</span><input type="number" min="1" max="${product.stock}" step="1" value="1" name="quantity">			
  						<span style="color:white">(庫存量：${product.stock})</span>  
  						<br><input type="submit" value="加入購物車" name="action" class="prod_num">
						</form>
                        </p>  
                        <div><a href="<c:url value='/pages/products.jsp'/>" class="back">回購物區</a></div>     
            </div>
        </div>
      
    </div>
    
  </body>
</html>
