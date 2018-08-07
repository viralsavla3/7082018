
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
label {
	float: left;
	width: 350px;
}

input[type=text] {
	float: left;
	width: 350px;
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
<title>Insert title here</title>
</head>
<body bgcolor=black text=red>


	<form action="UserController.hola">
		<marquee>
			<h1>ForgetPage</h1>
		</marquee>
		<label for="email">Email id: <input type="email" id="email"
			name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
			required> <br>
		<br> As Security Question:<br>
		<br> <label for="movie">Your Favourite Movie Name is: <input
				type="password" id="movie" name="movie" required><br>
			<br> <input type="submit" value="Submit"><br>
	</form>

</body>
</html>

