$(document).ready(function () {
    $('h1').addClass('text-center');
    $('h2').addClass('text-center');
    $('#yellowHeading').text('Yellow Team');
    $('#orangeTeamList').css("background-color", "orange");
    $('#blueTeamList').css("background-color", "blue");
    $('#redTeamList').css("background-color" , "red");
    $('#yellowTeamList').css("background-color", "yellow");
    $('#yellowTeamList').append('<li>Simon Jones</li>');
    $('#yellowTeamList').append('<li>Joseph Banks</li>');
    $('#oops').hide();
    $('#footerPlaceholder').remove();
    $('#footer').append('p').text('Name: Brady Gehrman Email: bradygehrman@gmail.com').addClass('text-center').css("font-family", "courier").css("font-size", 24);

    $('.myBannerHeading').remove();
    $('.well').append('<h1 class="page-header">Team Up!</h1>');
    $('.page-header').addClass('text-center');

    $('#orangeHeading').hover(function(){
        $(this).css('color', 'orange');
    },
    function(){
        $(this).css('color', '');
    });
    $('#blueHeading').hover(function(){
        $(this).css('color', 'blue');
    },
    function(){
        $(this).css('color', '');
    });
    $('#redHeading').hover(function(){
        $(this).css('color', 'red');
    },
    function(){
        $(this).css('color', '');
    });
    $('#yellowHeading').hover(function(){
        $(this).css('color', 'yellow');
    },
    function(){
        $(this).css('color', '');
    });
});