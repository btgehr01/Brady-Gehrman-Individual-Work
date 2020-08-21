$(document).ready(function () {
    $('#current-conditions').hide();
    $('#five-day-forecast').hide();
    $('#again-btn').hide();
    $('#again-btn').on('click', function () {
        $('#current-conditions').hide();
        $('#five-day-forecast').hide();
        $('#again-btn').hide();
        $('#get-info').show();
    })
    $('#show-weather-button').on('click', function () {
        var not5 = checkZipcode($('#enter-zip').val());
        if (not5) {
            $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Zip code: please enter a 5-digit zip code"));
            return false;
        }
        $('#errorMessages').empty();
        var zip = $('#enter-zip').val();
        var units = $('select').val();
        $.ajax({
            type: 'GET',
            url: 'http://api.openweathermap.org/data/2.5/weather?zip=' + zip + ',us&units=' + units + '&APPID=e5f868afacdd717ec3146133a9c433f6',
            success: function (data, status) {
                var temp = data.main.temp;
                var highTemp = data.main.temp_max;
                var lowTemp = data.main.temp_min;
                var humidity = data.main.humidity;
                var wind = data.wind.speed;
                var description = data.weather[0].description;
                var iconID = data.weather[0].icon;
                var cityName = data.name;

                console.log(temp);
                console.log(highTemp);
                console.log(lowTemp);
                console.log(humidity);
                console.log(description);
                console.log(iconID);
                console.log(cityName);
                console.log(wind);


                if (units == "Imperial") {
                    $('#Temp-Data').text(temp + '°F');
                    $('#High-Data').text(highTemp + '°F');
                    $('#Low-Data').text(lowTemp + '°F');
                } else {
                    $('#Temp-Data').text(temp + '°C');
                    $('#High-Data').text(highTemp + '°C');
                    $('#Low-Data').text(lowTemp + '°C');
                }
                $('#Humidity-Data').text(humidity + "%");
                if (units == "Imperial") {
                    $('#Wind-Data').text(wind + " mph");
                } else {
                    $('#Wind-Data').text(wind + " kmph");
                }
                $('#current-city').text("Current Conditions in " + cityName);
                $('#des').empty();
                $('#des').append("Description: " + description);
                var imageURL = "http://openweathermap.org/img/w/" + iconID + ".png";
                $("#icon").attr("src", imageURL);
                $.ajax({
                    type: 'GET',
                    url: 'https://api.openweathermap.org/data/2.5/forecast?zip=' + zip + ',us&cnt=40&units=' + units + '&APPID=27f8f18c88f3f26338f1eb28a342d1c0',
                    success: function (data, status) {
                        var dateNum = 0;
                        $.each(data.list, function (index, day) {
                            var dayDate = day.dt_txt;
                            console.log(dayDate);
                            if (dayDate.includes("12:00:00")) {
                                dateNum = dateNum + 1;
                                var oneDate = dayDate.split(" ");
                                if (units == "Imperial") {
                                    $('#hdata' + dateNum).text(day.main.temp_max + "°F");
                                    $('#ldata' + dateNum).text(day.main.temp_min + "°F");
                                } else {
                                    $('#hdata' + dateNum).text(day.main.temp_max + "°C");
                                    $('#ldata' + dateNum).text(day.main.temp_min + "°C");
                                }
                                $('#h' + dateNum).text(oneDate[0]);
                                $('#des' + dateNum).text(day.weather[0].description);
                                var iconURL = "http://openweathermap.org/img/w/" + day.weather[0].icon + ".png";
                                $('#icon' + dateNum).attr("src", iconURL);

                            }
                        });

                    },
                    error: function () {
                        $('#errorMessages').append($("<li>")
                            .attr({ class: 'list-group-item List-group.item-danger' })
                            .text("Error calling web service. Please try again later."));
                    },
                });
                $('#current-conditions').show();
                $('#five-day-forecast').show();
                $('#again-btn').show();
                $('#get-info').hide();
            },
            error: function () {
                $('#errorMessages').append($("<li>")
                    .attr({ class: 'list-group-item List-group.item-danger' })
                    .text("Error calling web service. Please try again later."));

            },
        });
    });
    function checkZipcode(input) {
        $('#errorMessages').empty();
        var length = input.toString().length;
        if (length != 5) {
            return true;
        } else {
            return false;
        }

    }
});
