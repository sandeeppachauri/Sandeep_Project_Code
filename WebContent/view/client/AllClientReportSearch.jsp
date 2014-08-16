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

	$("#"+"process").html("<right><img src=images/notificationloader.gif></right>");
	$("#"+"responseDiv").html("");
	var schemeName=$('#schemeName').val();
	var client=$('#client').val();
	var dateFrom=$('#dateFrom').val();
	var dateTo=$('#dateTo').val();
	var schemeStatus=$('#schemeStatus').val();
	var cardNo=$('#cardNo').val();
	var dataObj={"schemeName":schemeName,"client":client,"dateFrom":dateFrom,"dateTo":dateTo,"schemeStatus":schemeStatus,"cardNo":cardNo};
	$.ajax({
		 type : "post",
		    url : "<%=request.getContextPath()%>/view/client/clientReportSearchResult.action",
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
<div class="page_title"><h1>Client Scheme >> Report View</h1>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Daily Collection >> Report View" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Name:</div>
					     <div class="user_form_input inputarea">
					     <s:select id="schemeName" name="schemeName" 
                              list="schemeList"
                              headerKey="-1" headerValue="--Select Scheme Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Client Name:</div>
					     <div class="user_form_input inputarea">
					    <s:select id="client" name="client" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Client Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Status:</div>
					     <div class="user_form_input inputarea">
					     <s:select id="schemeStatus" name="schemeStatus" 
                              list="{'Active','Completed','Surrendered','Lucky Draw Completed'}"
                              headerKey="-1" headerValue="--Select Scheme Status--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Card Number:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="cardNo"  id="cardNo"  cssClass="form_menu_inputtext" placeholder="Enter Card Number" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
             	</div>
             	
             	 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Collection Date From:</div>
					     <div class="user_form_input inputarea">
					     <sj:datepicker name="dateFrom" id="dateFrom" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select Collection From Date"/>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Collection Date To:</div>
					     <div class="user_form_input inputarea">
					     <sj:datepicker name="dateTo" id="dateTo" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select Collection To Date"/>
					     </div>
					  </div>
             	</div>
             	
             	
				<div id="process"></div>
				<div class="fields" id="sub_field">
					<ul>
					<li class="submit" style="padding:0px 10px;">
					<input type="button" class="submit" name="" id="send" value="Get Graph" onclick="searchGraphReport();"></li>
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