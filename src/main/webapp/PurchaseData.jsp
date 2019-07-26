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
<table border="1">
<tr>
<th>ID</th>
<th>OrderCode</th>
<th>ReferenceNumber</th>
<th>QualityCheck</th>
<th>status</th>
<th>notes</th>
<th>Operations</th>
</tr>
<c:forEach items=${list} var="ob">
<tr>
<td><c:out value="${ob.id}"/></td>
<td><c:out value="${ob.orderCode}"/></td>
<td><c:out value="${ob.referenceNumber}"/></td>
<td><c:out value="${ob.qualityCheck}"/></td>
<td><c:out value="${ob.defaultStatus}"/></td>
<td><c:out value="${ob.note}"/></td>
<td><a href="view?id=${ob.id}">view</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>