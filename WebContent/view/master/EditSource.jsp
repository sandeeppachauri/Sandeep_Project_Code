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


<div class="page_title"><h1>Area View</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<center>
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="viewSource" action="viewSource" />
<s:url id="editSource" action="editSource" />


<center>
<sjg:grid 
		  id="gridedittable"
          caption="Area"
          href="%{viewSource}"
          gridModel="sourceGridModel"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="true"
          navigatorSearch="true"
          rowList="10,15,20,25,50,100,200,500"
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
          editurl="%{editSource}"
          shrinkToFit="false"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="sourceName" index="sourceName" title="Source Name" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="sourceCode" index="sourceCode" title="Source Code" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="sourceDesc" index="sourceDesc" title="Source Description" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="date" index="date" title="Create On" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="user" index="user" title="Created By" align="center" editable="false" search="true"/>
</sjg:grid>
</center>
</div>
</div>
</center>
</div>
</div>
</body>
</html>