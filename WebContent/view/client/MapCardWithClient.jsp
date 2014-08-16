<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
<body>
<s:form id="formtwo" name="formtwo" namespace="/view/client" action="mapCardWithClient" theme="simple"  method="post">
		
		     <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Client Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="clientsForCard" name="clientsForCard" 
                              list="clientNameList"
                              headerKey="-1" headerValue="--Select Name of client--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorclientsForCard" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Card No:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="cardNo"  id="cardNo"  cssClass="form_menu_inputtext" placeholder="Enter Card No" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorcardNo" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Scheme Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="schemeName" name="schemeName" 
                              list="schemeNameList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              onchange="getCardReferringDetails(this.value);"
                              >
                 			 </s:select>
					     <div id="errorschemeName" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Scheme D.O.J:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker name="schemeJoinDate" id="schemeJoinDate" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOJ"/>
					     <div id="errorschemeJoinDate" class="errordiv"></div></div>
					   </div>
             	</div>
             	
             	<div id="groupAbleScheme">
             	</div>
				<center><img id="indicator1" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
					<ul>
						<li class="submit" style="background: none;">
							<div class="type-button">
			                <sj:submit 
			                        targets="orglevel1Div1" 
			                        clearForm="true"
			                        value="  Register  " 
			                        effect="highlight"
			                        effectOptions="{ color : '#222222'}"
			                        effectDuration="5000"
			                        button="true"
			                        onCompleteTopics="level11"
			                        cssClass="submit"
			                        indicator="indicator1"
			                        onBeforeTopics="validate2"
			                        />
		               </div>
					</ul>
				<sj:div id="orglevel11"  effect="fold">
                    <div id="orglevel1Div1"></div>
               </sj:div>
               </div>
			</s:form>
</body>
</html>