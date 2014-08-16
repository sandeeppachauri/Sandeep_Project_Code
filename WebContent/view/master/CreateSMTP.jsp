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
</script>
</head>
<div class="page_title"><h1>Mail >> Configuration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Mail >> Configuration" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/common" action="smtpAdd" theme="simple"  method="post">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Server name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="server"  id="server"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorserver" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Server port:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="port"  id="port"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorport" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Email id:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="emailid"  id="emailid"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="erroemailid" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Password:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:password name="pwd"  id="pwd"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorpwd" class="errordiv"></div>
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