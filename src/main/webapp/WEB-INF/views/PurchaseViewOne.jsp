<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello User</h1>
<table border="1">
<tr>
<th>ID</th><td>${list.id}</td>
</tr>
<tr><th>OrderCode</th><td>${list.orderCode}</td>
</tr>
<tr>
<th>note</th><td>${list.note}</td>
</tr>
</table>
</body>
</html>