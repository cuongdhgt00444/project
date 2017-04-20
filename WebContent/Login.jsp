<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="css/login.css" rel="stylesheet">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
	function validateForm() {
		if (!validateRequiredField()) {
			document.getElementById("alert").innerHTML = "Please fill in required fields marked with *";
			return false;
		}

		document.getElementById("alert").innerHTML = "";
		document.getElementById("LoginForm").submit();
		return true;
	}

	function validateRequiredField() {
		var uname = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if ((!uname || !password)) {
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<!-- /.row -->
			<div class="panel-body">
				<form id="LoginForm" action="doLogin" method="post">
					<div class="imgcontainer">
						<img src="images/img_avatar2.png" alt="Avatar" class="avatar">
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label"
							style="text-align: left; margin-top: 15px">Username:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="" name="username" id="username"
								class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label"
							style="text-align: left; margin-top: 15px">Password:*</label>
						<div class="col-sm-7">
							<input type="password" id="password" name="password" placeholder=""
								class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label id="alert"
							style="text-align: left; margin-top: 15px; color: red"></label><br>
						<button type="button" onclick="validateForm()">Login</button>
						<a href="Register.jsp"> Register</a> <span class="psw"><a
							href="ChangePassword.jsp">Change password</a></span>
						<p>
							<span class="psw">Forgot <a href="ResetPassword.jsp">password?</a></span>
						</p>
					</div>
				</form>
			</div>
			<!-- /.row -->
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>

</body>
</html>
