<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
<head>

</head>
<body>
	<s:form id="formthree" name="formthree" namespace="/view/scheme"
		action="mapGroup" theme="simple" method="post">

		<div class="form_menubox">

			<div class="inputmain">
				<div class="user_form_text">Group Name:</div>
				<div class="user_form_input inputarea">
					<span class="needed"></span>
					<s:select id="groupId" name="groupId" list="groupNameList"
						headerKey="-1" headerValue="--Select Name of Group--"
						cssClass="form_menu_inputselect" onchange="checkGroupMembers(this.value);">
					</s:select>
					<div id="errorgroupId" class="errordiv"></div>
				</div>
			</div>
			
			<div class="inputmain">
				<div class="user_form_text1">Client Name:</div>
				<div class="user_form_input inputarea">
					<span class="needed"></span>
					<s:select id="clientId" name="clientId" list="clientNameList"
						headerKey="-1" headerValue="--Select Name of Client--"
						cssClass="form_menu_inputselect" onchange="getClientGroupableSchemes(this.value);">
					</s:select>
					<div id="errorclientId" class="errordiv"></div>
				</div>
			</div>

		</div>
		
		<div class="form_menubox">
		<div id="ajaxResponseGroupScheme"></div>
		</div>

		<center>
			<img id="indicator3" src="<s:url value="/images/indicator.gif"/>"
				alt="Loading..." style="display: none" />
		</center>
		<div class="fields" id="buttonShowHide">
			<ul>
				<li class="submit" style="background: none;">
					<div class="type-button">
						<sj:submit targets="orglevel1Div3" clearForm="true"
							value="  Configure  " effect="highlight"
							effectOptions="{ color : '#222222'}" effectDuration="5000"
							button="true" onCompleteTopics="level3" cssClass="submit"
							indicator="indicator3" onBeforeTopics="validate3" />
					</div>
			</ul>
			<sj:div id="orglevel13" effect="fold">
				<div id="orglevel1Div3"></div>
			</sj:div>
		</div>
	</s:form>
</body>
</html>