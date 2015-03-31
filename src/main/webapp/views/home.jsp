<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSC Banking System</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css" type="text/css" />
<link href="css/logo-nav.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#mytable").dataTable();

	});
</script>
</head>
<body>
	<%@ include file="models/navbar.jsp"%>
	<a href="transferview">Transfer Money</a>
	<div class="container">
		<div id="content-outer">
			<!-- start content -->
			<div id="content">
				<p>Welcome <a href="editCustomerInfo">${sessionScope.user.loginId }</a></p>
				<!--  start page-heading -->
				<div id="page-heading"> 
					<h1>Account Management</h1>
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
			<div class="clear">&nbsp;</div>
		</div>

		<div class="clear">&nbsp;</div>

		<!-- start footer -->
		<%@ include file="models/footer.jsp"%>
	</div>
</body>
</html>