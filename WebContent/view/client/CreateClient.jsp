<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<SCRIPT type="text/javascript">

var groupStatus=false;
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

$.subscribe('level12', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel12").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel12").fadeOut(); }, 4000);
	       });


$.subscribe('validate1', function(event,data)
        {
			if(document.formone.sourceName.value!=null && document.formone.sourceName.value=="" || document.formone.sourceName.value=="-1")
		    {
				clearAllErroDiv();
				errorsourceName.innerHTML="Error: Select Client Source";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.areaName.value!=null && document.formone.areaName.value=="" || document.formone.areaName.value=="-1")
		    {
				clearAllErroDiv();
				errorareaName.innerHTML="Error: Select Client Area";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.clientName.value!=null && document.formone.clientName.value=="" || document.formone.clientName.value=="-1")
		    {
				clearAllErroDiv();
				errorclientName.innerHTML="Error: Enter Client Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.clientMob.value!=null && document.formone.clientMob.value=="" || document.formone.clientMob.value=="-1")
		    {
				clearAllErroDiv();
				errorclientMob.innerHTML="Error: Enter Client MobileNo";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.clientAddress.value!=null && document.formone.clientAddress.value=="" || document.formone.clientAddress.value=="-1")
		    {
				clearAllErroDiv();
				errorclientAddress.innerHTML="Error: Enter Client Address";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.doj_date.value=="" || document.formone.doj_date.value=="-1")
		    {
				clearAllErroDiv();
				errordoj_date.innerHTML="Error: Select Client D.O.J";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
			var returnValue=testNumericValue('clientMob','errorclientMob');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			returnValue=testNumericValue('clientPhoneno','errorclientPhoneno');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
        });
 
$.subscribe('validate2', function(event,data)
        {

			if(document.formtwo.clientsForCard.value!=null && document.formtwo.clientsForCard.value=="" || document.formtwo.clientsForCard.value=="-1")
		    {
				clearAllErroDiv();
				errorclientsForCard.innerHTML="Error: Select Client Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formtwo.cardNo.value!=null && document.formtwo.cardNo.value=="" || document.formtwo.cardNo.value=="-1")
		    {
				clearAllErroDiv();
				errorcardNo.innerHTML="Error: Enter Unique Card No";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formtwo.schemeName.value!=null && document.formtwo.schemeName.value=="" || document.formtwo.schemeName.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeName.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formtwo.schemeJoinDate.value=="" || document.formtwo.schemeJoinDate.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeJoinDate.innerHTML="Error: Select Scheme D.O.J";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
        });
        
$.subscribe('validate3', function(event,data)
        {

			if(document.formThree.clientName.value!=null && document.formThree.clientName.value=="" || document.formThree.clientName.value=="-1")
		    {
				clearAllErroDiv();
				errorclientNameMap.innerHTML="Error: Select Client Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formThree.agentName.value!=null && document.formThree.agentName.value=="" || document.formThree.agentName.value=="-1")
		    {
				clearAllErroDiv();
				erroragentNameMap.innerHTML="Error: Select Agent Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
        });
              
function clearAllErroDiv()
{
	$("div[id^='error']").each(function() {
  	  // `this` now refers to the current element
	     this.innerHTML="";
  	});
}
function getClients()
{
	$("#ajaxResponse").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/beforeMapCardsWithClient.action",
	    success : function(subdeptdata) {
       $("#"+"ajaxResponse").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}

function getClientsAgent()
{

	$("#ajaxResponse1").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/beforeClientMapAgent.action",
	    success : function(subdeptdata) {
       $("#"+"ajaxResponse1").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}

function getCardReferringDetails(schemeId)
{
	$("#groupAbleScheme").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getCardReferringDetails.action?schemeId="+schemeId,
	    success : function(subdeptdata) {
       $("#"+"groupAbleScheme").html(subdeptdata);
	},
	   error: function() {
		   $("#"+"groupAbleScheme").html("");
        }
	 });
}

function getMappedSchemes(clinetId)
{
	$("#mapSchemeCardNumDiv").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/getMappedSchemes.action?status="+clinetId,
	    success : function(subdeptdata) {
       $("#"+"mapSchemeCardNumDiv").html(subdeptdata);
	},
	   error: function() {
		   alert("Error, Try Again!!");
        }
	 });
}

</script>
</head>
<body>
<div class="page_title"><h1>Client >> Registration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Client >> Add" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/client" action="addClient" theme="simple"  method="post">
		
		     <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client Source:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="sourceName" name="sourceName" 
                              list="sourceData"
                              headerKey="-1" headerValue="--Select Source of client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorsourceName" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Refer By:</div>
					     <div class="user_form_input inputarea">
					      <s:select id="referBy" name="referBy" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select CLient Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
					  
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client Area:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="areaName" name="areaName" 
                              list="areaList"
                              headerKey="-1" headerValue="--Select Area of client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorareaName" class="errordiv"></div>
					     </div> 
					  </div>
					  
             	</div>
             	
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="clientName"  id="clientName"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorclientName" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Client Mob:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="clientMob"  id="clientMob"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px" maxlength="10"/>
					     <div id="errorclientMob" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Phone No:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="clientPhoneno"  id="clientPhoneno"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					      <div id="errorclientPhoneno" class="errordiv"></div>
					      </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Email ID:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="clientEmailId"  id="clientEmailId"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Address:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="clientAddress"  id="clientAddress"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					      <div id="errorclientAddress" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">D.O.J:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker name="doj_date" id="doj_date" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOJ"/></div>
					     <div id="errordoj_date" class="errordiv"></div>
					   </div>
			   </div>
             	
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">D.O.B:</div>
					     <div class="user_form_input inputarea">
					      <sj:datepicker name="dob_date" id="dob_date" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOB"/>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">D.O.A:</div>
					     <div class="user_form_input inputarea">
					     <sj:datepicker name="doa_date" id="doa_date" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOA"/></div>
					     <div id="errordoj_date" class="errordiv"></div>
					     </div>
			  </div>
			  
			  
             
             <div class="form_menubox">
                  <div class="user_form_text">Photo:</div>
                  <div class="user_form_input" style="color:black;">
                  <s:file name="pic" id="pic" cssClass="form_menu_inputtext"  cssStyle="margin:0px 0px 10px 0px"  /></div>
				  <div class="user_form_text1">ID Proof:</div>
                  <div class="user_form_input" style="color:black;">
                  <s:file name="idProof" id="idProof" cssClass="form_menu_inputtext"  cssStyle="margin:0px 0px 10px 0px"  /></div>
			</div> 
					
				<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
					<ul>
						<li class="submit" style="background: none;">
							<div class="type-button">
			                <sj:submit 
			                        targets="orglevel1Div" 
			                        clearForm="true"
			                        value="  Register  " 
			                        effect="highlight"
			                        effectOptions="{ color : '#222222'}"
			                        effectDuration="5000"
			                        button="true"
			                        onCompleteTopics="level1"
			                        cssClass="submit"
			                        indicator="indicator2"
			                        onBeforeTopics="validate1"
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
<sj:accordionItem title="Client >> Card allotment" id="twoId" onclick="getClients();">
<div id="ajaxResponse"></div>
</sj:accordionItem>

<sj:accordionItem title="Client & Agent >> Mapping" id="threeId" onclick="getClientsAgent();">  
<div id="ajaxResponse1"></div>	
</sj:accordionItem>
</sj:accordion>
</div>
</div>
</body>
</html>