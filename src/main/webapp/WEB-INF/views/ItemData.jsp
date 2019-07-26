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
<h1>Welcome to Item Data Page</h1>
<table border="1">
<tr>
<th>ID</th>
<th>ItemCode</th>
<th>Item Width</th>
<th>Item Length</th>
<th>Item Heigth</th>
<th>Item BaseCost</th>
<th>Item Currency</th>
<th colspan="2">Operations</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob.id}"/></td>
<td><c:out value="${ob.itemCode}"/></td>
<td><c:out value="${ob.width}"/></td>
<td><c:out value="${ob.length}"/></td>
<td><c:out value="${ob.height}"/></td>
<td><c:out value="${ob.baseCost}"/></td>
<td><c:out value="${ob.baseCurrency}"/></td>
<td><a href="edit?id=${ob.id}">EDIT</a>
<td><a href="delete?id=${ob.id}">DELETE</a>
<td><a href="view?id=${ob.id}">View</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>