<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX</title>
</head>

<body>
	<form action = "HelloStrutsAction">
		<s:submit value = "HelloStruts"/>
	</form>

	<form action="WelcomeAction">
		<s:submit value="Welcome"/>
	</form>

	<s:form action="InquiryAction">
		<s:submit value="問い合わせ"/>
	</s:form>

	<br>

	GET 通信
		<s:form method="get" action="TestAction">
			<s:textfield name="username"/>
			<s:password name="password"/>
			<s:submit value="送信"/>
		</s:form>

	POST 通信
	<s:form method="post" action="TestAction">
		<s:textfield name="username"/>
		<s:password name="password"/>
		<s:submit value="送信"/>
	</s:form>

</body>

</html>