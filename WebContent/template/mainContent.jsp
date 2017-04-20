<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>


<div id="page-wrapper" ng-controller="mainContentController as list">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h4 class="page-header">{{contentHeader}}</h4>
			</div>
		</div>
		<!-- /.row -->
		Main content
		<p ng-repeat="message in list.messages"> {{message.id}}:{{message.text}}</p>
				<!-- /.row -->
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
</div>

</body>

</html>
