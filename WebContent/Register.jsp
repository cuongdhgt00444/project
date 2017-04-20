<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
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
		} else if (!validateEmail(email)) {
			document.getElementById("alert").innerHTML = "Invalid email format";
			return false;
		} else if (!ComparePassword()) {
			document.getElementById("alert").innerHTML = "New Password and Retype Password not match";
			return false;
		}

		document.getElementById("alert").innerHTML = "";
		document.getElementById("RegisterForm").submit();
		return true;
	}

	function validateRequiredField() {
		var username = document.getElementById("username").value;
		var firstname = document.getElementById("firstname").value;
		var lastname = document.getElementById("lastname").value;
		var dob = document.getElementById("dob").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		if (username && firstname && lastname && dob && email && password
				&& confirmPassword) {
			return true;
		}
		return false;
	}

	function validateEmail() {
		var email = document.getElementById("email").value;
		var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		return email_regex.test(email);
	}

	function ComparePassword() {
		var firstInput = document.getElementById("password").value;
		var secondInput = document.getElementById("confirmPassword").value;
		console.log(firstInput + "/" + secondInput);
		if (firstInput === secondInput) {
			document.getElementById("alert").innerHTML = "";
			return true;
		} else if (firstInput !== secondInput) {
			document.getElementById("alert").innerHTML = "New Password and Retype Password not match";
			return false;
		}
	}
</script>
</head>

<body>

	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<!-- /.row -->
			<div class="panel-body">
				<form id="RegisterForm" action="AddNewAccount" method="post">
					<div class="imgcontainer">
						<!-- <img src="images/img_avatar2.png" alt="Avatar" class="avatar"> -->
						<h1>Register</h1>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Firstname:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Firstname" name="firstname"
								id="firstname" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Middlename:</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Middlename" name="middlename"
								id="middlename" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Lastname:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Lastname" name="lastname"
								id="lastname" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">DoB:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="yyyy/MM/dd" name="dob" id="dob"
								class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Email:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="example@email.com" name="email"
								id="email" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Username:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Username" name="username"
								id="username" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Password:*</label>
						<div class="col-sm-7">
							<input type="password" id="password" name="password"
								placeholder="Password" class="form-control" required="true">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Confirm
							Password:*</label>
						<div class="col-sm-7">
							<input type="password" id="confirmPassword"
								name="confirmPassword" placeholder="Re-enter Password"
								onblur="ComparePassword()" class="form-control" required="true">
						</div>
					</div>
					<div>
						<label for="recommendation"> Would you like to receive
							daily meal recommendation?</label> <input type="checkbox"
							id="recommendation" name="recommendation" value="recommendation"
							style="width: 10%;" />
					</div>
					<label id="alert" style="color: red"></label><br>
					<button type="button" onclick="return validateForm();">Submit</button>
					<a href="Login.jsp">Back</a>

				</form>
			</div>
			<!-- /.row -->
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
</body>
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="js/plugins/morris/raphael.min.js"></script>
<script src="js/plugins/morris/morris.min.js"></script>
<script src="js/plugins/morris/morris-data.js"></script>

</html>
