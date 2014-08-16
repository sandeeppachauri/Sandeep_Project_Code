var feedTypeFlag;
var feedCatgFlag;
var feedSCatgFlag;

function getSubDept(deptId,destAjaxDiv,deptLevel,subdeptType,ftf,fcf,fscf) {
	feedTypeFlag=ftf;
	feedCatgFlag=fcf;
	feedSCatgFlag=fscf;
	var dept=$("#"+deptId).val();
	if (deptLevel=='2') {
    if (subdeptType=='1') {
	$.ajax({
		type :"post",
		url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/subDeptViaAjax.action?destination="+ destAjaxDiv+"&dept="+deptId,
		success : function(subDeptData){
		$("#" + destAjaxDiv).html(subDeptData);
	    },
	    error : function () {
			alert("Somthing is wrong to get Sub Department");
		}
	});
    }
	
    else if (subdeptType=='2') {
    	$.ajax({
    		type :"post",
    		url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/BySubDeptViaAjax.action?destination="+ destAjaxDiv+"&dept="+deptId,
    		success : function(subDeptData){
    		$("#" + destAjaxDiv).html(subDeptData);
    	    },
    	    error : function () {
    			alert("Somthing is wrong to get Sub Department");
    		}
    	});
	}
    
    else if (subdeptType=='3') {
		$.ajax({
			type :"post",
			url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/ToSubDeptViaAjax.action?destination="+ destAjaxDiv+"&dept="+deptId,
			success : function(subDeptData){
			$("#" + destAjaxDiv).html(subDeptData);
		    },
		    error : function () {
				alert("Somthing is wrong to get Sub Department");
			}
		});
    }
   
	}
	}

	
function getFeedType(subDeptId,destAjaxDiv) {
	if (feedTypeFlag=='1') {
	var subdept=$("#"+subDeptId).val();
	$.ajax({
		type :"post",
		url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/FBTypeAjax.action?destination="+ destAjaxDiv+"&deptOrSubDeptId="+subDeptId,
		success : function(feedTypeData){
		$("#" + destAjaxDiv).html(feedTypeData);
	    },
	    error : function () {
			alert("Somthing is wrong to get Feed Type");
		}
	});
	}
}

function getFeedCategory(fbTypeId,destAjaxDiv) {
	if (feedCatgFlag=='1') {
	var feedType=$("#"+fbTypeId).val();
	$.ajax({
		type :"post",
		url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/FBCategoryAjax.action?destination="+ destAjaxDiv+"&feedTypeId="+fbTypeId,
		success : function(categoryData){
		$("#" + destAjaxDiv).html(categoryData);
	    },
	    error : function () {
			alert("Somthing is wrong to get Category");
		}
	});
	}
}

function getFeedSubCategory(categoryId,destAjaxDiv) {
	if (feedSCatgFlag=='1') {
	var catgId=$("#"+categoryId).val();
	$.ajax({
		type :"post",
		url :"/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/FBSubCategoryAjax.action?destination="+ destAjaxDiv+"&catg="+categoryId,
		success : function(categoryData){
		$("#" + destAjaxDiv).html(categoryData);
	    },
	    error : function () {
			alert("Somthing is wrong to get Category");
		}
	});
	}
}


function getFeedBreifViaAjax(subCatgId)
{
      var subCatg = document.getElementById(subCatgId).value;
       $.getJSON("/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Feedback_Draft/SubCatgDetail.action?subcatg="+subCatg,
    	 function(data){
               if(data.feed_msg == null){
            	   $("#feedBrief").val("NA");
               }
               else {
            	   $("#feedBrief").val(data.feed_msg);
			   }
               
               if(data.addressing_time == null){
            	   $("#resolutionTime").val("00:30");
               }
               else {
            	   $("#resolutionTime").val(data.addressing_time);
			   }
               
               if(data.escalation_time == null){
            	   $("#escalationTime").val("02:00");
               }
               else {
            	   $("#escalationTime").val(data.escalation_time);
			   }
       });
}


