<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>

<script type="text/javascript">
	function printReport(divID) {
		var divElements = document.getElementById(divID).innerHTML;
		var oldPage = document.body.innerHTML;
		document.body.innerHTML = "<html><head><title></title></head><body>"
				+ divElements + "</body>";
		window.print();
		document.body.innerHTML = oldPage;
	}
	
	function viewFullActionDetail(clientID)
	{
		
		$("#fullView").load("<%=request.getContextPath()%>/view/scheme/fullReferenceDetails.action?clientId="
								+ clientID);
		$("#fullView").dialog('open');
	}

</script>

</head>
<body>

	<sj:dialog id="fullView" showEffect="slide" hideEffect="explode"
		autoOpen="false" modal="true"
		title="Client Reference Csutomer Details"
		closeTopics="closeEffectDialog" width="800" height="300"
		closeOnEscape="true"
		>
	</sj:dialog>


	<div class="group_content" align="center" id="one">
		<table width="100%" cellpadding="5" cellspacing="0" border="1"
			bordercolor="#bebdbc" style="border-collapse: collapse;">
			<tbody>
				<tr class="group_head">
					<td width="5%"><b>SR.No</b></td>
					<td width="5%"><b>Client.Id</b></td>
					<td width="15%"><b>Client Name</b></td>
					<td width="10%"><b>Client Mob</b></td>
					<td width="15%"><b>View All Reference</b></td>
				</tr>

				<s:iterator id="ClientReportPojo" value="clientSearchData"
					status="counter">
					<s:if test="#counter.count%2 != 0">
						<tr bgcolor="#e1e3e3">
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientId}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="like_button"
								onclick="viewFullActionDetail('<s:property value="%{clientId}"/>');">View
									All Reference</a></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientId}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="like_button"
								onclick="viewFullActionDetail('<s:property value="%{clientId}"/>');">View
									All Reference</a></td>
						</tr>
					</s:else>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="fields">
		<ul>
			<li class="submit" style="padding: 0px 10px;"><input
				type="button" class="submit" name="" id="report" value="Print"
				onclick='printReport("one");'></li>
		</ul>
	</div>
</body>
</html>