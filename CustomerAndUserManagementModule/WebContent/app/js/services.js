/*-----------------------Client----------------------------------------------*/
Module3.service('clientService', function($resource) {
	//alert("in Service");
    return $resource('', {}, {
    	getAllClients:{method:'GET' , isArray:true , url:'http://localhost:8080/CustomerAndUserManagementModule/rest/client'},
        submitDetails: {method:'POST', url:'http://localhost:8080/CustomerAndUserManagementModule/rest/client/add'},
        searchByName: {method:'GET',params:{name:"@name"},isArray:true , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/client/search'+'/:name'},
        deleteClient:{method:'GET',params:{id:"@id"} , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/client/remove'+'/:id'},
        searchById:{method:'GET', params:{id:"@id"},url:'http://localhost:8080/CustomerAndUserManagementModule/rest/client/searchbyid'+'/:id'},
       });
});

/*-----------------------User----------------------------------------------*/
Module3.service('userService', function($resource) {
	//alert("in Service");
    return $resource('', {}, {
    	get:{method:'GET',params:{id:"@id"}, url:'http://localhost:8080/CustomerAndUserManagementModule/rest/user'+"/:id"},
    	getAll:{method:'GET',isArray:true , url:'http://localhost:8080/CustomerAndUserManagementModule/rest/user'},
    	submit: {method:'POST', url:'http://localhost:8080/CustomerAndUserManagementModule/rest/user/add'},
    	search: {method:'GET',params:{name:"@name"},isArray:true , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/user/search'+'/:name'},
    	deleteuser:{method:'GET',params:{id:"@id"} , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/user/remove'+'/:id'},
    	adminlogin: {method:'POST', url:'http://localhost:8080/CustomerAndUserManagementModule/rest/admin/login'},
    	userlogin: {method:'POST', url:'http://localhost:8080/CustomerAndUserManagementModule/rest/user/login'}
    });
});


/*-----------------------Group----------------------------------------------*/


Module3.service('groupService', function($resource) {
	//alert("in Group Service");
    return $resource('', {}, {
    	get:{method:'GET',params:{id:"@id"}, url:'http://localhost:8080/CustomerAndUserManagementModule/rest/group'+"/:id"},
    	getAll:{method:'GET' , isArray:true , url:'http://localhost:8080/CustomerAndUserManagementModule/rest/group'},
    	submit: {method:'POST', url:'http://localhost:8080/CustomerAndUserManagementModule/rest/group/add'},
    	search: {method:'GET',params:{name:"@name"},isArray:true , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/group/search'+'/:name'},
    	deleteuser:{method:'GET',params:{id:"@id"} , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/group/remove'+'/:id'},
    	getAllmembers:{method:'GET',params:{id:"@id"},isArray:true , url: 'http://localhost:8080/CustomerAndUserManagementModule/rest/group/getallmembers'+'/:id'}
    
    });
});
