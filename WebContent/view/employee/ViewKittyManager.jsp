<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<s:url id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme"
	customBasepath="%{contextz}" />
<SCRIPT type="text/javascript">

	function viewReport(empId)
	{

		$("#viewReportDiv").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/viewReport.action?id="
							+ empId,
					success : function(subdeptdata) {
						$("#" + "viewReportDiv").html(subdeptdata);
					},
					error : function() {
						alert("error");
					}
				});
	}
</script>
</head>
<div class="page_title">
	<h1>Kitty Organization >> View Kitty Report</h1>
	<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block">
	<div style="float: left; padding: 20px 5%; width: 90%;">
		<sj:accordion id="accordion" autoHeight="false">
			<sj:accordionItem title="Kitty Organization >> Map organizer"
				id="oneId">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<s:form id="formone" name="formone" namespace="/view/employee"
							action="mapOrganizerWithGroup" theme="simple" method="post">
							<div class="form_menubox">
								<div class="inputmain">
									<div class="user_form_text">Organizer Name:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:select id="empName" name="empName" list="empNameList"
											headerKey="-1" headerValue="--Select Name of Organizer--"
											cssClass="form_menu_inputselect"
											onchange="viewReport(this.value);">
										</s:select>
										<div id="errorempName" class="errordiv"></div>
									</div>
								</div>
							</div>
							<div id="viewReportDiv"></div>
						</s:form>
					</div>
				</div>
			</sj:accordionItem>
		</sj:accordion>
	</div>
</div>
</html>