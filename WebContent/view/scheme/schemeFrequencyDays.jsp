<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:hidden value="%{frequency}" name="frequency" id="frequency"></s:hidden>
<div class="form_menubox">
						<div class="inputmain"><div class="user_form_text">Minimum <s:property value="%{frequency}"/>:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="minWeek"  id="minWeek"  cssClass="form_menu_inputtext" placeholder="Enter Weeks" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorminWeek" class="errordiv"></div>
					      </div>
					     </div> 
					     
					     <div class="inputmain"><div class="user_form_text1">Maximum <s:property value="%{frequency}"/>:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="maxWeek"  id="maxWeek"  cssClass="form_menu_inputtext" placeholder="Enter Weeks" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errormaxWeek" class="errordiv"></div>
					     </div>
					     </div> 
</div>
</body>
</html>