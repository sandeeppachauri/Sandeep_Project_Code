<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<body>

	<div class="group_content" align="center" id="two">
		<table width="100%" cellpadding="5" cellspacing="0" border="1"
			bordercolor="#bebdbc" style="border-collapse: collapse;">
			<tbody>
				<tr class="group_head">
					<td width="5%"><b>SR.No</b></td>
					<td width="15%"><b>Scheme Name</b></td>
					<td width="15%"><b>Scheme DOJ</b></td>
					<td width="15%"><b>Card Number</b></td>
					<td width="15%"><b>Client Name</b></td>
					<td width="10%"><b>Client Mob</b></td>
				</tr>

				<s:iterator id="ClientReportPojo" value="clientSearchFullViewData"
					status="counter">
					<s:if test="#counter.count%2 != 0">
						<tr bgcolor="#e1e3e3">
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td> 
							</td>
							<td align="left" valign="middle"><s:property
									value="%{schemeName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{schemeName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{joinDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{cardNo}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{clientMob}" /></td>
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