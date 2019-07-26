<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SaleOrder</title>
</head>
<body>
<h3>welcome to sale-order</h3>
<form:form action="save" method="post" modelAttribute="saleOrder">
<pre>
OrderCode:
<form:input path="saleOrderCode"/>
Shipment Code:
<form:select path="shipmentType.wid">
<form:options items="${ships}" itemLabel="shipmentCode" itemValue="wid"/>
</form:select>
Reference Number:
<form:input path="refNumber"/>
Stock Mode:
<form:radiobutton path="stockMode" value="Grade"/>Grade
<form:radiobutton path="stockMode" value="Margin"/>Margin
Stock Source:
<form:select path="stockSource">
<form:option value="">--select--</form:option>
<form:option value="Open">Open</form:option>
<form:option value="Avail">Avail</form:option>
<form:option value="Refund">Refund</form:option>
</form:select>
Status:
<form:input path="status" value="SALE-OPEN" readOnly="true"/>
Description:
<form:textarea path="description"/>
<input type="submit" value="Create Sale Order"/>
</pre>
</form:form>
${msg}
<a href="all">view all</a>
</body>
</html>