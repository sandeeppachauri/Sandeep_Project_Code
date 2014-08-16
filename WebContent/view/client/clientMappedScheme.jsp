<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<div class="inputmain"><div class="user_form_text1">Client Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="schemeName" name="schemeName" 
                              list="schemeNameList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              onchange="getSchemeStatus(this.value);"
                              >
                 			 </s:select>
					     <div id="errorschemeName" class="errordiv"></div>
					     </div> 
</div>