<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.error {
	color: red;
}
</style>
<div
	style="background-color: #B0C4DE; width: 600px; margin-left: 500px; border-style: double; margin-top: 70px">
	<div
		style="background-color: #5F9EA0; height: 40; text-align: center; font-size: 30px; text-shadow: gray;">User
		Registration Form</div>
	&nbsp;
	<form:form method="POST" commandName="csrRegistration">
		<table style="margin-left: 40px">
			<tr>
				<td>FirstName</td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>MobileNo</td>
				<td><form:input path="mobileNo" /> <form:errors
						path="mobileNo" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Email Address</td>
				<td><form:input path="userName" /> <form:errors
						path="userName" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Password</td>
				<td><form:password path="password" /> <form:errors
						path="password" cssClass="error" /></td>

			</tr>
			<tr>
				<td>Re Enter password</td>
				<td><form:password path="reEnterPassword" /> <form:errors
						path="reEnterPassword" cssClass="error" /></td>

			</tr>

			<tr>
				<td>identificationType</td>
				<td><form:select path="identificationType">
						<form:option value="select">select</form:option>
						<form:option value="adhar">adhar</form:option>
						<form:option value="voterid">voterId</form:option>
					</form:select> <form:errors path="identificationType" cssClass="error" /></td>
			</tr>

			<tr>
				<td>IdentificationNo</td>
				<td><form:input path="identificationNo" /> <form:errors
						path="identificationNo" cssClass="error" /></td>
			</tr>

			<tr>
				<td>plotNo</td>
				<td><form:password path="plotNo" /> <form:errors path="plotNo"
						cssClass="error" /></td>

			</tr>


			<tr>
				<td>street</td>
				<td><form:password path="street" /> <form:errors path="street"
						cssClass="error" /></td>

			</tr>

			<tr>
				<td>city</td>
				<td><form:select path="city">
						<form:option value="0">select</form:option>
						<c:forEach items="${cities}" var="city">
							<form:option value="${city.cityId }">${city.city }</form:option>
						</c:forEach>
					</form:select> <form:errors path="city" cssClass="error" /></td>

			</tr>

			<tr>
				<td>state</td>
				<td><form:select path="state">
						<form:option value="0">select</form:option>
						<c:forEach items="${states}" var="state">
							<form:option value="${state.stateId }">${state.state }</form:option>
						</c:forEach>
					</form:select> <form:errors path="state" cssClass="error" /></td>

			</tr>
			<tr>
				<td>zip</td>
				<td><form:password path="zip" /> <form:errors path="zip"
						cssClass="error" /></td>

			</tr>

			<tr>
				<td>Country</td>
				<td><form:select path="country">
						<form:option value="0">select</form:option>
						<c:forEach items="${countries }" var="country">
							<form:option value="${country.countryId }">${country.country }</form:option>
						</c:forEach>
					</form:select> <form:errors path="country" cssClass="error" /></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form:form>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;