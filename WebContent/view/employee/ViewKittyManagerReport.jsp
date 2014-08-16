<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>

<script type="text/javascript">
	function printReport(divID) {
		//Get the HTML of div
		var divElements = document.getElementById(divID).innerHTML;
		//Get the HTML of whole page
		var oldPage = document.body.innerHTML;

		//Reset the page's HTML with div's HTML only
		document.body.innerHTML = "<html><head><title></title></head><body>"
				+ divElements + "</body>";
		//Print Page
		window.print();
		//Restore orignal HTML
		document.body.innerHTML = oldPage;
	}
</script>

</head>
<body>
	<div class="group_content" align="center" id="one">
		<table width="100%" cellpadding="5" cellspacing="0" border="1"
			bordercolor="#bebdbc" style="border-collapse: collapse;">
			<tbody>
				<tr class="group_head">
					<td width="5%"><b>SR.No</b></td>
					<td width="15%"><b>Group Name</b></td>
					<td width="10%"><b>Reward Amount</b></td>
					<td width="20%"><b>Date</b></td>
					<td width="10%"><b>Time</b></td>
					<td width="7%"><b>Entry By</b></td>
				</tr>

				<s:iterator id="KittyManagment" value="kittyData"
					status="counter">
					<s:if test="#counter.count%2 != 0">
						<tr bgcolor="#e1e3e3">
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{groupName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{rewardAmount}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryTime}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryUser}" /></td>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="left" valign="middle"><s:property
									value="#counter.count" /></td>
							<td align="left" valign="middle"><s:property
									value="%{groupName}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{rewardAmount}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryDate}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryTime}" /></td>
							<td align="left" valign="middle"><s:property
									value="%{entryUser}" /></td>
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