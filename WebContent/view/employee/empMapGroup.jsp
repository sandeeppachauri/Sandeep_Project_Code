<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<div class="inputmain"><div class="user_form_text1">Group Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="mappedGroupName" name="mappedGroupName" 
                              list="mappedGroupNameList"
                              headerKey="-1" headerValue="--Select Group Name--" cssClass="form_menu_inputselect"
                              onchange="getMapGroupDetail(this.value);"
                              >
                 			 </s:select>
					     <div id="errormappedGroupName" class="errordiv"></div>
					     </div> 
</div>