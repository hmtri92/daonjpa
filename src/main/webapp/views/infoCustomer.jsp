<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
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
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>Edit profile
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse">
							</a>
							<a href="#portlet-config" data-toggle="modal" class="config">
							</a>
							<a href="javascript:;" class="reload">
							</a>
							<a href="javascript:;" class="remove">
							</a>
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->
						<form:form id="frmRegister" class="horizontal-form" action="edit" modelAttribute="customer"  method="POST">
							<div class="form-body">
								<h3 class="form-section">Person Info</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">First Name</label>
											<form:input type="text" name="firstName" path="firstName" class="form-control"/>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Last Name</label>
											<form:input type="text" name="lastName" path="lastName" class="form-control"/>
										</div>
									</div>
									<!--/span-->
								</div>
								<!--/row-->
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address</label>
											<form:input type="text" name="address" path="address" class="form-control"/>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">CellPhone</label>
											<form:input type="text" name="phone" path="phone" class="form-control"/>
										</div>
									</div>
									<!--/span-->
								</div>
								<!--/row-->
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Password</label>
											<form:input type="password" name="password" path="password" class="form-control"/>
										</div>
									</div>
								</div>
								
								<h2>Sơn coi phần code dưới để cho người dùng có thể đổi password nhe</h2>
								
								<%-- <div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">New password</label>
											<form:input type="password" name="newpassword" path="newpassword" class="form-control"/>
											<span class="help-block">
											Select your gender </span>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">RePassword</label>
											<form:input type="password" name="RePassword" path="RePassword" class="form-control"/>
										</div>
									</div>
									<!--/span-->
								</div>
							</div> --%>
							<div class="form-actions right">
								<button type="button" class="btn default">Cancel</button>
								<button id="registerSubmit" type="submit" class="btn blue"><i class="fa fa-check"></i> Save</button>
							</div>
						</form:form>
						<!-- END FORM-->
					</div>
				</div>
			</div>
	</div>
		
		<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
</body>
</html>