<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<table border="1" width="70%">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Designation</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.salary}</td>
					<td>${emp.designation}</td>
					<td><a href="editemp/${emp.id }">Edit</a></td>
					<td><a href="deleteemp/${emp.id }">Delete</a></td>
				</tr>
			
			</c:forEach>
		</table>
</body>
</html>