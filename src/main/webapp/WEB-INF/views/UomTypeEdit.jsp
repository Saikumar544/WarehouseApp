<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UomEdit</title>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<form:form action="update" method="POST" modelAttribute="uomType">
<pre>
Uom Id:
<form:input path="id"/>

Uom Type:
<form:select path="userType">
<form:option value=" ">--select--</form:option>
<form:option value="PACKING">Packing</form:option>
<form:option value="NO PACKING">No Packing</form:option>
Uom Model:
<form:input path="userModel"/>
Description:
<form:textarea path="userNote"/>
<input type="submit" value="update uom"/>
</pre>
</form:select>
</form:form>
</body>
</html>
