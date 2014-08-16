<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div class="group_content">
	<table width="100%" cellpadding="5" cellspacing="0" border="1"
		bordercolor="#bebdbc" style="border-collapse: collapse;">
		<tbody>
			<tr class="group_head">
				<td width="25%" align="center"><b>Select</b></td>
				<td width="25%" align="center"><b>Id</b></td>
				<td width="50%"><b>Scheme Name</b></td>
			</tr>
			<s:iterator value="clientGroupSchemeDetails" id="clientGroupSchemeDetails"
				status="counter">
				<s:if test="#counter.count%2 != 0">
					<tr bgcolor="#e1e3e3">
						<td align="center" valign="middle"><s:checkbox  name="gid" id="gid" value="true" fieldValue="%{key}" theme="simple"/> </td>
						<td align="center" valign="middle" width="25%"><b><s:property
									value="%{key}" /></b></td>
						<td align="left" valign="middle" width="50%"><s:property
								value="%{value}" /></td>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<td align="center" valign="middle"><s:checkbox  name="gid" id="gid" value="true" fieldValue="%{key}" theme="simple"/> </td>
						<td align="center" valign="middle" width="25%"><b><s:property
									value="%{key}" /></b></td>
						<td align="left" valign="middle" width="50%"><s:property
								value="%{value}" /></td>
					</tr>
				</s:else>
			</s:iterator>
		</tbody>
	</table>
</div>