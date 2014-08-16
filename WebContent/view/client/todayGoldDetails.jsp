<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="form_menubox">
					  <div class="inputmain" id="cashInhnd"><div class="user_form_text">Gold Date:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="goldDate"  id="goldDate" value="%{goldDate}" cssClass="form_menu_inputtext" readonly="true" placeholder="Enter Cash In Hand" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
					  
					  <div class="inputmain"><div class="user_form_text1">Gold Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="goldTypePrice" name="goldTypePrice" 
                              list="goldDetails"
                              headerKey="-1" headerValue="--Select Gold Type--" cssClass="form_menu_inputselect"
                              onchange="totalGoldAllot(this.value);"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
</div>