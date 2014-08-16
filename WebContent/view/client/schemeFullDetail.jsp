<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="group_content" align="center">
							<table width="100%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;"><tbody>
								<tr class="group_head">
									<td width="1%"><b>SR.No</b></td>
									<td width="45%"><b>Collection Date</b></td>
									<td width="45%"><b>Collection Amount</b></td>
								</tr>
								
								<s:iterator id="cardNoCollectionDetails" value="cardNoCollectionDetails" status="counter">  
								<s:if test="#counter.count%2 != 0">
								<tr bgcolor="#e1e3e3">
									<td align="left" valign="middle"><s:property value="#counter.count"/> </td>
									<td align="left" valign="middle"><s:property value="%{key}"/> </td>
									<td align="left" valign="middle"><s:property value="%{value}"/> </td>
								</tr>
								</s:if>
								<s:else>
								<tr>
									<td align="left" valign="middle"><s:property value="#counter.count"/> </td>
									<td align="left" valign="middle"><s:property value="%{key}"/> </td>
									<td align="left" valign="middle"><s:property value="%{value}"/> </td>
								</tr>
								</s:else>
								</s:iterator>
							</tbody></table>
						</div>