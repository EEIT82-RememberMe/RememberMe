<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Fullscreen Pageflip Layout with BookBlock</title>
		<meta name="description" content="Fullscreen Pageflip Layout with BookBlock" />
		<meta name="keywords" content="fullscreen pageflip, booklet, layout, bookblock, jquery plugin, flipboard layout, sidebar menu" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="../styles/jquery.jscrollpane.custom.css" />
		<link rel="stylesheet" type="text/css" href="../styles/bookblock.css" />
		<link rel="stylesheet" type="text/css" href="../styles/custom.css" />
		<script src="../js/modernizr.custom.79639.js"></script>
	
	</head>
	<body>
		<div id="container" class="container">	

			<div class="menu-panel">
				<h3>Table of Contents</h3>
				<ul id="menu-toc" class="menu-toc">
					<li class="menu-toc-current"><a href="#item1">Self-destruction</a></li>
					<li><a href="#item2">Why we die</a></li>
					<li><a href="#item3">The honeymoon</a></li>
					<li><a href="#item4">A drawing joke</a></li>
					<li><a href="#item5">Commencing practice</a></li>
				</ul>
				<div>
					<a href="http://tympanus.net/Development/AudioPlayer/">&larr; Previous Demo: Responsive Audio Player</a>
					<a href="http://tympanus.net/codrops/?p=12795">Back to the Codrops Article</a>
				</div>
			</div>
			<div class="bb-custom-wrapper">
				<div id="bb-bookblock" class="bb-bookblock">
				<div class="bb-item" id="item1">
						<div class="content">
							<div class="scroller">
								<div class="div_right">
									<p><em>M E N U</em></p>
									<p>每人最低消費飲品乙杯 | 餐點飲品均收10%服務費</p>
								</div>
								<div class="div_left">
									<img src="../imageMenu/menuFace.png">
								</div>
							</div>
						</div>
					</div>
					<div class="bb-item" id="item2">
						<div class="content">
							<div class="scroller">
								
								<div id="">
									<h2>| 記 得 喝 咖 啡 | Coffee</h2>	
									<div id="sessions"></div>
								</div>
								
							</div>
						</div>
					</div>
					
					<div class="bb-item" id="item3">
						<div class="content">
							<div class="scroller">
								<h2>The honeymoon</h2>
								<p>
								abcabcabcabcabcabcabcabcabcabc
								
								</p>

								<p><em>From <a href="http://www.gutenberg.org/ebooks/41595" target="_blank">"The Funny Side of Physic"</a> by A. D. Crabtre</em></p>
							</div>
						</div>
					</div>
					<div class="bb-item" id="item4">
						<div class="content">
							<div class="scroller">
								<h2>A drawing joke</h2>
								

								<p><em>From <a href="http://www.gutenberg.org/ebooks/41595" target="_blank">"The Funny Side of Physic"</a> by A. D. Crabtre</em></p>
							</div>
						</div>
					</div>
					<div class="bb-item" id="item5">
						<div class="content">
							<div class="scroller">
								<h2>Commencing practice</h2>
								

								<p><em>From <a href="http://www.gutenberg.org/ebooks/41595" target="_blank">"The Funny Side of Physic"</a> by A. D. Crabtre</em></p>
							</div>
						</div>
					</div>
				</div>
				
				<nav>
					<span id="bb-nav-prev">&larr;</span>
					<span id="bb-nav-next">&rarr;</span>
				</nav>

				<span id="tblcontents" class="menu-button">Table of Contents</span>

			</div>
				
		</div><!-- /container -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="../js/jquery.mousewheel.js"></script>
		<script src="../js/jquery.jscrollpane.min.js"></script>
		<script src="../js/jquerypp.custom.js"></script>
		<script src="../js/jquery.bookblock.js"></script>
		<script src="../js/page.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function(){
				var times;
				$.ajax({
					url: "../menu.controller/PopulateMenuFood?categoryNumber=1",
					method : "GET",			
					//data: {"category" : categoryNum},//name of category and value of catNum
					success: function(data, textStatus, jqXHR ){
						console.log(JSON.stringify(data));
						console.log(textStatus)
						console.log(jqXHR)	
						times = data;
						//alert(times.length);
						//$.tmpl($('#test'), data).appendTo("#div_notice > div.row");
						var newContent = '';
						for(var i =0; i <times.length; i++)
						{
							newContent += '<span>'+ times[i].textDecoration + times[i].foodNameUs +'</span>'
							             +'<br>'+'('+ times[i].info +')'+'-----------------------------'
							             + times[i].temperature + "NT " + times[i].price + '<br><br>';		
						}
						$('#sessions').html(newContent);
						
					},
					error: function(jqXHR,textStatus,errorThrown){
						console.log(errorThrown);
					}
				});
			});
	    </script>
		
		<script>
			$(function() {
				Page.init();
			});
		</script>	
	</body>
</html>
<!-- 								<div class="menu_top"> -->
<!-- 									<div class="menu_top_left"> -->
<!-- 										<h3>每人最低消費飲品乙杯 | 餐點飲品均收10%服務費</h3> -->
<!-- 										Minimum order One drink per person | All prices are subject to 10% service charge -->
<!-- 										<br><br><h3>如遇表演活動, 最低消費請參考店內公告</h3> -->
<!-- 										Minimum charge may change if any activity or performance in Remember Me Cafe' -->
<!-- 									</div> -->
<!-- 									<div class="menu_top_right"> -->
<!-- 										<img src="../images/menu_coffee_pic.jpg"> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<h2>Why we die</h2> -->