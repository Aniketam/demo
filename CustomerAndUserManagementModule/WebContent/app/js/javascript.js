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
