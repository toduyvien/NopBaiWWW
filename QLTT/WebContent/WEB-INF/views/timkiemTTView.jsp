<%@page import ="vn.edu.iuh.Model.TinTuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tim kiem Tin Tức</title>
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
.loi{
	color: red;
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
		<form action="timTinTucDM"  method="post">
			<table>
							
				<tr>
					<td>Mã DM:</td>
					<td><input type="text" name="ma" id="ma"></td>
					
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
						<th>Mã TT</th>
						<th>Tiêu Đề</th>
						<th>Nội Dung Tin Tức</th>
						<th>Liên Kết</th>
					</tr>
					<c:forEach var="tt" items="${list }">
					<tr>
						<td>${tt.matt}</td>
						<td>${tt.tieude}</td>
						<td>${tt.noidung}</td>
						<td>${tt.lienket}</td>
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