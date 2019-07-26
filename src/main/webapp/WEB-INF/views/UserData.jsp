<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Data</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>USERNAME</th>
<th>USER EMAIL</th>
<th>USER PASSWORD</th>
<th>ROLES</th>
<th>OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="ob">
<td><c:out value="${ob.id}"/></td>
<td><c:out value="${ob.userName}"/></td>
<td><c:out value="${ob.userEmail}"/></td>
<td><c:out value="${ob.userPassword}"/></td>
<td><c:out value="${ob.roles}"/></td>
<td><a href="edit?id=${ob.id}">Edit</a></td>
</c:forEach>
</table>
</body>
</html>