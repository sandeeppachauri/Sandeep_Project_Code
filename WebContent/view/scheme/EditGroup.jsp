<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<s:url id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme"
	customBasepath="%{contextz}" />

<SCRIPT type="text/javascript">
function showGroupMembers(cellvalue, options, rowObject) 
{
       return "<a href='#' onClick='getDetails("+rowObject.id+")'>" + cellvalue + "</a>";
}

function getDetails(id) 
{
	$("#fullDetail").show();
	$("#fullDetail").load("<%=request.getContextPath()%>/view/scheme/groupFullDetail.action?id="+id);
}
</SCRIPT>

</head>
<body>

	<div class="page_title">
		<h1>Group View</h1>
	</div>
	<div class="container_block">
		<div style="float: left; padding: 20px 5%; width: 90%;">
			<div class="form_inner" id="form_reg">
				<div class="page_form">
					<s:url id="viewGroup" action="viewGroup" />
					<s:url id="editGroup" action="editGroup" />

					<sjg:grid id="gridedittable" caption="View/Edit group"
						href="%{viewGroup}" gridModel="groupGridModel" navigator="true"
						navigatorAdd="false" navigatorView="true" navigatorDelete="false"
						navigatorEdit="true" navigatorSearch="true"
						rowList="10,15,20,25,50,100,200,500" rownumbers="-1" viewrecords="true"
						pager="true" pagerButtons="true" pagerInput="false"
						multiselect="true" loadingText="Requesting Data..." rowNum="10"
						width="835"
						navigatorSearchOptions="{sopt:['eq','ne','cn','bw','ne','ew']}"
						editurl="%{editGroup}" shrinkToFit="false">
						<sjg:gridColumn name="id" index="id" title="Id" align="center"
							editable="false" search="false" width="30" />
						<sjg:gridColumn name="groupName" index="groupName"
							title="Group Name" align="center" editable="true" search="true" />
						<sjg:gridColumn name="groupName" index="groupName"
							title="View Group Members" align="center" editable="true"
							search="true" formatter="showGroupMembers" />
						<sjg:gridColumn name="groupCustomerNumber"
							index="groupCustomerNumber" title="Number of members in group"
							align="center" editable="true" search="true" />
						<sjg:gridColumn name="groupStartDate" index="groupStartDate"
							title="Group Start Date" align="center" editable="false"
							search="true" />
						<sjg:gridColumn name="user" index="user" title="Created By"
							align="center" editable="false" search="true" />
						<sjg:gridColumn name="date" index="date" title="Created On"
							align="center" editable="false" search="true" />

					</sjg:grid>
				</div>
				<br />
				<br />
				<div id="fullDetail" style="display: none; width: 100%;"></div>
			</div>
		</div>
	</div>
</body>
</html>