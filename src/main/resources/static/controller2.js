function showGame(){
	$(".hiddenAddCourse").fadeOut(500);
	$(".hiddenScores").fadeOut(500);
	setTimeout(function(){
		$(".hiddenGames").fadeIn(500);
	},500);
}
function showHiddenScores(){
	$(".hiddenGames").fadeOut(500);
	setTimeout(function(){
		$(".hiddenScores").fadeIn(500);
	},500);
}
var app =angular.module('demo', []);
app.controller('AllPage', function($scope, $http) {
	var studentmail=localStorage.getItem("UserMail");
	var studentname=localStorage.getItem("UserName");
	$scope.StudentName=studentname;
	var temp = "http://localhost:8085/Course";
	//$scope.user = temp;
    $http.get(temp).
        then(function(response) {
            $scope.items = response.data;
        });
    
	$scope.showgames=function(){
		showGame();
		var val=$scope.fuck;
		//var studentmail=localStorage.getItem("StudentMail");
		var temp = "http://localhost:8085/Game/Course/"+val;
		//$scope.user = temp;
	    $http.get(temp).
	        then(function(response2) {
	            $scope.games = response2.data;
	            
	        });
	};
	
	$scope.getquestions=function(){
		var type;
		for (var x = 0 ; x < $scope.games.length; x++) {
		    if ($scope.games[x].id==$scope.game) {
		        type=$scope.games[x].type ;
		        break;
		    }
		}
		
		localStorage.setItem("GameNum", $scope.game);
		localStorage.setItem("GameType", type);
		window.location.href="http://localhost:8080/Fuck/Questions.html";
	};
	$scope.getscores=function()
	{
		//alert(studentmail);
		var temp = "http://localhost:8085/Score/Student/"+studentmail;
		//alert(temp);
	    $http.get(temp).
	        then(function(response5){
	            $scope.scores = response5.data;
	            //alert($scope.scores.length);
	        });
		
	}
	$scope.logout=function()
	{
		//$localStorage.$reset();
		window.location.href="http://localhost:8080/Fuck";
	}
	$scope.gohome=function()
	{
		//$localStorage.$reset();
		window.location.href="http://localhost:8080/Fuck/Student.html";
	}
});