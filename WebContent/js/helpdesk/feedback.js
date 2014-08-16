function getDetail(uniqueid)
{
      var uniqueid = document.getElementById(uniqueid).value;
       $.getJSON("/cloudapp/view/Over2Cloud/HelpDeskOver2Cloud/Lodge_Feedback/ContactDetailViaAjax.action?uid="+uniqueid,
    	 function(data){
               if(data.empName == null){$("#feedbackBy").val("NA");}
               else {$("#feedbackBy").val(data.empName);}
               
               if(data.mobOne == null){$("#mobileno").val("NA");}
               else {$("#mobileno").val(data.mobOne); }
               
               if(data.emailIdOne == null){$("#emailId").val("helpdesk@blkhospital.com");}
               else {$("#emailId").val(data.emailIdOne);}
               
               if (data.deptName ==null || data.deptName =='' || data.deptName =='NA') {
            	   document.getElementById('fielddiv').style.display="none";
        		   document.getElementById('selectdiv').style.display="block";
        		   $("#deptname1").val('');
            	   $("#subdept1").val('');
            	   $("#bysubdept").val('');
			   }
               else {
            	   document.getElementById('fielddiv').style.display="block";
        		   document.getElementById('selectdiv').style.display="none";
        		   $("#deptname1").val(data.deptName);
            	   $("#subdept1").val(data.subdept);
            	   $("#bysubdept").val(data.id);
			}
       });
}