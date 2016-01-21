<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	<link rel="stylesheet" href="../styles/orderInformation.css" type="text/css" media="screen" />
	
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="../js/hideshow.js" type="text/javascript"></script>
	<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
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
	List<OrderDetailBean> odt = orderService.select(number);
	request.setAttribute("orderDetail",odt);
%>

<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
	
		<section id="main" class="column"> 
 		<article class="module width_full">
<!-- 			<header><h3>菜單目錄清單</h3></header> -->
			<div class="module_content">
				<form action="../orders.controller/ProcessSimpleOrder" method="post">
					<div class="overview_today">	
							<span class="text_span">訂單編號 : ${order.orderId}</span><hr>
								<div class="row">
  									<div class="sender">
  										<b>會員資訊 :</b><br><br>
  										<span>帳號 : ${order.memberId}</span><br>
  										<span>E-Mail : ${order.email}</span><br>
  									</div>
 									 <div class="receiver">
 									 	<b>收件人/公司資訊 :</b><br><br>
 									 	<span>收件人/公司 : ${order.receiveName}</span><br>
  										<span>地址 : ${order.sendAddress}</span><br>
  										<span>電話 : ${order.phone}</span><br>
 									 </div>
								</div>
								<div class="orderlist">
									<table>
										<thead>
											<tr>
												<th>交易項目</th>
												<th>產品名稱</th>
												<th>英文名稱</th>
												<th>價格</th>		
											</tr>
											</thead>
											<tbody>
												<c:forEach var="orderDetail" items="${orderDetail}">
													<tr class="tb_tr">
														<td>${orderDetail.orderDetailId}</td>
														<td>${orderDetail.productNameTw}</td>
														<td>${orderDetail.productNameUs}</td>
														<td>${orderDetail.price}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="total">
										Total: NT 1090
										</div>
								</div>
					</div>
						<input type="hidden" value="${order.orderId}" name="orderId">
					<input type="submit" value="處理完成" name="action">
<%-- 					<a href="${pageContext.request.contextPath}/admin/orderList.jsp?name='action'">處理完成</a>	 --%>
				</form>
			</div>		
		</article>	
	 	</section> 
</body>

</html>