<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<script type="text/javascript">
function searchReport()
{

	var schemeName=$('#schemeName').val();
	$("#"+"process").html("<right><img src=images/notificationloader.gif></right>");
	var dataObj={"schemeId":schemeName};
	$.ajax({
		 type : "post",
		    url : "<%=request.getContextPath()%>/view/common/paymentPandingReportSearchResult.action",
		    data: dataObj,
		    success : function(subdeptdata) {
	       $("#"+"responseDiv").html(subdeptdata);
	       $("#"+"process").html("");
		},
		   error: function() {
	            alert("error");
	        }
	});
}
</script>
</head>
<div class="page_title"><h1> Payment Pending Status >> Report View Pending Payment</h1>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Client Scheme Status >> Report View" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
                 <div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Scheme Name:</div>
					     <div class="user_form_input inputarea">
					    <s:select id="schemeName" name="schemeName" 
                              list="schemeNameList"
                              headerKey="-1" headerValue="--Select Scheme Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div>
					  </div>
             	</div>
             	
				<div id="process"></div>
				<div class="fields" id="sub_field">
					<ul>
					<li class="submit" style="padding:0px 10px;">
					<input type="button" class="submit" name="" id="send" value="Search" onclick="searchReport();"></li>
					</ul>
				</div>
</div>
</div>
</sj:accordionItem>

</sj:accordion>
<br><br>
<div id="responseDiv"></div>
</div>
</div>
</html>