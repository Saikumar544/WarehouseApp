<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Edit</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="user">
<pre>
ID:
<form:input path="id" readOnly="true"/>
Name:
<form:input path="userName"/>
Email:
<form:input path="userEmail"/>
PassWord:
<form:password path="userPassword"/>
Roles:
<form:checkbox path="roles" value="ADMIN"/>ADMIN
<form:checkbox path="roles" value="MANAGER"/>MANAGER
<input type="submit" value="update"/>
</pre>
</form:form>
</body>
</html>