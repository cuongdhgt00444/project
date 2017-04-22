<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="Dashboard">Happy Meal</a>
		<!-- <a  href="Dashboard"><img class="img-responsive" src="images/logo.jpg"/></a> -->
	</div>
	<!-- Top Menu Items -->
	<c:if test="${sessionScope.account != null}">
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i>
					${sessionScope.account.username} <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
					<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
					</li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a></li>
					<li class="divider"></li>
					<li><a href="Logout"><i class="fa fa-fw fa-power-off"></i>
							Log Out</a></li>
				</ul></li>
		</ul>
	</c:if>
	<c:if test="${sessionScope.account == null}">
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="Login.jsp">Login</b></a>
		</ul>
	</c:if>
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li class="active"><a href="Dashboard"><i
					class="fa fa-fw fa-dashboard"></i> Home</a></li>
			<c:if test="${sessionScope.account != null}">
				<li><a href="addRecipePage"><i
						class="fa fa-fw fa-plus-circle"></i> Add New Recipe</a></li>
			</c:if>
			<c:if test="${sessionScope.account.role == 2}">
				<li><a href="DailyRecommendation"><i
						class="fa fa-fw fa-plus-circle"></i> Daily Recommendation</a></li>
			</c:if>
			<li><a href=""><i class="fa fa-fw fa-search"></i> Advance
					Search</a></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>

