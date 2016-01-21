<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
<link href="../styles/member-profile.css" rel="stylesheet">
<link href="../styles/label-form.css" rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/styles/memberOrders.css'/> ">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../js/jquery.tmpl.js"></script>

<!--     <script src="../js/fb-login.js" type="text/javascript"></script> -->
<!--     <script src="../js/fb-login2.js" type="text/javascript"></script> -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
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

<body id="body_sub">
	<jsp:include page="/includes/header.jsp" />

	<div class="container">

		<div id="main">
			<div class="inner">
				<%-- 				<h3 class="page-title">${user.name}的個人檔案<hr></h3> --%>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#orders" data-toggle="tab">查看訂單 Orders</a></li>
					<li><a href="#home" data-toggle="tab">個人檔案 Profile</a></li>
					<li><a href="#profile" data-toggle="tab">修改密碼 Password</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane active in" id="orders">
			                <div class="CSSTableGenerator" >
				                <table >
				                    <tr>
				                        <td>訂單編號</td>
				                        <td>訂單日期</td>
				                        <td>訂單狀態</td>
				                        <td></td>
				                    </tr>
				                    <c:forEach var="orderList" items="${orderList}">
				                    	<c:set var="s1" value="${orderList.orderDate}"/>
										<c:set var="s2" value="${fn:substring(s1,0,10)}"/>
					                    <tr>
					                        <td>${orderList.orderId}</td>
					                        <td>${s2}</td>
					                        <td>${orderList.ordersStatus}</td>
					                        <td>
					                        	<a style="text-decoration:none;" href="${pageContext.request.contextPath}/pages/selectDetail.jsp?orderId=${orderList.orderId}">
					                        		<button>查看訂單明細</button>
					                        	</a>
					                        </td>
					                    </tr>
				                    </c:forEach>
				                </table>
				            </div>
					</div>
					<div class="tab-pane fade" id="home">
						<form id="tab">
							<div class="form-row">
								<label class="form-head" for="form-username">帳號</label>
								<div class="form-content">
									<input type="text" name="memberId" value="${param.memberId}"
										placeholder="帳號" autofocus pattern="^[a-zA-Z0-9]+$" title="請輸入英文或數字" required>
								</div>
								<span class="error">${errors.memberId}</span>
							</div>
							<div class="form-row">
								<label class="form-head" for="form-name">暱稱</label>
								<div class="form-content">
									<input type="text" name="name" value="${param.name }" placeholder="暱稱" pattern="^[\u4E00-\u9fa5_a-zA-Z]+$" title="請輸入中文或英文" required>
								</div>
								<span class="error">${error.name }</span>
							</div>
							<div class="form-row">
								<label class="form-head" for="form-phone">電話</label>
								<div class="form-content">
									<input type="text" name="phone" value="${param.phone }" placeholder="電話" pattern="^[0]{1}[1-9]{1}[1-9]{1}[0-9]{7}$" title="手機：09XXXXXXXX,市話：02XXXXXXXX" required>
								</div>
								<span class="error">${error.phone }</span>
							</div>
							<div class="form-row">
								<label class="form-head" for="form-email">電子郵件</label>
								<div class="form-content">
									<input type="text" name="email" value="${param.email }" placeholder="電子郵件" pattern="^[a-zA-Z0-9_]+@[a-zA-Z0-9._]+$" title="請輸入正確的電子信箱" required>
								</div>
								<span class="error">${error.email }</span>
							</div>
							<div class="form-row">
								<label class="form-head" for="form-memberAddress">地址</label>
								<div class="form-content">
									<input type="text" name="memberAddress" value="${param.memberAddress }" placeholder="地址" pattern="^[\u4E00-\u9fa5_0-9]+$" title="請輸入正確的地址" required>
								</div>
								<span class="error">${error.memberAddress }</span>
							</div>
							
							<div class="submit-row form-row">
								<label class="form-head" for="form-element">&nbsp;</label>
								<div class="form-content">
									<input value="更新個人資料" type="submit" id="form-element">
								</div>

								<div id="fb-root"></div>


							</div>
							<div class="form-row">
								<label class="form-head"></label>
							</div>

						</form>
					</div>
					<div class="tab-pane fade" id="profile">
						<form id="tab2">
							<div class="form-row">
								<label class="form-head" for="form-password">請輸入新密碼</label>
								<div class="form-content">
									<input type="password" name="newMemberPassword"
										value="${param.memberPassword}" placeholder="新密碼" required>
								</div>
								<span class="error">${errors.memberPassword}</span>
							</div>
							<div class="submit-row form-row">
								<label class="form-head" for="form-element">&nbsp;</label>
								<div class="form-content">
									<input value="更新密碼" type="submit" id="form-element">
								</div>

								<div id="fb-root"></div>
							</div>
							<div class="form-row">
								<label class="form-head"></label>
							</div>
						</form>
					</div>
				</div>	
			</div>
		</div>
	</div>	
</body>
</html>