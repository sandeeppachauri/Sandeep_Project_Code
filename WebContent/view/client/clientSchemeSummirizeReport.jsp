<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="hot-sneaks" loadAtOnce="true"/>

</head>
<body>


<s:url id="clientSchemeSummirizeReport" action="clientSchemeSummirizeReportAction" >
<s:param name="id" value="%{id}"></s:param>
</s:url>
<sjg:grid 
		  id="gridedittable1"
          caption="Client Scheme Summerize Report"
          href="%{clientSchemeSummirizeReport}"
          gridModel="clientSummerizeReport"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="false"
          navigatorSearch="true"
          rowList="10,15,20,25"
          rownumbers="true"
          viewrecords="true"       
          pager="true"
          pagerButtons="true"
          pagerInput="false"   
          multiselect="true"  
          loadingText="Requesting Data..."  
          rowNum="10"
          width="835"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          shrinkToFit="false"
          hoverrows="true"
          draggable="true" 
          autoencode="true"
          hidegrid="true"
          footerrow="true" 
          userDataOnFooter="true"
          >
         
        <sjg:gridColumn  name="schemeName" index="schemeName" title="Scheme Name" align="center" editable="false" search="true" frozen="true"/>
        <sjg:gridColumn  name="schemeAmmount" index="schemeAmmount" title="Scheme Ammount" align="center" editable="false" search="true"  frozen="true"/>
        <sjg:gridColumn  name="schemeFrequency" index="schemeFrequency" title="Frequency" align="center" editable="false" search="true" frozen="true"/>
        <sjg:gridColumn  name="clientName" index="clientName" title="Client Name" align="center" editable="false" search="false" hidden="true"/> 
		<sjg:gridColumn  name="schemeStatus" index="schemeStatus" title="Scheme Status" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="cardNo" index="cardNo" title="Client card No" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="totalCollectionTillNow" index="totalCollectionTillNow" title="Total Collection Money" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="totalCollectionCounter" index="totalCollectionCounter" title="Total Collection Counter" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="schemePurchaseDate" index="schemePurchaseDate" title="Scheme Date" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="schemeOurContree" index="schemeOurContree" title="Scheme Countree" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="schemeMaturtyAmmount" index="schemeMaturtyAmmount" title="Maturty Ammount" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="schemePeriod" index="schemePeriod" title="Period" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="schemeTotalAmmount" index="schemeTotalAmmount" title="Total Ammount" align="center" editable="false" search="true"/>
</sjg:grid>
</body>
</html>