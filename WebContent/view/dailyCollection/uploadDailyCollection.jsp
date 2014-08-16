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

$.subscribe('validate1', function(event,data)
        {

			if(document.mannualAdd.colctnMode.value!=null && document.mannualAdd.colctnMode.value=="" || document.mannualAdd.colctnMode.value=="-1")
		    {
				clearAllErroDiv();
				errorcolctnMode.innerHTML="Error: Select Payment Mode";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.mannualAdd.colctnMode.value!=null && document.mannualAdd.colctnMode.value=="Cheque")
		    {
				if(document.mannualAdd.chequeNo.value!=null && document.mannualAdd.chequeNo.value=="" || document.mannualAdd.chequeNo.value=="-1")
			    {
					clearAllErroDiv();
					errorchequeNo.innerHTML="Error: Enter Cheque Number";
	            	event.originalEvent.options.submit = false;
	            	return false;
			    }
				else if(document.mannualAdd.submitAmmount.value!=null && document.mannualAdd.submitAmmount.value=="" || document.mannualAdd.submitAmmount.value=="-1")
			    {
					clearAllErroDiv();
					errorsubmitAmmount.innerHTML="Error: Enter Collection Amount";
	            	event.originalEvent.options.submit = false;
	            	return false;
			    }
				else if(document.mannualAdd.colelctionDate.value!=null && document.mannualAdd.colelctionDate.value=="" || document.mannualAdd.colelctionDate.value=="-1")
			    {
					clearAllErroDiv();
					errorcolelctionDate.innerHTML="Error: Enter Collection Date";
	            	event.originalEvent.options.submit = false;
	            	return false;
			    }
		    }
			else if(document.mannualAdd.submitAmmount.value!=null && document.mannualAdd.submitAmmount.value=="" || document.mannualAdd.submitAmmount.value=="-1")
		    {
				clearAllErroDiv();
				errorsubmitAmmount.innerHTML="Error: Enter Collection Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.mannualAdd.colelctionDate.value!=null && document.mannualAdd.colelctionDate.value=="" || document.mannualAdd.colelctionDate.value=="-1")
		    {
				clearAllErroDiv();
				errorcolelctionDate.innerHTML="Error: Enter Collection Date";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
			var returnValue=testNumericValue('submitAmmount','errorsubmitAmmount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
        });

function clearAllErroDiv()
{
	$("div[id^='error']").each(function() {
  	  // `this` now refers to the current element
	     this.innerHTML="";
  	});
}

function getCleintAllSchemes(clientId)
{
	$("#"+"buttonDIv").hide();
	document.getElementById("cardNo").value="";
	document.getElementById("clientName").value="";
	document.getElementById("agentName").value="";
	document.getElementById("ammount").value="";
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/common/clientAllSchemes.action?id="+clientId,
	    success : function(subdeptdata) {
       $("#"+"schemeResponse").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}
function setCleintCardNo(cardNoTemp)
{
	//cardno,clientaname,agent name
	var data=cardNoTemp.split('#');
	document.getElementById("cardNo").value=data[0];
	document.getElementById("clientName").value=data[1];
	document.getElementById("agentName").value=data[2];
	document.getElementById("ammount").value=data[3];
	$("#"+"buttonDIv").show();
}
function setValueForCheck(type)
{
	if(type=='Cash')
		{
			$("#"+"chqDiv").hide();
		}
	else{
		$("#"+"chqDiv").show();
	}
}
</script>
</head>
<div class="page_title"><h1>Daily Collection >> Registration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Daily Collection >> Add (Excel)" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="upload_AS_excel" namespace="/view/common" theme="css_xhtml" action="uploadDailyCollection" method="post" enctype="multipart/form-data" name="xlsx">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Excel Upload:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:file name="excel" id="excel"  cssClass="form_menu_inputtext" cssStyle="margin:0px 0px 10px 0px"/> 
					     <div id="erroraExcel" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Excel Formate:</div>
					     <div class="user_form_input inputarea">
					     <a href="<%=request.getContextPath()%>/view/dailyCollection/dailyCollection.xls" target="_blank">Download </a>
					     <div id="errorAreaCode" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
				<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div" 
	                        clearForm="true"
	                        value="  Upload  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level1"
	                        cssClass="submit"
	                        indicator="indicator2"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel1"  effect="fold">
                    <div id="orglevel1Div"></div>
               </sj:div>
               </div>
			</s:form>
</div>
</div>
</sj:accordionItem>


<sj:accordionItem title="Daily Collection >> Add" id="twoId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:form id="mannualAdd"  name="mannualAdd" namespace="/view/common" theme="css_xhtml" action="dailyCollectionMannual" method="post">

<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Client Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					    <s:select id="client" name="client" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Name Of CLient--" cssClass="form_menu_inputselect"
                              onchange="getCleintAllSchemes(this.value);"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
					  <div id="schemeResponse">
					  <div class="inputmain"><div class="user_form_text1">Scheme Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="schemeName" name="schemeName" 
                              list="{'No Data'}"
                              headerKey="-1" headerValue="--Select Scheme Of Client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
					  </div>
					  
</div>

<div class="form_menubox">

	                   <div class="inputmain"><div class="user_form_text">Card No:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="cardNo"  id="cardNo"  readonly="true"  cssClass="form_menu_inputtext" placeholder="Select Scheme Of CLient" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Client Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="clientName"  id="clientName"  readonly="true"  cssClass="form_menu_inputtext" placeholder="Select Scheme Of CLient" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
</div>


<div class="form_menubox">

	                   <div class="inputmain"><div class="user_form_text">Agent Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="agentName"  id="agentName"  readonly="true"   cssClass="form_menu_inputtext" placeholder="Select Scheme Of CLient" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Scheme Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="ammount"  id="ammount" readonly="true"  cssClass="form_menu_inputtext" placeholder="Select Scheme Of CLient" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
</div>

<div class="form_menubox">

	                   <div class="inputmain"><div class="user_form_text">Payment Mode:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="colctnMode" name="colctnMode" 
                              list="#{'Cash':'Cash','Cheque':'Cheque'}"
                              headerKey="-1" headerValue="--Select Mode of Payment--" cssClass="form_menu_inputselect"
                              onchange="setValueForCheck(this.value);"
                              >
                 			 </s:select>
                 			  <div id="errorcolctnMode" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain" id="chqDiv" style="display: none;"><div class="user_form_text1">Cheque Number:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					    <s:textfield name="chequeNo"  id="chequeNo" cssClass="form_menu_inputtext" placeholder="Select Cheque Number" cssStyle="margin:0px 0px 10px 0px"/>
					    <div id="errorchequeNo" class="errordiv"></div>
					    </div>
					     </div> 
</div>


<div class="form_menubox">

	                   <div class="inputmain"><div class="user_form_text">Collection Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="submitAmmount"  id="submitAmmount"  cssClass="form_menu_inputtext" placeholder="Enter Collection Amount" cssStyle="margin:0px 0px 10px 0px"/>
					      <div id="errorsubmitAmmount" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Collection Date:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker name="colelctionDate" id="colelctionDate" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select Installment Of"/>
					     <div id="errorcolelctionDate" class="errordiv"></div>
					     </div>
					     </div> 
</div>

<center><img id="indicator3" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields" style="display:none" id="buttonDIv">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div1" 
	                        clearForm="true"
	                        value="  Save  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level11"
	                        cssClass="submit"
	                        indicator="indicator3"
	                        onBeforeTopics="validate1"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel11"  effect="fold">
                    <div id="orglevel1Div1"></div>
               </sj:div>
</div>
               
</s:form>
</div>
</div>
</sj:accordionItem>
</sj:accordion>
</div>
</div>
</html>