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
			$("#orglevel12").fadeIn();
		}, 10);
		setTimeout(function() {
			$("#orglevel12").fadeOut();
		}, 4000);
	});
	
	$.subscribe('level3', function(event, data) {
		//document.getElementById("indicator1").style.display="none";
		setTimeout(function() {
			$("#orglevel13").fadeIn();
		}, 10);
		setTimeout(function() {
			$("#orglevel13").fadeOut();
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
			errorgroupName.innerHTML = "Error: Fill Group Name";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formone.groupCustomerNumber.value != null
				&& document.formone.groupCustomerNumber.value == ""
				|| document.formone.groupCustomerNumber.value == "-1") {
			clearAllErroDiv();
			errorgroupCustomerNumber.innerHTML = "Error: Fill No of customer";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formone.groupStartDate.value != null
				&& document.formone.groupStartDate.value == ""
				|| document.formone.groupStartDate.value == "-1") {
			clearAllErroDiv();
			errorgroupStartDate.innerHTML = "Error: Select Kitty Start Date";
			event.originalEvent.options.submit = false;
			return false;
		}
		clearAllErroDiv();
	});
	
	$.subscribe('validate2', function(event, data) {
		if (document.formtwo.schemeID.value != null
				&& document.formtwo.schemeID.value == ""
				|| document.formtwo.schemeID.value == "-1") {
			clearAllErroDiv();
			errorschemeID.innerHTML = "Error: Select Scheme Name";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formtwo.minInstPay.value != null
				&& document.formtwo.minInstPay.value == ""
				|| document.formtwo.minInstPay.value == "-1") {
			clearAllErroDiv();
			errorminInstPay.innerHTML = "Error: Select Inst Pay";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formtwo.maxMonth.value != null
				&& document.formtwo.maxMonth.value == ""
				|| document.formtwo.maxMonth.value == "-1") {
			clearAllErroDiv();
			errormaxMonth.innerHTML = "Error: Select Max Months";
			event.originalEvent.options.submit = false;
			return false;
		}
		else if (document.formtwo.rewardAmount.value != null
				&& document.formtwo.rewardAmount.value == ""
				|| document.formtwo.rewardAmount.value == "-1") {
			clearAllErroDiv();
			errorrewardAmount.innerHTML = "Error: Enter Reward Amount";
			event.originalEvent.options.submit = false;
			return false;
		}
		else if (document.formtwo.futurPay.value != null
				&& document.formtwo.futurPay.value == ""
				|| document.formtwo.futurPay.value == "-1") {
			clearAllErroDiv();
			errorfuturPay.innerHTML = "Error: Select Future Payment";
			event.originalEvent.options.submit = false;
			return false;
		}
		else if (document.formtwo.orgnzrAmount.value != null
				&& document.formtwo.orgnzrAmount.value == ""
				|| document.formtwo.orgnzrAmount.value == "-1") {
			clearAllErroDiv();
			errororgnzrAmount.innerHTML = "Error: Enter Org Reward Amount";
			event.originalEvent.options.submit = false;
			return false;
		}
		else if (document.formtwo.groupId.value != null
				&& document.formtwo.groupId.value == ""
				|| document.formtwo.groupId.value == "-1") {
			clearAllErroDiv();
			errorgroupId.innerHTML = "Error: Select Group Name";
			event.originalEvent.options.submit = false;
			return false;
		}
		clearAllErroDiv();
	});
	
	
	$.subscribe('validate3', function(event, data) {
		if (document.formthree.groupId.value != null
				&& document.formthree.groupId.value == ""
				|| document.formthree.groupId.value == "-1") {
			clearAllErroDiv();
			errorgroupId.innerHTML = "Error: Select Group Name";
			event.originalEvent.options.submit = false;
			return false;
		} else if (document.formthree.clientId.value != null
				&& document.formthree.clientId.value == ""
					|| document.formthree.clientId.value == "-1") {
				clearAllErroDiv();
				errorclientId.innerHTML = "Error: Select Client Name";
				event.originalEvent.options.submit = false;
				return false;
			} 
		clearAllErroDiv();
	});
	function getClients()
	{

		$("#ajaxResponse").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/beforeMapGroupWithClient.action",
		    success : function(subdeptdata) {
	       $("#"+"ajaxResponse").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	}
	
	function getClientSchemes()
	{

		$("#ajaxResponse1").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/beforeMappingGroupWithClientScheme.action",
					success : function(subdeptdata) {
						$("#" + "ajaxResponse1").html(subdeptdata);
					},
					error : function() {
						alert("error");
					}
				});
	}
	
	function checkGroupMembers(groupId)
	{

		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/checkGroupMembers.action?groupId="+groupId,
					success : function(subdeptdata) {
						document.getElementById("buttonShowHide").style.display="block";
						alert("You can add more members in group.");
					},
					error : function() {
						document.getElementById("buttonShowHide").style.display="none";
						alert("You can't add more members in group. Members limit is exceed.");
					}
				});
	}
	
	function getClientGroupableSchemes(clientId)
	{
		$("#ajaxResponseGroupScheme").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/getClientGroupableSchemes.action?clientId="+clientId,
					success : function(subdeptdata) {
						$("#" + "ajaxResponseGroupScheme").html(subdeptdata);
					},
					error : function() {
						alert("Error!!!");
					}
				});
	}
</script>
</head>
<div class="page_title">
	<h1>Group >> Manage Group & Customer</h1>
	<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block">
	<div style="float: left; padding: 20px 5%; width: 90%;">
		<sj:accordion id="accordion" autoHeight="false">
			<sj:accordionItem title="Group >> Add New Group" id="oneId">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<s:form id="formone" name="formone" namespace="/view/scheme"
							action="createGroup" theme="simple" method="post">
							<div class="form_menubox">
								<div class="inputmain">
									<div class="user_form_text">Group Name:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:textfield name="groupName" id="groupName"
											cssClass="form_menu_inputtext" placeholder="Enter Group Name"
											cssStyle="margin:0px 0px 10px 0px" />
										<div id="errorgroupName" class="errordiv"></div>
									</div>
								</div>
								<div class="inputmain">
									<div class="user_form_text1">No's Group Member:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<s:textfield name="groupCustomerNumber"
											id="groupCustomerNumber" cssClass="form_menu_inputtext"
											placeholder="Enter number of customer in group"
											cssStyle="margin:0px 0px 10px 0px" />
										<div id="errorgroupCustomerNumber" class="errordiv"></div>
									</div>
								</div>
							</div>
							<div class="form_menubox">
								<div class="inputmain">
									<div class="user_form_text">Group Start Date:</div>
									<div class="user_form_input inputarea">
										<span class="needed"></span>
										<sj:datepicker id="groupStartDate" name="groupStartDate"
											placeholder="Select Kitty Start Date" minDate="0"
											showOn="focus" displayFormat="dd-mm-yy"
											cssClass="form_menu_inputtext" />
										<div id="errorgroupStartDate" class="errordiv"></div>
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
			<sj:accordionItem title="Group >> Configure Group Type Scheme" id="twoId"
				onclick="getClients();">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<div id="ajaxResponse"></div>
					</div>
				</div>
			</sj:accordionItem>

			<sj:accordionItem title="Group >> Map Customer With Group"
				id="threeId" onclick="getClientSchemes();">
				<div class="form_inner" id="form_reg">
					<div class="page_form">
						<div id="ajaxResponse1"></div>
					</div>
				</div>
			</sj:accordionItem>

		</sj:accordion>
	</div>
</div>
</html>