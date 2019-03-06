<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.error {
	color: red;
}
</style>
<div
	style="background-color: #7FFFD4; width: 600px; margin-left: 700px; border-style: double; margin-top: 70px">
	<div
		style="background-color: #5F9EA0; height: 40; text-align: center; font-size: 30px; text-shadow: gray;">User
		Registration Form</div>
	&nbsp;
	<form:form method="POST" commandName="userRegistration">
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

				<td><form:checkbox path="termsAndConditions"
						label="terms and conditions" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form:form>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;

