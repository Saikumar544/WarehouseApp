<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
</head>
<body>
<a href="excel">Excel export</a>
<h3>welcome to uom data</h3>
<table border="1">
<tr>
<th>uid</th>
<th>utype</th>
<th>umodel</th>
<th>note</th>
<th colspan="2">Operation</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob.id}"></c:out></td>
<td><c:out value="${ob.userType}"></c:out></td>
<td><c:out value="${ob.userModel}"></c:out></td>
<td><c:out value="${ob.userNote}"></c:out></td>
<td><a href="delete?id=${ob.id}">DELETE</a>
<td><a href="edit?id=${ob.id}">EDIT</a>
<td><a href="view?id=${ob.id}">View</a>
</td>
</c:forEach>
</tr>
</table>
${msg}
</body>
</html>