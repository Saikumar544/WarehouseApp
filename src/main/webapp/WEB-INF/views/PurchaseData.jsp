<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseData</title>
</head>
<body>
<table border="1">
<tr>
<th>Id</th>
<th>order code</th>
<th>reference code</th>
<th>quality check</th>
<th>status</th>
<th>note</th>
<th colspan="4">Operations</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob.id}"></c:out>
<td><c:out value="${ob.orderCode}"></c:out>
<td><c:out value="${ob.referenceNumber}"></c:out>
<td><c:out value="${ob.qualityCheck}"></c:out>
<td><c:out value="${ob.qualityCheck}"></c:out>
<td><c:out value="${ob.defaultStatus}"></c:out>
<td><c:out value="${ob.note}"></c:out></td>
<td><a href="one?id=${ob.id}">one</a>
<td><a href="edit?id=${ob.id}">edit</a>
<td><a href="delete?id=${ob.id}">delete</a>
</tr>
</c:forEach>
</table>
</body>
</html>