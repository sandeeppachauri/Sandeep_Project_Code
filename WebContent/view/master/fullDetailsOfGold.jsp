<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<body>
<div class="group_content">
							<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;"><tbody>
								<tr class="group_head">
									<td width="20%"><b>Gold in % </b></td>
									<td width="20%"><b>Rate</b></td>
								</tr>
								
								<s:iterator id="goldDetails" value="goldDetails" status="counter">  
								<s:if test="#counter.odd">
								<tr bgcolor="#e1e3e3" id="row<s:property value="key"/>">
									<td align="left" valign="middle"><s:property value="key"/> </td>
									<td align="left" valign="middle"><s:property value="value"/> </td>
								</tr>
								</s:if>
								<s:else>
								<tr id="row<s:property value="key"/>">
									<td align="left" valign="middle"><s:property value="key"/> </td>
									<td align="left" valign="middle"><s:property value="value"/> </td>
								</tr>
								</s:else>
								</s:iterator>
							</tbody></table>
						</div>
</body>
</html>