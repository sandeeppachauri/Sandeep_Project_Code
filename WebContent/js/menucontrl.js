$(document).ready(function(){
	$("#MailConfiguration").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "view/Over2Cloud/Setting/MailConfig.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	$("#RegistrationSpaceConfiguration").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "view/Over2Cloud/Setting/serverconfigSpace.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	//Sandep work starts from here for organization 
	
	$("#organization").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeOrganization.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#organizationView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeOrganizationView.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#organizationModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeOrganizationModify.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#department").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDepartment.action?deptFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#departmentView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDepartmentView.action?deptFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#departmentModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDepartmentModify.action?deptFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#subDepartment").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeSubDepartment.action?existFlag=1&subDeptfalg=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#subDepartmentView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeSubDepartmentView.action?subDeptfalg=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#subDepartmentModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeSubDepartmentModify.action?subDeptfalg=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#designation").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDesignation.action?designationFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#designationView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDesignationView.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#designationModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/commonModules/beforeDesignationModify.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	$("#employee").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeEmployee.action?empModuleFalgForDeptSubDept=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#employeeView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeEmployeeView.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#employeeModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeEmployeeModify.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#employeeHistory").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeEmployeeHistory.action?empModuleFalgForDeptSubDept=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#mapEmployee").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeEmployeeMap.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#user").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeUser.action?flafSeleced=1&empModuleFalgForDeptSubDept=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#userView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeUserView.action?empModuleFalgForDeptSubDept=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#userModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeUserModify.action?empModuleFalgForDeptSubDept=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#kra_kpiAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforeKRAKPICreate.action?empModuleFalgForDeptSubDept=1&kraKPIFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#kra_kpiView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforekra_kpiView.action?modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#kra_kpiModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforekra_kpiView.action?modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#kra_kpiMap").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/hr/beforekra_kpiMapping.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	//Sales force menu works starts from here

	$("#offeringAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/offering/beforeOfferingAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#offeringView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/offering/beforeOfferingView.action?modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#offeringModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/offering/beforeOfferingView.action?modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	$("#offeringDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/offering/beforeOfferingView.action?modifyFlag=0&deleteFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	//Target Add and View and Modify
	$("#targetAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/target/beforeTargetAdd.action?header=Allot",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#targetView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/target/beforeTargetView.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#targetModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/target/beforeTargetAdd.action?header=Modify",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	//Target Add and View and Modify
	
	
	
	//Code Start for Incentive Added By Anurag
	
	$("#incentiveAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/incentive/beforeIncentiveAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#incentiveView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/incentive/beforeIncentiveView.action?modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#incentiveModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/incentive/beforeIncentiveView.action?modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#incentiveDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/incentive/beforeIncentiveView.action?modifyFlag=0&deleteFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	
	//Lead work start from here
	
	$("#leadAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Lead/beforeleadAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#leadView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Lead/beforeleadView.action?modifyFlag=0&deleteFlag=0&formater=0&lostLead=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#leadDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Lead/beforeleadView.action?modifyFlag=0&deleteFlag=1&formater=0&lostLead=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#leadAction").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Lead/beforeleadView.action?modifyFlag=0&deleteFlag=0&formater=1&lostLead=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#leadLostLead").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Lead/beforeleadView.action?modifyFlag=0&deleteFlag=0&formater=0&lostLead=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	
	//Lead work start end here
	
	
	//WFPM masters works STARTS from here

	$("#associateStatusAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_associate_status_master&mapSubTable=associate_status_master&moduleName=Associate Status Master&dataTable=associatestatus",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#associateStatusView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?modifyFlag=0&deleteFlag=0&mappingTable=mapped_associate_status_master&mapSubTable=associate_status_master&moduleName=Associate Status Master&dataTable=associatestatus",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#associateStatusModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?modifyFlag=1&deleteFlag=0&mappingTable=mapped_associate_status_master&mapSubTable=associate_status_master&moduleName=Associate Status Master&dataTable=associatestatus",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#associateStatusDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?modifyFlag=0&deleteFlag=1&mappingTable=mapped_associate_status_master&mapSubTable=associate_status_master&moduleName=Associate Status Master&dataTable=associatestatus",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#sourceMasterAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_source_master&mapSubTable=source_master&moduleName=Source Master&dataTable=sourceMaster",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#sourceMasterView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_source_master&mapSubTable=source_master&moduleName=Source Master&dataTable=sourceMaster&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#sourceMasterModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_source_master&mapSubTable=source_master&moduleName=Source Master&dataTable=sourceMaster&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	//Client Status
	$("#clientStatusAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_client_status_master&mapSubTable=client_status_master&moduleName=Client Status Master&dataTable=client_status",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#clientStatusView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_client_status_master&mapSubTable=client_status_master&moduleName=Client Status Master&dataTable=client_status&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#clientStatusModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_client_status_master&mapSubTable=client_status_master&moduleName=Client Status Master&dataTable=client_status&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});	

	//Location Master
	$("#locationAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_location_master&mapSubTable=location_master&moduleName=Location Master&dataTable=location_master_data",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#locationView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_location_master&mapSubTable=location_master&moduleName=Location Master&dataTable=location_master_data&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#locationModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_location_master&mapSubTable=location_master&moduleName=Location Master&dataTable=location_master_data&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

//lost master
	$("#lostMasterAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_lost_master&mapSubTable=lost_master&moduleName=Lost Master&dataTable=lost_master_data",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#lostMasterView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_lost_master&mapSubTable=lost_master&moduleName=Lost Master&dataTable=lost_master_data&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#lostMasterModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_lost_master&mapSubTable=lost_master&moduleName=Lost Master&dataTable=lost_master_data&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	//Associate Type
	$("#associateTypeAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_associate_type_master&mapSubTable=associate_type_master&moduleName=Associate Type Master&dataTable=associateType",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#associateTypeView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_associate_type_master&mapSubTable=associate_type_master&moduleName=Associate Type Master&dataTable=associateType&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#associateTypeModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_associate_type_master&mapSubTable=associate_type_master&moduleName=Associate Type Master&dataTable=associateType&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	//Associate Category
	$("#associateCategoryAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusAdd.action?mappingTable=mapped_associate_category_master&mapSubTable=associate_category_master&moduleName=Associate Category Master&dataTable=associateCategory",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#associateCategoryView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_associate_category_master&mapSubTable=associate_category_master&moduleName=Associate Category Master&dataTable=associateCategory&modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#associateCategoryModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/masters/beforeAssociateStatusView.action?mappingTable=mapped_associate_category_master&mapSubTable=associate_category_master&moduleName=Associate Category Master&dataTable=associateCategory&modifyFlag=1&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	//client data action part
	
	//------------------------------------------------------------------------
	$("#pclientAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientAdd.action?modifyFlag=0&deleteFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#pclientView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=0&deleteFlag=0&isExistingClient=0&lostFlag=0&convertToClient=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#pclientModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=1&deleteFlag=0&&lostFlag=0&convertToClient=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#pclientDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=0&deleteFlag=1&lostFlag=0&convertToClient=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#eclientView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=0&deleteFlag=0&isExistingClient=1&lostFlag=0&convertToClient=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	//for asociate work

//Code Start for Prospective Associate Added By Anurag
	
	$("#pAssociateAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateAdd.action",
		    data : "existAssociate="+ 0,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#pAssociateView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=0",
		    data : "existAssociate="+ 0,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#pAssociateModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=1&deleteFlag=0",
		    data : "existAssociate="+ 0,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#pAssociateDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=1",
		    data : "existAssociate="+ 0,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	///////////////

	//Code Start for Existing Associate Added By Anurag
	
	$("#existAssociateAdd").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateAdd.action",
		    data : "existAssociate="+ 1,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	$("#existAssociateView").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=0",
		    data : "existAssociate="+ 1,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#existAssociateModify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=1&deleteFlag=0",
		    data : "existAssociate="+ 1,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#existAssociateDelete").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=1",
		    data : "existAssociate="+ 1,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	// code Start for lost opportunity by Rahul

	$("#ProsLOperView").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=0&deleteFlag=0&lostFlag=1&isExistingClient=0&convertToClient=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
	$("#assoLOperView").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=0",
		    data : "existAssociate="+ 2,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});





	$("#prosLOperAction").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/wfpm/client/beforeClientView.action?modifyFlag=0&deleteFlag=0&lostFlag=1&isExistingClient=0&convertToClient=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});


	
	$("#assoLOperAction").click(function(){
		$("#data_part").html("");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/WFPM/Associate/ProspectiveAssociate/beforeAssociateView.action?modifyFlag=0&deleteFlag=0&convertToAsso=1",
		    data : "existAssociate="+ 2,
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
// code end for Lost Opportunity

	
	///////////////
	//help desk menu click data
	//Help desk modules
	$("#feed_draft_add").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/beforeFeedDraft.action?empModuleFalgForDeptSubDept=1&feedbackDarft=1",
		    success : function(feeddraft) {
	       $("#"+"data_part").html(feeddraft);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_draft_view").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/beforeFeedDraftView.action?modifyFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_draft_modify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/beforeFeedDraftView.action?modifyFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_via_call").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedViaCall.action?empModuleFalgForDeptSubDept=1&lodgeFeedback=1&feedStatus=call",
		    success : function(feeddraft) {
	       $("#"+"data_part").html(feeddraft);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_via_online").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedViaOnline.action?empModuleFalgForDeptSubDept=1&lodgeFeedback=1&feedStatus=online",
		    success : function(feeddraft) {
	       $("#"+"data_part").html(feeddraft);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



	$("#shift_add").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Shift_Conf/beforeShift.action?empModuleFalgForDeptSubDept=1&shiftConf=1",
		    success : function(feeddraft) {
	       $("#"+"data_part").html(feeddraft);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#shift_view").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Shift_Conf/beforeShiftView.action?modifyFlag=0",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#shift_modify").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Shift_Conf/beforeShiftView.action?modifyFlag=1",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#roaster_conf_add").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Roaster_Conf/beforeRoaster.action?flag=add",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#roaster_conf_apply").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Roaster_Conf/beforeRoaster.action?flag=apply",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_action_pending").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedAction.action?feedStatus=Pending",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_action_snooze").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedAction.action?feedStatus=Snooze",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	

	$("#feed_action_hp").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedAction.action?feedStatus=High Priority",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});

	$("#feed_action_resolved").click(function(){
		$("#data_part").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/beforeFeedAction.action?feedStatus=Resolved",
		    success : function(subdeptdata) {
	       $("#"+"data_part").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});



});