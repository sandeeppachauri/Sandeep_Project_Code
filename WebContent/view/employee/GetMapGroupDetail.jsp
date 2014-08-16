<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
</head>
</html>
<div class="inputmain">
	<div class="user_form_text">Reward Amount:</div>
	<div class="user_form_input inputarea">
		<span class="needed"></span>
		<s:textfield name="rewardAmount" id="rewardAmount"
			value="%{rewardAmount}" cssClass="form_menu_inputtext"
			readonly="true" cssStyle="margin:0px 0px 10px 0px" />
	</div>
</div>

<div class="inputmain">
	<div class="user_form_text1">Kitty Date:</div>
	<div class="user_form_input inputarea">
		<span class="needed"></span>
		<sj:datepicker name="kittyDate" id="kittyDate"
			changeMonth="true" changeYear="true" yearRange="1970:2020"
			showOn="focus" displayFormat="dd-mm-yy"
			cssClass="form_menu_inputtext" placeholder="Select Installment Of" />
	</div>
</div>