<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<div class="form_menubox">
				<s:iterator value="totalTextBox" status="counter">
					<s:if test="#counter.count%2 != 0">
							<div class="inputmain">
								<div class="user_form_text"><s:property value="%{value}"/>:</div>
								<div class="user_form_input inputarea"><span class="needed"></span>
								<s:textfield name="incrmtnValue"  id="incrmtnValue" value="" cssClass="form_menu_inputtext" placeholder="Enter Amount" cssStyle="margin:0px 0px 10px 0px"/>
								<div id="error<s:property value="%{key}"/>" class="errordiv">
								</div> 
								</div>
							</div>
						</s:if>
						<s:else>
							<div class="inputmain">
								<div class="user_form_text1"><s:property value="%{value}"/>:</div>
								<div class="user_form_input inputarea"><span class="needed"></span>
								<s:textfield name="incrmtnValue"  id="incrmtnValue" value=""  cssClass="form_menu_inputtext" placeholder="Enter Amount" cssStyle="margin:0px 0px 10px 0px"/>
								<div id="error<s:property value="%{key}"/>" class="errordiv"></div>
								</div>
							</div>
						</s:else>
				</s:iterator>
			</div>
			
<center><img id="indicator7" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div7" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level17"
	                        cssClass="submit"
	                        indicator="indicator7"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel17"  effect="fold">
                    <div id="orglevel1Div7"></div>
               </sj:div>
               </div>