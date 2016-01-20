<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>RememberMe後台管理系統</title>
	
	<link rel="stylesheet" href="../styles/menu.css" type="text/css" media="screen" />
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
<script>
$(document).ready(function() {
	//alert( "xxxxx");
	
	var $select = $('#foods');
	$.ajax({
		url: "../menu.controller/PopulateMenuFood",
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
<script type="text/javascript">
$(document).ready(function(){

	var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;
		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		var categoryNumber = getUrlParameter("category");
		//alert(categoryNumber);
	
	if (categoryNumber)
	{
		//alert(123);
		// $.ajax {
			// url: "/RememberMe/menu.controller/PopulateMenuFood?categoryNumber="+param,
		//}
		$("#foods").val(categoryNumber)
    }
	
    $('#foods').change(function(){
    	
    		//  change URL
    		//url: "/RememberMe/admin/menuList.jsp";
    	    //location.href  = "${pageContext.request.contextPath}/admin/menuList.jsp?categoryNumber="+param
    	
    		$(".row").html("");
       // Your event handler
       var categoryNum = $('select[id=foods]').val();
    	   //alert( "目錄類別"+ categoryNum);
       //var getNoticeData = function(n){
			$.ajax({
				url: "../menu.controller/PopulateMenuFood?categoryNumber="+categoryNum,
				method : "GET",			
				//data: {"category" : categoryNum},//name of category and value of catNum
				success: function(data, textStatus, jqXHR ){
					console.log(JSON.stringify(data));
					console.log(textStatus)
					console.log(jqXHR)
					if(categoryNum>0)
					{
						$.tmpl($('#test'), data).appendTo("#div_notice > div.row");
						$("#div_notice > div.row").prepend("<thead><tr><th>編號</th><th>名稱</th><th>英文名稱</th><th>食用溫度</th><th>價格</th><th>修改日期</th><th></th><th></th></tr></thead>");
					}
				},
				error: function(jqXHR,textStatus,errorThrown){
					console.log(errorThrown);
				}
			});
		//};
    });
    setTimeout(function(){$("#foods").val(categoryNumber).change();}, 0);
});
</script>
</head> 
<body>
	<jsp:include page="/includes/adminTop.jsp" />
	<jsp:include page="/includes/adminLeft.jsp" />
	
		<section id="main" class="column"> 
 		<article class="module width_full">
<!-- 			<header><h3>菜單目錄清單</h3></header> -->
			<div class="module_content">
					<div class="overview_today">			
							<span class="text_span">目錄類別選單
								<select id="foods">
									<option>請選擇目錄類別</option>
								</select>
							</span><hr>
							<div id="div_notice">
						<table>
						<!-- insert thead -->
						</table>
						<div class="row"></div>
					</div>	
				</div>		
			</article>
	 	</section> 
 <script id="test" type="text/x-jQuery-tmpl"> 

	
	<tr>
		<td class="foodListing">{{= foodId}}</td>
		<td class="foodListing">{{= foodNameTw}}</td>
		<td class="foodListing">{{= foodNameUs}}</td>
		<td class="foodListing">{{= temperature}}</td>
		<td class="foodListing">{{= price}}</td>
		<td class="foodListing">{{= updateDate}}</td>
	    <td class="foodListing">
			<a href="${pageContext.request.contextPath}/admin/modifyFoodData.jsp?foodId={{= foodId}}"><input type="button" class="edit" value="修改"/></a>
		</td>
	    <td class="foodListing">
			<a href="${pageContext.request.contextPath}/menu.controller/ModMenuFood?action=delete&foodId={{= foodId}}"><input type="button" class="delete" value="刪除"/></a>
		</td>
	    <br>
	</tr>
   
		</script>
</body>

</html>