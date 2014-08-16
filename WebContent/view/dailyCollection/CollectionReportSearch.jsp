<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<script type="text/javascript">
function printReport(divID) {
	var divElements = document.getElementById("print").innerHTML;
	var oldPage = document.body.innerHTML;
	document.body.innerHTML = "<html><head><title></title></head><body>"
			+ divElements + "</body>";
	window.print();
	document.body.innerHTML = oldPage;
}
</script>
</head>
<body>
<div id="print">
<div class="group_content">
<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>Collection Summarize Report</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>DETAIL OF MEMBERS</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="50%" align="center"><b>Particular</b></td>
<td width="25%"><b>No</b></td>
<td width="25%"><b>Amount</b></td>
</tr>
<tr bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b>Ledger Folio Till Yesterday</b></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalAccountTillYesterday}"/></td>
<td align="left" valign="middle" width="25%"><s:property value="%{totalAccountCollectionTillYesterday}"/></td>
</tr>
<tr>
<td align="center" valign="middle" width="50%"><b>New Members</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{newMembersToday}"/></td>
<td align="left" valign="middle" width="25%"><s:property value="%{newMemberCollection}"/></td>
</tr>

<tr bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b>Dead Members</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{deadMembersToday}"/></td>
<td align="left" valign="middle" width="25%"><s:property value="%{deadMemberCollection}"/></td>
</tr>

<tr>
<td align="center" valign="middle" width="50%"><b>Active Members</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{activeMembersToday}"/></td>
<td align="left" valign="middle" width="25%"><s:property value="%{activeMemberCollection}"/></td>
</tr>

<tr  bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b>Ledger Folio Till Today</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{totalAccountTillToday}"/></td>
<td align="left" valign="middle" width="25%"><s:property value="%{totalAccountCollectionTillToday}"/></td>
</tr>
</tbody>
</table>



<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>AREA NOT VISITED TODAY(*STATIC)</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="50%" align="center"><b>Area</b></td>
<td width="25%"><b>Member</b></td>
<td width="25%"><b>Amount</b></td>
</tr>
<tr bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b>Amar Colony</b></td>
<td align="left" valign="middle"  width="25%">1</td>
<td align="left" valign="middle" width="25%">1400</td>
</tr>
<tr>
<td align="center" valign="middle" width="50%"><b>Chattar Pur</b></td>
<td align="left" valign="middle" width="25%">3</td>
<td align="left" valign="middle" width="25%">4900</td>
</tr>

<tr bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b>Others</b></td>
<td align="left" valign="middle" width="25%">3</td>
<td align="left" valign="middle" width="25%">4200</td>
</tr>
</tbody>
</table>



<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>NEW MEMBERS TODAY</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="50%" align="center"><b>Area</b></td>
<td width="25%"><b>Member</b></td>
<td width="25%"><b>Amount</b></td>
</tr>

<s:iterator value="summerizeDataOfNewMembers" id="SummerizePojo"  status="counter">  
<s:if test="#counter.count%2 != 0">
<tr bgcolor="#e1e3e3">
<td align="center" valign="middle" width="50%"><b><s:property value="%{areaName}" /></b></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalMembersInArea}" /></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalAmmout}" /></td>
</tr>
</s:if>
<s:else>
<tr>
<td align="center" valign="middle" width="50%"><b><s:property value="%{areaName}" /></b></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalMembersInArea}" /></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalAmmout}" /></td>
</tr>
</s:else>
</s:iterator>

<tr>
<td align="center" valign="middle" width="50%"><b>Total:</b></td>
<td align="left" valign="middle" width="25%"><b><s:property value="%{newMembersToday}"/></b></td>
<td align="left" valign="middle" width="25%"><b><s:property value="%{newMemberCollection}"/></b></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>TOTAL COLLECTION OF SCHEMES</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr bgcolor="#e1e3e3">
<td align="left" valign="middle" width="75%"><b>TILL YESTERDAY</b></td>
<td align="left" valign="middle"  width="25%"><s:property value="%{totalCollectionTillYstrday}"/></td>
</tr>
<tr>
<td align="left" valign="middle" width="75%"><b>TODAY'S COLLECTION</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{totalCollectionOfToday}"/></td>
</tr>

<tr bgcolor="#e1e3e3">
<td align="left" valign="middle" width="75%"><b>TOTAL COLLECTION</b></td>
<td align="left" valign="middle" width="25%"><s:property value="%{totalCollectionOfAll}"/></td>
</tr>
</tbody>
</table>
</div>








<div class="group_content">
<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>Collection Summarize Report Of <s:property value="%{dateTo}"/> </center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="100%" valign="middle"><h2><center>DETAIL OF COLLECTION</center></h2></td>
</tr>
</tbody>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="20%" align="center"><b>Agent Name</b></td>
<td width="15%"  align="center"><b>Area Name</b></td>
<td width="10%"  align="center"><b>Members</b></td>
<td width="15%"  align="center"><b>Total Collection</b></td>
<td width="15%"  align="center"><b>Paid Members Today</b></td>
<td width="15%"  align="center"><b>Amount Collected</b></td>
<td width="5%"  align="left"><b>%</b></td>
</tr>

<s:iterator value="summerizeData" id="SummerizePojo"  status="counter">  
<s:if test="#counter.count%2 != 0">  
<tr  bgcolor="#e1e3e3">
<td align="center" valign="middle"><b><s:property value="%{empName}"/></b></td>
<td align="center" valign="middle"><s:property value="%{areaName}"/></td>
<td align="center" valign="middle"><s:property value="%{totalMembersInArea}"/></td>
<td align="center" valign="middle"><s:property value="%{totalCollectionAmmountFromArea}"/></td>
<td align="center" valign="middle"><s:property value="%{paidMembersToday}"/></td>
<td align="center" valign="middle"><s:property value="%{amountRecvdToday}"/></td>
<td align="left" valign="middle"><s:property value="%{inPer}"/></td>
</tr>
</s:if>
<s:else>
<tr>
<td align="center" valign="middle"><b><s:property value="%{empName}"/></b></td>
<td align="center" valign="middle"><s:property value="%{areaName}"/></td>
<td align="center" valign="middle"><s:property value="%{totalMembersInArea}"/></td>
<td align="center" valign="middle"><s:property value="%{totalCollectionAmmountFromArea}"/></td>
<td align="center" valign="middle"><s:property value="%{paidMembersToday}"/></td>
<td align="center" valign="middle"><s:property value="%{amountRecvdToday}"/></td>
<td align="left" valign="middle"><s:property value="%{inPer}"/></td>
</tr>
</s:else>
</s:iterator>
</tbody>
</table>

<!-- 
<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="42%" align="center"><b>406</b></td>
<td width="9%"  align="center"><b>257450</b></td>
<td width="9%"  align="center"><b>227</b></td>
<td width="14%"  align="center"><b>29500</b></td>
<td width="15%"  align="center"><b>29500</b></td>
</tr>
</tbody>
</table>
 -->
</div>
<div class="fields">
<ul>
<li class="submit" style="padding:0px 10px;">
<input type="button" class="submit" name="" id="report" value="Print" onclick='printReport();'></li>
</ul>
</div>
</div>
</body>
</html>