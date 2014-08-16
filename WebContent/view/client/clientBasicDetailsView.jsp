<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
</head>
<body>

<div class="associate_sub_block">

				<div class="form_menubox">
					<div class="associate_block">
						<div class="user_form_text associate_heading" style="margin:0px;">Client Name:</div>
						<div class="user_form_text associate_text" style="margin:0px;"><s:property value="%{clientName}"/></div>
					</div>
					<div class="associate_block">
						<div class="user_form_text1 associate_heading" style="margin:0px;">Client Mob:</div>
						<div class="user_form_text1 associate_text" style="margin:0px;"><s:property value="%{clientMob}"/></div>
					</div>
				</div>
				
				<div class="form_menubox">
					<div class="associate_block">
						<div class="user_form_text associate_heading" style="margin:0px;">Client Phone No:</div>
						<div class="user_form_text associate_text" style="margin:0px;"><s:property value="%{clientPhoneno}"/></div>
					</div>
					<div class="associate_block">
						<div class="user_form_text1 associate_heading" style="margin:0px;">Client Email Id:</div>
						<div class="user_form_text1 associate_text" style="margin:0px;"><s:property value="%{clientEmailId}"/></div>
					</div>
				</div>
				
				<div class="form_menubox">	
					<div class="associate_block">
						<div class="user_form_text associate_heading" style="margin:0px;">Client Address:</div>
						<div class="user_form_text associate_text" style="margin:0px;"><s:property value="%{clientAddress}"/></div>
					</div>
					<div class="associate_block">
						<div class="user_form_text1 associate_heading" style="margin:0px;">Client D.O.J:</div>
						<div class="user_form_text1 associate_text" style="margin:0px;"><s:property value="%{doj_date}"/></div>
					</div>
				</div>
				
				<div class="form_menubox">	
					<div class="associate_block">
						<div class="user_form_text associate_heading" style="margin:0px;">Client D.O.B:</div>
						<div class="user_form_text associate_text" style="margin:0px;"><s:property value="%{dob_date}"/></div>
					</div>
					<div class="associate_block">
						<div class="user_form_text1 associate_heading" style="margin:0px;">Client D.O.A:</div>
						<div class="user_form_text1 associate_text" style="margin:0px;"><s:property value="%{doa_date}"/></div>
					</div>
				</div>
</div>
</body>
</html>