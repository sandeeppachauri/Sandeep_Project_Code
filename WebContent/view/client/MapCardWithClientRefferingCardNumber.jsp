<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="user_form_text1">Referring Card No:</div>
<div class="user_form_input inputarea">
	<span class="needed"></span>
	<s:select id="referCardNo" name="referCardNo" list="referCardNoList"
		headerKey="-1" headerValue="--Select Card Number--"
		cssClass="form_menu_inputselect">
	</s:select>
	<div id="errorreferCardNo" class="errordiv"></div>
</div>
