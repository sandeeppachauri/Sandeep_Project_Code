<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
<s:url  id="contextz" value="/template/theme" />
<sj:head locale="en" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contextz}"/>
<script type="text/javascript">
function sendWishes(client,flag)
{
	var mob=client.split(",");
	if(mob[1]!="0")
		{
			$("#fullView").load("<%=request.getContextPath()%>/view/common/beforeSendWishses.action?flag="+flag+"&mobNo="+mob[1]+"&name="+mob[0]);
		    $("#fullView").dialog('open');
		}
	else
		{
		alert("Sorry No Mobile Number Find For Sending Wishes");
		$("#fullView").html("");
		}
	
}
</script>
</head>
<body>
<sj:dialog 
    	id="fullView" 
    	showEffect="slide" 
    	hideEffect="explode" 
    	autoOpen="false" 
    	modal="true" 
    	title="Send Wishses"
    	closeTopics="closeEffectDialog"
    	width="800"
    	height="300"
    >  
</sj:dialog>
<div class="page_title"><h1>Suvidha Area</h1></div>
<div class="container_block" style="width:49%;">
						<div class="main_block">
							<div class="text_heading">
								<span>Upcoming B'days</span>
								</span>
							</div>
							<div class="text">
								<div class="fuller">
									<ul>
										<li class="top">
											<ul>
												<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
												<li class="date">Date</li>
												<li class="subject">Client Name</li>
												<li class="assigned" style="width:37%;">Give Your Wishes</li>
											</ul>
										</li>
										<s:iterator value="bday" status="counter">  
											<s:if test="#counter.count%2 != 0">
												<li>
													<ul>
														<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
														<li class="date"><s:property value="%{value}"/> </li>
														<li class="subject"><s:property value="%{key}"/></li>
														<li class="assigned" style="width:37%;">
														<a href="javascript:void();" style="padding-left:10%;" class="remove_button"  onclick="sendWishes('<s:property value="%{key}"/>','0');">Send Your Wishes</a>
														</li>
													</ul>
												</li>
											</s:if>
											<s:else>
												<li style=" background:#eeeeed;">
													<ul>
														<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
														<li class="date"><s:property value="%{value}"/> </li>
														<li class="subject"><s:property value="%{key}"/></li>
														<li class="assigned" style="width:37%;">
														<a href="javascript:void();" style="padding-left:10%;" class="remove_button"  onclick="sendWishes('<s:property value="%{key}"/>','0');">Send Your Wishes</a>
														</li>
													</ul>
												</li>
											</s:else>
										</s:iterator>
									</ul>
								</div>
							</div>
						</div>
</div>
					<div class="container_block" style="width:49%;">
						<div class="main_block">
							<div class="text_heading">
								<span>Upcoming Anniversary</span>
							</div>
							<div class="text">
								<div class="fuller">
									<ul>
										<li class="top">
											<ul>
												<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
												<li class="date">Date</li>
												<li class="subject">Client Name</li>
												<li class="assigned" style="width:37%;">Give Your Wishes</li>
											</ul>
										</li>
										<s:iterator value="anvrsy" status="counter">  
											<s:if test="#counter.count%2 != 0">
												<li>
													<ul>
														<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
														<li class="date"><s:property value="%{value}"/> </li>
														<li class="subject"><s:property value="%{key}"/></li>
														<li class="assigned" style="width:37%;">
														<a href="javascript:void();" style="padding-left:10%;" class="remove_button"  onclick="sendWishes('<s:property value="%{key}"/>','1');">Send Your Wishes</a>
														</li>
													</ul>
												</li>
											</s:if>
											<s:else>
												<li style=" background:#eeeeed;">
													<ul>
														<li class="check"><div class="checkbox"><input type="checkbox" name="" value="" /></div></li>
														<li class="date"><s:property value="%{value}"/> </li>
														<li class="subject"><s:property value="%{key}"/></li>
														<li class="assigned" style="width:37%;">
														<a href="javascript:void();" style="padding-left:10%;" class="remove_button"  onclick="sendWishes('<s:property value="%{key}"/>','1');">Send Your Wishes</a>
														</li>
													</ul>
												</li>
											</s:else>
										</s:iterator>
									</ul>
								</div>
							</div>
						</div>
					</div>
<br><br>
<center>
<img src="images/leftlogo.png" style="padding-top: 10%"/>
</center>
</body>
</html>