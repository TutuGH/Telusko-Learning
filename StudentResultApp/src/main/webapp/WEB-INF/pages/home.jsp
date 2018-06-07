<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>
		<center style="color: red">Home Page</center>
	</h1>
	<form:form method="POST" commandName="studentCommand">
		<table>
			<tr>
				<td>City :</td>
				<td><form:input path="city" /> <form:errors path="city"></form:errors>
			</tr>
			<tr>
				<td>Lower Age :</td>
				<td><form:input path="lowerAge" /> <form:errors
						path="lowerAge"></form:errors>
			</tr>
			<tr>
				<td>Upper Age</td>
				<td><form:input path="upperAge" /> <form:errors
						path="upperAge"></form:errors>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>