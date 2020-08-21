$(document).ready(function () {
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();

    $('#mainButton').click(function () {
        $('#mainInfoDiv').show();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });
    $('#akronButton').click(function () {
        $('#akronWeather').hide();
        $('#akronInfoDiv').show();
        $('#mainInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });
    $('#minneapolisButton').click(function () {
        $('#minneapolisWeather').hide();
        $('#akronInfoDiv').hide();
        $('#mainInfoDiv').hide();
        $('#minneapolisInfoDiv').show();
        $('#louisvilleInfoDiv').hide();
    });
    $('#louisvilleButton').click(function () {
        $('#louisvilleWeather').hide();
        $('#akronInfoDiv').hide();
        $('#mainInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').show();
    });
    $('#akronWeatherButton').click(function () {
        $('#akronWeather').toggle();
    });
    $('#minneapolisWeatherButton').click(function () {
        $('#minneapolisWeather').toggle();
    });
    $('#louisvilleWeatherButton').click(function () {
        $('#louisvilleWeather').toggle();
    });

    // $('td').on('hover', function(){
    // })

    $('td').hover(function () {
        $(this).parent().css("background-color", "WhiteSmoke");

    },
        function () {

        $(this).parent().css("background-color", "");

        });

});