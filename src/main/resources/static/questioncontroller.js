function ShowTFQuestions(){
	setTimeout(function(){
		$(".tf").fadeIn(500);
	},500);
}
function ShowMSQQuestions(){
	setTimeout(function(){
		$(".msq").fadeIn(500);
	},500);
}
function showComment(){
	$("tf").fadeOut(500);
	$("msq").fadeOut(500);
	setTimeout(function(){
		$(".comment").fadeIn(500);
	},500);
}
var app =angular.module('demo', []);
app.controller('AllPage', function($scope, $http, $timeout) {
	var gameid  =localStorage.getItem("GameNum");
	var gametype=localStorage.getItem("GameType");
	var usermail=localStorage.getItem("UserMail");
	var usertype=localStorage.getItem("UserType");
	var username=localStorage.getItem("UserName");
	var gamenamee="";
	var tempp="http://localhost:8080/Game2/Name/"+gameid;
	//alert("game ID is "+ tempp);
	$http.get(tempp).
		then(function(response1) {
			$scope.shit=response1.data;
		//alert("Game Name Is "+$scope.shit.name);
		gamenamee=$scope.shit.name;
	});
	if(gametype=="tf"){
		ShowTFQuestions();
		var temp = "http://localhost:8080/Questions/TF/"+gameid;
	    $http.get(temp).
	        then(function(response2) {
	            $scope.questions = response2.data;
	            //$timeout($scope.submittf,1252145120000);
	        });
		
	}else{
		ShowMSQQuestions();
		var temp = "http://localhost:8080/Questions/MSQ/"+gameid;
	    $http.get(temp).
	        then(function(response3) {
	            $scope.msqquestions = response3.data;
	        });
	}
	
    $scope.submittf=function(){
    	var number=0;
    	for(i = 0; i < $scope.questions.length; i++){
    		var id=$scope.questions[i].id;
    		var radios = document.getElementsByName(id);
    		var answer;
    		for (var x = 0, length = radios.length; x < length; x++) {
    		    if (radios[x].checked) {
    		        answer=radios[x].value;
    		        break;
    		    }
    		}
    		
    		if($scope.questions[i].answer==answer)
    		{
    			number=number+1;

    		}
    	}
    	//alert("The Score IS "+number+" Out Of "+$scope.questions.length);
    	var score=(number/$scope.questions.length)*100;
		var dataObj = {
				sId : usermail,
				gId : gameid,
				val : score,
				gamename :gamenamee
		};
		var res = $http.post('http://localhost:8080/Score', dataObj);
		showComment();
    	
    };
    $scope.submitmsq=function(){
    	var number=0;
    	for(i = 0; i < $scope.msqquestions.length; i++){
    		var id=$scope.msqquestions[i].id;
    		var radios = document.getElementsByName(id);
    		var answer;
    		for (var x = 0, length = radios.length; x < length; x++) {
    		    if (radios[x].checked) {
    		        answer=radios[x].value;
    		        break;
    		    }
    		}
    		
    		if($scope.msqquestions[i].correct==answer)
    		{
    			number=number+1;

    		}
    	}
    	alert("The Score IS "+number+" Of "+$scope.msqquestions.length);
    	var score=(number/$scope.msqquestions.length)*100;
    	
		var dataObj = {
				sid : usermail,
				gid : gameid,
				val : score,
				gamename : gamenamee
		};
		var res = $http.post('http://localhost:8080/Score', dataObj);
		showComment();
    };
	$scope.submitcomment=function(){
		var comment=$scope.commentvalue;
		alert(comment);
		var dataObj2 = {
				gName : gamenamee,
				sName : username,
				gId : gameid,
				tId : usermail,
				value : comment
		};
		var res2 = $http.post('http://localhost:8080/Comment', dataObj2);
		if(usertype=="Teacher"){
			window.location.href="http://localhost:8080/TeacherPage";
		}else{
			window.location.href="http://localhost:8080/StudentPage";
		}
	};
	$scope.submit=function(){
		if(usertype=="Teacher"){
			window.location.href="http://localhost:8080/TeacherPage";
		}else{
			window.location.href="http://localhost:8080/StudentPage";
		}
	};
});