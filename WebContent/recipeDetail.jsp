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
<title>Recipe Detail</title>
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
<link href="css/main.css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>

<script type="text/javascript">
	//Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
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
				<!-- /.row -->
				<div class="row" style="border-bottom: 1px dotted #e6e6e6">
					<div class="col-sm-4">
						<img class="img-responsive" src="images/img_avatar2.png" width="300px">
					</div>
					<div class="col-sm-8">
						<h1 style="color: #4d4d4d">sdfsdfs${recipe.recipeName}</h1>

						<span>sfdfsdfds${recipe.description}</span> <span>Recipe by</span>
						${recipe.recipeBy}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<h2>Ingredient</h2>
						<ul>
							<li>ingredient 1</li>
							<li>ingredient 2</li>
							<li>ingredient 3</li>
							<li>ingredient 4</li>
						</ul>
					</div>
					<div class="col-sm-8">
						<h2>Direction</h2>
						<h3>
							<span>sdfsdfsdfs df sdhf sjkdhf kjsdhf]
								sdfhksdjhfjkhsdjkfh <br> shdfkjsdhfkjsdhfjsdhfjk <br>sfjksdhkjfhsdkjhfjkshdf
								<br>
							</span>
						</h3>
					</div>
				</div>
			</div>
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
