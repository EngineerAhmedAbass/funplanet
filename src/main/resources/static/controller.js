function Confirm(){
	$(".signUp").fadeOut(500,function(){
		$(".confirm").fadeIn(500);
	});
}
var app =angular.module('demo', []);
app.controller('home', function($scope, $http){
//    document.getElementById('signupdiv').style.display = "none";
//    document.getElementById('confirmdiv').style.display = "block";
	$scope.GetUser=function(){
	var val2 = document.getElementById("testpass").value;
	var val = document.getElementById("testid").value;
	var temp = "https://fun-planet.herokuapp.com/Teacher/"+val;
    $http.get(temp).
        then(function(response2) {
            $scope.greeting = response2.data;
            if($scope.greeting.pass==val2)
            {
            	window.alert("Loging  As " +$scope.greeting.name);
            	localStorage.setItem("UserMail", $scope.greeting.email);
            	localStorage.setItem("UserName", $scope.greeting.name);
            	localStorage.setItem("UserType","Teacher");
            	window.location.href="https://fun-planet.herokuapp.com/TeacherPage";
            }
            else{
            	temp = "https://fun-planet.herokuapp.com/Student/"+val;
            	$http.get(temp).
                then(function(response3) {
                	$scope.greeting2 = response3.data;
                    if($scope.greeting2.password==val2)
                    {
                    	window.alert("Loging  As " +$scope.greeting2.name);
                    	localStorage.setItem("UserMail", $scope.greeting2.email);
                    	localStorage.setItem("UserName", $scope.greeting2.name);
                    	localStorage.setItem("UserType","Student");
                    	window.location.href="https://fun-planet.herokuapp.com/StudentPage";
                    }
                    else{
                    	window.alert("The Email or Password Is Incorrect");
                    	window.location.reload();
                    }
                	
                })

            }
        });
    };
	$scope.sendcode=function(){
		var mail =document.getElementById("usermail").value;	
		var tem="https://fun-planet.herokuapp.com/Teacher/"+mail;
		$http.get(tem).
        then(function(response4) {
        	var testuser=response4.data;
        	if(testuser.name!=undefined)
        	{
        		alert("This Email Is Already Used, Try With Another Email ");
        		window.location.reload();
        	}
        	
        })
        
		tem="https://fun-planet.herokuapp.com/Student/"+mail;
		$http.get(tem).
        then(function(response5) {
        	var testuser=response5.data;
        	if(testuser.name!=undefined)
        	{
        		alert("This Email Is Already Used, Try With Another Email ");
        		window.location.reload();
        	}
        })
       var Code=Math.floor((Math.random() * 123456789) + 123456);
       //var Code=123456;
       localStorage.setItem("Code",Code);
  	   var val=document.getElementById("usermail").value ;
  	   var temp = "https://fun-planet.herokuapp.com/Signip/"+Code+"/"+val;
       $http.get(temp).
            then(function(response3) {
           	 	//Confirm();
             })
		
	};
	$scope.SendStudent=function(){
		var code=localStorage.getItem("Code");
		var Entered=document.getElementById("enteredcode").value;
		if(code==Entered){
			var type =$('input[name=Type]:checked').val();
			if(type=="Student"){
				var sname =document.getElementById("username").value;
				var spassword =document.getElementById("userpassword").value;
				var sphone =document.getElementById("userphone").value;
				var sage =document.getElementById("userage").value;
				var semail =document.getElementById("usermail").value;
				if(semail==undefined){
					alert("Email is Wrong");
				}else{
					var dataObj = {
							name : sname,
							password : spassword,
							phone : sphone,
							age : sage,
							email : semail
					};
					var res = $http.post('https://fun-planet.herokuapp.com/Student', dataObj);
					alert("Successfully Registerd ");
					window.location.reload();
				}
}else
	{
		var tname =document.getElementById("username").value;
		var tpassword =document.getElementById("userpassword").value;
		var tphone =document.getElementById("userphone").value;
		var tage =document.getElementById("userage").value;
		var temail =document.getElementById("usermail").value;
		if(temail==undefined){
			alert("Email is Wrong");
		}else{
		var dataObj = {
				name : tname,
				pass : tpassword,
				phone : tphone,
				age : tage,
				email : temail
			};
		$http.post('https://fun-planet.herokuapp.com/Teacher', dataObj);
		alert("Successfully Registerd ");
		window.location.reload();
		
	}}
	}
		else{
			alert("Enter Correct Code");
		}
    };
});
