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
<title>User Home Page</title>
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

<link href="css/star-rating.css" media="all" rel="stylesheet"
	type="text/css" />
<script src="js/star-rating.js" type="text/javascript"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="include/topMenu.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h2 class="page-header">Breakfast</h2>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<c:forEach items="${breakfast}" var="breakfastrecipe">
						<div class="col-sm-4">
							<div class="recipeGrid">
								<img class="img-responsive" src="images/no_img.png">
								<h3 style="color: #4d4d4d">${breakfastrecipe.recipeName}</h3>
								<input class="rating" value="${breakfastrecipe.rating}" data-size="xs"
									disabled />
								<h5 class="recipeDesc">
									<span>${breakfastrecipe.description}</span>
								</h5>
								<h5 class="recipeBy">
									<span>Recipe by</span> ${breakfastrecipe.recipeBy}
								</h5>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<h2 class="page-header">Lunch &amp; Dinner</h2>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<c:forEach items="${recipes}" var="recipe">
						<div class="col-sm-4">
							<div class="recipeGrid">
								<img class="img-responsive" src="images/no_img.png">
								<h3 style="color: #4d4d4d">${recipe.recipeName}</h3>
								<input class="rating" value="${recipe.rating}" data-size="xs"
									disabled />
								<h5 class="recipeDesc">
									<span>${recipe.description}</span>
								</h5>
								<h5 class="recipeBy">
									<span>Recipe by</span> ${recipe.recipeBy}
								</h5>
							</div>
						</div>
					</c:forEach>
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
