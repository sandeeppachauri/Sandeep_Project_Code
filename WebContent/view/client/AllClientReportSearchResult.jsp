<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>

<script type="text/javascript">

//Getting full detail of the client scheme card no based on the requiered
function viewFullDetail(clientID,cardNo)
{
	
	$("#mySingleSpaceDilog").load("<%=request.getContextPath()%>/view/client/schemeFullDetail.action?cardNo="+cardNo);
    $("#mySingleSpaceDilog").dialog('open');
}

function viewFullActionDetail(clientID,cardNo)
{
	
	$("#fullView").load("<%=request.getContextPath()%>/view/client/actionFullDetail.action?cardNo="+cardNo);
    $("#fullView").dialog('open');
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

</head>
<body>
	<sj:dialog id="mySingleSpaceDilog" showEffect="slide"
		hideEffect="explode" autoOpen="false" modal="true"
		title="Client Scheme Full Detail" closeTopics="closeEffectDialog"
		width="400" height="300">
	</sj:dialog>

	<sj:dialog id="fullView" showEffect="slide" hideEffect="explode"
		autoOpen="false" modal="true" title="Client Scheme Action Full Detail"
		closeTopics="closeEffectDialog" width="800" height="300">
	</sj:dialog>
	<div class="group_content" align="center" id="one">
		<table width="100%" cellpadding="5" cellspacing="0" border="1"
			bordercolor="#bebdbc" style="border-collapse: collapse;">
			<tbody>
				<tr class="group_head">
					<td width="5%"><b>SR.No</b></td>
					<td width="15%"><b>Client Name</b></td>
					<td width="10%"><b>Client Mob</b></td>
					<td width="20%"><b>Scheme Name</b></td>
					<td width="10%"><b>Card No</b></td>
					<td width="7%"><b>Total</b></td>
					<td width="10%"><b>D.O.J</b></td>
					<td width="7%"><b>History</b></td>
					<td width="15%"><b>Full View</b></td>
				</tr>

				<s:iterator id="ClientReportPojo" value="clientSearchData"
					status="counter">
					<s:if test="#counter.count%2 != 0">
						<tr bgcolor="#e1e3e3">
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{schemeName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{totalCollection}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="remove_button"
								onclick="viewFullActionDetail('<s:property value="%{clientId}"/>','<s:property value="%{cardNo}"/>');">History</a>
							</td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="remove_button"
								onclick="viewFullDetail('<s:property value="%{clientId}"/>','<s:property value="%{cardNo}"/>');">Collection
									View</a></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{schemeName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{totalCollection}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="remove_button"
								onclick="viewFullActionDetail('<s:property value="%{clientId}"/>','<s:property value="%{cardNo}"/>');">History</a>
							</td>
							<td align="left" valign="middle"><a
								href="javascript:void();" style="padding-left: 10%;"
								class="remove_button"
								onclick="viewFullDetail('<s:property value="%{clientId}"/>','<s:property value="%{cardNo}"/>');">Collection
									View</a></td>
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