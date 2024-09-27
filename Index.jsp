<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login here....</h2>
	<pre style=color:red;>
	<%if(request.getAttribute("error")!=null){
		out.print(request.getAttribute("error"));
	}	%>
	</pre>
	<form action="login" method="post">
		Email : <input type="email" name="email" /><br>
		password : <input type="password" name="password" /><br>
		<input type="submit" value="login"/>
	</form>
	
	<%if(request.getAttribute("inactive")!=null){
		out.print(request.getAttribute("inactive"));
	}
		%>
	
</body>
</html>