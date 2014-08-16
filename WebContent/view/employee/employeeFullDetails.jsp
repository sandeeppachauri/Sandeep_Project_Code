<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<body>
<div class="group_content" align="center">
							<table width="30%" cellpadding="5" cellspacing="0" border="1" bordercolor="#bebdbc" style=" border-collapse:collapse;"><tbody>
								<tr class="group_head">
									<td width="20%"><b>Mapped Clients</b></td>
									<!-- <td width="20%"><b>Remove</b></td> -->
								</tr>
								
								<s:iterator id="empList" value="empList" status="counter">  
								<s:if test="#counter.count%2 != 0">
								<tr bgcolor="#e1e3e3" id="row<s:property value="key"/>">
									<td align="left" valign="middle"><s:property value="value"/> </td>
									<!-- <td align="left" valign="middle"><a href="javascript:void();" style="padding-left:10%;"  title="Remove member from group" class="remove_button" onclick="removeArea('<s:property value="key"/>','row<s:property value="key"/>');">Remove area</a></td> -->
								</tr>
								</s:if>
								<s:else>
								<tr id="row<s:property value="key"/>">
									<td align="left" valign="middle"><s:property value="value"/> </td>
									<!-- <td align="left" valign="middle"><a href="javascript:void();" style="padding-left:10%;"  title="Remove member from group" class="remove_button" onclick="removeArea('<s:property value="key"/>','row<s:property value="key"/>');">Remove area</a></td> -->
								</tr>
								</s:else>
								</s:iterator>
							</tbody></table>
						</div>
</body>
</html>