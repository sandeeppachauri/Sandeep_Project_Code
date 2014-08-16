<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<s:hidden name="clientSchemeId" value="%{id}"></s:hidden>
<div id="one">
<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">D.O.J:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="joingDate" readonly="true" id="joingDate" value="%{joingDate}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Completion Time:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="cmpltnTime" readonly="true" id="cmpltnTime" value="%{cmpltnTime}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>

<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Total Installment:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="periodOfScheme"  id="periodOfScheme" value="%{periodOfScheme}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Installment Deposit:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="totalInst" readonly="true" id="totalInst" value="%{totalInst}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>	


<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Total Collection:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="totalAmount"  id="totalAmount" value="%{totalAmount}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Receive Collection:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="totalAmmountDeposite" readonly="true" id="totalAmmountDeposite" value="%{totalAmmountDeposite}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>


<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Maturity Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="matryAmmount"  id="matryAmmount" value="%{matryAmmount}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Withdraw Status:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="withdrawStatus"  id="withdrawStatus" value="%{status}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
</div>

<!-- CHnaged from here o replace all here -->
<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Return Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="rewardType" name="rewardType" 
                              list="{'Cash','Jwellery','Adjustment'}"
                              headerKey="-1" headerValue="--Select Return Type--" cssClass="form_menu_inputselect"
                              onchange="getTypeOfReward(this.value);"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Total Purchase Of:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="totalPurchaseOf"  id="totalPurchaseOf" cssClass="form_menu_inputtext" placeholder="Enter Total Purchase In Value" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>

<div class="form_menubox"  id="cashInhnd" style="display: none;">
					  <div class="inputmain"><div class="user_form_text">Cash In Hand:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="cashInHand"  id="cashInHand" cssClass="form_menu_inputtext" placeholder="Enter Cash In Hand" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
</div>

<div class="form_menubox"  id="cashAdjustment" style="display: none;">
					  <div class="inputmain"><div class="user_form_text">Adjustment Value:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="adjstmntVlue"  id="adjstmntVlue" cssClass="form_menu_inputtext" placeholder="Enter Adjustment Value" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Cash Return (If Any):</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="cashRtrn"  id="cashRtrn" cssClass="form_menu_inputtext" placeholder="Enter Cash Return" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
</div>



<div class="form_menubox" id="jlwlryDiv"  style="display: none;">
					  <div class="inputmain"><div class="user_form_text">Jwellery Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="jwlryType" name="jwlryType" 
                              list="{'Diamond Jwellery','Gold Jwellery','Silver Jwellery','Lucky/ Birth Stone'}"
                              headerKey="-1" headerValue="--Select Jwellery Type--" cssClass="form_menu_inputselect"
                              onchange="typeOfJwlry(this.value);"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
					  <div class="inputmain" id="dmndType"  style="display: none;"><div class="user_form_text1">Gold Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="dmnndGoldType" name="dmnndGoldType" 
                              list="{'18K','14K','9K'}"
                              headerKey="-1" headerValue="--Select Diamond Gold Type--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
					  <div class="inputmain" id="goldType"  style="display: none;"><div class="user_form_text1">Gold Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="pureGoldType" name="pureGoldType" 
                              list="{'23K','22K','18K','14K'}"
                              headerKey="-1" headerValue="--Select Gold Type--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div>
					  </div>
					  
					  <div class="inputmain"  id="silverPur"  style="display: none;"><div class="user_form_text1">Silver Weight:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="silverWght"  id="silverWght" cssClass="form_menu_inputtext" placeholder="Enter Silver Weight" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
					  <div class="inputmain"  id="luckStone"  style="display: none;"><div class="user_form_text1">Stone Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:select id="stoneName" name="stoneName" 
                              list="{'Pukhraj','Heera','Panna','Moti'}"
                              headerKey="-1" headerValue="--Select Stone Name--" cssClass="form_menu_inputselect"
                              />
					     </div>
					  </div>
</div>

<div  id="dimndDetail" style="display: none;">
<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Diamond Weight:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="dmndWght"  id="dmndWght" cssClass="form_menu_inputtext" placeholder="Enter Diamond Weight In Caret" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Diamond Rate:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="dmdnRate"  id="dmdnRate" cssClass="form_menu_inputtext"  placeholder="Enter Diamond Rate" onchange="fillValueOfDmnd(this.value);" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
					  
</div>

<div class="form_menubox">

					<div class="inputmain"><div class="user_form_text">Diamond Value:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="dmndValue"  id="dmndValue" cssClass="form_menu_inputtext" cssStyle="margin:0px 0px 10px 0px" readonly="true"/>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Gold Value:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="goldValue"  id="goldValue" cssClass="form_menu_inputtext" cssStyle="margin:0px 0px 10px 0px" readonly="true"/>
					     </div>
					  </div>
</div>
</div>

<div  id="goldDetail" style="display: none;">
<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Gold Weight:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="goldWght"  id="goldWght" cssClass="form_menu_inputtext" placeholder="Enter Gold Weight" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>
</div>

<div  id="stoneDetail" style="display: none;">
<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Stone Weight:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="stoneWght"  id="stoneWght" cssClass="form_menu_inputtext" placeholder="Enter Stone Weight" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>
</div>

<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Reward Cash (if Any):</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="rewardCash"  id="rewardCash" cssClass="form_menu_inputtext" placeholder="Enter Cash In Hand" cssStyle="margin:0px 0px 10px 0px"/>
					     </div>
					  </div>
</div>
</div>

<center><img id="indicator3" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div1" 
	                        clearForm="true"
	                        value="  Allot Reward  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level11"
	                        cssClass="submit"
	                        indicator="indicator3"
	                        />
	               </div>
	               </li>
	               <li class="submit" style="padding:0px 10px;">
    		 <input type="button" class="submit" name="" id="report" value="Print" onclick='printReport("one");'></li>
				</ul>
				<sj:div id="orglevel11"  effect="fold">
                    <div id="orglevel1Div1"></div>
               </sj:div>
               </div>