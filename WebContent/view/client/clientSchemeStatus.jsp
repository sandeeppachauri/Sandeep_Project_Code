<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<script type="text/javascript">
function printReport(divID) {
	var divElements = document.getElementById(divID).innerHTML;
	var oldPage = document.body.innerHTML;
	document.body.innerHTML = "<html><head><title></title></head><body>"
			+ divElements + "</body>";
	window.print();
	document.body.innerHTML = oldPage;
}
</script>
</head>
</html>
<s:hidden name="id" value="%{id}"></s:hidden>
<s:if test="%{clientWiseDailyCollectionHistory.size>0}">   
<div id="one">
<div class="form_menubox">
					  <div class="inputmain">
					  <s:if test="%{schemeTypeRecvd==0}">
					  <div class="user_form_text">Surrender Reasion:</div>
					  </s:if>
					  <s:else><div class="user_form_text">Re-open Mark:</div></s:else>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="surrenderRsn"  id="surrenderRsn"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Withdraw Status:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="status" readonly="true" id="status" value="%{status}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
</div>

<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Total Installment:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="periodOfScheme"  id="periodOfScheme" value="%{periodOfScheme}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Scheme Frequnecy:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="frequnecy" readonly="true" id="frequnecy" value="%{frequnecy}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
</div>	

<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Scheme Status:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="schemeStatus"  id="schemeStatus" value="%{schemeStatus}" readonly="true" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">D.O.J:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="joingDate" readonly="true" id="joingDate" value="%{joingDate}" cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorsurrenderRsn" class="errordiv"></div>
					     </div>
					  </div>
</div>	
<div class="group_content">
							<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;"><tbody>
								<tr class="group_head">
								   <td width="8%"><b>Sr.No</b></td>
								   <td width="10%"><b>Submit Date</b></td>
								   <td width="20%"><b>Account Type</b></td>
									<td width="20%"><b>Submit Type</b></td>
									<td width="15%"><b>Cheque Number</b></td>
									<td width="25%"><b>Amount</b></td>
								</tr>
								
								<s:iterator id="DailyCollectionDB" value="clientWiseDailyCollectionHistory" status="counter">  
								<s:if test="#counter.count%2 != 0">
								<tr bgcolor="#e1e3e3">
								    <td align="left" valign="middle"><s:property value="#counter.count"/> </td>
								    <td align="left" valign="middle"><s:property value="%{entryDate}"/> </td>
									<td align="left" valign="middle"><s:property value="%{bankCash}"/> </td>
									<td align="left" valign="middle"><s:property value="%{accountType}"/> </td>
									<td align="left" valign="middle"><s:property value="%{chequeNo}"/> </td>
									<td align="left" valign="middle"><s:property value="%{ammount}"/> </td>
								</tr>
								</s:if>
								<s:else>
								<tr>
								    <td align="left" valign="middle"><s:property value="#counter.count"/> </td>
									<td align="left" valign="middle"><s:property value="%{entryDate}"/> </td>
									<td align="left" valign="middle"><s:property value="%{bankCash}"/> </td>
									<td align="left" valign="middle"><s:property value="%{accountType}"/> </td>
									<td align="left" valign="middle"><s:property value="%{chequeNo}"/> </td>
									<td align="left" valign="middle"><s:property value="%{ammount}"/> </td>
								</tr>
								</s:else>
								</s:iterator>
								
								<tr class="group_head">
								   <td width="5%"><b>Collection:</b></td>
								   <td width="20%"><b></b><s:property value="%{amountSubmitDaily}"/></b></td>
								   <td width="20%"><b>Total Collection:</b></td>
									<td width="20%"><b><s:property value="%{totalAmount}"/></b></td>
									<td width="20%"><b>Receive Collection:</b></td>
									<td width="20%"><b><s:property value="%{totalCollectionRecieve}"/> </b></td>
								</tr>
								
							</tbody></table>
</div>
</div>
<s:if test="%{schemeTypeRecvd==0}">
<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div" 
	                        clearForm="true"
	                        value="  Surrender  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level1"
	                        cssClass="submit"
	                        indicator="indicator2"
	                        />
	               </div>
	               </li>
	               <li class="submit" style="padding:0px 10px;">
    		 		<input type="button" class="submit" name="" id="report" value="Print" onclick='printReport("one");'></li>
				</ul>
				<sj:div id="orglevel1"  effect="fold">
                    <div id="orglevel1Div"></div>
               </sj:div>
               </div>
</s:if>
<s:else>
<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div" 
	                        clearForm="true"
	                        value="  Re-open  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level1"
	                        cssClass="submit"
	                        indicator="indicator2"
	                        />
	               </div>
	               </li>
	               <li class="submit" style="padding:0px 10px;">
    		 		<input type="button" class="submit" name="" id="report" value="Print" onclick='printReport("one");'></li>
				</ul>
				<sj:div id="orglevel1"  effect="fold">
                    <div id="orglevel1Div"></div>
               </sj:div>
               </div>
</s:else>

</s:if>
<s:else>
<center><b>No Data Available</b></center>
</s:else>