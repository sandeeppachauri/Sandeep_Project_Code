<%@ taglib prefix="s" uri="/struts-tags" %>
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
</html>
<div id="print">
<div class="group_content" style="width: 75%; float: none; padding-left: 13%;">
<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head" align="left">
<td width="100%" valign="middle"><h2><s:property value="%{schemeName}" /></h2></td>
</tr>
<tr class="group_head" align="left">
<td width="100%" valign="middle"><h2>Group Summary</h2></td>
</tr>
<tr class="group_head" align="left">
<td width="100%" valign="middle"><h2>For <s:property value="%{dateTo}"/></h2></td>
</tr>
</tbody>
</table>
<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;">
<tbody>
<tr class="group_head">
<td width="25%" align="center" colspan="2"></td>
<td width="25%" colspan="2" align="center"><b><h2><s:property value="%{schemeName}" /></h2></b></td>
</tr>
<tr class="group_head">
<td width="25%" align="left"  colspan="2"><h2>Particulars</h2></td>
<td width="25%" colspan="2" align="center"><b><h2>For <s:property value="%{dateTo}"/></h2></b></td>
</tr>
<tr class="group_head">
<td width="25%" align="center"  colspan="2"></td>
<td width="25%" colspan="2" align="center"><b><h2>Nett</h2></b></td>
</tr>
<tr class="group_head">
<td width="25%" align="center"  colspan="2"></td>
<td width="25%"><b><h2>Transactions</h2></b></td>
<td width="25%"><b><h2>Balance</h2></b></td>
</tr>

<s:iterator value="clientWiseSchemeReport" id="SummerizePojo"  status="counter">  
<s:if test="#counter.count%2 != 0">  
<tr bgcolor="#e1e3e3">
<td width="25%" align="left"  colspan="2"><s:property value="%{empName}"/></td>
<td width="25%"><s:property value="%{amountRecvdToday}"/></td>
<td width="25%"><s:property value="%{totalAmmout}"/></td>
</tr>
</s:if>
<s:else>
<tr>
<td width="25%" align="left"  colspan="2"><s:property value="%{empName}"/></td>
<td width="25%"><s:property value="%{amountRecvdToday}"/></td>
<td width="25%"><s:property value="%{totalAmmout}"/></td>
</tr>
</s:else>
</s:iterator>
</tbody>
</table>
</div>
<div class="fields">
<ul>
<li class="submit" style="padding:0px 10px;">
<input type="button" class="submit" name="" id="report" value="Print" onclick='printReport();'></li>
</ul>
</div>
</div>