
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tim kiem Phim theo Ngay</title>
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
.loi{
	color: red;
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
		<form action="timFilm"  method="post">
			<table>
							
				<tr>
					<td>Ngay :</td>
					<td><input type="text" name="ngay" id="ngay" placeholder="dd/MM/yyyy"></td>
					
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="submit" value="Tim">
						</td>
				</tr>
			</table>
			
		</form>
		
			
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
				<c:forEach var="phim" items="${dstl}">
					<tr>
							<td>${phim.maphim}</td>
							<td>${phim.tenphim}</td>
							<td>${phim.mota }</td>
							<td>${phim.thoiluong }</td>
							<td><img alt="" src="${phim.url }" height="250px" width="150px"></td>
							<td>${phim.ngaykhoichieu }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
	</section>
	<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>