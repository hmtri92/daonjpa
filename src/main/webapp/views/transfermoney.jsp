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
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/bootstrap-switch.css">

<link href="docs/css/highlight.css" rel="stylesheet">
<link href="http://getbootstrap.com/assets/css/docs.min.css" rel="stylesheet">
<link href="docs/css/main.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="docs/js/highlight.js"></script>
<script type="text/javascript" src="js/bootstrap-switch.js"></script>
<script src="docs/js/main.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbar.jsp"%>

	<div class="container">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portlet blue-madison box">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i>Transfer
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<form class="form-horizontal" action="submitTransfer" method="post" style="padding 0 auto">
							<div class="form-group">
								<label class="col-md-3 control-label" for="sendaccount">Account: </label>
								<div class="col-md-5">
									<select name="sendaccount" class="form-control input-medium">
										<c:forEach var="item" items="${listaccount}">
											<option value="${item.id}">${item.accountName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">Amount: </label>
								<div class="col-md-5">
									<input type="text" name="amount" /><br>
								</div>
							</div>
							
							<!-- Choose target account or new account -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">Target Account: </label>
								<div class="col-md-5">
									<input type="checkbox" name="recentAccount" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">Recent Account: </label>
								<div class="col-md-5">
									<select class="form-control input-medium">
										<option></option>
									</select> 
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">New account: </label>
								<div class="col-md-5">
									<input type="text" name="accountname" /><br>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">Bank: </label>
								<div class="col-md-5">
									<select id="slbank" name="slbank" class="form-control input-medium">
										<option value="-1">--Choose Bank--</option>
										<c:forEach var="item" items="${listbank}">
											<option value="${item.id_bank}">${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="radio">Branch: </label>
								<div class="col-md-5">
									<select id="slbranch" name="slbranch" class="form-control input-medium">
										<option value="-1">--Choose Branch--</option>
										<!-- chưa có nội dung -->
									</select>
								</div>
							</div>
				
							<div>
								${message} 
							</div>
							
							<div class="form-group">
								<div class = "col-md-5 col-md-offset-4">
									<button class="btn btn-primary" type="submit" >Send</button>
									<button class="btn btn-primary" type="button">Cancel </button>
								</div>
							</div>
							
							
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- END PAGE CONTENT-->
		
	</div>
	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>


	<script type="text/javascript">
	$("[name='my-checkbox']").bootstrapSwitch();
		$(document)
				.ready(
						function() {
							$("#slbank").on("change", function() {
								getBranch(this);
							});

							function getBranch(sel) {
								$("#slbranch")
										.load(
												"ajaxGetbranch/" + sel.value,
												function(response, status, xhr) {
													if (status == "error") {
														var msg = "Sorry but there was an error: ";
														alert(msg);
													}
												});
							}

						});
	</script>
	
</body>
</html>