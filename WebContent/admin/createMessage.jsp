<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
$(document).ready(function() {
	//alert( "xxxxx");
	
	var $select = $('#foods');
	$.ajax({
		url: "${pageContext.request.contextPath}/menu.controller/PopulateMenuFood",
		method : "GET",
		// [{ value:"1", text:"coffee" }, {value:"2", text: "cake"}, {}, {}, {}]
		success: function(data, textStatus, jqXHR ){
			console.log(JSON.stringify(data));
			console.log(textStatus)
			console.log(jqXHR)
		
			$select.find('option.tt').remove();
			
			$.each(data, function(index, elem) {
		          var $options = $("<option></option>");
		          $options.attr("value", elem.value);
		          $options.addClass("tt");
		          $options.text(elem.text);
		          $select.append($options);
		          // "<option value='data.value' class='tt'> data.text </option>"
		          //var options = document.createElement("option")
		      	});
		},
		error: function(jqXHR,textStatus,errorThrown){
			console.log(errorThrown);
		}
	});      
  });
</script>
</head>
<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
		<section id="main" class="column"> 
 			 
 			<article class="module width_full">
			<header>
				<span class="head">新增留言</span>		
			</header>
			<div class="module_content">
				<article class="stats_overview">
					<div class="module_content">
<!--------------------------------------textDecoration-------------------------------------------------------->
					<form action="${pageContext.request.contextPath }/message.controller/MessageServlet" method="POST">
						<fieldset>
							<label>目錄顯示字樣</label>
							<textarea rows="2" style="font-size:20px" wrap="hard" name="messageContent">
							</textarea>
						</fieldset>
						<input type="hidden" name="memberId" value="admin">
						<input type="submit" value="新增" name="action">
<!-- 						<input type="reset" value="清除" > -->
					</form>
				</div>
				</article>
				<div class="clear"></div>
			</div>
			
		</article><!-- end of stats article -->
	 	</section> 
</body>

</html>