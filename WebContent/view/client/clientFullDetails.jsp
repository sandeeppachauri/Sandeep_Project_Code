<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<script type="text/javascript">
function toggle_visibility(id1,id2) {
	if(document.getElementById(id1).style.display == 'block'){
		var sub1			=	document.getElementById(id1);
		var sub2			=	document.getElementById(id2);
		sub2.className		=	"inactive";
		sub1.style.display	=	"none";
	}else{
		var sub1			=	document.getElementById(id1);
		var sub2			=	document.getElementById(id2);
		sub2.className		=	"active";
		sub1.style.display	=	"block";
	}
}

var a=0,b=0,c=0,d=0,e=0,f=0,g=0;
function getClientBasicDetails(clientId)
{
	if(a==0)
		{
		$("#content1").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		a=1;
			$.ajax({
			    type : "post",
			    url : "<%=request.getContextPath()%>/view/client/clientBasicDetailsView.action?id="+clientId,
			    success : function(subdeptdata) {
		       $("#"+"content1").html(subdeptdata);
			},
			   error: function() {
		            alert("error");
		        }
			 });
		}
	
}
function getClientSchemeSummerizeDetails(clientId)
{
	if(b==0)
		{
		b=1;
		$("#content2").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
			$.ajax({
			    type : "post",
			    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeSummirizeReport.action?id="+clientId,
			    success : function(subdeptdata) {
		       $("#"+"content2").html(subdeptdata);
			},
			   error: function() {
		            alert("error");
		        }
			 });
		}
	
}
function getClientSchemeWiseDetails(clientId)
{
	if(c==0)
		{
		c=1;
		$("#content3").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeWiseReport.action?id="+clientId+"&moduleFalg=3",
		    success : function(subdeptdata) {
	       $("#"+"content3").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		}
	
}
function getClientActiveSchemeDetails(clientId)
{
	if(d==0)
		{
		d=1;
		$("#content4").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeWiseReport.action?id="+clientId+"&moduleFalg=0",
		    success : function(subdeptdata) {
	       $("#"+"content4").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		}
	
}
function getClientCompletedSchemeDetails(clientId)
{
	if(e==0)
		{
		e=1;
		$("#content5").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeWiseReport.action?id="+clientId+"&moduleFalg=1",
		    success : function(subdeptdata) {
	       $("#"+"content5").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		}
	
}
function getClientSurrenderSchemeDetails(clientId)
{
	if(f==0)
		{
		f=1;
		$("#content6").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
		$.ajax({
		    type : "post",
		    url : "<%=request.getContextPath()%>/view/client/beforeclientSchemeWiseReport.action?id="+clientId+"&moduleFalg=2",
		    success : function(subdeptdata) {
	       $("#"+"content6").html(subdeptdata);
		},
		   error: function() {
	            alert("error");
	        }
		 });
		}
	
}
function getClientUploadedDocuments(clientId)
{
	if(g==0)
	{
	g=1;
	$("#content7").html("<br><br><center><img src=images/ajax-loaderNew.gif></center>");
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/client/clientDocuments.action?id="+clientId,
	    success : function(subdeptdata) {
       $("#"+"content7").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
	}
}
</script>
</head>
<body>

<div class="wrapper">
	<div class="sub_wrapper">
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab1" class="inactive" onclick="javascript:toggle_visibility('content1','tab1');getClientBasicDetails('<s:property value="%{id}"/>');"><b>Client Information</b></a></div>
		<div class="content_main" id="content1" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab7" class="inactive" onclick="javascript:toggle_visibility('content7','tab7');getClientUploadedDocuments('<s:property value="%{id}"/>');""><b>Client Uploaded Documents</b></a></div>
		<div class="content_main" id="content7" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		
		
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab2" class="inactive" onclick="javascript:toggle_visibility('content2','tab2');getClientSchemeSummerizeDetails('<s:property value="%{id}"/>');"><b>Client Scheme Summarize Report</b></a></div>
		<div class="content_main" id="content2" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab3" class="inactive" onclick="javascript:toggle_visibility('content3','tab3');getClientSchemeWiseDetails('<s:property value="%{id}"/>');"><b>Client Scheme Wise Detail Report</b></a></div>
		<div class="content_main" id="content3" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab4" class="inactive" onclick="javascript:toggle_visibility('content4','tab4');getClientActiveSchemeDetails('<s:property value="%{id}"/>');""><b>Client Active Schemes Detail Report</b></a></div>
		<div class="content_main" id="content4" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab5" class="inactive" onclick="javascript:toggle_visibility('content5','tab5');getClientCompletedSchemeDetails('<s:property value="%{id}"/>');""><b>Client Completed Scheme Detail Report</b></a></div>
		<div class="content_main" id="content5" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		
		<div class="block_main repeating_block_head"><a href="javascript:void();" id="tab6" class="inactive" onclick="javascript:toggle_visibility('content6','tab6');getClientSurrenderSchemeDetails('<s:property value="%{id}"/>');""><b>Client Surrendered Scheme Detail Report</b></a></div>
		<div class="content_main" id="content6" style="border-top:3px solid #aaa9ab; min-width:98%; overflow-x:scroll;">
			
		</div>
		
	</div>
</div>
</body>
</html>