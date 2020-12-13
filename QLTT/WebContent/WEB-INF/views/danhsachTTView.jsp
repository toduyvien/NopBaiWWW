<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Tin Tức</title>
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
		<c:forEach var="dm" items="${dsdm }">
			<li>Tên DM: ${dm.tendanhmuc }</li>
			<div class="w3-container">
				<table class="w3-table w3-striped">
					<tr>
						<th>Mã TT</th>
						<th>Tiêu Đề</th>
						<th>Nội Dung Tin Tức</th>
						<th>Liên Kết</th>
						<th>Xóa </th>
					</tr>
					<c:forEach var="tt" items="${dm.dsTinTuc }">
					<tr>
						<td>${tt.matt}</td>
						<td>${tt.tieude}</td>
						<td>${tt.noidung}</td>
						<td>${tt.lienket}</td>
						<td><a href="xoaTinTuc?id=<c:out value="${tt.matt}"></c:out>">
											<button
													class="pull-left">Xoa</button>		
											</a>
							<a href="suaTinTuc?id1=<c:out value="${tt.matt}"></c:out>">
											<button
													class="pull-left">Sua</button>		
											</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</section>
	<footer>
	<jsp:include page="_footer.jsp"></jsp:include>
	</footer>
</body>
</html>