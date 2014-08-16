<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<SCRIPT type="text/javascript">
$.subscribe('level1', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel1").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel1").fadeOut(); }, 4000);
	       });
</script>
</head>
<body>
		<s:form id="formone" name="formone" namespace="/view/client" action="addClient" theme="simple"  method="post">
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Wish Type:</div>
					     <div class="user_form_input inputarea">
					     <s:if test="%{flag==0}">Birthday Wish</s:if>
					     <s:else>Anniversary Wish</s:else>
					     </div> 
					  </div>
             	</div>
             	
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client Name:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="clientName"  id="clientName" value="%{name}"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px" disabled="true"/>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Client Mob:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="clientMob"  id="clientMob" value="%{mobNo}"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px" disabled="true"/>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Message:</div>
					     <s:textarea name="msg" placeholder="Enter Your Wishiing Message" rows="4" cols="50"></s:textarea>
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
			                        value="  Send Wish  " 
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
</body>
</html>