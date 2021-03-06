

function isEmpty(id) {
	var x = document.getElementById(id).value;
	if (x == "" || x == null) {
		document.getElementById(id).setAttribute("aria-describedby","inputError2Status");
		return false;
	}
	return true;
}

function compare(value1, value2) {
	if (document.getElementById(value1).value == document.getElementById(value2).value) {
		return true;
	}
	return false;
}

function checkMyRegister() {
//	alert("1");
	var result = true;
	result = result && isEmpty("firstName");
	result = result && isEmpty("lastName");
	result = result && isEmpty("userName");
	result = result && isEmpty("email");
	result = result && isEmpty("password");
	result = result && isEmpty("confirmpassword");
	result = result && isEmpty("cellPhone");
	result = result && compare("password", "confirmpassword");
	
	
	if (result == false) {
		document.getElementById("message").style.visibility = "visible";
	}
	return result;
	
}

function submitUpdateProfile() {
	$.ajax({
		url: "UpdateProfile",
		type: "POST",
		data: $("#frmUpdate").serialize(),
		success: function(result) {
			var json = JSON.parse(result);
		}
	})
}

$("#registerSubmit").click(function(event){
	aler(2222);
	$.ajax({
		url: "Register",
		type: "POST",
		data: $("#frmRegister").serialize(),
		success:function() {
			},
		error:function(){
			}
		});
	});

function loadBranch() {
	$("#branchlist")
	.empty()
	.append('<option value="-1">--Choose Branch--</option>')
	$.ajax({
		type : "POST",
		url : "getBranch",
		data : {"idBank" : $("#banklist").val()},
		success : function(results) {
			$.each(results, function(i, item){
				$("#branchlist").append($("<option></option>").text(this.nameBranch).val(this.id));
			});
		},
		error: function(){      
	   		alert("Error while request..");
	  	}
	});
}

function checkName() {
	$.ajax({
		type : "POST",
		url : "checkName",
		data : {"idAccount" : $("#accountNumber").val()},
		success : function(result) {
			$("#name").val(result);
		},
		error: function(){      
	   		alert("Error while request..");
	  	}
	});
}

function goHome() {
	location.href = "home";
}

function changeCheckBox() {
	if ($("#checkBox").prop("checked")) {
		$("#recentAccount").removeAttr('disabled');
		$("#accountNumber").attr('disabled','disabled');
		$("#banklist").attr('disabled','disabled');
		$("#branchlist").attr('disabled','disabled');
		
	} else {
		$("#accountNumber").removeAttr('disabled');
		$("#banklist").removeAttr('disabled');
		$("#branchlist").removeAttr('disabled');
		$("#recentAccount").attr('disabled','disabled');
	}
}

function loadTarget() {
	$("#recentAccount")
	.empty()
	.append('<option value="-1">--Choose Recent Account--</option>')
	$.ajax({
		type : "POST",
		url : "getTargetByAccount",
		data : {"idAccount" : $("#sendaccount").val()},
		success : function(results) {
			$.each(results, function(i, item){
				$("#recentAccount").append($("<option></option>").text(this.name).val(this.id_taget));
			});
		},
		error: function(){      
	   		alert("Error while request..");
	  	}
	});
}

