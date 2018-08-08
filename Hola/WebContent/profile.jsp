<%@page import="lti.hola.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="banner.jsp"/>
<% RegisterBean user = (RegisterBean) session.getAttribute("User"); %>
<table align="center">
<tr><th colspan="2" >Your Profile Details</th></tr>
<tr><td> Name </td><td><%= user.getName() %></td></tr>
<tr><td> Email </td><td><%=user.getEmail() %></td></tr>
<tr><td> Age</td><td><%=user.getAge() %></td></tr>
<tr><td> Gender </td><td><%=user.getGender() %></td></tr>
<tr><td> City </td><td><%=user.getCity() %></td></tr>
<tr><td colspan="2"><img src="<%=user.getPhoto() %>" height="200" width="200"></td></tr>
</table>
<%@ include file="footer.html" %>
</body>
</html>