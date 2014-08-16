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

			if(document.formone.goldPrice.value!=null && document.formone.goldPrice.value=="" || document.formone.goldPrice.value=="-1")
		    {
				clearAllErroDiv();
				errorgoldPrice.innerHTML="Error: Enter Gold Price";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.dateOfGold.value!=null && document.formone.dateOfGold.value=="" || document.formone.dateOfGold.value=="-1")
		    {
				clearAllErroDiv();
				errordateOfGold.innerHTML="Error: Enter Gold Date";
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
		<s:form id="formone" name="formone" namespace="/view/common" action="addGoldRate" theme="simple"  method="post">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Gold Price:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="goldPrice"  id="goldPrice"  cssClass="form_menu_inputtext" placeholder="Enter Gold Price" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorgoldPrice" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Price Of Date:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker name="dateOfGold" id="dateOfGold" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOJ"/>
					     <div id="errordateOfGold" class="errordiv"></div>
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
	                        value="  Save  " 
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