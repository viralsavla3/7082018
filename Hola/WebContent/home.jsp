<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
form {
	width: 400px;
}

label {
	float: left;
	width: 150px;
}

input[type=text] {
	float: left;
	width: 250px;
}

.clear {
	clear: both;
	height: 0;
	line-height: 0;
}

.floatright {
	float: right;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor=black text=red>
<jsp:include page="banner.jsp"/>

<form action="UserController.hola" method="get">
		<marquee>
			<h1>LOGIN PAGE</h1>
		</marquee>
		<h1>HomePage</h1>
		<label for="email">Email id: <input type="email" id="email"
			name="email" required> 
			<label for="password">Password: <input
				type="password" id="password" name="password" 
				required><br>
			<br> 
			<input type="submit" value="Login">
	</form>
	<p>
		<a href="forget.jsp" style="color: yellow">Forget password</a>
	</p>
	<p>
		<a href="register.jsp" style="color: yellow">Register</a>
	</p>
	</form>
	<%@ include file="footer.html" %>
</body>
</html>

