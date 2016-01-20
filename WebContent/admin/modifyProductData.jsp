<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="../styles/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="../styles/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="../js/hideshow.js" type="text/javascript"></script>
	<script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
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
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>
<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
</head>
<%@ page import="products.model.ProductBean" %>
<%@ page import="products.model.ProductService" %>
<%
    String num = request.getParameter("productId");
    String currentPage = request.getParameter("page");
    int number = Integer.parseInt(num);
    //System.out.println(number);
    ProductBean bean = new ProductBean();
    ProductService productService = new ProductService();
    ProductBean result = productService.select(number);
    result.setProductId(number);
    request.setAttribute("select", result);
    request.setAttribute("currentPage", currentPage);
    //System.out.print(result.getProductId());
%>
<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
		<section id="main" class="column"> 
 			 
 			<article class="module width_full">
			<header>
				<span class="head">修改產品資訊</span>		
			</header>
			<div class="module_content">
				<article class="stats_overview">
					<div class="module_content">
<!--------------------------------------productNameTw-------------------------------------------------------->
					<form action="../products.controller/ModProduct" method="POST" enctype="multipart/form-data">
						<fieldset style="width:48%; float:left;">
							<label>產品名稱</label>
							<input type="text" name="productNameTw" value="${select.productNameTw}" style="width:92%;">
						</fieldset>
<!--------------------------------------productNameUs-------------------------------------------------------->
						<fieldset style="width:48%; float:right;">
							<label>英文名稱</label>
							<input type="text" name="productNameUs" value="${select.productNameUs}" style="width:92%;">
						</fieldset>
<!--------------------------------------productDescription-------------------------------------------------------->
						<fieldset>
							<label>產品敘述</label>
							<textarea rows="5" style="font-size:20px" name="productDescription">${select.productDescription}</textarea>
						</fieldset>
						
<!--------------------------------------remarks-------------------------------------------------------->
						<fieldset>
							<label>備註</label>
							<textarea rows="2" style="font-size:20px"  name="remarks" >${select.remarks}</textarea>
						</fieldset>
<!--------------------------------------productImage-------------------------------------------------------->
						<fieldset style="width:30%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>圖片</label>
							<div class="form-group">
                                      <input type="file" accept="image/*" name="productImage" value="${select.productImage}">
                            </div>
						</fieldset>
<!--------------------------------------productPrice/stock-------------------------------------------------------->
						<fieldset style="width:40%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>價格</label>
<!-- 							<input type="text" style="width:5%;float:left;margin-left: 50px;" name="blogLink" value=""> -->
<!-- 							<input type="text" style="width:5%;float:left;margin-left: 50px;" name="blogLink" value=""> -->
								<span style="float:left"></span><input type="text" style="width:30%;" name="productPrice" value="${select.productPrice}">
								<span style="float:left">庫存</span><input type="text" style="width:10%;" name="stock" value="${select.stock}">
						</fieldset><div class="clear"></div>
						
						<input type="hidden" value="${currentPage}" name="page">
 						<input type="hidden" value="${select.productId}" name="productId">
						<input type="submit" value="更新" name="action">
					</form>
				</div>
				
				</article>

				
				<div class="clear"></div>
			</div>
			
		</article><!-- end of stats article -->
	 	</section> 
</body>
</html>