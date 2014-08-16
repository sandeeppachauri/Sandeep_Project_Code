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

function viewMappedArea(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog("+row.id+")'>" + cellvalue + "</a>";
}

function openDialog(id) 
{
	$("#fullDetail").show();
	$("#content1").load("<%=request.getContextPath()%>/view/employee/fullDetail.action?id="+id);
}

function removeArea(mapId,divID)
{
		document.getElementById(divID).style.display="none";
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/deleteEmpFromArea.action?id="+mapId,
		    success : function(subdeptdata) {
		    	document.getElementById(divID).style.display="none";
		},
		   error: function() {
	            alert("error");
	        }
		 });
}
</script>
</head>
<body>


<div class="page_title"><h1>Employee View</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="viewEmp" action="viewEmp" />
<s:url id="editEmp" action="editEmp" />


<sjg:grid 
		  id="gridedittable"
          caption="Employee"
          href="%{viewEmp}"
          gridModel="empGridModel"
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
          editurl="%{editEmp}"
          shrinkToFit="false"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="empName" index="empName" title="Employee Name" align="center" editable="true" search="true" formatter="viewMappedArea"/>
		<sjg:gridColumn  name="empMob" index="empMob" title="Employee Mob" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="empPhoneNo" index="empPhoneNo" title="Employee Phoneno" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="empEmailId" index="empEmailId" title="Employee Emailid" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="empAddress" index="empAddress" title="Employee Address" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="doj_date" index="doj_date" title="Employee D.O.J" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="empId" index="empId" title="Employee ID" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="entryDate" index="entryDate" title="Create On" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="entryUser" index="entryUser" title="Created By" align="center" editable="false" search="true"/>
</sjg:grid>

</div>

<br><br>
<div id="fullDetail" style="display: none; width:100%;">
<div class="wrapper">
	<div class="sub_wrapper">
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab1"><b>Mapped Clients With Employee</b></a></div>
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