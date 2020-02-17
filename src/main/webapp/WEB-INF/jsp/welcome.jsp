<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
	<font color="green">${msg}</font>
	<br/>
	<form:form action="/submitform?customer_id=${ContactDel.customer_id}" method="post"
		modelAttribute="ContactDel">
		<table>
			<tr>
				<th>Customer_Name:</th>
				<td><form:input path="customer_Name" />
				</th>
			</tr>
			<tr>
				<th>Customer_Email:</th>
				<td><form:input path="customer_Email" />
				</th>
			</tr>
			<tr>
				<th>mobile:</th>
				<td><form:input path="mobile" />
				</th>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="save">
				</th>
			</tr>
		</table>
	</form:form>
	<a href="/viewAllData">Show All Contact</a>
</body>
</html>