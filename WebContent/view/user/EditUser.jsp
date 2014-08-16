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


<div class="page_title"><h1>User View</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="viewUser" action="viewUser" />


<sjg:grid 
		  id="gridedittable"
          caption="User"
          href="%{viewUser}"
          gridModel="userGridModel"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="false"
          navigatorEdit="false"
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
          shrinkToFit="false"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="userId" index="userId" title="Login ID" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="userName" index="userName" title="User Name" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="userType" index="userType" title="User Type" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="mobNo" index="mobNo" title="User Mob No" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="date" index="date" title="Created On" align="center" editable="false" search="true"/>
</sjg:grid>
</div>
</div>
</div>
</div>
</body>
</html>