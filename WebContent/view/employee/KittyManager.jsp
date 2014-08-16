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
	$.subscribe('level1', function(event, data) {
		//document.getElementById("indicator1").style.display="none";
		setTimeout(function() {
			$("#orglevel1").fadeIn();
		}, 10);
		setTimeout(function() {
			$("#orglevel1").fadeOut();
		}, 4000);
	});
	
	$.subscribe('level2', function(event, data) {
		//document.getElementById("indicator1").style.display="none";
		setTimeout(function() {
			$("#orglevel2").fadeIn();
		}, 10);
		setTimeout(function() {
			$("#orglevel2").fadeOut();
		}, 4000);
	});
	
	function clearAllErroDiv() {
		$("div[id^='error']").each(function() {
			// `this` now refers to the current element
			this.innerHTML = "";
		});
	}

	$.subscribe('validate1', function(event, data) {
		if (document.formone.groupName.value != null
				&& document.formone.groupName.value == ""
				|| document.formone.groupName.value == "-1") {
			clearAllErroDiv();
			errorgroupName.innerHTML = "Error: Select Group Name";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formone.empName.value != null
				&& document.formone.empName.value == ""
				|| document.formone.empName.value == "-1") {
			clearAllErroDiv();
			errorempName.innerHTML = "Error: Select Organizer Name";
			event.originalEvent.options.submit = false;
			return false;
		} 
		clearAllErroDiv();
	});
	
	$.subscribe('validate2', function(event, data) {
		if (document.formtwo.empIdkitty.value != null
				&& document.formtwo.empIdkitty.value == ""
				|| document.formtwo.empIdkitty.value == "-1") {
			clearAllErroDiv();
			errorempIdkitty.innerHTML = "Error: Select Organizer Name";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formtwo.mappedGroupName.value != null
				&& document.formtwo.mappedGroupName.value == ""
				|| document.formtwo.mappedGroupName.value == "-1") {
			clearAllErroDiv();
			errormappedGroupName.innerHTML = "Error: Select Group Name";
			event.originalEvent.options.submit = false;
			return false;
		} 
		clearAllErroDiv();
	});

	function getMapGroup(empId)
	{

		$("#mapGroupedd").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/getMapGroup.action?id="+empId,
					success : function(subdeptdata) {
						$("#" + "mapGroupedd").html(subdeptdata);
					},
					error : function() {
						alert("error");
					}
				});
	}
	
	function getMapGroupDetail(groupid)
	{

		$("#mapGroupedDetails").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/getMapGroupDetail.action?id="+groupid,
					success : function(subdeptdata) {
						$("#" + "mapGroupedDetails").html(subdeptdata);
					},
					error : function() {
						alert("No reward amount is alloted for this group.");
					}
				});
	}
</script>
</head>
<div class="page_title">
	<h1>Kitty Organization >> Manage Kitty & Rewards</h1>
	<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block">
	<div style="float: left; padding: 20px 5%; width: 90%;">
		<sj:accordion id="accordion" autoHeight="false">
			<sj:accordionItem title="Kitty Organization >> Map organizer" id="oneId">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<s:form id="formone" name="formone" namespace="/view/employee"
							action="mapOrganizerWithGroup" theme="simple" method="post">
							<div class="form_menubox">
								<div class="inputmain">
									<div class="user_form_text">Group Name:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:select id="groupName" name="groupName"
											list="groupNameList" headerKey="-1"
											headerValue="--Select Name of Group--"
											cssClass="form_menu_inputselect">
										</s:select>
										<div id="errorgroupName" class="errordiv"></div>
									</div>
								</div>
								<div class="inputmain">
									<div class="user_form_text1">Organizer Name:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:select id="empName" name="empName"
											list="empNameList" headerKey="-1"
											headerValue="--Select Name of Organizer--"
											cssClass="form_menu_inputselect">
										</s:select>
										<div id="errorempName" class="errordiv"></div>
									</div>
								</div>
							</div>
							<center>
								<img id="indicator2"
									src="<s:url value="/images/indicator.gif"/>" alt="Loading..."
									style="display: none" />
							</center>
							<div class="fields">
								<ul>
									<li class="submit" style="background: none;">
										<div class="type-button">
											<sj:submit targets="orglevel1Div" clearForm="true"
												value="  Add Group  " effect="highlight"
												effectOptions="{ color : '#222222'}" effectDuration="5000"
												button="true" onCompleteTopics="level1" cssClass="submit"
												indicator="indicator2" onBeforeTopics="validate1" />
										</div>
								</ul>
								<sj:div id="orglevel1" effect="fold">
									<div id="orglevel1Div"></div>
								</sj:div>
							</div>
						</s:form>
					</div>
				</div>
			</sj:accordionItem>
			<sj:accordionItem title="Kitty Organization >> Add kitty arranged"
				id="twoId">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
					<s:form id="formtwo" name="formtwo" namespace="/view/employee"
							action="kittyOrganizationDone" theme="simple" method="post">
							<div class="form_menubox">
								<div class="inputmain">
									<div class="user_form_text">Organizer Name:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:select id="empIdkitty" name="empIdkitty"
											list="empNameList" headerKey="-1"
											headerValue="--Select Name of Organizer--"
											cssClass="form_menu_inputselect" onchange="getMapGroup(this.value);">
										</s:select>
										<div id="errorempIdkitty" class="errordiv"></div>
									</div>
								</div>
								<div id="mapGroupedd"></div>
							</div>
							<div id="mapGroupedDetails"></div>
							<center>
								<img id="indicator3"
									src="<s:url value="/images/indicator.gif"/>" alt="Loading..."
									style="display: none" />
							</center>
							<div class="fields">
								<ul>
									<li class="submit" style="background: none;">
										<div class="type-button">
											<sj:submit targets="orglevel2Div" clearForm="true"
												value="  Submit  " effect="highlight"
												effectOptions="{ color : '#222222'}" effectDuration="5000"
												button="true" onCompleteTopics="level2" cssClass="submit"
												indicator="indicator3" onBeforeTopics="validate2" />
										</div>
								</ul>
								<sj:div id="orglevel2" effect="fold">
									<div id="orglevel2Div"></div>
								</sj:div>
							</div>
						</s:form>
					</div>
				</div>
			</sj:accordionItem>
		</sj:accordion>
	</div>
</div>
</html>