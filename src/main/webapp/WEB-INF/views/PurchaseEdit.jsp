<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
<form:form action="update" method="POST" modelAttribute="purchaseOrder">
<pre>
Order Id:
<form:input path="id" readOnly="true"/>
Order Code:
<form:input path="orderCode"/>
ReferenceNumber:
<form:input path="referenceNumber"/>
QualityCheck:
<form:radiobutton path="qualityCheck" value="required"/>Required
<form:radiobutton path="qualityCheck" value="notRequired"/>Not Required
ShipmentCode:
<form:select path="shipmentType.wid">
<form:options items="${ships}" itemLabel="shipmentCode" itemValue="wid"/>
</form:select>
VendorCode:
<form:select path="warehouseType.id">
<form:options items="${wuser}" itemLabel="uType" itemValue="id"/>
</form:select>
Status:
<form:input path="defaultStatus" value="Open" readonly="true"/>
Description:
<form:textarea path="note"/>
<input type="submit" value="update">
</pre>
</form:form>
</body>
</html>