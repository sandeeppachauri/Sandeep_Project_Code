<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script type="text/javascript">
function fillData()
{
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
}
</script>
</head>
</html>
<div class="content_block_top">
					<div class="heading"><h1>Luthra Jewellers</h1></div>

					<div class="profile">
						<div class="profile_pic"><a href="javascript:void();" onmouseout="var change_pic = document.getElementById('mychange_pic'); change_pic.style.display='none';" onmouseover="var change_pic = document.getElementById('mychange_pic'); change_pic.style.display='block';">
							<img src="images/member.jpg" width="51" height="65" alt="" title="" /></a>
							<div class="change_pic" id="mychange_pic"><a href="javascript:void();">Update</a></div>
						</div>							
						<div class="profile_desc">
							<div class="date"><s:property value="#session['loginTime']" /></div>
							<div class="profile_details">
								<ul>
									<li><a href="javascript:void();" class="profile_name"><s:property value="#session['userName']" /></a>
										<ul class="sub_menu">
											<li><a href="javascript:void(0);" onclick="fillData();">My Profile</a></li>
											<li><a href="<s:url action="logout"/>" target="_top">Logout</a></li>
										</ul>
									</li>
								</ul>
							</div>
						</div>					
					</div>

				</div>
