<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<SCRIPT type="text/javascript">
$.subscribe('level1', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel1").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel1").fadeOut(); }, 4000);
	       });



function clearAllErroDiv()
{
	$("div[id^='error']").each(function() {
  	  // `this` now refers to the current element
	     this.innerHTML="";
  	});
}
function getCLientSchems(clientId)
{
	$("#schemeStatusAjax").html("");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/clientOpneSchemes.action?id="+clientId,
	    success : function(subdeptdata) {
       $("#"+"schemeResponse").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}
function getSchemeStatus(schemeId)
{
	
	$("#schemeStatusAjax").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getClientOpenSchemeStatusForClose.action?id="+schemeId,
	    success : function(subdeptdata) {
       $("#"+"schemeStatusAjax").html(subdeptdata);
	},
	   error: function() {
            alert("Not Eligible For Close");
        }
	 });
}

function getCloseCLientList()
{
	$("#closeClitList").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/beforeCloseSchemeReward.action",
	    success : function(subdeptdata) {
       $("#"+"closeClitList").html(subdeptdata);
	},
	   error: function() {
            alert("Error");
        }
	 });
}
</script>
</head>
<div class="page_title"><h1>Client Scheme >> Close</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Client Scheme >> Close" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:form id="formone" name="formone" namespace="/view/client" action="clientSchemeClose" theme="simple"  method="post">

				<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="clientName" name="clientName" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Client Name--" cssClass="form_menu_inputselect"
                              onchange="getCLientSchems(this.value);"
                              >
                 			 </s:select>
					     <div id="errorclientName" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div id="schemeResponse">
					  <div class="inputmain"><div class="user_form_text1">Client Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="schemeName" name="schemeName" 
                              list="#{'-1':'No List'}"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              onchange="getSchemeStatus(this.value);"
                              >
                 			 </s:select>
					     <div id="errorschemeName" class="errordiv"></div>
					     </div> 
					  </div>
					  </div>
             	</div>		
				<div id="schemeStatusAjax"></div>             
			</s:form>
</div>
</div>
</sj:accordionItem>

<sj:accordionItem title="Client Scheme >> Close Reward" id="twoId" onclick="getCloseCLientList();">  
<div id="closeClitList"></div>
</sj:accordionItem>
</sj:accordion>
</div>
</div>
</html>