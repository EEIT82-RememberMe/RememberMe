<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
<link href="../styles/label-form.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../js/jquery.tmpl.js"></script>

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

<script>
window.onload = function(){
	var select , option;
	select = document.getElementById('select');
	option = document.getElementById('option');
	
	function packageOption(){
		var pack = this.options[this.selectedIndex].value;
		if(pack == '郵寄'){
			option.innerHTML = '50';
		}else if(pack == '宅配'){
			option.innerHTML = '60';
		}else if(pack == '超商取貨付款'){
			option.innerHTML = '70';
		}else if(pack == '面交'){
			option.innerHTML = '0';
		}else if(pack == '貨到付款'){
			option.innerHTML = '100';
		}else{
			option.innerHTML = '';
		}
	}
	select.addEventListener('change', packageOption, false);
}
</script>

<body id="body_sub">
	<jsp:include page="/includes/header.jsp" />

	<div class="container">

		<div id="main">
			<div class="inner">
				<h3 class="page-title">
					填寫訂單資訊
					<hr>
				</h3>
				<div class="simple-form-wrapper">
					<form action="../orders.controller/ProcessOrderForm" method="POST"> 
<!-----------------------------------------代收者------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>收件者</label>
							<div class="form-content">
								<input type="text" name="receiver"
									value="${user.name}" placeholder="${user.name}">
							</div>
							<span class="error">${errors.NOreceiver}</span>
						</div>
<!-----------------------------------------信箱------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>Email</label>
							<div class="form-content">
								<input type="text" name="email"
									value="${user.email}" placeholder="${user.email}">
							</div>
							<span class="error">${errors.NOemail}</span>
						</div>
<!-----------------------------------------聯絡電話------------------------------------------>						
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>聯絡電話</label>
							<div class="form-content">
								<input type="text" name="phone"
									value="${user.phone}" placeholder="${user.phone}">
							</div>
							<span class="error">${errors.NOphone}</span>
						</div>
<!-----------------------------------------地址------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>寄送地址</label>
							<div class="form-content">
								<input type="text" name="address"
									value="${user.memberAddress}" placeholder="${user.memberAddress}">
							</div>
							<span class="error">${errors.NOaddress}</span>
						</div>
<!-----------------------------------------付款方式------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>付款方式</label>
							<div class="form-content">
								<select name="payMethod" id="select">
									<option>請選擇付款方式 </option>
									<option value="郵寄">郵寄 </option>
									<option value="宅配">宅配</option>
									<option value="超商取貨付款">超商取貨付款 </option>
									<option value="貨到付款">貨到付款</option>
									<option value="面交">面交</option>
								</select>
								<select name="transportPrice" style="border:none;color:white;background:black;height:22px;-webkit-appearance: none;">
									<option id="option"></option>
								</select>
								<span class="error">${errors.NOpayMethod}</span>
							</div>
						</div>
<!--------------------------------------------------------------------------------------->
						<div class="submit-row form-row">
							<label class="form-head" for="form-element">&nbsp;</label>
							<div class="form-content">
								<input value="確認資料" type="submit" id="form-element">
							</div>
						</div>
						<div class="form-row">
							<label class="form-head"></label>
						</div>
					</form>
					<div class="actions">
						<a href="<c:url value='/pages/login.jsp'/>">已經註冊</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>