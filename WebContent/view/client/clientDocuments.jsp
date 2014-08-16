<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
<body>
<ul>
<s:iterator value="searchData">
            <li>            
                <h4><a href="<%=request.getContextPath()%>/view/client/download.action?path=<s:property value="key"/>"><s:property value="value"/></a></h4>
            </li>
</s:iterator>
</ul>     
</body>
</html>
