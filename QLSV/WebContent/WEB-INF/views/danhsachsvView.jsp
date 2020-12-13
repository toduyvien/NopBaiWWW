<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>QLSV</title>
</head>
<body>
	<header>
	<jsp:include page="_header.jsp"></jsp:include>
	</header>
	<nav>
		<jsp:include page="_menu.jsp"></jsp:include>
	</nav>
	<section>
		<c:forEach var="lop" items="${dslop }">
			<li>Tên Lop: ${lop.tenlop}</li>
			<div class="w3-container">
				<table class="w3-table w3-striped">
					<tr>
						<th>Mã SV</th>
						<th>Ten SV</th>
						<th>Gioi Tinh</th>
						<th>Ngay Sinh</th>
						
					</tr>
					<c:forEach var="sv" items="${lop.dsSinhVien }">
					<tr>
						<td>${sv.masv}</td>
						<td>${sv.tensv}</td>
						<td>${sv.gioitinh}</td>
						<td>${sv.ngaysinh}</td>
						
					</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</section>
	<footer>
	<jsp:include page="_footer.jsp" ></jsp:include>
	</footer>
</body>
</html>