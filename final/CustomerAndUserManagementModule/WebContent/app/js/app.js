var Module3 = angular.module('Module3', [ 'ngRoute', 'ngResource' ]);

Module3.config(function($routeProvider) {
	$routeProvider.when('/ClientRegistration', {
		templateUrl : 'ClientDetails.html', // For Client Registration
		controller : 'SubmitClientDetails'
	}).when('/editClient/:id', {
		templateUrl : 'ClientDetails.html', // For Updating Client details
		controller : 'SubmitClientDetails'
	}).when('/searchClient', {
		templateUrl : 'SearchClientByName.html', // For Searching Client by Name
		controller : 'GetallClients'
	}).when('/UserRegistration', {
		templateUrl : 'UserDetails.html', // For User Registration
		controller : 'SubmitUserDetails'
	}).when('/editUser/:id', {
		templateUrl : 'UserDetails.html', // For Updating User Details
		controller : 'SubmitUserDetails'
	}).when('/login', {
		templateUrl : 'login.html', // For user Login
		controller : 'loginController'
	}).when('/adminLogin', {
		templateUrl : 'AdminLogin.html', // For Admin Login
		controller : 'adminLoginController'
	}).when('/logout', {
		templateUrl : 'Logout.html', // For logout
		controller : 'logout'
	}).when('/searchUser', {
		templateUrl : 'SearchUserByName.html', // For Searching User by Name
		controller : 'GetallUsers'
	}).when('/group', {
		templateUrl : 'group.html',
		controller : 'SubmitGroup'
	}).when('/editgroup/:id', {
		templateUrl : 'group.html',
		controller : 'SubmitGroup'
	}).when('/addMember/:id', {
		templateUrl : 'Allmembers.html',
		controller : 'AddMembersInGroup'
	}).when('/searchgroup', {
		templateUrl : 'SearchGroupByName.html',
		controller : 'GetAllGroups'
	});
});
