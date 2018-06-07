<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h1>
		<center style="color: red">Result Page</center>
	</h1>
	<h4 style="color: red">Top 5 Student Results</h4>
	<table border="1">
		<tr bgcolor="cyan">
			<th>Name</th>
			<th>Age</th>
			<th>Marks</th>
			<th>City</th>
		</tr>
		<c:forEach var="st" items="${student}">
			<tr>
				<td><c:out value="${st.name}"></c:out></td>
				<td><c:out value="${st.age}"></c:out></td>
				<td><c:out value="${st.marks}"></c:out></td>
				<td><c:out value="${st.city}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<a href="home.htm">Home</a>
</body>
</html>