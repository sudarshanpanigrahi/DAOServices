<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Registration</title>
</head>
<body>
	<h2>Enter your Data</h2>
	<form action="Create_Reg" method="post">

		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Mobile No:</td>
				<td><input type="number" name="phone"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="Add Data"></td>
			</tr>
		</table>
	</form>
	<%
	if(request.getAttribute("msg")!=null){
		out.print(request.getAttribute("msg"));
	}
	%>
</body>
</html>