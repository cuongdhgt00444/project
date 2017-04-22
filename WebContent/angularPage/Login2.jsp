<div ng-controller="loginController">
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<!-- /.row -->
			<div class="panel-body">

				<form name="loginForm" ng-submit="login()">
				{{pageTitle}}
					<div class="imgcontainer">
						<img src="images/img_avatar2.png" alt="Avatar" class="avatar">
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label"
							style="text-align: left; margin-top: 15px">Username:</label>
						<div class="col-sm-7">
							<input type="text" name="username" ng-model="username"
								class="form-control" required> <span style="color: red"
								ng-show="loginForm.user.$touched && loginForm.user.$invalid">
								<span ng-show="loginForm.user.$error.required">Username
									is required.</span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label"
							style="text-align: left; margin-top: 15px">Password:</label>
						<div class="col-sm-7">
							<input type="password" name="password" ng-model="password"
								class="form-control" required> <span style="color: red"
								ng-show="loginForm.password.$dirty && loginForm.password.$invalid">
								<span ng-show="loginForm.password.$error.required">Password
									is required.</span>
							</span>
						</div>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label class="col-sm-3 control-label" -->
<!-- 							style="text-align: left; margin-top: 15px">Email:</label> -->
<!-- 						<div class="col-sm-7"> -->
<!-- 							<input type="email" name="email" ng-model="email" -->
<!-- 								class="form-control" required> <span style="color: red" -->
<!-- 								ng-show="loginForm.email.$dirty && loginForm.email.$invalid"> -->
<!-- 								<span ng-show="loginForm.email.$error.required">Email is -->
<!-- 									required.</span> <span ng-show="loginForm.email.$error.email">Invalid -->
<!-- 									email address.</span> -->
<!-- 							</span> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<p>
						<button type="submit" class="btn btn-primary" ng-disabled="loginForm.$invalid">Login</button>
					</p>
				</form>
			</div>
			<!-- /.row -->
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
</div>