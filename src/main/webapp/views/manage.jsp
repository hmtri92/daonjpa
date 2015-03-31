<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome <a href="editCustomerInfo">${sessionScope.user.loginId}</a>
	<table>
		<thead>
			<tr>
				<th>Account Name</th>
				<th>Account Type</th>
				<th>Available Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listAccount}">
				<tr>
					<td>${item.accountName}</td>
					<td>${item.accountType}</td>
					<td>${item.availableAmount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>