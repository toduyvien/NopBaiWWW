<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/save" method="post">
		<table border="2">
			<tr>
				<td>Name : </td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Salary : </td>
				<td><form:input path="salary"/></td>
			</tr>
			<tr>
				<td>Designation : </td>
				<td><form:input path="designation"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="save">
			</tr>
		</table>
	
	</form:form>
</body>
</html>