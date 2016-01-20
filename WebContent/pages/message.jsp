<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
	<link href="../styles/notice.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="../js/jquery.tmpl.js"></script>
	<link href="../styles/style.css" rel="stylesheet">
    <link href="../styles/style-responsive.css" rel="stylesheet" />
    
    
    <title></title>
	
</head>

<body id="body_sub"  >
	<jsp:include page="/includes/header.jsp" />
	
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
								<c:when test="${element.memberId=='admin'}"><font size="4" style="color: #9955FF">${element.memberId}</font></c:when>
								<c:when test="${element.memberId!='admin'}"><font size="4" style="color: #77FFEE">${element.memberId}</font></c:when>
							</c:choose>
							<font size="2" color="#AAAAAA">|   ${times[i]}</font><br>
							<div class="dialog">
								<span class="dialogbot"></span>
								<span class="dialogtop"></span>
							<font class="fontmesgcontent">${element.messageContent}</font>
							</div>
							</div>
							<c:if test="${user.memberId!=null }">
								<div class="mesghref">
									<font size="2">
										<a value="${element.messageId}" href="javascript:void(0)" class="mesgreply">回覆</a> 
										<c:if test="${user.memberId==element.memberId }">
											<a href="${pageContext.request.contextPath}/message.controller/ProcessMessage?messageId=${element.messageId}" >刪除</a><br>
										</c:if>
									</font>
								</div>
							</c:if>
						</div>	
							<div id="a${element.messageId}" class="block"></div>
							<div class="responseDiv">
								<c:forEach items="${ messageResponse}" var="res" varStatus="status">
									<c:if  test="${res.messageId == element.messageId }">
										<input type="hidden" value="${res.messageResponseId }" name="messageResponseId">
											<input type="hidden" value="${res.messageId }" name="messageId">
											<c:set var="j" value="${status.count-1 }" ></c:set>
											 <div class="refontcontent">
											    <c:choose><c:when test="${res.memberId=='admin'}"><font size="4" style="color: #9955FF">${res.memberId}</font></c:when>
											    <c:when test="${res.memberId!='admin'}"><font size="4" style="color: #77FFEE">${res.memberId}</font></c:when>
											    </c:choose><font size="2" color="#AAAAAA"> |  ${responseTimes[j] } </font><br>
												<div class="redialog">
													<font class="fontremesgcontent">${res.messageResponseContent }<br></font>
												</div>
											</div>
											<c:if test="${res.memberId==user.memberId}">
												<div class="remesghref">
													<font size="1">
														<a class="del" href="${pageContext.request.contextPath}/message.controller/ProcessMessageResponse?messageResponseId=${res.messageResponseId}" name="res_delete" value="Delete">刪除</a><br>
													</font>
												</div>
											</c:if>
									</c:if>
								</c:forEach>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="table_page_css"><span id="table_page"></span></div>
	</div>
				<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-tablepage-1.0.js"></script>
				<script> 
				    $(function(){
				    	$("#message_show").tablepage($("#table_page"),6);
				    })
					$(document).ready(function(){
				
					$(".mesgreply").click(function(){ 
						 $("#a"+$(this).attr("value")).html( "<form action='${pageContext.request.contextPath}/message.controller/ProcessMessageResponse' method='post' id='responseform' class='reply_form'><input type='hidden' name='memberId' value='${user.memberId}'><input type='hidden' name='messageId' value='"+$(this).attr("value")+"' ><br><textarea name='reply_content' rows='5' wrap='hard' cols='50' id='content' ></textarea><br><input type='submit' name='send' value='Send' id='responsend'><input type='reset' value='Clean' id='respcel'></form>");
					var aa =$(this).attr("value");
					});
					});
					
				</script>  	
	<c:if test="${user.memberId==null }">	
	<div><table><a href="${pageContext.request.contextPath }/pages/login.jsp"  >我要留言</a></table></div>			
	</c:if>				
	<c:if test="${user.memberId!=null }">
		<div>
		    <form method="post" class="contact-form" action="${pageContext.request.contextPath}/message.controller/ProcessMessage"  >
		        <table id="message_table">
		           <tr>
		               <td id="td_head">留言區</td>
		           </tr>
		           	<tr><td><input type="hidden" name="memberId" value="${user.memberId }"></td></tr>
		            <tr>
		                <td><textarea  name="messageContent"  wrap="hard" rows="5" cols="32"></textarea></td>
		            </tr>
		            <tr>
		                <td id="td_but">
		                <input type="submit" class="post_reset" name="passbtn" value="留言" > 
		                <input type="reset" class="post_reset" value="清除"></td>
		            </tr>
		        </table>
		    </form>
		</div>
	</c:if>
</body>

</html>