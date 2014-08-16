<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="hot-sneaks" loadAtOnce="true"/>
<SCRIPT type="text/javascript">
function showSchemeDetails(cellvalue, options, rowObject) 
{
       return "<a href='#' onClick='getDetails("+rowObject.id+")'>" + cellvalue + "</a>";
}
function getDetails(valuepassed){
	 $("#schemeReport").load("<%=request.getContextPath()%>/view/scheme/getSchemeCondition?id="+valuepassed);
    $("#schemeReport").dialog('open');
	return false;
	}

</SCRIPT>
</head>
<body>
<sj:dialog
          id="schemeReport"
          showEffect="slide"
          hideEffect="explode"
          autoOpen="false"
          title="Scheme Withdraw Detail"
          modal="true"
          closeTopics="closeEffectDialog"
          width="800"
          height="300"
          draggable="true"
    	  resizable="true"
    	  buttons="{ 
			'Cancel':function() { cancelButton4(); } 
			}"
          >
</sj:dialog>

<div class="page_title"><h1>Scheme View</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="viewScheme" action="viewScheme" />
<s:url id="editScheme" action="editScheme" />


<sjg:grid 
		  id="gridedittable"
          caption="Scheme"
          href="%{viewScheme}"
          gridModel="schemeGridModel"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="true"
          navigatorSearch="true"
          rowList="10,15,20,25,50,100,200,500"
          rownumbers="-1"
          viewrecords="true"       
          pager="true"
          pagerButtons="true"
          pagerInput="false"   
          multiselect="true"  
          loadingText="Requesting Data..."  
          rowNum="10"
          width="835"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          editurl="%{editScheme}"
          shrinkToFit="false"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="schemeName" index="schemeName" title="Scheme Name" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="schemeDesc" index="schemeDesc" title="Scheme Desc" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="schemeFrequency" index="schemeFrequency" title="Scheme Frequency" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="minPeriod" index="minPeriod" title="Min-period" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="amount" index="amount" title="Amount" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="totalAmount" index="totalAmount" title="Total Deposit" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="ourContri" index="ourContri" title="Contribution" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="netMaturity" index="netMaturity" title="Scheme Maturity" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="withdrawable" index="withdrawable" title="Withdrawable" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="luckyDraw" index="luckyDraw" title="Eligible For Lucky Draw" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="wthdrwCondtn" index="wthdrwCondtn" title="Condition" align="center" editable="true" search="true" formatter="showSchemeDetails"/>
</sjg:grid>
</div>
</div>
</div>
</div>
</body>
</html>