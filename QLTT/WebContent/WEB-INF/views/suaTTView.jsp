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
		<form action="suaTinTuc"  method="post">
			
			<h4 na>Chỉnh sửa thông tin tintuc: <c:out
							value="${tt.matt}" ></c:out></h4>
			<table>
				<tr>
					<td>Ma  TT:</td>
					<td><input type="text" name="matt"  value="${tt.matt}" readonly></td>
					
				</tr>
				<tr>
					<td>Tiêu Đề:</td>
					<td><input type="text" name="tieude"  value="${tt.tieude}"></td>
					
				</tr>
				<tr>
					<td>Nội Dung TT:</td>
					<td><input type="text" name="noidung"  value="${tt.noidung}"></td>
					
				</tr>
				<tr>
					<td>Liên Kết:</td>
					<td><input type="text" name="lienket" id="lienket"  value="${tt.lienket}"></td>
					
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" name="submit" value="Sua">
						<input type="reset" name="reset" value="Reset"></td>
				</tr>
			</table>
			
		</form>
		
	</section>
	<footer>
	<jsp:include page="_footer.jsp"></jsp:include>
	</footer>
</body>
</html>