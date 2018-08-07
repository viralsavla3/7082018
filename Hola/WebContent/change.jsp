<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
	window.alert("Password successfully reset");
  //confirm_password.setCustomValidity("home.jsp");
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
</head>
<body>

<form action="UserController.hola" method="get">
Email id: <input type="text" id="email"	name="email" required>
New Password:<input type="password" id="password" placeholder="Password" name="password" required>
Re-enter New Password:<input type="password" placeholder="Confirm Password" id="confirm_password" name="password" required>
<input type="submit" id="submit" name="submit" value="Confirm" onclick="validatePassword()">
</form>
<br><br>
</body>
</html>