<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<SCRIPT type="text/javascript">
$.subscribe('level1', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel1").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel1").fadeOut(); }, 4000);
	       });

$.subscribe('validate1', function(event,data)
        {

			if(document.formone.empName.value!=null && document.formone.empName.value=="" || document.formone.empName.value=="-1")
		    {
				clearAllErroDiv();
				errorempName.innerHTML="Error: Enter Employee Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.empMob.value!=null && document.formone.empMob.value=="" || document.formone.empMob.value=="-1")
		    {
				clearAllErroDiv();
				errorempMob.innerHTML="Error: Enter Employee Mobile No";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.empAddress.value!=null && document.formone.empAddress.value=="" || document.formone.empAddress.value=="-1")
		    {
				clearAllErroDiv();
				errorempAddress.innerHTML="Error: Enter Employee Address";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.doj_date.value!=null && document.formone.doj_date.value=="" || document.formone.empMob.value=="-1")
		    {
				clearAllErroDiv();
				errordoj_date.innerHTML="Error: Enter Employee D.O.J";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			
			clearAllErroDiv();
			
			var returnValue=testNumericValue('empMob','errorempMob');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			returnValue=testNumericValue('empPhoneNo','errorempPhoneNo');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
        });

function clearAllErroDiv()
{
	$("div[id^='error']").each(function() {
  	  // `this` now refers to the current element
	     this.innerHTML="";
  	});
}
</script>
</head>
<div class="page_title"><h1>Employee >> Registration</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Employee >> Add" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/employee" action="employeeAdd" theme="simple"  method="post">
		
             	
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="empName"  id="empName"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorempName" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Mob:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="empMob"  id="empMob"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px" maxlength="10"/>
					     <div id="errorempMob" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Phone No:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="empPhoneNo"  id="empPhoneNo"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorempPhoneNo" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Email ID:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="empEmailId"  id="empEmailId"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorempEmailId" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Address:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="empAddress"  id="empAddress"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					      <div id="errorempAddress" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">D.O.J:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker name="doj_date" id="doj_date" changeMonth="true" changeYear="true" yearRange="1970:2020" showOn="focus" displayFormat="dd-mm-yy" 
					     cssClass="form_menu_inputtext" placeholder="Select DOJ"/>
					     <div id="errordoj_date" class="errordiv"></div>
					     </div>
					     </div>
			   </div>
				
				
				<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Emp ID:</div>
					     <div class="user_form_input inputarea">
					     <s:textfield name="empId"  id="empId"  cssClass="form_menu_inputtext" placeholder="Enter Data" cssStyle="margin:0px 0px 10px 0px"/>
					     </div> 
					  </div>
					  <!-- 
					  <div class="inputmain"><div class="user_form_text1">Employee Type:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="empType" name="empType" 
                              list="{'Employee','Organizer'}"
                              headerKey="" headerValue="--Select Value--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
                 			 <div id="errorfuturPay" class="errordiv"></div>
					     </div> 
					  </div>
					   -->
             	</div>
             	
				<center><img id="indicator2" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level1"
	                        cssClass="submit"
	                        indicator="indicator2"
	                        onBeforeTopics="validate1"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel1"  effect="fold">
                    <div id="orglevel1Div"></div>
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