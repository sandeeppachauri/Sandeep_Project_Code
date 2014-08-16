<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script type="text/javascript">

//Getting full detail of the client scheme card no based on the requiered
function viewFullActionDetail(clientId)
{
	
	$("#mySingleSpaceDilog").load("<%=request.getContextPath()%>/view/scheme/viewGroupMemberCollectionDetail.action?clientId="+clientId);
    $("#mySingleSpaceDilog").dialog('open');
}

function printReport(divID) {
	var divElements = document.getElementById(divID).innerHTML;
	var oldPage = document.body.innerHTML;
	document.body.innerHTML = "<html><head><title></title></head><body>"
			+ divElements + "</body>";
	window.print();
	document.body.innerHTML = oldPage;
}
</script>
<body>
<sj:dialog id="mySingleSpaceDilog" showEffect="slide"
		hideEffect="explode" autoOpen="false" modal="true"
		title="Client Scheme Full Detail" closeTopics="closeEffectDialog"
		width="800" height="300" closeOnEscape="true">
	</sj:dialog>
<div class="group_content">
	<table width="100%" cellpadding="5" cellspacing="0" border="1"
		bordercolor="#bebdbc" style="border-collapse: collapse;">
		<tbody>
			<tr class="group_head">
				<td width="5%"><b>SR.No</b></td>
				<td width="25" align="center"><b>Client Name</b></td>
				<td width="25%" align="center"><b>Client Mobile Number</b></td>
				<td width="25%" align="center"><b>Full Payment View</b></td>
			</tr>
			<s:iterator value="mappedClientWithGroup" id="mappedClientWithGroup"
				status="counter">
				<s:if test="#counter.count%2 != 0">
					<tr bgcolor="#e1e3e3">
						<td align="left" valign="middle"><s:property
								value="#counter.count" /></td>
						<td align="center" valign="middle" width="25%"><b><s:property
									value="%{key}" /></b></td>
						<td align="center" valign="middle" width="25"><s:property
								value="%{value}" /></td>
						<td align="center" valign="middle"><a href="javascript:void();"
							style="padding-left: 10%;" class="like_button"
							onclick="viewFullActionDetail('<s:property value="%{key}"/>');">Full
								Payment View</a></td>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<td align="center" valign="middle"><s:property
								value="#counter.count" /></td>
						<td align="center" valign="middle" width="25%"><b><s:property
									value="%{key}" /></b></td>
						<td align="center" valign="middle" width="25"><s:property
								value="%{value}" /></td>
						<td align="center" valign="middle"><a href="javascript:void();"
							style="padding-left: 10%;" class="like_button"
							onclick="viewFullActionDetail('<s:property value="%{key}"/>');">Full
								Payment View</a></td>
					</tr>
				</s:else>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>