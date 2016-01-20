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
 		<div  id="show">
		<table id="message_show">
			<tbody id="showbody" >
				<c:forEach var = "element" items="${message }"  varStatus="status"  >
					<tr >
						<c:set var="i"  value="${status.count-1}"></c:set>
						<td class="messageName">
						<input type="hidden" name="messageId" value="${element.messageId}"  >
						<div class="mesgborder">
							<div class="fontcontent">
							<c:choose>
								<c:when test="${element.memberId=='admin'}"><font size="4" style="background-color: #9955FF">${element.memberId}</font></c:when>
								<c:when test="${element.memberId!='admin'}"><font size="4" style="background-color: #77FFEE">${element.memberId}</font></c:when>
							</c:choose>
							<font size="1" color="#AAAAAA">${times[i]}</font><br>
							
							<font class="fontmesgcontent">${element.messageContent}</font>
							
							</div>
							<div class="mesghref">
							<font size="1">
							<a value="${element.messageId}" href="javascript:void(0)" class="mesgreply">Reply</a> 
							<a href="${pageContext.request.contextPath}/message.controller/MessageServlet?messageId=${element.messageId}" >Delete</a><br>
							</font>
							</div>
						</div>	
							<div id="a${element.messageId}" class="block"></div>
							<div class="responseDiv">
								<c:forEach items="${ messageResponse}" var="res" varStatus="status">
										<c:if  test="${res.messageId == element.messageId }">
										<input type="hidden" value="${res.messageResponseId }" name="messageResponseId">
											<input type="hidden" value="${res.messageId }" name="messageId">
											<c:set var="j" value="${status.count-1 }" ></c:set>
											${res.memberId } ${responseTimes[j] }<br>
											${res.messageResponseContent }<br>
												<a class="del" href="${pageContext.request.contextPath}/message.controller/ResponseServlet?messageResponseId=${res.messageResponseId}" name="res_delete" value="Delete">Delete</a><br>
										</c:if>
								</c:forEach>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="table_page_css"><span  id="table_page"></span></div>
	</div>
				<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-tablepage-1.0.js"></script>
 			  		<script> 
				    $(function(){
				    	$("#message_show").tablepage($("#table_page"),6);
				    })
					$(document).ready(function(){
				
					$(".mesgreply").click(function(){ 
						 $("#a"+$(this).attr("value")).html( "<form  action='${pageContext.request.contextPath}/message.controller/ResponseServlet' method='post' id='responseform' class='reply_form'><input type='hidden' name='memberId' value='${user.memberId}'><input type='hidden' name='messageId' value='"+$(this).attr("value")+"' ><br><textarea name='reply_content' rows='5' cols='50' id='content' ></textarea><br><input type='submit' name='send' value='Send' id='responsend'><input type='reset' value='Clean' id='respcel'></form>");
// 					var aa =$(this).attr("value");
// 						$("#responseform").on("submit",function(re){
// 							re.preventDefault();
// 							$.ajax({
// 								type:"get",
// 								url:"${pageContext.request.contextPath}/message.controller/ResponseServlet",
// 								data:{memberId:'${user.memberId}',messageId:aa,send:'Send',reply_content:$('#content').val()},
// 								dataType:"text",
// 								success:function(responseText){
// 											location.reload();
// 								},
// 								error:function(ss){
// 									alert("ssssssss");
// 								}
// 							})
// 						})
					});
					});
					
				</script>  	
 			  		
 		</section> 
</body>

</html>