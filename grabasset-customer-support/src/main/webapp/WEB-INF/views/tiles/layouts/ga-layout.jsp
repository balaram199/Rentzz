<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/common/js/bootstrap.min.js' />"
	rel="stylesheet"></link>
<link href="<c:url value='/common/js/bootstrp/bootstrap.js' />"
	rel="stylesheet"></link>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col" align="center">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="col">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<div class="row">
		<div class="col" align="center">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
</html>