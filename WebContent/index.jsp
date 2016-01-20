<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link rel="stylesheet" type="text/css" href="styles/bgstretcher.css" />
	
	<!-- 最新編譯和最佳化的 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <!-- 選擇性佈景主題 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

    <!-- 最新編譯和最佳化的 JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <!-- bootstrap.js & css -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">

        function slideSwitch() {
            var $active = $('#slideshow IMG.active');

            if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

            // use this to pull the images in the order they appear in the markup
            var $next =  $active.next().length ? $active.next()
                    : $('#slideshow IMG:first');

            // uncomment the 3 lines below to pull the images in random order

            // var $sibs  = $active.siblings();
            // var rndNum = Math.floor(Math.random() * $sibs.length );
            // var $next  = $( $sibs[ rndNum ] );


            $active.addClass('last-active');

            $next.css({opacity: 0.0})
                    .addClass('active')
                    .animate({opacity: 1.0}, 3000, function() {
                        $active.removeClass('active last-active');
                    });
        }

        $(function() {
            setInterval( "slideSwitch()", 9000 );
        });

    </script>
    
<title>Insert title here</title>
</head>
<body id="index_body">
<!-- <script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1652372388346353',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script> -->
<jsp:include page="/includes/header.jsp" />
	

<!-- this will work with any number of images -->
<!-- set the active class on whichever image you want to show up as the default
(otherwise this will be the last image) -->
<div id="slideshow">
    <img src="images/cover12.jpg" alt="Slideshow Image 1" class="active" />
    <img src="images/cover11.jpg" alt="Slideshow Image 2" />
    <img src="images/cover10.jpg" alt="Slideshow Image 3" />
    <img src="images/cover9.jpg" alt="Slideshow Image 4" />
    <img src="images/cover13.jpg" alt="Slideshow Image 5" />
</div>

<div id="top_news_wrap">
	<div id="top_news">
		<h2 class="NL">
			<span>NEWS</span>
		</h2>
		<div id="innerbox">
			<dl>
				<dt><span>一位想用歌聲</span>2015.12.20</dt>
				<dd>不同的角度看待事物比起拍照，有時卻更喜歡用身體五官去感受自然</dd>
		    </dl>
			<dl>
				<dt><span>純淨的嗓音</span>2015.12.20</dt>
				<dd>希望用一個人帶著一把吉他的方式和真摯的聲音訴說他的故事</dd>
			</dl>
			<dl>
				<dt><span>生活上點點滴滴</span>2015.12.20</dt>
				<dd>一位想用歌聲跟你說故事的女聲黃茵琪對音樂有堅持</dd>
			</dl>
			<dl>
				<dt><span>歌聲跟你說故事</span>2015.12.20</dt>
				<dd>歡民謠與迷幻搖滾，反核，支持台灣獨立歌曲中的故事來自生活</dd>
			</dl>
		</div>
		
<!-- 		<div id="more" class="NL"> -->
<!-- 			<a class="btn_more pjax "href="">MORE</a> -->
<!-- 		</div> -->
	</div>
</div>		
<!-- <div
  class="fb-like"
  data-share="true"
  data-width="450"
  data-show-faces="true">
</div> -->
		
</body>
</html>