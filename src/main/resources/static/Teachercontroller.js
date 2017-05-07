function showGame(){
	$(".hiddenAddCourse").fadeOut(500);
	$(".hiddenAddGame").fadeOut(500);
	$(".copygame").fadeOut(500);
	$(".assesstant").fadeOut(500);
	$(".cancelation").fadeOut(500);
	setTimeout(function(){
		$(".hiddenGames").fadeIn(500);
	},500);
}
function showCollaborator(){
	$(".hiddenAddCourse").fadeOut(500);
	$(".hiddenAddGame").fadeOut(500);
	$(".copygame").fadeOut(500);
	$(".hiddenGames").fadeOut(500);
	$(".cancelation").fadeOut(500);
	setTimeout(function(){
		$(".assesstant").fadeIn(500);
	},500);
}
function stealGame(){
	$(".hiddenAddCourse").fadeOut(500);
	$(".hiddenAddGame").fadeOut(500);
	$(".assesstant").fadeOut(500);
	$(".hiddenGames").fadeOut(500);
	$(".cancelation").fadeOut(500);
	setTimeout(function(){
		$(".copygame").fadeIn(500);
	},500);
}
function showMyCourses(){
	$(".allCourses").fadeOut(500,function(){
		$(".Courses").fadeIn(500);
	});
}
function showAddGame(){
	$(".hiddenAddCourse").fadeOut(500);
	$(".hiddenGames").fadeOut(500);
	$(".copygame").fadeOut(500);
	$(".assesstant").fadeOut(500);
	$(".cancelation").fadeOut(500);
	setTimeout(function(){
		$(".hiddenAddGame").fadeIn(500);
	},500);
}function showAddCourse(){
	$(".hiddenAddGame").fadeOut(500);
	$(".hiddenGames").fadeOut(500);
	$(".copygame").fadeOut(500);
	$(".assesstant").fadeOut(500);
	$(".cancelation").fadeOut(500);
	setTimeout(function(){
		$(".hiddenAddCourse").fadeIn(500);
	},500);
}function showAllCourses(){
	$(".Courses").fadeOut(500,function(){
		$(".allCourses").fadeIn(500);
	});
}function Notification(){
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
function cancelOrReleaseGame(){
	$(".hiddenAddGame").fadeOut(500);
	$(".hiddenGames").fadeOut(500);
	$(".copygame").fadeOut(500);
	$(".assesstant").fadeOut(500);
	$(".hiddenAddCourse").fadeOut(500);
	setTimeout(function(){
		$(".cancelation").fadeIn(500);
	},500);
}
var app =angular.module('teach', []);
app.controller('AllPage', function($scope,$http) {
	var teachermail=localStorage.getItem("UserMail");
	var teachername=localStorage.getItem("UserName");
	$scope.TeacherName=teachername;
	var temp = "https://fun-planet.herokuapp.com/Course/Teacher/Not/"+teachermail;
    $http.get(temp).
        then(function(response) {
            $scope.items = response.data;
        });
    temp = "https://fun-planet.herokuapp.com/Course/Teacher/"+teachermail;
    $http.get(temp).
        then(function(response2) {
            $scope.courses = response2.data;
        });
	
	temp = "https://fun-planet.herokuapp.com/Games/Teacher/"+teachermail;
    $http.get(temp).
        then(function(response3) {
            $scope.notmygames = response3.data;
        });
    $scope.showmycourses=function(){
    	showMyCourses();
    };
	
	temp = "https://fun-planet.herokuapp.com/Comment/"+teachermail;
    $http.get(temp).
        then(function(response4) {
            $scope.notifications = response4.data;
        });
	
	temp = "https://fun-planet.herokuapp.com/Game/Teacher/"+teachermail;
    $http.get(temp).
        then(function(response5) {
            $scope.mygames = response5.data;
        });
	
	temp = "https://fun-planet.herokuapp.com/Teacher/One/"+teachermail;
    $http.get(temp).
        then(function(response6) {
            $scope.collaborators = response6.data;
        });
	
	temp = "https://fun-planet.herokuapp.com/Game/Teacher/Canceled/"+teachermail;
    $http.get(temp).
        then(function(response7) {
            $scope.canceledgames = response7.data;
        });
	
	temp = "https://fun-planet.herokuapp.com/Game/Teacher/Availabe/"+teachermail;
    $http.get(temp).
        then(function(response8) {
            $scope.availablegames = response8.data;
        });
	
    $scope.showmycourses=function(){
    	showMyCourses();
    };
	
    $scope.showgames=function(){
		showGame();
		var val=$scope.selectedcourse;
		var temp = "https://fun-planet.herokuapp.com/Game/Course/"+val;
	    $http.get(temp).
	        then(function(response2) {
	            $scope.games = response2.data;
	            
	        });
	};
	$scope.showmygames=function(){
		showGame();
		var val=$scope.mycourse;
		var temp = "https://fun-planet.herokuapp.com/Game/Course/"+val;
	    $http.get(temp).
	        then(function(response2) {
	            $scope.games = response2.data;
	            
	        });
	};
	$scope.stealgame=function(){
		var val1=$scope.stolencourse;
		var val2=$scope.notmygameid;
		//var studentmail=localStorage.getItem("StudentMail");
		var temp = "https://fun-planet.herokuapp.com/CopyGame/"+val2+"/"+val1+"/"+teachermail;
		alert(temp);
	    $http.get(temp).
	        then(function(response5) {
	            alert("The Game Stolen Successfully");
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
		window.location.href="https://fun-planet.herokuapp.com/QuestionsPage";
	};
	$scope.createcourse=function(){
		
		if($scope.courseage==undefined ){
			alert("Course Age Cannot be Null");
		}else if ($scope.coursename==undefined ){
			alert("Course Name Cannot be Null");
		}else if($scope.coursedes==undefined){
			alert("Course description Cannot be Null");
		}else{
			var dataObj = {
				teacherId : teachermail,
				age : $scope.courseage,
				name : $scope.coursename,
				des : $scope.coursedes
			};
			$http.post('https://fun-planet.herokuapp.com/Course', dataObj);
			alert("Successfully Added Course ");
			window.location.reload();
		}
	};
$scope.CreateGame=function(){
		var courseid=$('input[name=choosencourse]:checked').val();
		var gametype=$('input[name=chossengameType]:checked').val();
		if($scope.newgamename==undefined ){
			alert("Game Name Cannot be Null");
		}else if (courseid==undefined ){
			alert("You Must Choose Course For Game");
		}else if($scope.newgamedes==undefined){
			alert("Game description Cannot be Null");
		}else if(gametype==undefined){
			alert("You Must Choose The Type Of The Game");
		}else{
			var dataObj = {
					teacherID : teachermail,
					courseID : courseid,
					type : gametype,
					state:"True",
					name : $scope.newgamename,
					des : $scope.newgamedes
				};
			$http.post('https://fun-planet.herokuapp.com/Game', dataObj);
			
			localStorage.setItem("NewGameTeacherID", teachermail);
			localStorage.setItem("NewGameCourseID", courseid);
			localStorage.setItem("NewGameType", gametype);
			localStorage.setItem("NewGameName", $scope.newgamename);
			localStorage.setItem("NewGameDes", $scope.newgamedes);
			window.location.href="https://fun-planet.herokuapp.com/NewQuestionsPage";
		}
	};
	$scope.addcollaborator=function()
	{
		//var teacher=$scope.collaboratorid;
		var teacher=$('input[name=collaboratormail]:checked').val();
		var game=$scope.mygame;
		alert(teacher+" "+game);
		var dataObj4 = {
				tId : teacher,
				gId : game
			};
		$http.post('https://fun-planet.herokuapp.com/Collaborator', dataObj4);
		window.location.reload();
	};
	$scope.cancelgame=function()
	{
		var canceledgame=$scope.availablegameid;
	    temp = "https://fun-planet.herokuapp.com/Game/Cancel/"+canceledgame;
		$http.get(temp).
			then(function(response2) {
			alert("Game Successfully Canceled");
			window.location.reload();
			});
		
	}
	$scope.uncancelgame=function()
	{
		var uncanceledgame=$scope.canceledgameid;
	    temp = "https://fun-planet.herokuapp.com/Game/UnCancel/"+uncanceledgame;
		$http.get(temp).
			then(function(response2) {
			alert("Game Successfully UnCanceled");
			window.location.reload();
			});
		
	}
	$scope.gohome=function()
	{
		window.location.reload();
	};
	$scope.logout=function()
	{
		window.location.href="https://fun-planet.herokuapp.com";
	};
	
});
