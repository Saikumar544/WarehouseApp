<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<form:form action="update" method="POST" modelAttribute="item">
<pre>
Item ID:
<form:input path="id" readOnly="true"/>
Item Code:
<form:input path="itemCode"/>
Item Dimensions:
<form:input path="width"/>WIDTH
<form:input path="length"/>LENGTH
<form:input path="height"/>HEIGHT
Item BaseCost:
<form:input path="baseCost"/>
Item BaseCurrency:
<form:select path="baseCurrency">
<form:option value="">--select--</form:option>
<form:option value="INR">INR</form:option>
<form:option value="USD">USD</form:option>
<form:option value="AUS">AUS</form:option>
<form:option value="ERU">ERU</form:option>
</form:select>
<input type="submit" value="Update"/>
</pre>
</form:form>
</body>
</html>