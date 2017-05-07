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
function Notification(){
	var pos = $('.notification').css('right');
	if(pos =="0px"){
		/*var notWidth = $(".notification").Width();
		var pos = "-"+notWidth+"px";
		$('.notification').css({'right':pos}); */
		$(".notification").animate({right: '-500px'}); 
	}else{
		$(".notification").animate({right: '0px'}); 
	}
}

var app =angular.module('demo', []);
app.controller('AllPage', function($scope, $http) {
	var studentmail=localStorage.getItem("UserMail");
	var studentname=localStorage.getItem("UserName");
	$scope.StudentName=studentname;
	var temp = "https://fun-planet.herokuapp.com/Course";
    $http.get(temp).
        then(function(response) {
            $scope.items = response.data;
        });
    
    temp2 = "https://fun-planet.herokuapp.com/Notify/"+studentmail;
    $http.get(temp2).
        then(function(response3) {
            $scope.notifications = response3.data;
        });
    $scope.showmycourses=function(){
    	showMyCourses();
    };
	$scope.showgames=function(){
		showGame();
		var val=$scope.selectedcourse;
		var temp = "https://fun-planet.herokuapp.com/Game/Not/Course/"+val;
	    $http.get(temp).
	        then(function(response2) {
	            $scope.games = response2.data;
	        });
	};
	
	$scope.getquestions=function(){
		var gameid=$('input[name=GameID]:checked').val();
		if(gameid==undefined)
		{
			alert("You Must Choose Game First");
		}
		else
			{
				var type;
				for (var x = 0 ; x < $scope.games.length; x++) {
				    if ($scope.games[x].id==$scope.game) {
				        type=$scope.games[x].type ;
				        break;
				    }
			}
			
			localStorage.setItem("GameNum", $scope.game);
			localStorage.setItem("GameType", type);
			window.location.href="https://fun-planet.herokuapp.com/QuestionsPage";
			}

	};
	$scope.getscores=function()
	{
		//alert(studentmail);
		var temp = "https://fun-planet.herokuapp.com/Score/Student/"+studentmail;
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
		window.location.href="https://fun-planet.herokuapp.com";
	}
	$scope.gohome=function()
	{
		//$localStorage.$reset();
		window.location.href="https://fun-planet.herokuapp.com/StudentPage";
	}
});