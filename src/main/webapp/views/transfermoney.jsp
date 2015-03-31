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
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<form action="submitTransfer" method="post">
	<div>
		<span>Choose account to transfer</span>
		<select name="sendaccount">
			<c:forEach var="item" items="${listaccount}">
				<option value="${item.id}">${item.accountName}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		
		<span>TargetAccount</span>
		<input type="radio" name="radio"/>Recent Account
		<select>
			<option></option>
		</select>
		<input type="radio" name="radio"/>
		To Account <input type="text" name="accountname"/><br>
	</div>
		<span>Amount</span></br>
		<input type="text" name="amount"/>
	</div>
	<div>
		<span>Bank</span>
		
		<select id="slbank" name="slbank">
			<option value="-1">--Choose Bank--</option>
			<c:forEach var="item" items="${listbank}">
				<option value="${item.id_bank}">${item.name}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<span>Branch</span>
		<select id="slbranch" name="slbranch">
			<option value="-1">--Choose Branch--</option>
		</select>
	</div>
	<div>
	${message}
		<input type="submit" value="submit">
	</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#slbank").on("change",function(){
				getBranch(this);
			});

			function getBranch(sel) {
				$( "#slbranch" ).load( "ajaxGetbranch/" + sel.value , function( response, status, xhr ) {
				  if ( status == "error" ) {
				    var msg = "Sorry but there was an error: ";
				    alert(msg);
				  }
				});
			}
			
		});
	</script>
</body>
</html>