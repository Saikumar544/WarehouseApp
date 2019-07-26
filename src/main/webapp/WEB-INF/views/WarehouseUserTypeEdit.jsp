<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WareHouse</title>
</head>
<body>
<form:form action="update" method="POST"
		modelAttribute="warehouseUserType">
		<h3>Welocome to Warehouse Edit User Type</h3>
		<pre>
ID:<form:input path="id" readonly="true" />
User Type:
<form:radiobutton path="uType" />Vendor
<form:radiobutton path="uType" />Customer
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
User Contact:
<form:input path="uContact" />
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
<input type="submit" value="update" /> 
</pre>
	</form:form>
</body>
</html>