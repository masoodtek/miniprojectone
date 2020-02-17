<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function alertName(){
	confirm("Do you want delete this file !!!!");
} 
</script> 
</head>
<body>
	<h1>All Contact</h1>
	<a href="welcome">Add More Contact</a>
	<br/><font color="green">${msg}</font> 
	<br/>
	<table border="1px">
		<tr>
			<th>Customer_Name</th>
			<th>Customer_Email</th>
			<th>Mobile</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.customer_Name}</td>
				<td>${contact.customer_Email}</td>
				<td>${contact.mobile}</td>
				<td><a href="/edit?customer_id=${contact.customer_id}">Edit</a>&nbsp;<a
					href="/delete?customer_id=${contact.customer_id}" onclick="alertName()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

