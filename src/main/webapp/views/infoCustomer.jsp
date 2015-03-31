<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Information
	<div id="login-overlay" class="modal-dialog">
			<div id="message" name="message"></div>
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Edit</h4>
				</div>
				<div class="modal-body">
					<form:form id="frmRegister" class="registerFrom" action="edit" modelAttribute="customer"  method="POST">
						<form:input type="hidden" path="loginId" />
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="firstName">First
								Name</label>
							<div class="col-sm-8">
								<form:input type="text" name="firstName" path="firstName"/>
							</div>
						</div>
			
						<div class="form-group">
							<label class="control-label col-sm-4" for="lastName">Last
								Name</label>
							<div class="col-sm-8">
								<form:input type="text" name="lastName" path="lastName"/>
							</div>
						</div>
			
						<div class="form-group">
							<label class="control-label col-sm-4" for="email">Address</label>
							<div class="col-sm-8">
								<form:input type="text" name="address" path="address"/>
							</div>
						</div>
			
			
						<div class="form-group">
							<label class="control-label col-sm-4" for="cellPhone">CellPhone</label>
							<div class="col-sm-8">
								<form:input type="text" name="phone" path="phone"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="password">Password</label>
							<div class="col-sm-8">
								<form:input type="password" name="password" path="password"/>
									
							</div>
						</div>
			
						<div class="row">
							<div class="col-md-4 col-md-offset-8 ">
								<input id="registerSubmit"
									class="btn btn-lg btn-primary btn-block" type="submit" value="Submit"/>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>