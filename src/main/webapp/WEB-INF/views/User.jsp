<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="user">
<pre>
Name:
<form:input path="userName"/>
Email:
<form:input path="userEmail"/>
PassWord:
<form:password path="userPassword"/>
Roles:
<form:checkbox path="roles" value="ADMIN"/>ADMIN
<form:checkbox path="roles" value="MANAGER"/>MANAGER
<input type="submit" value="Register"/>
</pre>
</form:form>
${msg}
<a href="all">view all</a>
</body>
</html>