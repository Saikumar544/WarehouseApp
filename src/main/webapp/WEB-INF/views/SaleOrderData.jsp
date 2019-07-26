<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Data</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>Sale Order Code</th>
<th>Shipment Type</th>
<th>ReferenceNumber</th>
<th>Stock Mode</th>
<th>Stock Source</th>
<th>Status</th>
<th>Description</th>
<th>Operations</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob.id}"/></td>
<td><c:out value="${ob.shipmentType.shipmentCode}" /></td>
<td><c:out value="${ob.refNumber}"/></td>
<td><c:out value="${ob.stockMode}"/></td>
<td><c:out value="${ob.stockSource}"/></td>
<td><c:out value="${ob.status}"/></td>
<td><c:out value="${ob.description}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>