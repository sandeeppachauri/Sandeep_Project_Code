<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="hi">
<META NAME="description" CONTENT="One place for your all needs Over2Cloud">
<title>::: Suvidha :::</title>
<script type="text/javascript" src="<s:url value="/js/homePage.js"/>"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<link href="<s:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
<link href="<s:url value="css/theme1.css"/>" rel="stylesheet" type="text/css"/>
<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value="/js/js.js"/>"></script>
<!-- Services menu starts heres -->

<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/ddaccordion.js"></script>
<script type="text/javascript" src="js/expandable_block.js"></script>
<!-- Services menu ends here -->
<script type="text/javascript">	
function validadeTextField(userForm,fieldName) {
	if(fieldName==null || fieldName==""){
		return true;
	}
	  var nameValue = document.getElementById(fieldName).value;
	  var iChars = "0123456789";
	    for (var i = 0; i < nameValue.length; i++) {
	        if (iChars.indexOf(nameValue.charAt(i)) == -1) {
	        	document.getElementById(fieldName).value="";
	        	alert("Enter Alphabet Only.");
	        }
	    }
	    return false;
	}
	
$(document).ready(function(){
	
	$("#araeAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeAraeAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#arededit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeArededit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#sourceAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeSourceAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#sourceEdit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeSourceEdit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#smtpAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeSmtpAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#smtpEdit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeSmtpEdit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#clientAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	
	$("#clientEdit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientEdit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	
	$("#clientMapAgent").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientMapAgent.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#clientMap").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientMapScheme.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#clientsrndr").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientSurrender.action?schemeTypeRecvd=0",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#reopenScheme").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeReopenScheme.action?schemeTypeRecvd=2",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#closeScheme").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientClose.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#luckyDrawScheme").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeLuckyDrawScheme.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#clientReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeClientReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	
	//employee work from here
	$("#employeeAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/beforeEmployeeAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#employeeEdit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/beforeEmployeeEdit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#employeeMapArea").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/beforeEmployeeAreaMap.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#uploadCollection").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeUploadCollection.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#collectionReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeCollectionReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#collectionSummerizeReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeCollectionSummerizeReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#collectionClientReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeCollectionClientReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	
	$("#dailyGoldPrice").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeDailyGoldPrice.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#dailyGoldPriceView").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeDailyGoldPriceView.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#userAdd").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeUserAdd.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#userEdit").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeUserEdit.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#pwdReset").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforePwdReset.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#backup").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeBackup.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	//Scheme
	$("#schemeAdd").click(function(){
        $("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/view/scheme/beforeSchemeAdd.action",
            success : function(subdeptdata) {
       $("#"+"mainHome").html(subdeptdata);
        },
           error: function() {
            alert("error");
        }
         });
        
	});
	
	$("#schemeEdit").click(function(){
        $("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/view/scheme/beforeSchemeEdit.action",
            success : function(subdeptdata) {
       $("#"+"mainHome").html(subdeptdata);
        },
           error: function() {
            alert("error");
        }
         });
        
	});
	
	$("#mapWithGroup").click(function(){
        $("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/view/scheme/beforeMapWithGroup.action",
            success : function(subdeptdata) {
       $("#"+"mainHome").html(subdeptdata);
        },
           error: function() {
            alert("error");
        }
         });
        
	});
	
	$("#viewGroup").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/beforeViewGroup.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#kittyManager").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/beforeKittyManager.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#viewKittyManager").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/employee/beforeViewKittyManager.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	
	$("#groupReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/scheme/beforeViewGroupReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#clientSchemeStatusReport").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/common/beforeClientSchemeStatusReport.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
	});
	
		$("#paymentPandingStatusReport").click(function(){
			$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
			$.ajax({
			    type : "post",
			    url : "<%=request.getContextPath()%>/view/common/beforePaymentPandingReport.action",
			    success : function(subdeptdata) {
		       $("#"+"mainHome").html(subdeptdata);
			},
			   error: function() {
		            alert("error");
		        }
			 });
		
		
	});
	
});

function testNumericValue (fieldName,divId){
	var numValue = $("input#"+fieldName).val();
	if (numValue !== "" && !$.isNumeric(numValue)) {
		  //Check if phone is numeric
		  document.getElementById(divId).innerHTML="Error: Only Numeric Value";
		  $("input#"+fieldName).focus(); //Focus on field
		  return false;
		}
	else{
		return true;
	}
	}
</script>
</head>
	
<body>
<div class="wrapper">
<div class="main_wrapper" id="main_full_page">
	
<!-- Left Side Bar Coming fix -->
<s:include value="/menubar.jsp"></s:include>
<!-- left sidebar ends -->
		
<div class="content">
	<div class="content_block">
	<!--  top content Fix  -->
			<s:include value="/top.jsp"></s:include>
	<!--  top content ends  -->
			
			<div class="container">
			<div id="data_part">
			<!-- Main Block  Changeable-->
				<s:include value="/mainpage.jsp"></s:include>
				<!-- End Main Block -->	
			</div>
			
			
			<!-- Footer.jsp fixed -->
			<s:include value="/footer.jsp"></s:include>
			
			</div>
			
	</div>
</div>

</div>
</div>
</body>
</html>
