<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<script type="text/javascript">
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

	<div class="group_content" align="center" id="two">
		<table width="100%" cellpadding="5" cellspacing="0" border="1"
			bordercolor="#bebdbc" style="border-collapse: collapse;">
			<tbody>
				<tr class="group_head">
					<td width="5%"><b>SR.No</b></td>
					<td width="20%"><b>Client Name</b></td>
					<td width="10%"><b>Card Number</b></td>
					<td width="10%"><b>Amount</b></td>
					<td width="15%"><b>Last Collection Date</b></td>
					<td width="15%"><b>Next</b></td>
					<td width="10%"><b>Frequency</b></td>
				</tr>

				<s:iterator id="ClientReportPojo" value="clientSearchFullViewData"
					status="counter">
					<s:if test="#counter.count%2 != 0">
						<tr bgcolor="#e1e3e3">
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{totalCollection}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{frequency}" /></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{totalCollection}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{frequency}" /></td>
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
				onclick='printReport("two");'></li>
		</ul>
	</div>
</body>
</html>