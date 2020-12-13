<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them SV</title>
</head>
<body>
	<form action="themsv " method="post">
	
		<input type="text" placeholder="Nhap ten :  " name="tensv"><br>
		<input type="radio"  name="gioitinh" value="Nam"> Nam<br>
		<input type="radio"  name="gioitinh" value="Nu"> Nu<br>
		<input type="text" placeholder="Nhap ngay sinh :  " name="ngaysinh"><br>
		<select name="lop">
			<c:forEach items="${dslop}" var="id">
    					<option value="${id.malop}">${id.malop}</option>
					</c:forEach>
		</select>
		
		<input type="submit" value="submit">
	
	</form>
</body>
</html>