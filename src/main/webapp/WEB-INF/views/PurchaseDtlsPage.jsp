<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to puchase Screen</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="purchaseDtls">
ID:
<form:input path="id" readyOnly="true" />
OrderCode:
<form:input path="orderCode"/>
SelectItem:
<form:select path="item.id">
<form:option value="">--select--</form:option>
<form:options items="${list}" itemLabel="itemCode" itemValue="id"/>
</form:select>	
Quantity:
<form:input path="quantity"/>
<input type="submit" value="ADD"/>
<hr>
<table border="1">
<tr>
<tr>
<th>SNO</th>
<th>ITEM</th>
<th>BASECOST</th>
<th>QTY</th>
<th>OPERATIONS</th>
</tr>
<c:if test="${not empty list1}">
<c:forEach items="${list1}" var="ob">
<tr>
<td><c:out value="${ob.id}"/></td>
<td><c:out value="${ob.item.itemCode}"/></td>
<td><c:out value="${ob.item.baseCost}"/></td>
<td><c:out value="${ob.quantity}"/>
<td><a href="delete?id=${ob.id}">REMOVE</a></td>
</c:forEach>
</c:if>
</table>
</form:form>
${message}
</body>
</html>