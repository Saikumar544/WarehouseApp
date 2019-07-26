<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>ID</th><td><c:out value="${ob.id}"/></td></tr>
<tr><th>ItemCode</th><td><c:out value="${ob.itemCode}"/></td></tr>
<tr><th>Item BaseCost</th><td><c:out value="${ob.baseCost}"/></td></tr>
<tr><th>Item BaseCurrency</th><td><c:out value="${ob.baseCurrency}"/></td></tr>
</table>
</body>
</html>