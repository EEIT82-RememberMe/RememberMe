<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../styles/cart-style.css" rel="stylesheet" type="text/css"/>

	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/notice.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	
	<script src="../js/simpleCart.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Login Page 2 | Creative - Bootstrap 3 Responsive Admin Template</title>

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
<%@ page import="java.util.List" %>
<%@ page import="orders.model.OrdersBean" %>
<%@ page import="orders.model.OrderDetailBean" %>
<%@ page import="orders.model.OrderService" %>
<%
	String num = request.getParameter("orderId");
	int number = Integer.parseInt(num);
	OrderService orderService = new OrderService();
	OrdersBean ord = orderService.selectSimple(number);
	request.setAttribute("order",ord);
	List<OrderDetailBean> odb = orderService.select(number);
	request.setAttribute("orderDetail",odb);
%>
<body id="body_sub" >
<jsp:include page="/includes/header.jsp" />
    <div class="container">
		 <div class="check">
                <div class="container" style="margin:100px">	 
                	<div class="col-md-9 cart-items" >
	                <h3 style="color:white">訂單明細 order detail<hr></h3>
	                   <span style="float:left">訂單編號 : ${order.orderId}</span><br>
	                   <span style="float:left">寄送人 : ${user.name}</span><br>
	                   <span style="float:left">聯絡電話 : ${user.phone}</span><br>
	                   <span style="float:left">代收者/公司 : ${order.receiveName}</span><br>
	                   <span style="float:left">代收者/公司(電話) : ${order.phone}</span><br>
	                   <span style="float:left">E-Mail : ${order.email}</span><br>
	                   <span style="float:left">寄送至 : ${order.sendAddress}</span><br>
	                   <span style="float:left">付款方式 : ${order.payMethod}</span><br>
	                   <span style="float:left">運費  : ${order.transportPrice}元</span><br>
	                  <br>
	                  <br>
                   
                   <h4 style="color:white">商品 ordered product<hr></h4>
                </div>
                	<c:forEach var="orderDetail" items="${orderDetail}">
	                	<div class="cart-header2">
	                		<div class="cart-sec simpleCart_shelfItem">
	                			<div class="cart-item-info">
								<ul class="qty">
									<li>${orderDetail.productNameTw} ${orderDetailproductNameUs}</li>
									<li>NT ${orderDetail.price} X ${orderDetail.quantity}</li>
									<li>Total : ${orderDetail.price*orderDetail.quantity}</li>
								</ul>
								</div>
							</div>
						</div>	
					</c:forEach>
                </div>
				<a class="confirm_btn" href="../orders.controller/OrdersMember" >回訂單查詢</a>
            </div>  
    </div>
  </body>
</html>
