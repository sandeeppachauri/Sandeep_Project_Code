<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


<s:url id="actionFullDetailGrid" action="actionFullDetailGrid" >
<s:param name="cardNo" value="%{cardNo}"></s:param>
</s:url>

<sjg:grid 
		  id="gridedittable"
          caption="Action History"
          href="%{actionFullDetailGrid}"
          gridModel="fullActionHistory"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="false"
          navigatorSearch="false"
          rowList="10,15,20,25"
          rownumbers="-1"
          viewrecords="true"       
          pager="true"
          pagerButtons="true"
          pagerInput="false"   
          multiselect="true"  
          loadingText="Requesting Data..."  
          rowNum="5"
          width="835"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          shrinkToFit="false"
          >
		<sjg:gridColumn  name="joingDate" index="joingDate" title="Joining Date" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="cmpltnTime" index="cmpltnTime" title="Completion Date" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="totalAmount" index="totalAmount" title="Total Amount" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="matryAmmount" index="matryAmmount" title="Maturty Amount" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="periodOfScheme" index="periodOfScheme" title="Total Installment" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="totalAmmountDeposite" index="totalAmmountDeposite" title="Total Deposite" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="totalInst" index="totalInst" title="Installment Deposite" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="schemeStatus" index="schemeStatus" title="Scheme Status" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="rewardType" index="rewardType" title="Return Type" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="totalPurchaseOf" index="totalPurchaseOf" title="Total Purchase Of" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="cashInHand" index="cashInHand" title="Total Purchase" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="jwlryType" index="jwlryType" title="Jwellery Type" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="adjstmntVlue" index="adjstmntVlue" title="Adjustment Value" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="cashRtrn" index="cashRtrn" title="Cash Return" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="dmdnRate" index="dmdnRate" title="Diamond rate" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="dmndValue" index="dmndValue" title="Diamond value" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="dmndWght" index="dmndWght" title="Diamond Weight" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="dmnndGoldType" index="dmnndGoldType" title="Diamond Gold Type" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="goldValue" index="goldValue" title="Gold Value" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="goldWght" index="goldWght" title="Gold Weight" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="pureGoldType" index="pureGoldType" title="Gold Type" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="silverWght" index="silverWght" title="Silver Weight" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="stoneName" index="stoneName" title="Stone Name" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="stoneWght" index="stoneWght" title="Stone Weight" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="date" index="date" title="Action Date" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="time" index="time" title="Action Time" align="center" editable="false" search="true"/>
		
</sjg:grid>
</body>
</html>