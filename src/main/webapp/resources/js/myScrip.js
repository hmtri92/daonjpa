

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