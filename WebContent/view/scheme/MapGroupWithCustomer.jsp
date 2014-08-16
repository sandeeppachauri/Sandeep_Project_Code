<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
<head>

</head>
<body>
<s:form id="formtwo" name="formtwo" namespace="/view/scheme" action="mapGroupWithClient" theme="simple"  method="post">
		
		     <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="schemeID" name="schemeID" 
                              list="schemeNameList"
                              headerKey="-1" headerValue="--Select Name of Scheme--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorschemeID" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Min Inst Pay:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="minInstPay"  id="minInstPay"  cssClass="form_menu_inputtext" placeholder="Enter Minimum Number Of installment" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorminInstPay" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Max Month:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="maxMonth"  id="maxMonth"  cssClass="form_menu_inputtext" placeholder="Enter maximum num of month for joining" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errormaxMonth" class="errordiv"></div>
					     </div>
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Reward Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="rewardAmount"  id="rewardAmount"  cssClass="form_menu_inputtext" placeholder="Enter reward amount to be given" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorrewardAmount" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Future Payment:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="futurPay" name="futurPay" 
                              list="{'Yes','No'}"
                              headerKey="" headerValue="--Select Value--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
                 			 <div id="errorfuturPay" class="errordiv"></div>
					     </div> 
					  </div>
					  
					   <div class="inputmain"><div class="user_form_text1">Organizer Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="orgnzrAmount"  id="orgnzrAmount"  cssClass="form_menu_inputtext" placeholder="Enter reward amount to be given" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errororgnzrAmount" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Group Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="groupId" name="groupId" 
                              list="groupNameList"
                              headerKey="-1" headerValue="--Select Name of Group--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorgroupId" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	
				<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
					<ul>
						<li class="submit" style="background: none;">
							<div class="type-button">
			                <sj:submit 
			                        targets="orglevel1Div2" 
			                        clearForm="true"
			                        value="  Configure  " 
			                        effect="highlight"
			                        effectOptions="{ color : '#222222'}"
			                        effectDuration="5000"
			                        button="true"
			                        onCompleteTopics="level2"
			                        cssClass="submit"
			                        indicator="indicator2"
			                        onBeforeTopics="validate2"
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