<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to warehouse view page!</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		<tr>
		<tr>
			<th>UserType</th>
			<td>${ob.uType}</td>
		</tr>
		<tr>
			<th>UserCode</th>
			<td>${ob.uCode}</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${ob.uMail}
	</table>

</body>
</html>