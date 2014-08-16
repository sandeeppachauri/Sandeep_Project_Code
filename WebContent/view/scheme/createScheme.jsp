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

$.subscribe('level12', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel22").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel22").fadeOut(); }, 4000);
	       });

$.subscribe('level13', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel13").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel13").fadeOut(); }, 4000);
	       });

$.subscribe('level14', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel14").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel14").fadeOut(); }, 4000);
	       });

$.subscribe('level15', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel15").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel15").fadeOut(); }, 4000);
	       });
	       
$.subscribe('level16', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel16").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel16").fadeOut(); }, 4000);
	       });
	       
$.subscribe('level17', function(event,data)
	       {
			//document.getElementById("indicator1").style.display="none";
	         setTimeout(function(){ $("#orglevel17").fadeIn(); }, 10);
	         setTimeout(function(){ $("#orglevel17").fadeOut(); }, 4000);
	       });
function getSchemePeriod(scheme)
{
	var schemeName=$("#"+scheme).val();
	$.ajax({
		type :"post",
		url :"/Suvidha/view/scheme/getSchemeDetails.action?scheme1="+schemeName,
		success : function(subCategoryData) {
			$("#schemePerDiv").html(subCategoryData);
		},
		error : function() {
			alert("error");
		}
	});
}

function getincrmntlSchemes()
{
	$("#"+"schemeResponseText").html("");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/scheme/allIncrmtnlSchemes.action",
	    success : function(subdeptdata) {
       $("#"+"schemeResponse").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}

function drarNoOfTextBox(schemeId)
{
	$("#schemeResponseText").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/scheme/drawIncrtmntText.action?schemeId="+schemeId,
	    success : function(subdeptdata) {
       $("#"+"schemeResponseText").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}


function clearAllErroDiv()
{
	$("div[id^='error']").each(function() {
  	  // `this` now refers to the current element
	     this.innerHTML="";
  	});
}

$.subscribe('validate1', function(event,data)
        {
			if(document.formone.schemeName.value!=null && document.formone.schemeName.value=="" || document.formone.schemeName.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeNameTemp.innerHTML="Error: Enter Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.schemeDesc.value!=null && document.formone.schemeDesc.value=="" || document.formone.schemeDesc.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeDesc.innerHTML="Error: Enter Scheme Description";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.schemeStartDate.value!=null && document.formone.schemeStartDate.value=="" || document.formone.schemeStartDate.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeStartDate.innerHTML="Error: Select Date";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formone.schemeEndDate.value!=null && document.formone.schemeEndDate.value=="" || document.formone.schemeEndDate.value=="-1")
		    {
				clearAllErroDiv();
				errorschemeEndDate.innerHTML="Error: Select Date";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
        });
        
        
$.subscribe('validate2', function(event,data)
        {

			if(document.formTwo.scheme1.value!=null && document.formTwo.scheme1.value=="" || document.formTwo.scheme1.value=="-1")
		    {
				clearAllErroDiv();
				errorscheme1.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.minPeriod.value!=null && document.formTwo.minPeriod.value=="" || document.formTwo.minPeriod.value=="-1")
		    {
				clearAllErroDiv();
				errorminPeriod.innerHTML="Error: Enter Minimum Period";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.amount.value!=null && document.formTwo.amount.value=="" || document.formTwo.amount.value=="-1")
		    {
				clearAllErroDiv();
				erroramount.innerHTML="Error: Enter Scheme Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.totalAmount.value!=null && document.formTwo.totalAmount.value=="" || document.formTwo.totalAmount.value=="-1")
		    {
				clearAllErroDiv();
				errortotalAmount.innerHTML="Error: Enter Total Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.contr.value!=null && document.formTwo.contr.value=="" || document.formTwo.contr.value=="-1")
		    {
				clearAllErroDiv();
				errorcontr.innerHTML="Error: Enter Suvidha Contribution";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.maxAmount.value!=null && document.formTwo.maxAmount.value=="" || document.formTwo.maxAmount.value=="-1")
		    {
				clearAllErroDiv();
				errormaxAmount.innerHTML="Error: Enter Full Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.withdrw.value!=null && document.formTwo.withdrw.value=="" || document.formTwo.withdrw.value=="-1")
		    {
				clearAllErroDiv();
				errorwithdrw.innerHTML="Error: Select Withdraw Option";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.luckyDraw.value!=null && document.formTwo.luckyDraw.value=="" || document.formTwo.luckyDraw.value=="-1")
		    {
				clearAllErroDiv();
				errorluckyDraw.innerHTML="Error: Select Luckydraw Option";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formTwo.incremntal.value!=null && document.formTwo.incremntal.value=="" || document.formTwo.incremntal.value=="-1")
		    {
				clearAllErroDiv();
				errorincremntal.innerHTML="Error: Select Increment Option";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			var returnValue=testNumericValue('minPeriod','errorminPeriod');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('amount','erroramount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('totalAmount','errortotalAmount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('contr','errorcontr');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('maxAmount','errormaxAmount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			clearAllErroDiv();
        });
        
$.subscribe('validate3', function(event,data)
        {
			if(document.formFour.scheme3.value!=null && document.formFour.scheme3.value=="" || document.formFour.scheme3.value=="-1")
		    {
				clearAllErroDiv();
				errorscheme3.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFour.minWeek.value!=null && document.formFour.minWeek.value=="" || document.formFour.minWeek.value=="-1")
		    {
				clearAllErroDiv();
				errorminWeek.innerHTML="Error: Enter Minimum Time";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFour.maxWeek.value!=null && document.formFour.maxWeek.value=="" || document.formFour.maxWeek.value=="-1")
		    {
				clearAllErroDiv();
				errormaxWeek.innerHTML="Error: Enter Maximum Time";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFour.bonusAmount.value!=null && document.formFour.bonusAmount.value=="" || document.formFour.bonusAmount.value=="-1")
		    {
				clearAllErroDiv();
				errorbonusAmount.innerHTML="Error: Enter Bonus Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFour.widraw.value!=null && document.formFour.widraw.value=="" || document.formFour.widraw.value=="-1")
		    {
				clearAllErroDiv();
				errorwidraw.innerHTML="Error: Select Withdraw Option";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFour.paymentAfter.value!=null && document.formFour.paymentAfter.value=="" || document.formFour.paymentAfter.value=="-1")
		    {
				clearAllErroDiv();
				errorpaymentAfter.innerHTML="Error: Select Future Payment";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
			var returnValue=testNumericValue('minWeek','errorminWeek');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('maxWeek','errormaxWeek');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('bonusAmount','errorbonusAmount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
			
			returnValue=testNumericValue('paymentAfter','errorpaymentAfter');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
        });
        
$.subscribe('validate4', function(event,data)
        {
			if(document.formFive.scheme4.value!=null && document.formFive.scheme4.value=="" || document.formFive.scheme4.value=="-1")
		    {
				clearAllErroDiv();
				errorscheme4.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFive.luckyPay.value!=null && document.formFive.luckyPay.value=="" || document.formFive.luckyPay.value=="-1")
		    {
				clearAllErroDiv();
				errorluckyPay.innerHTML="Error: Select Future Payment";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFive.paymentMode.value!=null && document.formFive.paymentMode.value=="" || document.formFive.paymentMode.value=="-1")
		    {
				clearAllErroDiv();
				errorpaymentMode.innerHTML="Error: Select Payment Mode";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formFive.luckyDrawAmt.value!=null && document.formFive.luckyDrawAmt.value=="" || document.formFive.luckyDrawAmt.value=="-1")
		    {
				clearAllErroDiv();
				errorluckyDrawAmt.innerHTML="Error: Enter Lucky Draw Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
			var returnValue=testNumericValue('luckyDrawAmt','errorluckyDrawAmt');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
        });
        
$.subscribe('validate5', function(event,data)
        {
			if(document.formSix.scheme5.value!=null && document.formSix.scheme5.value=="" || document.formSix.scheme5.value=="-1")
		    {
				clearAllErroDiv();
				errorscheme5.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formSix.loyalityAmount.value!=null && document.formSix.loyalityAmount.value=="" || document.formSix.loyalityAmount.value=="-1")
		    {
				clearAllErroDiv();
				errorloyalityAmount.innerHTML="Error: Enter Loyality Amount";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			else if(document.formSix.loyalityGms.value!=null && document.formSix.loyalityGms.value=="" || document.formSix.loyalityGms.value=="-1")
		    {
				clearAllErroDiv();
				errorloyalityGms.innerHTML="Error: Enter Loyality Gold";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
			
			var returnValue=testNumericValue('loyalityAmount','errorloyalityAmount');
			if(!returnValue){
				event.originalEvent.options.submit = false;
				return false;
			}
        });
        
$.subscribe('validate6', function(event,data)
        {
			if(document.formNine.schemeName.value!=null && document.formNine.schemeName.value=="" || document.formNine.schemeName.value=="-1")
		    {
				clearAllErroDiv();
				errorscheme6.innerHTML="Error: Select Scheme Name";
            	event.originalEvent.options.submit = false;
            	return false;
		    }
			clearAllErroDiv();
        });
</script>
</head>
<div class="page_title"><h1>Scheme >> Add New Scheme</h1>
<span class="needed_block">= indicates mandatory fields</span>
</div>
<div class="container_block"><div style=" float:left; padding:20px 5%; width:90%;">
<sj:accordion id="accordion" autoHeight="false">
<sj:accordionItem title="Scheme >> Add" id="oneId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formone" name="formone" namespace="/view/scheme" action="schemeNew" theme="simple"  method="post">
                 <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Name:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="schemeName"  id="schemeName"  cssClass="form_menu_inputtext" placeholder="Enter Scheme Name" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorschemeNameTemp" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Scheme Description:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textarea name="schemeDesc"  id="schemeDesc"  cssClass="form_menu_inputtext" placeholder="Scheme Description" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorschemeDesc" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Start Date:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker  id="schemeStartDate" name="schemeStartDate" placeholder="Enter Open Date" minDate="0" showOn="focus" displayFormat="dd-mm-yy" cssClass="form_menu_inputtext"/>
					     <div id="errorschemeStartDate" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Scheme End Date:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <sj:datepicker  id="schemeEndDate" name="schemeEndDate" placeholder="Enter End Date" minDate="0" showOn="focus" displayFormat="dd-mm-yy" cssClass="form_menu_inputtext"/>
					     <div id="errorschemeEndDate" class="errordiv"></div>
					     </div>
					  </div>
             	</div>
             	
             	<div class="form_menubox">
					  <div class="inputmain"><div class="user_form_text">Groupable Scheme:</div>
					     <div class="user_form_input inputarea">
							<s:select id="groupAble" name="groupAble" 
                              list="{'Yes','No'}"
                              headerKey="" headerValue="--Select Value--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     </div> 
					  </div>
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
<sj:accordionItem title="Scheme Type >> Add" id="twoId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formTwo" name="formTwo" namespace="/view/scheme" action="schemeNewType" theme="simple"  method="post">
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="scheme1" name="scheme1" 
                              list="schemeList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              listKey="id"
                              listValue="schemeName"
                              >
                 			 </s:select>
					     <div id="errorscheme1" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme Frequency:</div>
					     <font face="Verdana" color="#CC9900">
      							<input type="radio" value="daily" name="multiTimeValue" tabindex="2" onClick="validateClick(this.value, this.form);" class="selectcell">
      						</font>
      						<label class="labelcell" style="font-size:10px;"> Daily&nbsp;&nbsp;</label>
      						<font face="Verdana" color="#CC9900">
      							<input type="radio" value="weekly" name="multiTimeValue" tabindex="3" onClick="validateClick(this.value, this.form);" class="selectcell" checked="checked">
      						</font>
      						
      						<label class="labelcell" style="font-size:10px;"> Weekly&nbsp;</label>
      						   <font face="Verdana" color="#CC9900">
      							 <input type="radio" value="monthly" name="multiTimeValue" tabindex="4" onClick="validateClick(this.value, this.form);" class="selectcell">
      							</font>
      						<label class="labelcell" style="font-size:10px;">Monthly&nbsp;&nbsp;</label>
      						<font face="Verdana" color="#CC9900">
                            <input type="radio" value="Quarterly" name="multiTimeValue" tabindex="4" onClick="validateClick(this.value, this.form);" class="selectcell">
                            </font>
							<label class="labelcell" style="font-size:10px;">Quarterly&nbsp; </label>
                            <font face="Verdana" color="#CC9900">
                            	<input type="radio" value="HalfEarly" name="multiTimeValue" tabindex="4" onClick="validateClick(this.value, this.form);" class="selectcell">
                            </font>
                            <label class="labelcell" style="font-size:10px;">Half Yearly &nbsp;</label>  	
      						<font face="Verdana" color="#CC9900">
      						<input type="radio" value="yearly" name="multiTimeValue" tabindex="5" onClick="validateClick(this.value, this.form);" class="selectcell">
      						</font>
      						<label class="labelcell" style="font-size:10px;"> Yearly&nbsp; </b>
					  </div>
             	</div>
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Min Period:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="minPeriod"  id="minPeriod"  cssClass="form_menu_inputtext" placeholder="Enter Min Period" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorminPeriod" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="amount"  id="amount"  cssClass="form_menu_inputtext" placeholder="Enter Amount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="erroramount" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Total Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="totalAmount"  id="totalAmount"  cssClass="form_menu_inputtext" placeholder="Enter Min Period" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errortotalAmount" class="errordiv"></div>
					     </div> 
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Our Contribution:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="contr"  id="contr"  cssClass="form_menu_inputtext" placeholder="Enter Contribution Aount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorcontr" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	<div class="form_menubox">
					   <div class="inputmain"><div class="user_form_text">Net Maturity Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="maxAmount"  id="maxAmount"  cssClass="form_menu_inputtext" placeholder="Enter Maturity Amount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errormaxAmount" class="errordiv"></div>
					     </div>
					  </div>
					  <div class="inputmain"><div class="user_form_text1">Withdrawable:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="withdrw" name="withdrw" 
                              list="{'Yes','No'}"
                              headerKey="-1" headerValue="--Select Status--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorwithdrw" class="errordiv"></div>
					     </div> 
					  </div>
             	</div>
             	<div class="form_menubox">
             	<div class="inputmain"><div class="user_form_text">Lucky Draw:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="luckyDraw" name="luckyDraw" 
                              list="{'Yes','No'}"
                              headerKey="-1" headerValue="--Select Status--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorluckyDraw" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Incremental:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="incremntal" name="incremntal" 
                              list="{'Yes','No'}"
                              headerKey="-1" headerValue="--Select Status--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorincremntal" class="errordiv"></div>
					     </div> 
					     
					  </div>
             	</div>
             	
				<center><img id="indicator22" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel2Div2" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        cssClass="submit"
	                        indicator="indicator22"
	                        onCompleteTopics="level12"
	                        onBeforeTopics="validate2"
	                        />
	               </div>
				</ul>
				<sj:div id="orglevel22"  effect="fold">
                    <div id="orglevel2Div2"></div>
               </sj:div>
               </div>
			</s:form>
</div>
</div>
</sj:accordionItem>
<sj:accordionItem title="Scheme Withdraw Condition >> Add" id="twoId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formFour" name="formFour" namespace="/view/scheme" action="schemeNewCondition" theme="simple"  method="post">
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="scheme3" name="scheme3" 
                              list="schemeWithList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              listKey="id"
                              listValue="schemeName"
                               onchange="getSchemePeriod('scheme3')"
                              >
                 			 </s:select>
					     <div id="errorscheme3" class="errordiv"></div>
					     </div> 
					  </div>
				</div>
					<div class="form_menubox">
					  <div id="schemePerDiv">
             	</div>
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Bonus Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      	<s:textfield name="bonusAmount"  id="bonusAmount"  cssClass="form_menu_inputtext" placeholder="Enter Bonus Amount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorbonusAmount" class="errordiv"></div>
					     </div> 
					  </div>
					  
					  <div class="inputmain"><div class="user_form_text1">Withdrawable:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="widraw" name="widraw" 
                              list="#{'Yes':'Yes','No':'No'}"
                              headerKey="-1" headerValue="--Select Withdrawable--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorwidraw" class="errordiv"></div>
					     </div> 
					  </div>
			  </div>
			  
			  <div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Payment After:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      	<s:textfield name="paymentAfter"  id="paymentAfter"  cssClass="form_menu_inputtext" placeholder="Enter Number Of Payment After" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorpaymentAfter" class="errordiv"></div>
					     </div> 
					  </div>
			  </div>
             	
             	<div id="schemePerDiv">
             	</div>
				<center><img id="indicator24" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div4" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level14"
	                        cssClass="submit"
	                        indicator="indicator24"
	                        onBeforeTopics="validate3"
	                        />
	               </div>
	             </li>
				</ul>
				<sj:div id="orglevel14"  effect="fold">
                    <div id="orglevel1Div4"></div>
               </sj:div>
               </div>
			</s:form>
</div>
</div>
</sj:accordionItem>
<sj:accordionItem title="Scheme Lucky Draw >> Add" id="twoId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formFive" name="formFive" namespace="/view/scheme" action="schemeLuckyDrawAdd" theme="simple"  method="post">
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="scheme4" name="scheme4" 
                              list="luckySchemeList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              listKey="id"
                              listValue="schemeName"
                              >
                 			 </s:select>
					     <div id="errorscheme4" class="errordiv"></div>
					     </div> 
					  </div>
					  
					   <div class="inputmain"><div class="user_form_text1">Future Payment:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:select id="luckyPay" name="luckyPay" 
                              list="{'Yes','No'}"
                              headerKey="-1" headerValue="--Select Status--" cssClass="form_menu_inputselect"
                              >
                 			 </s:select>
					     <div id="errorluckyPay" class="errordiv"></div>
					     </div> 
					  </div>
				</div>
				
				<div class="form_menubox">
					    <div class="inputmain"><div class="user_form_text">Payment Mode:</div>
						     <div class="user_form_input inputarea"><span class="needed"></span>
								<s:select id="paymentMode" name="paymentMode" 
	                              list="#{'1':'Gold','2':'Cash','3':'Scratch Card'}"
	                              headerKey="-1" headerValue="--Select Payment Mode--" cssClass="form_menu_inputselect"
	                              >
	                 			 </s:select>
						     <div id="errorpaymentMode" class="errordiv"></div>
						     </div> 
						  </div>
					  
					   <div class="inputmain"><div class="user_form_text1">Lucky Draw Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					     <s:textfield name="luckyDrawAmt"  id="luckyDrawAmt"  cssClass="form_menu_inputtext" placeholder="Enter Draw Amount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorluckyDrawAmt" class="errordiv"></div>
					     </div>
					  </div>
					 
             	</div>
             	
             	<div class="form_menubox">
             	<font color="red"><b>*Note:</b>In case of Scratch Card please fill Lucky Draw Amount <b>"0".</b></font>
             	</div>
				<center><img id="indicator25" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div5" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level15"
	                        cssClass="submit"
	                        indicator="indicator25"
	                        onBeforeTopics="validate4"
	                        />
	               </div>
	             </li>
				</ul>
				<sj:div id="orglevel15"  effect="fold">
                    <div id="orglevel1Div5"></div>
               </sj:div>
               </div>
			</s:form>
</div>
</div>
</sj:accordionItem>
<sj:accordionItem title="Scheme Extra Loyality >> Add" id="twoId">  
<div class="form_inner" id="form_reg">
<div class="page_form">
		<s:form id="formSix" name="formSix" namespace="/view/scheme" action="extraLoyalityAdd" theme="simple"  method="post">
             	<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Scheme:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:select id="scheme5" name="scheme5" 
                              list="schemeList"
                              headerKey="-1" headerValue="--Select Scheme--" cssClass="form_menu_inputselect"
                              listKey="id"
                              listValue="schemeName"
                              >
                 			 </s:select>
					     <div id="errorscheme5" class="errordiv"></div>
					     </div> 
					  </div>
					 <div class="inputmain"><div class="user_form_text1">Loyality Amount:</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
							<s:textfield name="loyalityAmount"  id="loyalityAmount"  cssClass="form_menu_inputtext" placeholder="Enter Loyality Amount" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorloyalityAmount" class="errordiv"></div>
					     </div> 
					  </div>
				</div>
				<div class="form_menubox">
	                   <div class="inputmain"><div class="user_form_text">Loyality Gold(in gms):</div>
					     <div class="user_form_input inputarea"><span class="needed"></span>
					      <s:textfield name="loyalityGms"  id="loyalityGms"  cssClass="form_menu_inputtext" placeholder="Enter Loyality Gold" cssStyle="margin:0px 0px 10px 0px"/>
					     <div id="errorloyalityGms" class="errordiv"></div>
					     </div> 
					  </div>
				</div>
				<center><img id="indicator26" src="<s:url value="/images/indicator.gif"/>" alt="Loading..." style="display:none"/></center>
				<div class="fields">
				<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
	                <sj:submit 
	                        targets="orglevel1Div6" 
	                        clearForm="true"
	                        value="  Register  " 
	                        effect="highlight"
	                        effectOptions="{ color : '#222222'}"
	                        effectDuration="5000"
	                        button="true"
	                        onCompleteTopics="level15"
	                        cssClass="submit"
	                        indicator="indicator26"
	                        onBeforeTopics="validate5"
	                        />
	               </div>
	             </li>
				</ul>
				<sj:div id="orglevel16"  effect="fold">
                    <div id="orglevel1Div6"></div>
               </sj:div>
               </div>
			</s:form>
</div>
</div>
</sj:accordionItem>
<sj:accordionItem title="Scheme Incremental Configuration " id="lastId" onclick="getincrmntlSchemes();">
<s:form id="formNine" name="formNine" namespace="/view/scheme" action="incrmtnlSchemeAdd" theme="simple"  method="post">
<div id="schemeResponse"></div>
<div id="schemeResponseText"></div>
</s:form>
</sj:accordionItem>
</sj:accordion>
</div>
</div>
</html>