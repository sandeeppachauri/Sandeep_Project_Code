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

$.subscribe('level11', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel11").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel11").fadeOut(); }, 4000);
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
	var schemeTypeRecvd=document.getElementById("schemeTypeRecvd").value;
	//alert("schemeTypeRecvd  "+schemeTypeRecvd);
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getClientMapSchemes.action?id="+clientId+"&schemeTypeRecvd="+schemeTypeRecvd,
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
	//alert(schemeId);
	var schemeTypeRecvd=document.getElementById("schemeTypeRecvd").value;
	$("#schemeStatusAjax").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getClientSchemeStatus.action?id="+schemeId+"&schemeTypeRecvd="+schemeTypeRecvd,
	    success : function(subdeptdata) {
       $("#"+"schemeStatusAjax").html(subdeptdata);
	},
	   error: function() {
            alert("Not Eligible For withdrawal");
        }
	 });
}

//SURRENDER SCHEME WORK 
function getCLientSchemsForSurrender(clientID)
{
	$("#surrndrSchemeDeatilDiv").html("");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getClientSchemeSurrender.action?id="+clientID,
	    success : function(subdeptdata) {
       $("#"+"schemeStatusAjaxSurrender").html(subdeptdata);
	},
	   error: function() {
            alert("Not Eligible For withdrawal");
        }
	 });
}

function getSchemeDetailsSurrender(schemeId)
{
	//alert(schemeId);
	$("#surrndrSchemeDeatilDiv").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getClientSchemeSurrenderDetail.action?id="+schemeId,
	    success : function(subdeptdata) {
       $("#"+"surrndrSchemeDeatilDiv").html(subdeptdata);
	},
	   error: function() {
            alert("Not Eligible For withdrawal");
        }
	 });
}

function getTypeOfReward(rewardType)
{
	if(rewardType=='Cash')
		{
		$("#"+"cashAdjustment").hide();
		$("#"+"jlwlryDiv").hide();
		document.getElementById('adjstmntVlue').value="";
		document.getElementById('cashRtrn').value="";
		$("#"+"cashInhnd").show();
		
		}
	else if(rewardType=='Adjustment')
		{
		$("#"+"cashInhnd").hide();
		$("#"+"jlwlryDiv").hide();
		document.getElementById('cashInHand').value="";
		$("#"+"cashAdjustment").show();
		}
	else
		{
		$("#"+"cashAdjustment").hide();
		document.getElementById('adjstmntVlue').value="";
		document.getElementById('cashRtrn').value="";
		document.getElementById('cashInHand').value="";
		$("#"+"cashInhnd").hide();
		$("#"+"jlwlryDiv").show();
		
		}
}

function typeOfJwlry(jwlryType)
{
	//alert(jwlryType);
	if(jwlryType=="Diamond Jwellery")
		{
			$("#"+"goldType").hide();
			$("#"+"silverPur").hide();
			$("#"+"luckStone").hide();
			$("#"+"stoneDetail").hide();
			document.getElementById('stoneWght').value="";
			$("#"+"goldDetail").hide();
			document.getElementById('pureGoldType').value="-1";
			document.getElementById('silverWght').value="";
			document.getElementById('goldWght').value="";
			document.getElementById('stoneName').value="-1";
			$("#"+"dmndType").show();
			$("#"+"dimndDetail").show();
		}
	else if(jwlryType=="Gold Jwellery")
	{
		document.getElementById('dmnndGoldType').value="-1";
		document.getElementById('silverWght').value="";
		document.getElementById('stoneName').value="-1";
		document.getElementById('dmndWght').value="";
		document.getElementById('dmdnRate').value="";
		document.getElementById('dmndValue').value="";
		document.getElementById('goldValue').value="";
		$("#"+"stoneDetail").hide();
		document.getElementById('stoneWght').value="";
		$("#"+"dmndType").hide();
		$("#"+"silverPur").hide();
		$("#"+"luckStone").hide();
		$("#"+"dimndDetail").hide();
		$("#"+"goldType").show();
		$("#"+"goldDetail").show();
	}
	else if(jwlryType=="Silver Jwellery")
	{
		document.getElementById('dmnndGoldType').value="-1";
		document.getElementById('pureGoldType').value="-1";
		document.getElementById('stoneName').value="-1";
		document.getElementById('dmndWght').value="";
		document.getElementById('dmdnRate').value="";
		document.getElementById('dmndValue').value="";
		document.getElementById('goldValue').value="";
		document.getElementById('goldWght').value="";
		$("#"+"stoneDetail").hide();
		document.getElementById('stoneWght').value="";
		$("#"+"dmndType").hide();
		$("#"+"goldType").hide();
		$("#"+"silverPur").show();
		$("#"+"luckStone").hide();
		$("#"+"dimndDetail").hide();
		$("#"+"goldDetail").hide();
	}
	else
		{
			document.getElementById('dmnndGoldType').value="-1";
			document.getElementById('pureGoldType').value="-1";
			document.getElementById('silverWght').value="";
			document.getElementById('dmndWght').value="";
			document.getElementById('dmdnRate').value="";
			document.getElementById('dmndValue').value="";
			document.getElementById('goldValue').value="";
			document.getElementById('goldWght').value="";
			$("#"+"goldDetail").hide();
			$("#"+"dmndType").hide();
			$("#"+"dimndDetail").hide();
			$("#"+"goldType").hide();
			$("#"+"silverPur").hide();
			$("#"+"luckStone").show();
			$("#"+"stoneDetail").show();
		}
}
function fillValueOfDmnd(dmdnRate)
{
	var dmndWght=document.getElementById('dmndWght').value;
	var dmndvalue=dmndWght*dmdnRate;
	//alert("dmdnRate  "+dmdnRate+"   dmndWght   "+dmndWght+"   dmndvalue   "+dmndvalue);
	var totalPurchaseOf=document.getElementById('totalPurchaseOf').value;
	var goldOf=totalPurchaseOf-dmndvalue;
	document.getElementById('dmndValue').value=dmndvalue;
	document.getElementById('goldValue').value=goldOf;
}

function printReport(divID) {
	var divElements = document.getElementById(divID).innerHTML;
	var oldPage = document.body.innerHTML;
	document.body.innerHTML = "<html><head><title></title></head><body>"
			+ divElements + "</body>";
	window.print();
	document.body.innerHTML = oldPage;
}
</script>
</head>
<div class="page_title"><h1>Client Scheme >> Surrender</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Client Scheme >> Surrender" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:form id="formone" name="formone" namespace="/view/client" action="clientSchemeSurrender" theme="simple"  method="post">
<s:hidden name="schemeTypeRecvd" value="%{schemeTypeRecvd}" id="schemeTypeRecvd"></s:hidden>		

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

<sj:accordionItem title="Client Scheme >> Surrender Reward" id="twoId">  
<s:form id="formTwo" name="formTwo" namespace="/view/client" action="clientSchemeSurrenderReward" theme="simple"  method="post">
<s:hidden id="goldTypeCart" name="goldTypeCart"></s:hidden>
<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="clientName" name="clientName" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Client Name--" cssClass="form_menu_inputselect"
                              onchange="getCLientSchemsForSurrender(this.value);"
                              >
                 			 </s:select>
					     <div id="errorclientName" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div id="schemeStatusAjaxSurrender">
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
             	
<div id="surrndrSchemeDeatilDiv"></div>

</s:form>
</sj:accordionItem>
</sj:accordion>
</div>
</div>
</html>