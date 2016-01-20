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
    <div class="container">
		 <div class="check">
                <div class="container" style="margin-top:100px">	 
                	<div class="col-md-9 cart-items" >
                        <h4 style="color:white">檢視購物車 view cart<hr></h4>
                        
                            <script>$(document).ready(function(c) {
                                $('.close1').on('click', function(c){
                                    $('.cart-header').fadeOut('slow', function(c){
                                        $('.cart-header').remove();
                                    });
                                    });	  
                                });
                           </script>
                  
                         
                         <script>$(document).ready(function(c) {
                                $('.close2').on('click', function(c){
                                        $('.cart-header2').fadeOut('slow', function(c){
                                    $('.cart-header2').remove();
                                });
                                });	  
                                });
                         </script>

            <c:if test="${not empty cart}">          
    			<c:forEach var="item" items="${cart.items}">                  
                      <div class="cart-header2">
                      
							<!--delete -->
<!--                 				<div class="close2"> -->
<!--                 				   <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
<!--                 				 </div> -->
							<form action="<c:url value='../products.controller/ProcessCart'/>" method="post">
							<input type="hidden" name="productId" value="<c:out value='${item.product.productId}'/>">
                				 <input type="submit" name="action" value="X 移除"  style="float:right;background-color:Transparent;border:none;">
                				</form>
                                <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc">
                                         <img src="../imageProducts/${item.product.productImage}" class="img-responsive" alt=""/>
                                    </div>
                                    <div class="cart-item-info">
                                        <ul class="qty">
                                            <li><p>${item.product.productNameTw} ${item.product.productNameUs}</p></li>
                                            <li>
                                            		<p>
                                            		
                                            		<form action="<c:url value='../products.controller/ProcessCart'/>" method="post">
                                            			NT ${item.product.productPrice} x 
                                            			<input type="number" min="1" max="${item.product.stock}" step="1" value='<c:out value='${item.quantity}'/>' name="quantity" class="quantity">
                                            			<input type="hidden" name="productId" value="<c:out value='${item.product.productId}'/>">
                                            			<input type="submit" name="action" value="更新" style="background-color:Transparent;border:none;">
                                            		</form>
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
               </c:forEach>       
               </c:if>    
                    </div>
                    <div class="col-md-3 cart-total">
                        <div class="price-details">
                            <h3 style="color:white">Price Details</h3>
                            <span>Total</span>
                            <span class="total1">${cart.totalFormat}</span>
                            <span>Discount</span>
                            <span class="total1">10%(Festival Offer)</span>
                        </div>
                        <hr class="featurette-divider">
                        <ul class="total_price">
                           <li class="last_price"> <h4>TOTAL</h4></li>	
                           <li class="last_price"><span>${cart.totalFormat}</span></li>
                           <div class="clearfix"> </div>
                        </ul> 
                        <div class="clearfix"></div>
                        <a class="order" href="<c:url value='/orders.controller/CheckCart' />">前往結帳</a>
                        <a class="continue" href="<c:url value='/pages/products.jsp'/>">繼續購物</a>
                        
                    </div>

                    <div class="clearfix"> </div>
                </div>
            </div>  
    </div>
  </body>
</html>
