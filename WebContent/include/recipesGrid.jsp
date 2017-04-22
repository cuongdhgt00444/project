<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>
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
<c:forEach items="${recipes}" var="recipe">
	<div class="col-sm-4">
		<div class="recipeGrid">
			<img class="img-responsive" src="images/no_img.png">
			<h3 style="color: #4d4d4d">${recipe.recipeName}</h3>
			<input class="rating"  value="${recipe.rating}"
				data-size="xs"  disabled/>
			<h5 class="recipeDesc">
				<span>${recipe.description}</span>
			</h5>
			<h5 class="recipeBy">
				<span>Recipe by</span> ${recipe.recipeBy}
			</h5>
		</div>
	</div>
</c:forEach>
