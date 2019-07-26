<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom</title>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
<h3 align="center">Welcome to UomType</h3>
<form action="save" method="post">
<form:form modelAttribute="uomType">
UomType:
<form:select path="userType">
<form:option value=" ">--select--</form:option>
<form:option value="PACKING">Packing</form:option>
<form:option value="NO PACKING">No Packing</form:option>
<form:option value="N/A">n/a</form:option>
</form:select>
<br>
<br>
Uom Model:
<form:input path="userModel"/>
<form:errors path="userModel"/>
<br>
<br>
Description:
<form:textarea path="userNote"/>
<input type="submit" value="create Uom">
</form:form>
</form>
<a href="all">View All</a>
${msg}
</body>	
</html>
