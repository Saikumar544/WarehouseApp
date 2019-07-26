<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html>
<body>
	<h3>Welcome to Documents Page!!</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
	Document : <input type="file" name="fob" />
	<input type="submit" value="Upload" />
	
</pre>
	</form>
	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Download</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob[1]}" /></td>
				<td><a href="download?fId=${ob[0]}">Download</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>