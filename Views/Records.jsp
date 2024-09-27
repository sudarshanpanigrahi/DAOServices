<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>All Records</h2>
<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
	<% ResultSet res = (ResultSet)request.getAttribute("result");
	while(res.next()){%>
	<tr>
		<td><%=res.getString(1) %></td>	
		<td><%=res.getString(2) %></td>	
		<td><%=res.getString(3) %></td>	
		<td><a href="DeleteReg?email=<%=res.getString(2) %>">delete </a></td>	
		<td><a href="Update?email=<%=res.getString(2) %>&phone=<%=res.getString(3) %>">Update </a></td>	
<%} %>
	</tr>
</table>
</body>
</html>