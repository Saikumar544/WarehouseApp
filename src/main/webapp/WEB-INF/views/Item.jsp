<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="item">
<pre>
Item Code:
<form:input path="itemCode"/>
Item Dimensions:
<form:input path="width" size="4"/>WIDTH <form:input path="length" size="4"/>LENGTH <form:input path="height" size="4"/>HEIGHT
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
Uom:
<form:select path="uom.id">
<form:option value="">--select--</form:option>
<form:options items="${uoms}" itemLabel="userModel" itemValue="id"/>
</form:select>
Order Code:
<form:select path="order.id">
<form:option value="">--select--</form:option>
<form:options items="${orders}" itemLabel="orderCode" itemValue="id"/>
</form:select>
<input type="submit" value="Create Item"/>
</pre>
</form:form>
${msg}
</body>
<a href="all">view all</a>
</html>