'use strict';

var app = angular.module('myApp', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when("/login", {
		templateUrl : "Login2.jsp",
		controller : 'loginController'
	}).when("/newAccount", {
		templateUrl : "AddNewAccount2.jsp"
	}).when("/register", {
		templateUrl : "Register2.jsp"
	})

} ]);

app.factory('messages', function() {
	var messages = {};

	messages.list = [];

	messages.add = function(message) {
		messages.list.push({
			id : messages.list.length,
			text : message
		});
	}

	return messages;

});

app.factory('userService', function() {
	var userAccount = "default user";

	return {
		getAccount : function() {
			return userAccount;
		},

		setAccount : function(account) {
			userAccount = account;
		}
	}

});

app.factory('accountService', function() {
	var userAccount = {};

	return {
		getAccount : function() {
			return userAccount;
		},

		setAccount : function(account) {
			userAccount = account;
		}
	}

});

app.controller('bannerController', function($rootScope, $scope, $http,
		$location, messages, userService) {
	var self = this;
	messages.add("testes");
	console.log("get userservice: " + userService.getAccount());
	$scope.bannerTitle = userService.getAccount();
});
app.controller('accountController', function($rootScope, $scope, $http,
		$location, accountService) {
	$scope.username = accountService.getAccount().email;
});
app.controller('leftMenuController', function($rootScope, $scope, $http,
		$location) {

});
app.controller('mainContentController', function($rootScope, $scope, $http,
		$location, messages, userService) {
	var self = this;

	$scope.contentHeader = "test";
	self.messages = messages.list
});
