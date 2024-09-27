<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<form action="Update" method="Post">
	Email:<input type="text" name="email" value="<%=request.getAttribute("email")%>"readonly><br>
	phone:<input type="number" name="phone" value="<%=request.getAttribute("phone") %>" /><br> 
		<input type="submit" name="update" />
	</form>
</body>
</html>