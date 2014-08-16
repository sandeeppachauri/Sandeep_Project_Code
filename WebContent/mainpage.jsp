<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<script type="text/javascript">

function loadBdyAndAndy()
{
	$.ajax({
	    type : "post",
	    url : "<%=request.getContextPath()%>/view/common/bdayAny.action",
	    success : function(subdeptdata) {
       $("#"+"mainHome").html(subdeptdata);
	},
	   error: function() {
            alert("error");
        }
	 });
}
loadBdyAndAndy();
</script>
</head>
</html>
<div id="mainHome">
</div>