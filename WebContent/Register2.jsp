<div>
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<!-- /.row -->
			<div class="panel-body">
				<form id="RegisterForm"  >
					<div class="imgcontainer">
						<!-- <img src="images/img_avatar2.png" alt="Avatar" class="avatar"> -->
						<h1>Register</h1>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Firstname:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Firstname" name="firstname"
								id="firstname" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Middlename:</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Middlename" name="middlename"
								id="middlename" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Lastname:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Lastname" name="lastname"
								id="lastname" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">DoB:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="yyyy/MM/dd" name="dob" id="dob"
								class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Email:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="example@email.com" name="email"
								id="email" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Username:*</label>
						<div class="col-sm-7">
							<input type="text" placeholder="Username" name="username"
								id="username" class="form-control" required="true">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Password:*</label>
						<div class="col-sm-7">
							<input type="password" id="password" name="password"
								placeholder="Password" class="form-control" required="true">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label"
							style="text-align: left; margin-top: 15px">Confirm
							Password:*</label>
						<div class="col-sm-7">
							<input type="password" id="confirmPassword"
								name="confirmPassword" placeholder="Re-enter Password"
								onblur="ComparePassword()" class="form-control" required="true">
						</div>
					</div>
					<div>
						<label for="recommendation"> Would you like to receive
							daily meal recommendation?</label> <input type="checkbox"
							id="recommendation" name="recommendation" value="recommendation"
							style="width: 10%;" />
					</div>
					<label id="alert" style="color: red"></label><br>
					<button type="button" onclick="return validateForm();">Submit</button>
					<a href="Login.jsp">Back</a>

				</form>
			</div>
			<!-- /.row -->
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
</div>