<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<script type="text/javascript">

function viewGoldDetails(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog(&#34;"+row.goldRate+"&#34;)'>" + cellvalue + "</a>";
}

function openDialog(goldRate) 
{
	alert(goldRate);
	$("#fullDetail").show();
	$("#content1").load("<%=request.getContextPath()%>/view/common/fullDetailGoldPrice.action?goldRate="+goldRate);
}
</script>
</head>
<body>


<div class="page_title"><h1>Daily Wise Gold Rate</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="viewGoldRate" action="viewGoldRate" />
<s:url id="editGoldRate" action="editGoldRate" />
<sjg:grid 
		  id="gridedittable"
          caption="Daily Wise Gold Rate"
          href="%{viewGoldRate}"
          gridModel="goldGridModel"
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
          width="680"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          editurl="%{editGoldRate}"
          shrinkToFit="false"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="goldRate" index="goldRate" title="Gold Rate" align="center" editable="true" search="true" formatter="viewGoldDetails"/>
		<sjg:gridColumn  name="goldRateDate" index="goldRateDate" title="Gold Date" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="user" index="user" title="Created By" align="center" editable="false" search="true"/>
</sjg:grid>
</div>

<br><br>
<div id="fullDetail" style="display: none; width:82%;">
<div class="wrapper">
	<div class="sub_wrapper">
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab1"><b>Gold Details In Different Area</b></a></div>
		<div class="content_main" id="content1" style="border-top:3px solid #aaa9ab; min-width:98%; display: block;">
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>