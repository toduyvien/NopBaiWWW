<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TimKiem</title>
</head>
<body>
	<form action="timkiemsv"  method="post">
	
	<input type="text" name="batdau"><br>
	<input type="text" name="ketthuc"><br>
	
	<input type="submit" value="submit"><br>
	</form>
	
	<table class="w3-table w3-striped">
					<tr>
						<th>Mã SV</th>
						<th>Ten SV</th>
						<th>Gioi Tinh</th>
						<th>Ngay Sinh</th>
						
					</tr>
					<c:forEach var="sv" items="${dssv}">
					<tr>
						<td>${sv.masv}</td>
						<td>${sv.tensv}</td>
						<td>${sv.gioitinh}</td>
						<td>${sv.ngaysinh}</td>
						
					</tr>
					</c:forEach>
				</table>
</body>
</html>