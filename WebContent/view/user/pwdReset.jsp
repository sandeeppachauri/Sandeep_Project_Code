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
<div class="page_title"><h1>User Password >> Reset</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="User Password >> Reset" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/common" action="pwdReset" theme="simple"  method="post">
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Login Id:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="loginID" name="loginID" 
                              list="userList"
                              headerKey="-1" headerValue="--Select Login Id--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorloginID" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Password:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:password name="pwd"  id="pwd"  cssClass="form_menu_inputtext" placeholder="Enter Password" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorpwd" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Re-type Password:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:password name="cnfrmPwd"  id="cnfrmPwd"  cssClass="form_menu_inputtext" placeholder="Confirm Password" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorcnfrmPwd" class="errordiv"></div>
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