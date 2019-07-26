<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to data page</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>UserType</th>
			<th>UserCode</th>
			<th>UserFor</th>
			<th>Email</th>
			<th>Contact</th>
			<th>ID Type</th>
			<th>ID Number</th>
			<th colspan="3">Operations</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.uType}" /></td>
				<td><c:out value="${ob.uCode}" /></td>
				<td><c:out value="${ob.userFor}" /></td>
				<td><c:out value="${ob.uMail}" /></td>
				<td><c:out value="${ob.uContact}" /></td>
				<td><c:out value="${ob.uIdType}" /></td>
				<td><c:out value="${ob.idNumber}" /></td>
				<td><a href="delete?id=${ob.id}">DELETE</a>
				<td><a href="edit?id=${ob.id}">EDIT</a>
				<td><a href="view?id=${ob.id}">View</a>
			</tr>
		</c:forEach>
	</table>
	<a href="excel">export to excel</a>
	${msg}
</body>
</html>