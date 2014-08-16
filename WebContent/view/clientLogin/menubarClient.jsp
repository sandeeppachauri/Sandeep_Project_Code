<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page pageEncoding="UTF-8" %>
<%
String userType=(String)session.getValue("userType");
%>
<html>
<body>
<div class="sidebar">
			<div class="sidebar_block">
				<div class="logo"><a href="javascript:void();">
					<!-- <img src="images/logo1.jpg" width="184" height="60" title="XSGX Creators" /></a> -->
				</div>
				<div class="page_text">Client Dashboard</div>
				<div class="main_menu">
					<div class="main_menu_sub_block">
						<div class="member_image"><a href="javascript:void();" title="Change image"><img height="60" width="60" title="" alt="" src="images/member.jpg"></a></div>
						<div class="member_details">
							<h1><a href="javascript:void();" title="Manage profile"><s:property value="#session['userName']" /></a></h1>
							<p><s:property value="#session['loginTime']" />
							</p>
						</div>
					</div>
					<div class="main_menu_sub_block">
						<div class="left_side_menu" id="left_side_menu">
							<ul>
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','1','9');" id="menu_tab1" class="this_active people"><b>My Information</b></a>
								</li>
								
								<li><a href="javascript:void();"  onclick="show_sub_menu('menu_tab','sub_menu','2','9');" id="menu_tab2" class="this_active feeds"><b>My Schemes</b></a>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','6','9');" id="menu_tab3" class="this_active messages"><b>Reach Us</b></a>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','8','9');" id="menu_tab4" class="this_active vaults"><b>Online Payment</b></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
