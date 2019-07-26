<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hello,Welcome to View Page</h3>
<table border="1">
<tr>
<th>ID</th><td>${ob.id}</td>
</tr>
<tr>
<th>Type</th><td>${ob.userType}</td>
</tr>
<tr>
<th>Model</th><td>${ob.userModel}</td>
</tr>
<tr>
<th>Note</th><td>${ob.userNote}</td>
</tr>
</table>
</body>
</html>