function ShowTFQuestions(){
	setTimeout(function(){
		$(".TF").fadeIn(500);
	},500);
}
function ShowMSQQuestions(){
	setTimeout(function(){
		$(".MSQ").fadeIn(500);
	},500);
}
var app =angular.module('InsertQuestions', []);
app.controller('AllPage', function($scope,$http) {
	var teachermail=localStorage.getItem("NewGameTeacherID");
	var courseid=localStorage.getItem("NewGameCourseID");
	var gametype=localStorage.getItem("NewGameType");
	var newgamename=localStorage.getItem("NewGameName");
	var newgamedes=localStorage.getItem("NewGameDes");
	var GameID;
    $http.get("http://localhost:8085/Game").
    then(function(response3) {
        $scope.newgames = response3.data;
        for(x=0 ; x < $scope.newgames.length ;x++ )
        {
        	if(($scope.newgames[x].teacherID==teachermail)&&($scope.newgames[x].courseID==courseid)&&($scope.newgames[x].type==gametype)&&($scope.newgames[x].name==newgamename)&&($scope.newgames[x].des==newgamedes))
        	{
        		GameID=$scope.newgames[x].id;
        		break;
        	}            	
       	}
    });
    if(gametype=="tf")
    	{
    	ShowTFQuestions();
    	}else{
    	ShowMSQQuestions();
    	}
    $scope.AddTFQuestion=function(){
    	var ans=$('input[name=anwser]:checked').val();
    	var dataObj = {
    			gameId : GameID,
    			question : $scope.tfquestion,
    			answer : ans
			};
		$http.post('http://localhost:8085/QuestionTF', dataObj);
		alert("Question Added");
    	$scope.tfquestion="";
        var ele = document.getElementsByName("anwser");
        for(var i=0;i<ele.length;i++)
    	      {ele[i].checked = false;}

    };
    $scope.AddMSQQuestion=function(){
    	
    	var dataObj = {
    			gameID : GameID,
    			question : $scope.msqquestion,
    			a : $scope.answera,
    			b : $scope.answerb,
    			c : $scope.answerc,
    			d : $scope.answerd,
    			correct : $scope.correctanswer
			};
    	
		$http.post('http://localhost:8085/QuestionMSQ', dataObj);
		alert("Question Added");
    	$scope.msqquestion="";
    	$scope.answera="";
    	$scope.answerb="";
    	$scope.answerd="";
    	$scope.correctanswer="";
    };
    
$scope.Finish=function(){
	alert("All Questions Added Successfully");
	window.location.href="http://localhost:8080/FunPlanetGui/Teacher.html";
    };
    
});