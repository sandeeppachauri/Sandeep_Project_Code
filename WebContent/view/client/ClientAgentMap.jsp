<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
</head>
<body>

<s:form id="formThree" name="formThree" namespace="/view/client" action="clientAgentMapping" theme="simple"  method="post">
		
			  <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="clientName" name="clientName" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Client Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorclientNameMap" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Agent:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					    <s:select id="agentName" name="agentName" 
                              list="agentNameList"
                              headerKey="-1" headerValue="--Select Agent Name--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="erroragentNameMap" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
					
				<center><img id="indicator3" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div2" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level12"
	                        cssClass="submit"
	                        indicator="indicator3"
	                        onBeforeTopics="validate3"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel12"  effect="fold">
                    <div id="orglevel1Div2"></div>
               </sj:div>
               </div>
			</s:form>
</body>
</html>