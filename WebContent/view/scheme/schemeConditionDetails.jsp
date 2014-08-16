<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:url id="viewCond" action="viewSchemesWithdCond"  escapeAmp="true">
  <s:param name="id" value="%{id}"/>
</s:url>

<sjg:grid 
		  id="gridedittable112"
          caption="Scheme"
          href="%{viewCond}"
          gridModel="condList"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="true"
          navigatorSearch="true"
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
          editurl="%{editScheme}"
          shrinkToFit="false"
          loadonce="true"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="withType" index="withType" title="Withdraw Type" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="minPeriod" index="minPeriod" title="Withdraw Min Period" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="maxPeriod" index="maxPeriod" title="Withdraw Max Period" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="widraw" index="widraw" title="Withdraw" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="paymentAfter" index="paymentAfter" title="Payment After" align="center" editable="true" search="true"/>
</sjg:grid>
</body>
</html>