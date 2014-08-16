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

$.subscribe('validate1', function(event,data)
        {

			if(document.formone.areaName.value!=null && document.formone.areaName.value=="" || document.formone.areaName.value=="-1")
		    {
				clearAllErroDiv();
				errorAreaName.innerHTML="Error: Enter Area Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.areaCode.value!=null && document.formone.areaCode.value=="" || document.formone.areaCode.value=="-1")
		    {
				clearAllErroDiv();
				errorAreaCode.innerHTML="Error: Enter Area Code";
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
</script>
</head>
<div class="page_title"><h1>Area >> Registration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Area >> Add" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/common" action="areaMasterAdd" theme="simple"  method="post">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Area name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="areaName"  id="areaName"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorAreaName" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Area code:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="areaCode"  id="areaCode"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorAreaCode" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Description:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="areaDesc"  id="areaDesc"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
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

</sj:accordion>
</div>
</div>
</html>