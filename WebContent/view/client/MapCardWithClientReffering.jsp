<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="form_menubox">
	<div class="inputmain">
		<div class="user_form_text">Referred By:</div>
		<div class="user_form_input inputarea">
			<span class="needed"></span>
			<s:select id="refereName" name="refereName" list="refereNameList"
				headerKey="-1" headerValue="--Select Name--"
				cssClass="form_menu_inputselect"
				onchange="getMappedSchemes(this.value);">
			</s:select>
			<div id="errorrefereName" class="errordiv"></div>
		</div>
	</div>
	<div class="inputmain" id="temp">
		<div id="mapSchemeCardNumDiv"></div>
	</div>
</div>
