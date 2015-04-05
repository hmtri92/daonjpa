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
<link rel="stylesheet" href="css/datepicker.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/datepicker.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>

<script>
	  $('#sandbox-container .input-daterange').datepicker({
	  });
  </script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbar.jsp"%>

		<div class="container">
		<div class="tab-pane" id="tab_1">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>Search Trancation
					</div>
				</div>
				<div class="portlet-body form">
					<!-- BEGIN FORM-->
					<form id="frmRegister" class="horizontal-form" action="getlisttransaction" method="POST">
						<div class="form-body">
							<h3 class="form-section">Search Info</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">From date</label>
										<input  type="text" placeholder="From date"  id="fromdate" name="fromdate" class="form-control">
									</div>
								</div>
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">To date</label>
										<input  type="text" placeholder="To date"  id="todate" name="todate" class="form-control">
									</div>
								</div>
								<!--/span-->
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Source Account</label>
										<input  type="text" placeholder="source account"  id="saccount" name="saccount" class="form-control">
									</div>
								</div>
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Target Account</label>
										<input  type="text" placeholder="target account"  id="tgaccount" name="tgaccount" class="form-control">
									</div>
								</div>
								<!--/span-->
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Bank</label>
										<input  type="text" placeholder="bank"  id="bank" name="bank" class="form-control">
									</div>
								</div>
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Branch</label>
										<input  type="text" placeholder="branch"  id="branch" name="namebranch" class="form-control">
									</div>
								</div>
								<!--/span-->
							</div>
						</div>
						<div class="form-actions right">
							<button id="registerSubmit" type="submit" class="btn blue"><i class="fa fa-check"></i> Search</button>
						</div>
					</form>
					<!-- END FORM-->
					<h3 class="form-section">Result Info</h3>
					<table class="table table-hover">
		       			<thead>
		       				<tr>
		       					<td>Source Account</td>
		       					<td>Target Account</td>
		       					<td>Date</td>
		       					<td>Amount</td>
		       					<td>Bank</td>
		       					<td>Branch</td>
		       				</tr>
		       			</thead>
		       			<tbody>
		       				<c:forEach var="item" items="${list}">
		       				<tr>
		       					<td>${item.sendAccount.accountName}</td>
		       					<td>${item.receiveAccount.accountName}</td>
		       					<td>${item.date}</td>
		       					<td>${item.amount}</td>
		       					<td>${item.branch.bank.name}</td>
		       					<td>${item.branch.nameBranch}</td>			
		       				</tr>
		       				</c:forEach>
		       			</tbody>
		       		</table>
					
				</div>
			</div>
		</div>
	</div>

<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
	
	<script type="text/javascript">
         // When the document is ready
         $(document).ready(function () {
             
             $('#fromdate').datepicker({
                 format: "yyyy-mm-dd"
             });  
             $('#todate').datepicker({
                 format: "yyyy-mm-dd"
             });  
         
         });
     </script>
	
</body>
</html>