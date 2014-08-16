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
$(document).ready(function(){
	
	$("#menu_tab1").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/clientlogin/beforeMyInfo.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#menu_tab2").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/clientlogin/beforeMySchemes.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#menu_tab3").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/clientlogin/beforeMyContactUs.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
	
	$("#menu_tab4").click(function(){
		$("#mainHome").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/clientlogin/beforePayUs.action",
		    success : function(subdeptdata) {
	       $("#"+"mainHome").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		
	});
});
</script>
</head>
	
<body>
<div class="wrapper">
<div class="main_wrapper" id="main_full_page">
	
<!-- Left Side Bar Coming fix -->
<s:include value="/view/clientLogin/menubarClient.jsp"></s:include>
<!-- left sidebar ends -->
		
<div class="content">
	<div class="content_block">
	<!--  top content Fix  -->
			<s:include value="/view/clientLogin/topClient.jsp"></s:include>
	<!--  top content ends  -->
			
			<div class="container">
			<div id="data_part">
			<!-- Main Block  Changeable-->
				<s:include value="/view/clientLogin/mainpageClient.jsp"></s:include>
				<!-- End Main Block -->	
			</div>
			</div>
			
	</div>
</div>

</div>
</div>
</body>
</html>
