<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Film</title>
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
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</nav>
	<section>
		<form action="themFilm"  method="post">
			<table>
				
				<tr>
					<td> Ten phim: </td>
					<td><input type="text" name="tenphim"></td>
				</tr>
				<tr>
					<td>Mo ta</td>
					<td><input type="text" name="mota"></td>
				</tr>
				<tr>
					<td>Thoi gian phim</td>
					<td><input type="text" name="thoigianphim"></td>
				</tr>
				<tr>
					<td>Url</td>
					<td><input type="text" name="url"></td>
				</tr>
				<tr>
					<td>Ngay khoi chieu</td>
					<td><input type="text" name="ngaykhoichieu"></td>
				</tr>

				<tr>
					<td>Ma the loai</td>
					<td>
						<input type="text" name="matheloai" >
							
									
					
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
					<td>Mã Thể Loại |</td>
					<td>Tên Thể Loại |</td>
					<td>Mô Tả |</td>


				</tr>
					<c:forEach var="tl" items="${dstl}">
						<tr>
						<td>${tl.ma}</td>
						<td>${tl.ten}</td>
						<td>${tl.mota}</td>
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