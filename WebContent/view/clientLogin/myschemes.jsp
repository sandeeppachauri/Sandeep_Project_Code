<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%
String clientId=(String)session.getAttribute("clientId");
%>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<SCRIPT type="text/javascript">

function getClientSchemeSummerizeDetails(clientId)
{
		b=1;
		$("#content2").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
			$.ajax({
			    type : "post",
			    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeSummirizeReport.action?id="+clientId,
			    success : function(subdeptdata) {
		       $("#"+"content2").html(subdeptdata);
			},
			   error: function() {
		            alert("error");
		        }
			 });
	
}

function getClientSchemeWiseDetails(clientId)
{
		$("#content3").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeWiseReport.action?id="+clientId+"&moduleFalg=3",
		    success : function(subdeptdata) {
	       $("#"+"content3").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
}
getClientSchemeSummerizeDetails('<%=clientId%>');
getClientSchemeWiseDetails('<%=clientId%>');
</script>
</head>
<body>
<div class="page_title"><h1>My Schemes Information</h1>
</div>
<div class="container_block">
<div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<div id="content2">
</div>
<br>
<div id="content3">
</div>				
</div>
</div>
</div>
</div>
</body>
</html>