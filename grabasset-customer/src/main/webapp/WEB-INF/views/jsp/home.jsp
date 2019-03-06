<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a:link {
	color: green;
	background-color: transparent;
	text-decoration: none;
}

a:visited {
	color: pink;
	background-color: transparent;
	text-decoration: none;
}

a:hover {
	color: red;
	background-color: transparent;
	text-decoration: underline;
}

a:active {
	color: #4000ff;
	background-color: transparent;
	text-decoration: underline;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>


	<div position="absolute" display="inline-block"
		style="margin-left: 1000">
		<a href="${pageContext.request.contextPath}/user-register.htm"
			padding="150px" style="text-decoration: none;">REGISTER</a> || <a
			href="${pageContext.request.contextPath}/User-reg-form.jsp"
			padding="150px" style="text-decoration: none;">lOGIN</a>
	</div>

	<div>
		<h1 align="center">Grab Asset Packages</h1>
		<h1 align="center">
			<a href="html_images.asp" target="_blank">Electronics</a>
		</h1>
		<h1 align="center">
			<a href="html_images.asp" target="_blank">Toys</a>
		</h1>
		<h1 align="center">
			<a href="html_images.asp" target="_blank">Automobiles</a>
		</h1>
		<h1 align="center">
			<a href="html_images.asp" target="_blank">Home Appliances</a>
		</h1>
	</div>
</body>
&nbsp;&nbsp;&nbsp;&nbsp;
</html>