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

			if(document.formone.userName.value!=null && document.formone.userName.value=="" || document.formone.userName.value=="-1")
		    {
				clearAllErroDiv();
				erroruserName.innerHTML="Error: Enter User Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.loginID.value!=null && document.formone.loginID.value=="" || document.formone.loginID.value=="-1")
		    {
				clearAllErroDiv();
				errorloginID.innerHTML="Error: Enter Unique Login Id";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.pwd.value!=null && document.formone.pwd.value=="" || document.formone.pwd.value=="-1")
		    {
				clearAllErroDiv();
				errorpwd.innerHTML="Error: Enter Password";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.userType.value!=null && document.formone.userType.value=="" || document.formone.userType.value=="-1")
		    {
				clearAllErroDiv();
				erroruserType.innerHTML="Error: Select User Type";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.userMob.value!=null && document.formone.userMob.value=="" || document.formone.userMob.value=="-1")
		    {
				clearAllErroDiv();
				erroruserMob.innerHTML="Error: Enter Mobile Number";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.pwd.value!=document.formone.cnfrmPwd.value)
		    {
				clearAllErroDiv();
				errorpwd.innerHTML="Error: Enter Same Password In Both";
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
<div class="page_title"><h1>User >> Registration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="User >> Add" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/common" action="createUser" theme="simple"  method="post">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">User name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="userName"  id="userName"  cssClass="form_menu_inputtext" placeholder="Enter User Name" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="erroruserName" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Login ID:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="loginID"  id="loginID"  cssClass="form_menu_inputtext" placeholder="Enter Login Id" cssStyle="margin:0px 0px 10px 0px"/>
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
					     </div>
					  </div>
             	</div>
             	
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">User Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="userType" name="userType" 
                              list="#{'1':'Admin','2':'Employee','3':'Client'}"
                              headerKey="-1" headerValue="--Select User Type--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="erroruserType" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">User Mob No:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="userMob"  id="userMob"  cssClass="form_menu_inputtext" placeholder="Enter User Mobile No" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="erroruserMob" class="errordiv"></div>
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