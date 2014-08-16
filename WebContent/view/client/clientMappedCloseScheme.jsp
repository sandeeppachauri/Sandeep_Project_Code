<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:hidden name="clientId" value="%{id}"/>
<div class="inputmain"><div class="user_form_text1">Client Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="schemeName" name="schemeName" 
                              list="schemeNameList"
                              headerKey="-1" headerValue="--Select Close Scheme--" cssClass="form_menu_inputselect"
                              onchange="getSchemeDetails(this.value);"
                              >
                 			 </s:select>
					     <div id="errorschemeName" class="errordiv"></div>
					     </div> 
</div>