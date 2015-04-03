<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Target Account</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbar.jsp"%>
	
	<div class="container">
		<div class="panel panel-primary">
			<form class="form-horizontal" action="" method="POST" style="padding 0 auto">
				<div class="form-group">
					<label class="col-md-3 control-label" for="sendaccount">Account owner: </label>
					<div class="col-md-5">
						<select name="sendaccount" class="form-control input-medium">
							<c:forEach var="item" items="${listaccount}">
								<option value="${item.id}">${item.accountName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label">Account number: </label>
					<div class="col-md-5">
						<input type="text" name="amount" class="form-control"/><br>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label">Name: </label>
					<div class="col-md-5">
						<input type="text" name="amount" class="form-control disabled"/><br>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="sendaccount">Bank: </label>
					<div class="col-md-5">
						<select name="sendaccount" class="form-control input-medium">
							<c:forEach var="bank" items="${listBank}">
								<option value="${bank.id_bank}">${bank.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="sendaccount">Branch: </label>
					<div class="col-md-5">
						<select name="sendaccount" class="form-control input-medium">
							<c:forEach var="branch" items="${listBrach}">
								<option value="${branch.id}">${branch.nameBranch}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				
				<!-- Submit and cancel -->				
				<div class="form-group">
					<div class = "col-md-5 col-md-offset-4">
						<button class="btn btn-primary" type="submit" >Send</button>
						<button class="btn btn-primary" type="button">Cancel </button>
					</div>
				</div>
				
				
			</form>
		</div>
		
	</div>
	
	
	
	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>

</body>
</html>