<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="hot-sneaks" loadAtOnce="true"/>
<script type="text/javascript">

function setDownloadType(type)
{
  $("#downloadDSR").load("<%=request.getContextPath()%>/view/dailyCollection/dailyCollectionDownload.jsp?downloadType="+type+"&mapName=dailySales");
  $("#downloadDSR").dialog('open');
}


</script>
</head>
<body>


<s:url id="dailyCollectionSearch" action="searchCollectionReportView" escapeAmp="false">
<s:param name="agent" value="%{agent}"></s:param>
<s:param name="client" value="%{client}"></s:param>
<s:param name="cardNo" value="%{cardNo}"></s:param>
<s:param name="collectionType" value="%{collectionType}"></s:param>
<s:param name="dateFrom" value="%{dateFrom}"></s:param>
<s:param name="dateTo" value="%{dateTo}"></s:param>
<s:param name="recieptNo" value="%{recieptNo}"></s:param>
</s:url>

<sjg:grid 
		  id="gridedittable"
          caption="Daily Collection Search Report"
          href="%{dailyCollectionSearch}"
          gridModel="searchReportView"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="false"
          navigatorSearch="false"
          rowList="10,15,20,25,50,60,80,100,150,200,250,300,350,400,500,600,700,800,900,1000,1100,1200,1500,1800,2000,3000"
          rownumbers="-1"
          viewrecords="true"       
          pager="true"
          pagerButtons="true"
          pagerInput="false"   
          multiselect="false"  
          loadingText="Requesting Data..."  
          rowNum="20"
          width="900"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          shrinkToFit="false"
          hoverrows="true"
          draggable="true" 
          autoencode="true"
          hidegrid="true"
          footerrow="true" 
          userDataOnFooter="true"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false" hidden="true"/> 
        <sjg:gridColumn  name="recieptNo" index="recieptNo" title="Reciept No" align="center" editable="false" search="true" width="60"/>
        <sjg:gridColumn  name="mode" index="mode" title="Collection Mode" align="center" editable="false" search="true" width="60"/>
        <sjg:gridColumn  name="cardNo" index="cardNo" title="Card No" align="center" editable="false" search="true" width="60"/>
		<sjg:gridColumn  name="clientName" index="clientName" title="Client Name" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="accountType" index="accountType" title="Account Type" align="center" editable="false" search="true" width="100"/>
		<sjg:gridColumn  name="agentCode" index="agentCode" title="Agent Name" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="ammount" index="ammount" title="Submit Ammount" align="center" editable="false" search="true" width="100"/>
		<sjg:gridColumn  name="bankCash" index="bankCash" title="Cash/Cheque" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="chequeNo" index="chequeNo" title="Cheque No" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="collectionDate" index="collectionDate" title="Collection Date" align="center" editable="false" search="true" width="90"/>
		<sjg:gridColumn  name="entryDate" index="entryDate" title="Entry Date" align="center" editable="false" search="true" width="90"/>
</sjg:grid>


<br>
<center>
         <sj:a 
                 id="downloadExcel"
                 buttonIcon="ui-icon-arrowthickstop-1-s"
                 button="true"
                 onclick="setDownloadType('downloadExcel')" 
                 >Excel</sj:a>
   
   </center>
   
 <sj:dialog 
                 id="downloadDSR" 
                 autoOpen="false" 
                 modal="true" 
                 width="340" 
                 height="350"
                 showEffect="slide"
                 hideEffect="explode"
                 title="Download Collection Data">
    </sj:dialog>
</body>
</html>