<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
<div class="collapse navbar-collapse navbar-ex1-collapse" ng-controller="leftMenuController">
	<ul class="nav navbar-nav side-nav">
		<li class="active"><a href="#"><i
				class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>
		<li><a href="#newAccount"><i
				class="fa fa-fw fa-plus-circle"></i> Add New Account</a></li>
	</ul>
</div>
<!-- /.navbar-collapse -->
