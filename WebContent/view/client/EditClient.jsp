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

function viewFullDetails(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog("+row.id+")'>" + cellvalue + "</a>";
}

function openDialog(id) 
{
	$("#fullDetail").show();
	$("#fullDetail").load("<%=request.getContextPath()%>/view/client/fullDetail.action?id="+id);
}

</script>
<script type="text/javascript"> 
    var datePick = function(elem) 
    { 
       jQuery(elem).datepicker(); 
       jQuery('#ui-datepicker-div').css("z-index", 2000); 
    } 
    </script> 
</head>
<body>


<div class="page_title"><h1>Client View</h1></div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<div class="form_inner" id="form_reg">
<div class="page_form">
<s:url id="clientView" action="clientView" />
<s:url id="editClient" action="editClient" />


<sjg:grid 
		  id="gridedittable"
          caption="Client View"
          href="%{clientView}"
          gridModel="clientGridModel"
          navigator="true"
          navigatorAdd="false"
          navigatorView="true"
          navigatorDelete="true"
          navigatorEdit="true"
          navigatorSearch="true"
          rowList="10,15,20,25,50,100,200,500"
          rownumbers="true"
          viewrecords="true"       
          pager="true"
          pagerButtons="true"
          pagerInput="true"   
          multiselect="false"  
          loadingText="Requesting Data..."  
          rowNum="10"
          width="835"
          navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
          editurl="%{editClient}"
          shrinkToFit="false"
	      dataType="json"
          >
        <sjg:gridColumn  name="id" index="id" title="Id" align="center" editable="false" search="false"/> 
		<sjg:gridColumn  name="clientName" index="clientName" title="Client Name" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="clientName" index="clientName" title="Full Histoty Of Client" align="center" editable="false" search="true" formatter="viewFullDetails"/>
		<sjg:gridColumn  name="clientMob" index="clientMob" title="Client Mob" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="clientPhoneno" index="clientPhoneno" title="Client Phoneno" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="clientEmailId" index="clientEmailId" title="Client Emailid" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="clientAddress" index="clientAddress" title="Client Address" align="center" editable="true" search="true"/>
		<sjg:gridColumn  name="doj_date" index="doj_date" title="Client D.O.J" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="dob_date" index="dob_date" title="Client DOB" align="center" editable="false" search="true" formatter="date" formatoptions="{newformat : 'd.m.Y', srcformat : 'Y-m-d'}" editoptions="{ dataInit:datePick }"/>
		<sjg:gridColumn  name="doa_date" index="doa_date" title="Create DOA" align="center" editable="false" search="true"  formatter="date" formatoptions="{newformat : 'd.m.Y', srcformat : 'Y-m-d'}" editoptions="{ dataInit:datePick }"/>
		<sjg:gridColumn  name="sourceName" index="sourceName" title="Client Source" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="user" index="user" title="Created By" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="date" index="date" title="Date" align="center" editable="false" search="true"/>
		<sjg:gridColumn  name="time" index="time" title="Time" align="center" editable="false" search="true"/>
</sjg:grid>

</div>
<br><br>
<div id="fullDetail" style="display: none; width:100%;">
</div>
</div>
</div>
</div>
</body>
</html>