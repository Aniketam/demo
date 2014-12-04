
function validateForm(){
	
	return(validateName()&&validateContact()
			&&validateEmail()
			&&validateAddress()
			&&validateDesc()
			&&validatePresence()
			&&validateCTO()
			&&validateDomain()
			&&validateCEO()
			&&validateStatus()
			&&validateOffice()
			&&validateEmp()
			&&validateRevenue()
	);
}

function validateName(){
	
	var inputName=document.getElementById("name");
	var errorTag=document.getElementById("name"+"Error");
	var name=document.forms["clientForm"]["name"].value;
	var namereg=/^[A-Za-z ]{4,20}$/;
	if (name==""||name==null) {
		inputName.focus();
		var errmsg="please enter name";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	 if(!(namereg.test(name))){ 
		 inputName.value=""; 
		var errmsg= "name must be start with letter and min 4 and max 20 char"; 
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	 else{
		 var errmsg="";
		 showError(inputName,errorTag,errmsg);
		 return true;
	 }
}
	



	function validateContact(){
			
			var inputName=document.getElementById("contact");
			var errorTag=document.getElementById("contact"+"Error");
			var contact=document.forms["clientForm"]["contact"].value;
			var contactreg=/^[0-9 ]{10,10}$/;
			
			if (contact==""||contact==null) {
				inputName.focus();
				var errmsg="please enter contact number";
				showError(inputName,errorTag,errmsg);
				return false; 
				}
			 if(!(contactreg.test(contact))){ 
				 inputName.value=""; 
				var errmsg= "contact  must be number and must be 10 digit"; 
				showError(inputName,errorTag,errmsg);
				return false; 
				}
			 else{
				 var errmsg="";
				 showError(inputName,errorTag,errmsg); 
				 return true;
			 }
	 
}
	
	
	
	
function validateEmail(){
	var errmsg="";
	var inputName=document.getElementById("email");
	var errorTag=document.getElementById("email"+"Error");
	var email=document.forms["clientForm"]["email"].value;
	var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
	
	if (email==""||email==null) {
		inputName.focus();
		errmsg="please enter your email";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	 if(!(emailRegex.test(email))){ 
		 inputName.value=""; 
		 errmsg= "please enter your valid email address"; 
		showError(inputName,errorTag,errmsg);
		return false; 
	 }
		 showError(inputName,errorTag,errmsg);
		 return true;
	 
}

function validateAddress(){
	var inputName=document.getElementById("address");
	var errorTag=document.getElementById("address"+"Error");
	var address=document.forms["clientForm"]["address"].value;
	if (address==""||address==null) {
		inputName.focus();
		var errmsg="please enter address";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	else{
		var errmsg="";
		showError(inputName,errorTag,errmsg);
		return true;
	}
}

function validateDesc(){
	var inputName=document.getElementById("desc");
	var errorTag=document.getElementById("desc"+"Error");
	var desc=document.forms["clientForm"]["desc"].value;
	if (desc==""||desc==null) {
		inputName.focus();
		var errmsg="please enter address";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	else{
		var errmsg="";
		showError(inputName,errorTag,errmsg);
		return true;
	}
}
	
	function validatePresence(){
		var inputName=document.getElementById("presence");
		var errorTag=document.getElementById("presence"+"Error");
		var presence=document.forms["clientForm"]["presence"].value;
		if (presence==""||presence==null) {
			inputName.focus();
			var errmsg="please enter Presence";
			showError(inputName,errorTag,errmsg);
			return false; 
			}
		else{
			var errmsg="";
			showError(inputName,errorTag,errmsg);
			return true;
		}
	}
		
		function validateCTO(){
			var inputName=document.getElementById("cto");
			var errorTag=document.getElementById("cto"+"Error");
			var cto=document.forms["clientForm"]["cto"].value;
			if (cto==""||cto==null) {
				inputName.focus();
				var errmsg="please enter cto";
				showError(inputName,errorTag,errmsg);
				return false; 
				}
			else{
				var errmsg="";
				showError(inputName,errorTag,errmsg);
				return true;
			}
		}
		
		
		function validateCEO(){
			var inputName=document.getElementById("ceo");
			var errorTag=document.getElementById("ceo"+"Error");
			var ceo=document.forms["clientForm"]["ceo"].value;
			if (ceo==""||ceo==null) {
				inputName.focus();
				var errmsg="please enter ceo";
				showError(inputName,errorTag,errmsg);
				return false; 
				}
			else{
				var errmsg="";
				showError(inputName,errorTag,errmsg);
				return true;
			}
		}
		
		
			
 
	function validateDomain(){
		var inputName=document.getElementById("domain");
		var errorTag=document.getElementById("domain"+"Error");
		var domain=document.forms["clientForm"]["domain"].value;
		if (domain==""||domain==null) {
			inputName.focus();
			var errmsg="please select domain";
			showError(inputName,errorTag,errmsg);
			return false; 
			}
		else{
			var errmsg="";
			showError(inputName,errorTag,errmsg);
		}
		
	}
	
	function validateStatus(){
		var inputName=document.getElementById("status");
		var errorTag=document.getElementById("status"+"Error");
		var status=document.forms["clientForm"]["status"].value;
		if (status==""||status==null) {
			inputName.focus();
			var errmsg="please select status";
			showError(inputName,errorTag,errmsg);
			return false; 
			}
		else{
			var errmsg="";
			showError(inputName,errorTag,errmsg);
		}
		
	}
	
	function validateOffice(){
		var inputName=document.getElementById("office");
		var errorTag=document.getElementById("office"+"Error");
		var office=document.forms["clientForm"]["office"].value;
		if (office==""||office==null) {
			inputName.focus();
			var errmsg="please Enter office";
			showError(inputName,errorTag,errmsg);
			return false; 
			}
		else{
			var errmsg="";
			showError(inputName,errorTag,errmsg);
		}
		
	}
	
	
	
	
	
  function validateEmp(){
	var inputName=document.getElementById("emp");
	var errorTag=document.getElementById("emp"+"Error");
	var emp=document.forms["clientForm"]["emp"].value;
	if (emp==""||emp==null) {
		inputName.focus();
		var errmsg="please enter employees";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	else if(isNaN(emp)){
		inputName.focus();
		var errmsg="please enter valid employees. it must be number";
		showError(inputName,errorTag,errmsg);
		return false; 
	}
	else{
		var errmsg="";
		showError(inputName,errorTag,errmsg);
		return true;
	}
	 
	 
}
  
  
  
  
function validateRevenue(){
	
	var inputName=document.getElementById("revenue");
	var errorTag=document.getElementById("revenue"+"Error");
	var revenue=document.forms["clientForm"]["revenue"].value;
	if (revenue==""||revenue==null) {
		inputName.focus();
		var errmsg="please enter company revenue";
		showError(inputName,errorTag,errmsg);
		return false; 
		}
	else if(isNaN(revenue)){
		inputName.focus();
		var errmsg="please enter valid revenue it must be number";
		showError(inputName,errorTag,errmsg);
		return false; 
	}
	else
	{
		var errmsg="";
		showError(inputName,errorTag,errmsg);
		return true;
	}
	 
	 
}

function showError(inputName,errorTag,errmsg){
		inputName.focus();
		errorTag.innerHTML=errmsg;
}

/*================Shakeeb==============*/
var status;
function startup() 
{
	status="";	
}
function nameValidate() 
{
	var name=document.forms["loginform"]["username"].value;
	if (name == "")
	{
		status="";
		 document.getElementById("errorBox").innerHTML = "field should not be empty";
		 /*document.getElementsByName("username")[0].style.background= "red";*/
		 return false;
	}
	else
		{
		status="full";
		}
}
function passwordValidate() 
{
	var password = document.forms["loginform"]["password"].value;
	if(password == "") 
	{ 
		status="";
		document.getElementById("errorBox1").innerHTML = "field should not be empty";
		return false; 
	}
	else
	{
	status="full";
	}
	
}
function submitvalidate() 
{
	
	if(status==="")
		{
		/*alert("fill the mandatory fields");*/
		return false;
		}
	return true;
}
		