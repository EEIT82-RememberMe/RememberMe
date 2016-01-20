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
</head>

  <body id="body_sub" >
<jsp:include page="/includes/header.jsp" />

	<div class="container">

		<div id="main">
			<div class="inner">
				<h3 class="page-title">登入<hr></h3>
				<div class="simple-form-wrapper">
					<form action="../member.controller/ProcessLogin" method="POST">
						<div class="form-row">
							<label class="form-head" for="form-username">帳號</label>
							<div class="form-content">
								<input type="text" name="memberId" value="${param.memberId}" placeholder="帳號" autofocus>
							</div>
							<span class="error">${errors.memberId}</span>
						</div>
						<div class="form-row">
							<label class="form-head" for="form-password">密碼</label>
							<div class="form-content">
								<input type="password" name="memberPassword" value="${param.memberPassword}" placeholder="密碼">
							</div>
							<span class="error">${errors.memberPassword}</span>
						</div>
						<div class="form-row">
							<label class="form-head" for="form-remember"></label>
							<div class="form-content">
								<ul>
									<li><input name="remember[yes]" value="yes"
										type="checkbox" id="form-remember"><label
										for="form-remember">記住我 / 保持登入狀態</label></li>
								</ul>
							</div>
						</div>
						<div class="submit-row form-row">
							<label class="form-head" for="form-element">&nbsp;</label>
							<div class="form-content">
								<input value="登入" type="submit" id="form-element">
							</div>
								
							 <div id="fb-root"></div>
        <script>
          //initializing API
          window.fbAsyncInit = function() {
            FB.init({appId: '1652372388346353', status: true, cookie: true,
                     xfbml: true});
          };
          
          (function(d, s, id) {
        	  
            var e = document.createElement('script'); e.async = true;
            e.src = document.location.protocol +
              '//connect.facebook.net/en_US/all.js';
            document.getElementById('fb-root').appendChild(e);
            
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/zh_TW/sdk.js";
//             fjs.parentNode.insertBefore(js, fjs); 
          }(document, 'script', 'facebook-jssdk'));
          
          
          function testAPI() {
        	    console.log('Welcome!  Fetching your information.... ');
        	    FB.api('/me', function(response) {
        	      console.log('Successful login for: ' + response.name);
        	     // document.getElementById('status').innerHTML =
        	       // 'Thanks for logging in, ' + response.name + response.id +  '!';
        	      location.href  = "../member.controller/ProcessFacebookLogin?name=" + response.name + "&id=" + response.id
        	      
        	    });
        	  }
        </script>

        <!-- custom login button -->
        <a href="#" onclick="fblogin();return false;"><img src="../images/fb_login.png"></a>


        <script>
          //your fb login function
          function fblogin() {
            FB.login(function(response) {
            	FB.getLoginStatus(function(response) {
            	      if (response.status === 'connected') {
            	    	  //alert(123);
            	    	  testAPI();
            	        // connected
            	    	  //console.log('Successful login for: ' + response.name);
            	      } else if (response.status === 'not_authorized') {
            	        // not_authorized
            	        login();
            	      } else {
            	        // not_logged_in
            	       login();
            	      }
            	    });        		
            });
          }
        </script>
											
						</div>
						<div class="form-row">
							<label class="form-head"></label>
						</div>
					</form>
					<div class="actions">
						<a href="<c:url value='/pages/register.jsp'/>">註冊帳號</a> <a href="/tw/forgot-password/">忘記密碼？</a>
					</div>
				</div>
			</div>
		</div>

		

	</div>


</body>
</html>
