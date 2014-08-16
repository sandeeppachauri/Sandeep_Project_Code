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
	var agent=$('#agent').val();
	var client=$('#client').val();
	var cardNo=$('#cardNo').val();
	var collectionType=$('#collectionType').val();
	var dateFrom=$('#dateFrom').val();
	var dateTo=$('#dateTo').val();
	var recieptNo=$('#recieptNo').val();
	var dataObj={"agent":agent,"client":client,"cardNo":cardNo,"collectionType":collectionType,"dateFrom":dateFrom,"dateTo":dateTo,"recieptNo":recieptNo};
	$.ajax({
		 type : "post",
		    url : "<%=request.getContextPath()%>/view/common/searchCollectionReport.action",
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


function searchGraphReport()
{
	$("#"+"process").html("<right><img src=images/notificationloader.gif></right>");
	var agent=$('#agent').val();
	var client=$('#client').val();
	var cardNo=$('#cardNo').val();
	var collectionType=$('#collectionType').val();
	var dateFrom=$('#dateFrom').val();
	var dateTo=$('#dateTo').val();
	var recieptNo=$('#recieptNo').val();
	var dataObj={"agent":agent,"client":client,"cardNo":cardNo,"collectionType":collectionType,"dateFrom":dateFrom,"dateTo":dateTo,"recieptNo":recieptNo};
	$.ajax({
		 type : "post",
		    url : "<%=request.getContextPath()%>/view/common/searchCollectionGraphicalReport.action",
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
<div class="page_title"><h1>Daily Collection >> Report View</h1>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Daily Collection >> Report View" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Agent Name:</div>
					     <div class="user_form_input inputarea">
					     <s:select id="agent" name="agent" 
                              list="agentNames"
                              headerKey="-1" headerValue="--Select Source of client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Client Name:</div>
					     <div class="user_form_input inputarea">
					    <s:select id="client" name="client" 
                              list="clientsNames"
                              headerKey="-1" headerValue="--Select Source of client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div>
					  </div>
             	</div>
             	
             	
             	
             	 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Card No:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="cardNo"  id="cardNo"  cssClass="form_menu_inputtext" placeholder="Enter Card No" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Collection Type:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="collectionType"  id="collectionType"  cssClass="form_menu_inputtext" placeholder="Enter Collection Type" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
             	</div>
             	
             	 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Date From:</div>
					     <div class="user_form_input inputarea">
					     <sj:datepicker name="dateFrom" id="dateFrom" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select From Date"/>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Date To:</div>
					     <div class="user_form_input inputarea">
					     <sj:datepicker name="dateTo" id="dateTo" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select To Date"/>
					     </div>
					  </div>
             	</div>
             	
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Receipt No:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="recieptNo"  id="recieptNo"  cssClass="form_menu_inputtext" placeholder="Enter Receipt No" cssStyle="margin:0px 0px 10px 0px"/>
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