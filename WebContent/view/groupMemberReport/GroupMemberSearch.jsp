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
<script type="text/javascript">
function searchReport()
{

	$("#"+"process").html("<right><img src=images/notificationloader.gif></right>");
	$("#"+"responseDiv").html("");
	var refrncCountFrom=$('#refrncCountFrom').val();
	var refrncCountTo=$('#refrncCountTo').val();
	var dataObj={"refrncCountFrom":refrncCountFrom,"refrncCountTo":refrncCountTo};
	$.ajax({
		 type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/viewGroupReport.action",
					data : dataObj,
					success : function(subdeptdata) {
						$("#" + "responseDiv").html(subdeptdata);
						$("#" + "process").html("");
					},
					error : function() {
						alert("error");
					}
				});
	}
</script>
</head>
<div class="page_title">
	<h1>Group Member >> Report View</h1>
</div>
<div class="container_block">
	<div style="float: left; padding: 20px 5%; width: 90%;">
		<sj:accordion id="accordion" autoHeight="false">
			<sj:accordionItem title="Group Member >> Report View" id="oneId">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<div class="form_menubox">
							<div class="inputmain">
								<div class="user_form_text">Ref Count From:</div>
								<div class="user_form_input inputarea">
									<s:textfield name="refrncCountFrom" id="refrncCountFrom"
										cssClass="form_menu_inputtext" placeholder="Enter Count Number"
										cssStyle="margin:0px 0px 10px 0px" />
								</div>
							</div>
							<div class="inputmain">
								<div class="user_form_text1">Ref Count To:</div>
								<div class="user_form_input inputarea">
									<s:textfield name="refrncCountTo" id="refrncCountTo"
										cssClass="form_menu_inputtext" placeholder="Enter Count Number"
										cssStyle="margin:0px 0px 10px 0px" />
								</div>
							</div>
						</div>

						<div id="process"></div>
						<div class="fields" id="sub_field">
							<ul>
								<li class="submit" style="padding: 0px 10px;"><input
									type="button" class="submit" name="" id="send" value="Search"
									onclick="searchReport();"></li>
							</ul>
						</div>
					</div>
				</div>
			</sj:accordionItem>

		</sj:accordion>
		<br>
		<br>
		<div id="responseDiv"></div>
	</div>
</div>
</html>