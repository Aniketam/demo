var role;
var a;
/*--------------------Client----------------------------------------------*/

//Submit Client Details Controller
Module3.controller("SubmitClientDetails", [
		'$scope',
		'$resource',
		'clientService',
		'$routeParams',
		function($scope, $resource, clientService, $routeParams) {
			
			// for updating client details
			$(".CForm").show();
			$(".CMsg").hide();
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			if ($routeParams.id != null) {
				clientService.searchById({
					id : $routeParams.id
				}, function(responsedata) {
					$scope.client = responsedata;
				}, function() {

				});
			}

			// for submitting client details

			$scope.submitClientForm = function() {
				clientService.submitDetails($scope.client, function(
						responsedata) {
					if (responsedata.result == "true")
						{
							//alert("Submited Successfully...!!!!");
							$(".CForm").hide();
							$(".CMsg").show();
						}
				}, function() {
				});
			};
		} ]);

// Get All Clients Controller

Module3.controller("GetallClients", [ '$scope', '$resource', 'clientService',
		function($scope, $resource, clientService) {

			// Get all client details
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			clientService.getAllClients(function(data) {
				$scope.allclients = data;

				// Search client by name

				$scope.changeClientName = function() {
					clientService.searchByName({
						name : $scope.clientName
					}, function(data) {
						$scope.allclients = data;
					}, function() {
					});
				};
			}, function() {
			});

			// remove client by id

			$scope.removeClient = function(selected) {
				alert("Got it 1st");
				clientService.deleteClient({
					id : selected.id
				}, function(data) {

				}, function() {

				});
			};
		} ]);

/*--------------------------User----------------------------------------------*/

// Submit User Details Controller
Module3.controller("SubmitUserDetails", [ '$scope', '$resource', 'userService',
		'$routeParams', function($scope, $resource, userService, $routeParams) {
			//alert("HI in User..");
			// for updating user details
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			if ($routeParams.id != null) {
				userService.get({
					id : $routeParams.id
				}, function(data) {
					$scope.user = data;
				}, function() {
				});
			}

			// for submitting user details

			$scope.submitUserForm = function() {
				userService.submit($scope.user, function(responsedata) {
					if (responsedata.result == "true")
						{
						alert("Submited Successfully...!!!!");
						$scope.user = null;
						$scope.confirmPassword = null;
						$scope.userform.$setPristine();
						}
				}, function() {
				});
			};
		} ]);

// Get All User Controller

Module3.controller("GetallUsers", [ '$scope', '$resource', 'userService',
		function($scope, $resource, userService) {

			// Get all user details
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			userService.getAll(function(data) {
				$scope.allUsers = data;

				// Search user by name

				$scope.changeUserName = function() {
					userService.search({
						name : $scope.name
					}, function(data) {
						$scope.allUsers = data;
					}, function() {
					});
				};
			}, function() {
			});

			// remove client by id

			$scope.removeUser = function(selected) {
				userService.deleteuser({
					id : selected.uid
				}, function(data) {
				}, function() {
				});
			};
		} ]);

/*
 * Module3.controller("editUserController", [ '$scope', '$resource',
 * 'userService', '$routeParams', function($scope, $resource, userService,
 * $routeParams) { alert("in Edit user"); userService.get({ id : $routeParams.id },
 * function(data) { console.log("Successfull"); $scope.user = data; },
 * function() { console.log("unsuccessfull"); }); } ]);
 */

/*-----------------------Admin----------------------------------------------*/

// Get Admin Login Controller
Module3.controller("adminLoginController", [
		'$scope', 
		'$resource',
		'userService',
		'$routeParams',
		function($scope,$resource, userService, $routeParams) {
			//alert("here");
			if($scope.adminSuccess == null)
				$scope.adminSuccess = false;
			$scope.adminLoginForm = function() {
				//alert('our form is amazing');
				console.log("username " + $scope.admin.username);
				$scope.obj = userService.adminlogin($scope.admin, function(
						responsedata) {
					console.log('sucessfully entered');
					if (responsedata.result == "true") {
						console.log('true');
						//$scope.adminSuccess = true;
						document.getElementById("Scope1").setAttribute("value",true);
						//document.getElementById("adminSucLog").setAttribute("ng-show",true);
						console.log("HI...chkng flag "+ $scope.adminSuccess);
						role = 'admin';
					}
					else
						{
						alert("Login Failed..");
						$scope.admin = null;
						//$scope.admin.password = null;
						$scope.loginform.$setPristine();
						}
					
					a = $('#Scope1').val();
					//alert(a);
				  	if(a == 'true')
				  	{
				  		//alert("Got it");
				  		$(".login").hide();
				  		$(".AfterLogin").show();
				  		$(".Contentdone").hide();
				  	}
				}, function() {
					console.log('sorry error');
					
				});
					
			};
		} ]);

// Get Login controller

Module3.controller("loginController", [
		'$scope',
		'$resource',
		'userService',
		'$routeParams',
		function($scope, $resource, userService, $routeParams) {
			$scope.userLoginForm = function() {
				//alert("HI..User");
				console.log("username " + $scope.user.username);
				$scope.obj = userService.userlogin($scope.user, function(
						responsedata) {
					console.log('sucessfully entered');
					if (responsedata.result == "true") {
						console.log('true');
						$scope.userSuccess = true;
						document.getElementById("Scope2").setAttribute("value",true);
						role = 'user';
					}
					else
					{
						alert("Login Failed..");
						$scope.user = null;
						$scope.loginform.$setPristine();
					}
					a = $('#Scope2').val();
					//alert(a);
				  	if(a == 'true')
				  	{
				  		//alert("Got it");
				  		$(".login").hide();
				  		$(".AfterUserLogin").show();
				  		$(".Contentdone1").hide();
				  	}
				}, function() {
					console.log('sorry error');
				});

			};
		} ]);

/*-----------------------Group----------------------------------------------*/

Module3.controller("SubmitGroup", [
		'$scope',
		'$resource',
		'groupService',
		'$routeParams',
		function($scope, $resource, groupService, $routeParams) {
			
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			if ($routeParams.id != null) {
				//alert("in Edit group");
				groupService.get({
					id : $routeParams.id
				}, function(data) {
					console.log("Successfull");
					$scope.group = data;
				}, function() {
					console.log("UnSuccessfull");
				});
			}
			//alert("here");
			$scope.submitGroupForm = function() {
				//alert('our form is amazing');
				//console.log("Name " + $scope.group.name);
				$scope.obj = groupService.submit($scope.group, function(
						responsedata) {
					if (responsedata.result == "true")
						alert("Submited Successfully...!!!!");
					console.log('sucessfully entered');
				}, function() {
					console.log('sorry error');
				});
			};
		} ]);

Module3.controller("GetAllGroups", [ '$scope', '$resource', 'groupService','userService','$routeParams',
		function($scope, $resource, groupService,userService,$routeParams) {
			console.log("get all groups");
			
			
			if(role == 'admin')		  	
				$(".Contentdone").show();		  	
			else
				$(".Contentdone1").show();
			
			
			groupService.getAll(function(data) {
				console.log("sucessfull");
				$scope.allGroups = data;
				console.log($scope.allGroups.name);

				$scope.changeGroupName = function() {
					//alert("name Changed");
					console.log("name=" + $scope.groupName);
					groupService.search({
						name : $scope.groupName
					}, function(data) {
						$scope.allGroups = data;
						console.log('sucessfully entered');
					}, function() {
						console.log('sorry error');
					});

				};
				
				$scope.changeGroupName = function() {
					//alert("name Changed");
					console.log("name=" + $scope.groupName);
					groupService.search({
						name : $scope.groupName
					}, function(data) {
						$scope.allGroups = data;
						console.log('sucessfully entered');
					}, function() {
						console.log('sorry error');
					});

				};
				
			}, function() {
				console.log("unsucessfull");
			});
				/* remove Group by id */

			$scope.RemoveGroup = function(selected) {
				//alert("remove");
				console.log("In remove user...." + selected.uid);
				groupService.deleteuser({
					id : selected.gid
				}, function(data) {
					console.log('sucessfully entered');
				}, function() {
					console.log('sorry error');
				});
			};
		} ]);
/*======================================== Add group member ========================================*/
/*Module3.controller("AddMembersInGroup", [ 
                                         '$scope',
                                         '$resource',
                                         'userService',
                                         '$routeParams',
             function($scope, $resource,userService,$routeParams){
                              alert("in AddMembersInGroup " + $routeParams.id);    			
                      if(role == 'admin')		  	
                           	$(".Contentdone").show();		  	
                      else
                           	$(".Contentdone1").show();
                           			
                      if ($routeParams.id != null) {
          				console.log("route params");
          				alert("in get all group" + $routeParams.id);
          				userService.getAll({
          					id : $routeParams.id
          				}, function(data) {
          					console.log("sucessfull");
          					$scope.user = data;
          				}, function() {
          					console.log("unsucessfull");
          				});
          			}    			
        } ]);*/
/*======================================== Logout ========================================*/
Module3.controller("logout", [ 
                            '$scope',
                            '$resource',
                            'userService',
                            '$routeParams',
             function($scope, $resource,userService,$routeParams){
              console.log("In logout");
              $(".logout").show();
              if(role == 'admin')
            	  $(".AfterLogin").hide();
              else
            	  $(".AfterUserLogin").hide();
              
           if(role == 'admin')
        	   {
                    $scope.admin.username= " ";
                    $scope.admin.password= " ";
        	   }
           else
                    $scope.user.username=" ";
                    $scope.user.password=" ";
        } ]);