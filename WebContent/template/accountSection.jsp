<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- Top Menu Items -->
<div ng-controller="accountController">
	<ul class="nav navbar-right top-nav">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown"><i class="fa fa-user"></i> {{username}} <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
				<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a></li>
				<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a></li>
				<li class="divider"></li>
				<li><a href="Logout"><i class="fa fa-fw fa-power-off"></i>
						Log Out</a></li>
			</ul></li>
	</ul>
</div>
