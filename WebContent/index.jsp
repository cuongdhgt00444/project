
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title ng-bind="pageTitle"></title>
<link href="css/login.css" rel="stylesheet">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">
<link href="css/modelLogin.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>


</head>
<body>
	<div>
		<div>

			<!-- <a href="#login">login</a> <a href="#register">Register</a> <a
				href="#newAccount">new account</a>
 -->
		</div>
		<div ng-view></div>
	</div>
	<script src="js/app/app.js"></script>
	<script src="js/app/loginController.js"></script>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>
</body>

</html>
