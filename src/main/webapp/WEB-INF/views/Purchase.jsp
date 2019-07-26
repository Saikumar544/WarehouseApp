<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="purchaseOrder">
<pre>
OrderId:
<form:input path="id" readOnly="true"/>
Order Code:
<form:input path="orderCode"/>
ReferenceNumber:
<form:input path="referenceNumber"/>
QualityCheck:
<form:radiobutton path="qualityCheck" value="required"/>Required
<form:radiobutton path="qualityCheck" value="notRequired"/>Not Required
Status:
<form:input path="defaultStatus" value="Open" readonly="true"/>
Description:
<form:textarea path="note"/>
ShipmentCode:
<form:select path="shipmentType.wid">
<form:options items="${ships}" itemLabel="shipmentCode" itemValue="wid"/>
</form:select>
OrderCode:
<form:select path="warehouseType.id">
<form:options items="${wuser}" itemLabel="uType" itemValue="id"/>
</form:select>
<input type="submit" value="save">
</pre>
<a href="all">ViewAll</a>
</form:form>

${msg}
</body>
</html>