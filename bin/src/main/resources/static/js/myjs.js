function signUpButton(){
    $(".backgroundsignUp").fadeOut(500);
	$("body").addClass("greenbackground");
    $(".logIn").fadeOut(500);
    setTimeout(function(){
        $(".backgroundlogIn").fadeIn(500);
        $(".signUp").fadeIn(500);
    },500);
}

function logInButton(){
    $(".backgroundlogIn").fadeOut(500);
	$("body").removeClass("greenbackground");
    $(".signUp").fadeOut(500);
    $(".confirm").fadeOut(500);
    setTimeout(function(){
        $(".backgroundsignUp").fadeIn(500);
        $(".logIn").fadeIn(500);
    },500);
}