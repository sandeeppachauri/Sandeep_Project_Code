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
					<img src="images/logo1.jpg" width="184" height="60" title="XSGX Creators" /></a>
				</div>
				<div class="page_text">Your dashboard</div>
				<div class="main_menu">
					<div class="main_menu_sub_block">
						<div class="member_image"><a href="javascript:void();" title="Change image"><img height="60" width="60" title="" alt="" src="images/member.jpg"></a></div>
						<div class="member_details">
							<h1><a href="javascript:void();" title="Manage profile"><s:property value="#session['userName']" /></a></h1>
							<p><s:property value="#session['loginTime']" />,&nbsp;&nbsp;<b><a href="<s:url action="logout"/>" target="_top" title="Log out">Logout</a></b></p>
						</div>
					</div>
					<div class="main_menu_sub_block">
						<div class="left_side_menu" id="left_side_menu">
							<ul>
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','1','9');" id="menu_tab1" class="this_active people"><b>Client</b></a>
									<ul style=" display:none;" id="sub_menu1">
												<li><a href="javascript:void();" id="clientAdd" ><b>Add</b></a>
												<li><a href="javascript:void();" id="clientEdit"><b>Edit</b></a>
												<li><a href="javascript:void();" id="clientsrndr"><b>Surrender scheme</b></a>
												<li><a href="javascript:void();" id="reopenScheme"><b>Re-open scheme</b></a>
												<li><a href="javascript:void();" id="closeScheme"><b>Close scheme</b></a>
												<li><a href="javascript:void();" id="luckyDrawScheme"><b>Luck Draw scheme</b></a>
												<li><a href="javascript:void();" id="clientReport"><b>Client Report</b></a>
									</ul>
								</li>
								
								<li><a href="javascript:void();"  onclick="show_sub_menu('menu_tab','sub_menu','2','9');" id="menu_tab2" class="this_active feeds"><b>Area</b></a>
									<ul style=" display:none;" id="sub_menu2">
										
										<li><a href="javascript:void();" id="araeAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="arededit"><b>Edit</b></a>
										
									</ul>
								</li>
								
								<li><a href="javascript:void();"  onclick="show_sub_menu('menu_tab','sub_menu','9','9');" id="menu_tab9" class="this_active feeds"><b>Mail Configuration</b></a>
									<ul style=" display:none;" id="sub_menu9">
										<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="smtpAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="smtpEdit"><b>Edit</b></a>
										<%} %>
									</ul>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','6','9');" id="menu_tab6" class="this_active messages"><b>Source</b></a>
									<ul style=" display:none;" id="sub_menu6">
										<li><a href="javascript:void();" id="sourceAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="sourceEdit"><b>Edit</b></a></li>
									</ul>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','8','9');" id="menu_tab8" class="this_active messages"><b>Collection Manager</b></a>
									<ul style=" display:none;" id="sub_menu8">
										<li><a href="javascript:void();" id="uploadCollection"><b>Upload Collection</b></a></li>
										<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="collectionReport"><b>Collection Report</b></a></li>
										<li><a href="javascript:void();" id="collectionSummerizeReport"><b>Collection Summarize Report</b></a></li>
										<li><a href="javascript:void();" id="collectionClientReport"><b>Collection Client Report</b></a></li>
										<li><a href="javascript:void();" id="groupReport"><b>Group Members Report</b></a></li>
										<li><a href="javascript:void();" id="clientSchemeStatusReport"><b>Client Scheme Status Report</b></a></li>
										<li><a href="javascript:void();" id="paymentPandingStatusReport"><b>Payment Pending Status Report</b></a></li>
										<%} %>
									</ul>
								</li>
								
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','3','9');" id="menu_tab3" class="this_active vaults"><b>Scheme</b></a>
									<ul style=" display:none;" id="sub_menu3">
										<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="schemeAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="schemeEdit"><b>Edit</b></a></li>
										<li><a href="javascript:void();" id="mapWithGroup"><b>Map With Group</b></a></li>
										<li><a href="javascript:void();" id="viewGroup"><b>View Group</b></a></li>
										<%} %>
									</ul>
								</li>
								<li><a href="javascript:void();"  onclick="show_sub_menu('menu_tab','sub_menu','4','9');" id="menu_tab4" class="this_active groups"><b>Employee</b></a>
									<ul style=" display:none;" id="sub_menu4">
										<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="employeeAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="employeeEdit"><b>Edit</b></a></li>
										<li><a href="javascript:void();" id="employeeMapArea"><b>Map with area</b></a></li>
										<%} %>
										<li><a href="javascript:void();" id="kittyManager"><b>Kitty Manager</b></a></li>
										<li><a href="javascript:void();" id="viewKittyManager"><b>View Kitty Report</b></a></li>
									</ul>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','5','9');" id="menu_tab5" class="this_active groups"><b>User</b></a>
									<ul style=" display:none;" id="sub_menu5">
										<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="userAdd"><b>Add</b></a></li>
										<li><a href="javascript:void();" id="userEdit"><b>Edit</b></a></li>
										<%} %>
									</ul>
								</li>
								
								<li><a href="javascript:void();" onclick="show_sub_menu('menu_tab','sub_menu','7','9');" id="menu_tab7" class="this_active admin"><b>Admin</b></a>
									<ul style=" display:none;" id="sub_menu7">
											<%
										if(userType.equalsIgnoreCase("1"))
										{
										%>
										<li><a href="javascript:void();" id="dailyGoldPrice"><b>Daily Gold Price Edit</b></a></li>
										<li><a href="javascript:void();" id="dailyGoldPriceView"><b>Daily Gold Price View</b></a></li>
										<li><a href="javascript:void();" id="pwdReset"><b>Password Reset</b></a></li>
										<li><a href="javascript:void();" id="backup"><b>Take Backup</b></a></li>
										<%} %>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
