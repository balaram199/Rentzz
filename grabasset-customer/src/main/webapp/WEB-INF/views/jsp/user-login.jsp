<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>Member Login</title>
</head>
<body>
	<h2>GrabAsset Member Login</h2>
	<p style="color: red;">
		<c:if test="${not empty error}">
				Username or password is not valid
			</c:if>
	</p>
	<form action="${pageContext.request.contextPath}/grabasset-process-login.htm" method="post">
		<table style="margin-left: 40px">
			<tr>
				<td>userName</td>
				<td><input type="text" name="j_username" />
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="j_password" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
		<input type="hidden" name="source" value="mer" />
	</form>
</body>
