<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse</title>
</head>
<body>
	<form:form action="save" method="POST"
		modelAttribute="warehouseUserType">
		<h3>Welcome to Warehouse User Type</h3>
		<pre>
User Type:
<form:radiobutton path="uType" value="VENDOR"  />Vendor
<form:radiobutton path="uType" value="CUSTOMER" />Customer
User Code:
<form:input path="uCode" />
User For:
<form:select path="userFor">
<form:option value="">--select--</form:option>
<form:option value="PURCHASE">purchase</form:option>
<form:option value="SALE">sale</form:option>
</form:select>
Email:
<form:input path="uMail" />
<form:errors path="uMail"/>
User Contact:
<form:input path="uContact" />
<form:errors path="uContact"/>
User Id Type:
<form:select path="uIdType">
<form:option value="">--select--</form:option>
<form:option value="PANCARD">pan card</form:option>
<form:option value="AADHAR">aadhar card</form:option>
<form:option value="VOTER ID">voter id</form:option>
<form:option value="OTHER">other</form:option>
</form:select>
Id Number:
<form:input path="idNumber" />
<input type="submit" value="create uom" /> 
</pre>
	</form:form>
	<a href="all">view list</a> ${msg}
</body>
</html>