$(document).ready(function () {
    $('#edit-dvd').hide();
    $('#showDVD').hide();
    $('#CreateDVD').hide();
    $('#search-data').hide();
    $('#').hide();
    loadDVDs();
});

function loadDVDs() {
    $('#contentRows').empty();
    var contentRows = $('#contentRows');
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvds',

        success: function (dvdArray) {
            $.each(dvdArray, function (index, dvd) {
                var dvdId = dvd.dvdId;
                var title = dvd.title;
                var releaseYear = dvd.releaseYear;
                var director = dvd.director;
                var rating = dvd.rating;
                var notes = dvd.notes;
                var row = "<tr>"
                row += '<td><a onclick="showDVD(' + dvdId + ')">' + title + '</a></td>';
                row += "<td>" + releaseYear + "</td>";
                row += "<td>" + director + "</td>";
                row += "<td>" + rating + "</td>";
                row += '<td><a onclick="showEditForm(' + dvdId + ')">Edit</a>';
                row += " | "
                row += '<a onclick="showDeleteForm(' + dvdId + ')">Delete</a></td>';
                row += "</tr>";

                contentRows.append(row);

            });

        },
        error: function () {
            $('#errorMessages').append($("<li>")
                .attr({ class: 'list-group-item List-group.item-danger' })
                .text("Error calling web service. Please try again later."));
        },

    });


}
function showDVD(dvdId) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + dvdId,

        success: function (dvd) {

            var dvdId = dvd.dvdId;
            var title = dvd.title;
            var releaseYear = dvd.releaseYear;
            var director = dvd.director;
            var rating = dvd.rating;
            var notes = dvd.notes;

            $('#show-title').text(title);
            $('#show-release').text(releaseYear);
            $('#show-director').text(director);
            $('#show-rating').text(rating);
            $('#show-notes').text(notes);
            $('#showDVD').show();
            $('#all-top').hide();
        },
        error: function () {
            $('#errorMessages').append($("<li>")
                .attr({ class: 'list-group-item List-group.item-danger' })
                .text("Error calling web service. Please try again later."));
        },
    });
}
function closeViewMenu() {
    $('#showDVD').hide();
    $('#all-top').show();
}
function showEditForm(dvdId) {
    $('#errorMessages').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + dvdId,
        success: function (data, status) {
            var ratingId = $('#' + data.rating).val();
            $('#edit-dvdId').text(dvdId);
            $('#edit-Dvd-title').val(data.title);
            $('#edit-release').val(data.releaseYear);
            $('#edit-director').val(data.director);
            $('#edit-rating-select').val(ratingId).change();
            $('#edit-notes').val(data.notes);
            $('#edit-dvd').show();
            $('#all-top').hide();
        },
        error: function () {
            $('#errorMessages').append($("<li>")
                .attr({ class: 'list-group-item List-group.item-danger' })
                .text("Error calling web service. Please try again later."));
        }
    });
}
function editDVD() {
    $('#errorMessages').empty();

    var title = $('#edit-Dvd-title').val();
    var continueTitle = checkTitle(title);
    if (!(continueTitle)) {
        $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Please Enter a title for the Dvd."));
        return false;
    }

    var releaseYear = $('#edit-release').val();
    var continueRelease = checkYear(releaseYear);

    if (!(continueRelease)) {
        $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Please Enter a 4-digit year."));
        return false;
    }

    var dvdId = $('#edit-dvdId').text();
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/dvd/' + dvdId,
        data: JSON.stringify({
            "dvdId": $('#edit-dvdId').val(),
            "title": $('#edit-Dvd-title').val(),
            "releaseYear": $('#edit-release').val(),
            "director": $('#edit-director').val(),
            "rating": $('#edit-rating-select').val(),
            "notes": $('#edit-notes').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        'dataType': 'json',
        success: function () {
            $('#errorMessage').empty();
            loadDVDs();
            closeEditMenu();
        },
        error: function () {
            $('#errorMessages').append($("<li>")
                .attr({ class: 'list-group-item List-group.item-danger' })
                .text("Error calling web service. Please try again later."));
        },

    });


}
function closeEditMenu() {
    $('#edit-dvd').hide();
    $('#all-top').show();
}
function showCreateForm() {
    $('#CreateDVD').show();
    $('#all-top').hide();
}
function createDVD() {
    $('#errorMessages').empty();

    var title = $('#set-Dvd-title').val();
    var continueTitle = checkTitle(title);
    if (!(continueTitle)) {
        $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Please Enter a title for the Dvd."));
        return false;
    }

    var releaseYear = $('#set-release').val();
    var continueRelease = checkYear(releaseYear);

    if (!(continueRelease)) {
        $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Please Enter a 4-digit year."));
        return false;
    }
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/dvd',
        data: JSON.stringify({
            "title": $('#set-Dvd-title').val(),
            "releaseYear": $('#set-release').val(),
            "director": $('#set-director').val(),
            "rating": $('#set-rating').val(),
            "notes": $('#set-notes').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        'dataType': 'json',
        success: function () {
            $('#errorMessages').empty();
            loadDVDs();
            closeCreateMenu();
        },
        error: function () {
            $('#errorMessages').append($("<li>")
                .attr({ class: 'list-group-item List-group.item-danger' })
                .text("Error calling web service. Please try again later."));
        },
    });

}
function closeCreateMenu() {
    $('#errorMessages').empty();
    $('#set-Dvd-title').val('');
    $('#set-release').val('');
    $('#set-director').val('');
    var ratingId = $('#baseOption').val();
    $('#set-set-rating').val(ratingId).change();
    $('#set-notes').val('');
    $('#CreateDVD').hide();
    $('#all-top').show();
}
function showDeleteForm(dvdId) {
    var wantToDelete = window.confirm("Are you sure you would like to delete this dvd from the library?");
    if (wantToDelete) {
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/dvd/' + dvdId,
            success: function () {
                loadDVDs();
            },
        });
    } else {
        return false;
    }
}
function searchDVD() {
    $('#contentRowsForSearch').empty();
    var contentRows = $('#contentRowsForSearch');
    var searchCategory = $('#search-cat').val();
    var searchedTerm = $('#search-term').val();
    var title = 'Title';
    var release = 'Release Year';
    var director = 'Director';
    var rating = 'Rating';
    if (searchedTerm.length == 0 || searchCategory === null) {
        $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Both Search Category and Search Term are required."));
        return false;
    }

    if (searchCategory == title) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/title/' + searchedTerm,

            success: function (dvdArray) {
                $('#errorMessages').empty();
                if (dvdArray.length == 0 || dvdArray == undefined) {
                    var text = "<tr>"
                    text += "<td> No Results found </td>"
                    text += "</tr>"
                    contentRows.append(text);
                } else {

                    $.each(dvdArray, function (index, dvd) {
                        var title = dvd.title;
                        var releaseYear = dvd.releaseYear;
                        var director = dvd.director;
                        var rating = dvd.rating;
                        var notes = dvd.notes;
                        var row = "<tr>"
                        row += '<td>' + title + '</td>';
                        row += "<td>" + releaseYear + "</td>";
                        row += "<td>" + director + "</td>";
                        row += "<td>" + rating + "</td>";
                        row += "<td>" + notes + "</td>";
                        row += "</tr>";

                        contentRows.append(row);
                    });
                }
                $('#search-data').show();
                $('#all-top').hide();
            },
            error: function () {
                $('#errorMessages').append($("<li>")
                    .attr({ class: 'list-group-item List-group.item-danger' })
                    .text("Error calling web service. Please try again later."));
            },

        });
    }
    if (searchCategory == release) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/year/' + searchedTerm,

            success: function (dvdArray) {
                $('#errorMessages').empty();
                if (dvdArray.length == 0 || dvdArray == undefined) {
                    var text = "<tr>"
                    text += "<td> No Results found </td>"
                    text += "</tr>"
                    contentRows.append(text);
                } else {


                    $.each(dvdArray, function (index, dvd) {
                        var title = dvd.title;
                        var releaseYear = dvd.releaseYear;
                        var director = dvd.director;
                        var rating = dvd.rating;
                        var notes = dvd.notes;
                        var row = "<tr>"
                        row += '<td>' + title + '</td>';
                        row += "<td>" + releaseYear + "</td>";
                        row += "<td>" + director + "</td>";
                        row += "<td>" + rating + "</td>";
                        row += "<td>" + notes + "</td>";
                        row += "</tr>";

                        contentRows.append(row);
                    });
                }
                $('#search-data').show();
                $('#all-top').hide();
            },
            error: function () {
                $('#errorMessages').append($("<li>")
                    .attr({ class: 'list-group-item List-group.item-danger' })
                    .text("Error calling web service. Please try again later."));
            },

        });
    }
    if (searchCategory == director) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/director/' + searchedTerm,

            success: function (dvdArray) {
                $('#errorMessages').empty();
                if (dvdArray.length == 0 || dvdArray == undefined) {
                    var text = "<tr>"
                    text += "<td> No Results found </td>"
                    text += "</tr>"
                    contentRows.append(text);
                } else {
                    $.each(dvdArray, function (index, dvd) {
                        var title = dvd.title;
                        var releaseYear = dvd.releaseYear;
                        var director = dvd.director;
                        var rating = dvd.rating;
                        var notes = dvd.notes;
                        var row = "<tr>"
                        row += '<td>' + title + '</td>';
                        row += "<td>" + releaseYear + "</td>";
                        row += "<td>" + director + "</td>";
                        row += "<td>" + rating + "</td>";
                        row += "<td>" + notes + "</td>";
                        row += "</tr>";

                        contentRows.append(row);
                    });
                }
                $('#search-data').show();
                $('#all-top').hide();
            },
            error: function () {
                $('#errorMessages').append($("<li>")
                    .attr({ class: 'list-group-item List-group.item-danger' })
                    .text("Error calling web service. Please try again later."));
            },

        });
    }
    if (searchCategory == rating) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/rating/' + searchedTerm,

            success: function (dvdArray) {
                $('#errorMessages').empty();
                if (dvdArray.length == 0 || dvdArray == undefined) {
                    var text = "<tr>"
                    text += "<td> No Results found </td>"
                    text += "</tr>"
                    contentRows.append(text);
                } else {
                    $.each(dvdArray, function (index, dvd) {
                        var title = dvd.title;
                        var releaseYear = dvd.releaseYear;
                        var director = dvd.director;
                        var rating = dvd.rating;
                        var notes = dvd.notes;
                        var row = "<tr>"
                        row += '<td class="text-center" >' + title + '</td>';
                        row += "<td>" + releaseYear + "</td>";
                        row += "<td>" + director + "</td>";
                        row += "<td>" + rating + "</td>";
                        row += "<td>" + notes + "</td>";
                        row += "</tr>";

                        contentRows.append(row);
                    });
                }
                $('#search-data').show();
                $('#all-top').hide();
            },
            error: function () {
                $('#errorMessages').append($("<li>")
                    .attr({ class: 'list-group-item List-group.item-danger' })
                    .text("Error calling web service. Please try again later."));
            },

        });
    }
    var ratingId = $('#base').val();
    $('#search-term').val('');
    $('search-cat').val(ratingId).change();

}
function closeSearch() {
    $('#search-data').hide();
    $('#all-top').show();
}
function checkYear(input) {
    if (!(input.length == 4)) {
        return false;
    }
    if (isNaN(input)) {
        return false;
    } else {
        return true;
    }

}
function checkTitle(input) {
    if (input.length == 0) {
        return false;
    } else {
        return true;
    }
}
