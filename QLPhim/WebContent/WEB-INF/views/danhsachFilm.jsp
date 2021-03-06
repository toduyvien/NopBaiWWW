<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách  Film</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
body {
	width: 100%;
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
	height: auto;
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
	<jsp:include page="header.jsp"></jsp:include>
	</header>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>
	<section>
		<c:forEach var="tl" items="${dstl }">
			<li>Tên DM: ${tl.ten }</li>
			<div class="w3-container">
				<table class="w3-table w3-striped">
					<tr>
						<td>MaPhim </td>
						<td>TenPhim </td>
						<td>Mota </td>
						<td>Thoi Gian Phim</td>
						<td>URL</td>
						<td>ngay khoi chieu</td>
					</tr>
					<c:forEach var="phim" items="${tl.dsFilm }">
					<tr>
							<td>${phim.maphim}</td>
							<td>${phim.tenphim}</td>
							<td>${phim.mota }</td>
							<td>${phim.thoiluong }</td>
							<td><img alt="" src="${phim.url }" height="250px" width="150px"></td>
							<td>${phim.ngaykhoichieu }</td>
							
								<td><a href="xoaFilm?id=<c:out value="${phim.maphim}"></c:out>">
											<button
													class="pull-left">Xoa</button>		
											</a>
							<a href="suaPhim?id1=<c:out value="${phim.maphim}"></c:out>">
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
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>