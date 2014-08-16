<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
       .sortable {
                   height:15px;
                   margin:5px;
                   padding:10px;
                   text-align: left;
                 }
</style>
<script type="text/javascript">
$.subscribe('complete_close',function(event,data)
		{
	      $("#downloadDSR").dialog('close');
        });
</script>
</head>


<body topmargin="0" leftmargin="0">
<!--<s:property  value="%{#parameters.downloadType}"/>-->

<s:bean name="com.suvidha.common.CommonPropertyMap" var="propertyMap">
<s:param name="key">dailySales</s:param>
</s:bean>

<s:form id="download" action="downloadReport"  theme="css_xhtml" namespace="/view/common" method="post">
<s:hidden name="downloadType" value="%{#parameters.downloadType}"/>
<s:hidden name="mapName" value="%{#parameters.mapName}"/>
<sj:div 
          id="sortable" 
          sortable="true" 
          sortableOpacity="0.8" 
          sortablePlaceholder="ui-state-highlight" 
          sortableForcePlaceholderSize="true" 
          cssStyle="width: 300px;">
 
          <s:iterator value="#propertyMap.valueMap" status="rowstatus">
          <div id="#rowstatus.index"  class="sortable ui-widget-content ui-corner-all">
               <s:checkbox  labelposition="right" label="%{value}" name="titles"  fieldValue="%{key}"/>
          </div>
          </s:iterator>
</sj:div>
</s:form>
<center>           
<sj:a 
          buttonIcon="ui-icon-check"
          button="true"
          formIds="download"
          >Ok
</sj:a>
             
      
<sj:a 
          buttonIcon="ui-icon-close"
          button="true"
          onClickTopics="complete_close"
          >Close
</sj:a>
</center>
</body>
</html>
