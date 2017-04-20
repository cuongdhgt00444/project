'use strict';

var app = angular.module('myApp');

app.controller('loginController', function($rootScope, $scope, $http,
		$location, messages, userService,accountService) {
	// $rootScope.pageTitle = "Login Page";
	$scope.login = function() {
		$http(
				{
					method : 'GET',
					url : 'doLogin?username=' + $scope.username + '&password='
							+ $scope.password
				}).success(function(data, status, headers, config) {
			userService.setAccount(data.username);
			accountService.setAccount(data);
			console.log("set userservice: " + userService.getAccount);
			console.log("username : " + data.username);
			messages.add(data.username);
			$scope.account = data;
			$scope.bannerTitle = "welcome";
			$scope.username = data.username;
			$scope.contentHeader = data.username;
			console.log("username" + $scope.account.username);
			$location.path("/newAccount")
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});

	};
});
