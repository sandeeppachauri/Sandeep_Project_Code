<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>::: Suvidha :::</title>
  <link rel="stylesheet" href="cssNew/style.css">
</head>
<body>
 <s:form id="formone" name="formone" action="loginCtr" theme="simple"  method="post" cssClass="login">
    <p>
      <label for="login">Login ID:</label>
      <s:textfield name="login" id="login" value="Your Login Id"/>
    </p>

    <p>
      <label for="password">Password:</label>
      <s:password name="password" id="password" value="4815162342"></s:password>
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>

	<p class="forgot-password">Client Login will be by it's card number.</p>
    <p class="forgot-password"><a href="forgetPassword.jsp">Forgot your password?</a></p>
  </s:form>
</body>
</html>
