<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Add New Account</title>
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
<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

	function validateForm() {
		//var test = serverValidation();
		if (!validateRequiredField()) {
			document.getElementById("emailError").innerHTML = "Please fill in required fields marked with *";
			return false;
		} else if (!validateEmail()) {
			document.getElementById("emailError").innerHTML = "Invalid email format";
			return false;
		}
		//                else if (!serverValidation()) {
		//                }

		document.getElementById("emailError").innerHTML = "";
		document.getElementById("addNewAccountForm").submit();
		return true;
	}

	function validateRequiredField() {
		var role = document.getElementById("role").value;
		var faculty = document.getElementById("faculty").value;
		var firstname = document.getElementById("firstname").value;
		var lastname = document.getElementById("lastname").value;
		var email = document.getElementById("email").value;
		if ((!role || !faculty || !firstname || !lastname || !email)) {
			return false;
		}
		return true;
	}

	function validateEmail() {
		var email = document.getElementById("email").value;
		var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		return email_regex.test(email);
	}

	function serverValidation() {
		var firstname = document.getElementById("firstname").value;
		var middlename = document.getElementById("middlename").value;
		var lastname = document.getElementById("lastname").value;
		var email = document.getElementById("email").value;
		console.log("calling ajax");
		$
				.ajax({

					url : 'ServerValidation?firstname=' + firstname
							+ '&middlename=' + middlename + '&lastname='
							+ lastname + '&email=' + email,
					success : function(response) {
						console.log("response" + response);
						if (response === "profile") {
							document.getElementById("emailError").innerHTML = "This profile is aready existed";
							return false;
						} else if (response === "email") {
							document.getElementById("emailError").innerHTML = "This email is aready existed";
							return false;
						} else {
							document.getElementById("emailError").innerHTML = "";
							return true;
						}
					}
				});
	}
</script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="/include/topMenu.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h4 class="page-header">Add new recipe</h4>
					</div>
				</div>
				<!-- /.row -->
				<div class="panel-body">
					<form method="POST" class="form-horizontal" role="form"
						action="AddNewRecipe?step=1">
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Recipe
								Name:*</label>
							<div class="col-sm-4">
								<input type="text" name="recipeName" id="recipeName"
									class="form-control" required />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Description:</label>
							<div class="col-sm-4">
								<textarea class="form-control" name="description" id="description"
									class="form-control" rows="5"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Direction:*</label>
							<div class="col-sm-4">
								<textarea class="form-control" name="direction" id="direction"
									class="form-control" required rows="5"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Category:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="category" id="category"
									required>
									<option value="" selected disabled>---Select
										category---</option>
									<c:forEach items="${categories}" var="category">
										<option value="${category.id}">${category.category}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">DishType:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="dishtype" id="dishtype"
									required>
									<option value="" selected disabled>---Select
										DishType---</option>
									<c:forEach items="${dishtypes}" var="dishtype">
										<option value="${dishtype.id}">${dishtype.dishType}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Cooking
								Style:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="cookStyle" id="cookStyle"
									required>
									<option value="" selected disabled>---Select
										cookStyles---</option>
									<c:forEach items="${cookStyles}" var="cookStyle">
										<option value="${cookStyle.id}">${cookStyle.style}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Serve
								Time:*</label>
							<div class="col-sm-4">
								<select multiple class="form-control" name="serveTime"
									id="serveTime" required>
									<c:forEach items="${serveTimes}" var="serveTime">
										<option value="${serveTime.serveTime}">${serveTime.serveTime}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">From
								Country:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="country" id="country"
									required>
									<option value="" selected disabled>---Select
										country---</option>
									<c:forEach items="${countries}" var="country">
										<option value="${country.id}">${country.countryName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<%-- <div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Main
								ingredients:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="mainIngredient"
									id="mainIngredient" required>
									<option value="" selected disabled>---Select
										ingredient---</option>
									<c:forEach items="${ingredients}" var="ingredient">
										<option value="${ingredient.id}">${ingredient.ingredientName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Other
								ingredients:*</label>
							<div class="col-sm-4">
								<select multiple class="form-control" name="otherIngredient"
									id="otherIngredient" required>
									<c:forEach items="${ingredients}" var="ingredient">
										<option value="${ingredient.id}">${ingredient.ingredientName}</option>
									</c:forEach>
								</select>
							</div>
						</div> --%>

						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Cost:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="cost" id="cost" required>
									<option value="">---Select cost---</option>
									<option value="High">High</option>
									<option value="Medium">Medium</option>
									<option value="Low">Low</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Serving:*</label>
							<div class="col-sm-4">
								<input type="text" name="serving" id="serving"
									class="form-control" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Difficulty:*</label>
							<div class="col-sm-4">
								<select class="form-control" name="difficulty" id="difficulty"
									required>
									<option value="">---Select difficulty---</option>
									<option value="Hard">Hard</option>
									<option value="Normal">Normal</option>
									<option value="Easy">Easy</option>
								</select>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Calorie:*</label>
							<div class="col-sm-4">
								<input type="text" name="calorie" id="calorie"
									class="form-control" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Protein:</label>
							<div class="col-sm-4">
								<input type="text" name="protein" id="protein"
									class="form-control" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" style="text-align: left">Fat:</label>
							<div class="col-sm-4">
								<input type="text" name="fat" id="fat" class="form-control"
									required>
							</div>
						</div> -->
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button type="reset" class="btn btn-primary">Reset</button>
								<button type="submit" class="btn btn-primary">Next</button>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<label id="emailError"
									style="text-align: left; margin-top: 15px; color: red"></label>
							</div>
						</div>
					</form>
				</div>
				<!-- /.row -->
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
		</div>
	</div>
	<!-- /#wrapper -->

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
