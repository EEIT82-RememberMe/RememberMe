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

<body id="body_sub" >
<jsp:include page="/includes/header.jsp" />

<form action="<c:url value="/orders.controller/Checkout" />" method="POST">
    <div class="container">
		 <div class="check">
                <div class="container" style="margin-top:100px">	 
                	<div class="col-md-9 cart-items" >
                   <h4 style="color:white">訂單總覽 view order<hr></h4>
                   <span style="float:left">寄送人 : ${receiveInformation.name}</span><br>
                   <span style="float:left">聯絡電話 : ${receiveInformation.phone}</span><br>
                   <span style="float:left">收件者/公司 :${receiver}</span><br>
                   <span style="float:left">收件者/公司(電話) : ${phone}</span><br>
                   <span style="float:left">E-Mail : ${email}</span><br>
                   <span style="float:left">寄送至 : ${address}</span><br>
                   <span style="float:left">付款方式  : ${payMethod}</span><br>
                   <span style="float:left">運費  : ${transportPrice}元</span><br>
                  <a class="modify" href="<c:url value='/pages/orderForm.jsp'/>" style="float:right">變更訂單資料</a>
                  <br>
                  <br>
                                  
         <h4 style="color:white">訂單商品 ordered product<hr></h4>
            <c:if test="${not empty cart}">          
    			<c:forEach var="item" items="${cart.items}">                  
                      <div class="cart-header2">
                      
							<!--delete -->
<!--                 				<div class="close2"> -->
<!--                 				   <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
<!--                 				 </div> -->
                                <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc">
                                         <img src="../imageProducts/${item.product.productImage}" class="img-responsive" alt=""/>
                                    </div>
                                    <div class="cart-item-info">
                                        <ul class="qty">
                                            <li><p>${item.product.productNameTw}</p></li>
                                            <li><p>${item.product.productNameUs}</p></li>
                                            <li>
                                            		<p>
<%--                                             		<form action="<c:url value='../products.controller/ProcessCart'/>" method="post"> --%>
                                            			NT ${item.product.productPrice} x ${item.quantity}
<%--                                             			<input type="number" min="1" max="${item.product.stock}" step="1" value='<c:out value='${item.quantity}'/>' name="quantity" class="quantity"> --%>
<%--                                             			<input type="hidden" name="productId" value="<c:out value='${item.product.productId}'/>"> --%>
<!--                                             			<input type="submit" name="action" value="更新" style="background-color:Transparent;border:none;"> -->
<!--                                             		</form> -->
                                            		</p>
                                            	</li>
                                            <li><p>Total : ${item.quantity * item.product.productPrice}</p></li>
                                        </ul>
                                        <div class="delivery">
                                            <div class="clearfix"></div>
                                        </div>	
                                   </div>
                                   <div class="clearfix"></div>					
                                </div>
                        </div>
                        
                <input type="hidden" name="productNameTw" value="${item.product.productNameTw}">
                <input type="hidden" name="productNameUs" value="${item.product.productNameUs}">
                <input type="hidden" name="quantity" value="${item.quantity}">
                <input type="hidden" name="productPrice" value="${item.product.productPrice}">
               </c:forEach> 
            </c:if>    
            	<input type="hidden" name="memberId" value="${user.memberId}">
                <input type="hidden" name="receiver" value="${receiver}">
                <input type="hidden" name="phone" value="${phone}">
                <input type="hidden" name="email" value="${email}">
                <input type="hidden" name="address" value="${address}">
                <input type="hidden" name="payMethod" value="${payMethod}">
                <input type="hidden" name="transportPrice" value="${transportPrice}">
						<a class="modify" href="<c:url value='/pages/cart.jsp'/>" style="float:right">變更/移除商品</a>                   
                </div>
                
                    <div class="col-md-3 cart-total">
                        <div class="price-details">
                            <h3 style="color:white">Price Details</h3>
                            <span>小計</span>
                            <span class="total1">60 NT</span>
                            <span>折扣</span>
                            <span class="total1">0%</span>
                            <span>運費</span>
                            <span class="total1">150.00</span>
                            <div class="clearfix"></div>				 
                        </div>
                        <hr class="featurette-divider">
                        <ul class="total_price">
                           <li class="last_price"> <h4>TOTAL</h4></li>	
                           <li class="last_price"><span>210 NT</span></li>
                           <div class="clearfix"> </div>
                        </ul> 
                        <div class="clearfix"></div>
                        
                        <div class="button">
                        <input name="action" type="submit" value="確認訂單" class="confirm_btn">
                        </div>
                        
                    </div>
                    
</form>                    
                    <div class="clearfix"> </div>
                </div>
            </div>  
       </div>
  </body>
</html>
