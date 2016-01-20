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
<script type="text/javascript">
	function call() {
		var kcyear = document.getElementsByName("year")[0], kcmonth = document
				.getElementsByName("month")[0], kcday = document
				.getElementsByName("day")[0];
		var d = new Date();
		var n = d.getFullYear();
		for (var i = n; i >= 1950; i--) {
			var opt = new Option();
			opt.value = opt.text = i;
			kcyear.add(opt);
		}
		kcyear.addEventListener("change", validate_date);
		kcmonth.addEventListener("change", validate_date);
		function validate_date() {
			var y = +kcyear.value, m = kcmonth.value, d = kcday.value;
			if (m === "2")
				var mlength = 28 + (!(y & 3) && ((y % 100) !== 0 || !(y & 15)));
			else
				var mlength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ][m - 1];
			kcday.length = 0;
			for (var i = 1; i <= mlength; i++) {
				var opt = new Option();
				opt.value = opt.text = i;
				if (i == d)
					opt.selected = true;
				kcday.add(opt);
			}
		}
		validate_date();
	}
</script>
</head>

<body id="body_sub">
	<jsp:include page="/includes/header.jsp" />

	<div class="container">

		<div id="main">
			<div class="inner">
				<h3 class="page-title">
					註冊會員
					<hr>
				</h3>
				<div class="simple-form-wrapper">
					<form action="../member.controller/ProcessRegister" method="POST"> 
<!-----------------------------------------帳號------------------------------------------>	
						<div class="form-row">
							<label class="form-head" for="form-username"><span class="must">*</span>帳號</label>
							<div class="form-content">
								<input type="text" name="memberId" value="${param.memberId}"
									placeholder="" autofocus>
							</div>
							<span class="error">${errors.memberId}</span>
						</div>
<!-----------------------------------------密碼------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>密碼</label>
							<div class="form-content">
								<input type="password" name="memberPassword"
									value="${param.memberPassword}" placeholder="">
							</div>
							<span class="error">${errors.memberPassword}</span>
						</div>
<!-----------------------------------------姓名------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password">姓名</label>
							<div class="form-content">
								<input type="text" name="memberPassword"
									value="${param.memberPassword}" placeholder="">
							</div>
							<span class="error"></span>
						</div>
<!-----------------------------------------性別------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password">性別</label>
							<div class="form-content">
								<input type="radio" name="gender" value="male"><span> 男 </span></input> <input
									type="radio" name="gender" value="female"><span> 女 </span></input>
							</div>
							<span class="error"></span>
						</div>
<!-----------------------------------------生日------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password">生日</label>
							<div class="form-content">
								<div class="register-form-row">
									<div class="register-form-row-col">
										     <span>月:<span> <select name="month" onchange="call()">
											<option value="">月份</option>
											<option value="1">1月</option>
											<option value="2">2月</option>
											<option value="3">3月</option>
											<option value="4">4月</option>
											<option value="5">5月</option>
											<option value="6">6月</option>
											<option value="7">7月</option>
											<option value="8">8月</option>
											<option value="9">9月</option>
											<option value="10">10月</option>
											<option value="11">11月</option>
											<option value="12">12月</option>
										</select> <span>日:</span> <select name="day">
											<option value="">日</option>
										</select> <span>年:</span> <select name="year" onchange="call()">
											<option value="">年份</option>
										</select>
									</div>
								</div>
							</div>
							<span class="error"></span>
						</div>
<!-----------------------------------------信箱------------------------------------------>						
						<div class="form-row">
							<label class="form-head" for="form-password"><span class="must">*</span>電子郵件</label>
							<div class="form-content">
								<input type="email" name="email"
									value="${param.email}" placeholder="">
							</div>
							<span class="error">${errors.email}</span>
						</div>
<!-----------------------------------------地址------------------------------------------>
						<div class="form-row">
							<label class="form-head" for="form-password">地址</label>
							<div class="form-content">
								<input type="text" name="memberPassword"
									value="${param.memberPassword}" placeholder="">
							</div>
							<span class="error"></span>
						</div>
						<div class="submit-row form-row">
							<label class="form-head" for="form-element">&nbsp;</label>
							<div class="form-content">
								<input value="註冊" type="submit" id="form-element">
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