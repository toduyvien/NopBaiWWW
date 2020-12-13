<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Tin Tức</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
body {
	width: 80%;
	border: 1px solid black;	
}
header{ 
	width: 100%;
	height: auto;
	border-bottom: 1px solid black;
	text-align: center;
}
nav{ 
	width: 100%;
	height: auto;
	border-bottom: 1px solid black;
	text-align: center;
}
section{ 
	width: 100%;
	height: 500px;
	border-bottom: 1px solid black;
	text-align: left;
}
footer{ 
	width: 100%;
	height: auto;
	border-bottom: 1px solid black;
	text-align: center;
}
a{
	color: black;
}

</style>
</head>
<body>
	<header>
		<jsp:include page="_header.jsp"></jsp:include>
	</header>
	<nav>
		<jsp:include page="_menu.jsp"></jsp:include>
	</nav>
	<section>
		<form action="themTinTuc"  method="post">
			<table>
				
				<tr>
					<td>Tiêu Đề:</td>
					<td><input type="text" name="tieude" id="tieude"></td>
					
				</tr>
				<tr>
					<td>Nội Dung TT:</td>
					<td><input type="text" name="noidung" id="noidung"></td>
					
				</tr>
				<tr>
					<td>Liên Kết:</td>
					<td><input type="text" name="lienket" id="lienket"></td>
					
				</tr>
				<tr>
					<td>Mã DM:</td>
					<td>
					<select name="item">
					<c:forEach items="${dsdm}" var="id">
    					<option value="${id.madm}">${id.madm}</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="submit" value="Thêm">
						<input type="reset" name="reset" value="Reset"></td>
				</tr>
			</table>
			
		</form>
		<div class="w3-container">
				<table class="w3-table w3-striped">
					<tr>
						<th>Mã DM</th>
						<th>Tên DM</th>
						<th>Người Quản Lý</th>
						<th>Ghi Chú</th>
					</tr>
					<c:forEach var="dm" items="${dsdm}">
						<tr>
							<td>${dm.madm}</td>
							<td>${dm.tendanhmuc}</td>
							<td>${dm.nguoiquanly}</td>
							<td>${dm.ghichu}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	</section>
	<footer>
	<jsp:include page="_footer.jsp"></jsp:include>
	</footer>
</body>
</html>