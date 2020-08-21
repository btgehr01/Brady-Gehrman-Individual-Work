$(document).ready(function () {

    loadItems();

});

function loadItems() {

    $('#errorMessages').empty();

    clearItems();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (itemArray) {

            var nameOfDiv = $('#allItems');

            var length = itemArray.length;

            var numNotDone = length;

            var count = 2;

            while (numNotDone > 0) {

                //3,2,1
                //6,5,4
                //9,8,7
                //12,11,10

                var block = '';

                var id = itemArray[count].id;
                var name = itemArray[count].name;
                var price = itemArray[count].price;
                var quantity = itemArray[count].quantity;

                if ((count + 1) / 3 % 1 == 0) {
                    block += '<div id= row' + (count + 1) / 3 + '>'; //2,5,8,11
                }

                block += '<div class="thirty" style="border: 2px solid" id="' + count + '" onclick= showItem(' + id + ')';
                block += '<p>' + id + '</p>';
                block += '<p class="text-center">' + name + '</p>';
                block += '<p class="text-center">$' + price + '</p>';
                block += '<br></br>';
                block += ' <p class="text-center">Quantity Left: ' + quantity + '</p>';
                block += '</div>';

                if (count % 3 == 0) { //0,3,6,9,12
                    block += '</div>';
                    block += '<br></br>'
                    count = count + 5;
                } else {
                    count = count - 1;
                }
                numNotDone = numNotDone - 1;
                nameOfDiv.append(block);
            }
        },
        error: function () {
            $('#errorMessages').append($("<li>")
            .attr({ class: 'list-group-item List-group.item-danger' })
            .text("Error calling web service. Please try again later."));
        },

    });

}
function clearItems() {
    $('#allItems').empty();
}
function addMoney(amount) {
    var moneyToAdd = parseFloat(amount);

    var moneyIn = parseFloat($('#money-in').val());

    var moneyOut = parseFloat(moneyIn + moneyToAdd);

    moneyOut = moneyOut.toFixed(2);

    $('#money-in').val(moneyOut);
}
function showItem(id) {
    $('#item-number').val(id);
}
function makePurchase() {
    var moneyIn = $('#money-in').val();
    var itemID = $('#item-number').val();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/money/' + moneyIn + '/item/' + itemID + '/',
        success: function (object) {
            $('#money-in').val('0.00');
            var change = "";
            var message = 'Thank You!!!'
            if (object.quarters > 0) {
                if (object.quarters == 1) {
                    change += ' ' + object.quarters + " Quarter"
                } else {
                    change += ' ' + object.quarters + " Quarters"
                }
            }
            if (object.dimes > 0) {
                if (object.dimes == 1) {
                    change += ' ' + object.dimes + " dime"
                } else {
                    change += ' ' + object.dimes + " dimes"
                }
            }
            if (object.nickels > 0) {
                if (object.nickels == 1) {
                    change += ' ' + object.nickels + " nickel"
                } else {
                    change += ' ' + object.nickels + " nickels"
                }
            }
            if (object.pennies > 0) {
                if (object.pennies == 1) {
                    change += ' ' + object.pennies + " penny"
                } else {
                    change += ' ' + object.pennies + " pennies"
                }
            }
            $('#messages-box').val(message);
            $('#changeOutput').val(change);
            loadItems();
        },
        error: function (message) {
            var message = message.responseJSON.message;
            $('#messages-box').val(message);
        },
    });
}
function giveChange() {

    var change = $('#changeOutput').val();
    var moneyInMachine = $('#money-in').val();

    if(!(change == '')){
    var message = 'Here is your change!!';
    $('#messages-box').val(message);
    setTimeout(showChangeGiven, 3000);
    }

    if(change == '' &&  moneyInMachine != '0.00'){
    $('#changeOutput').val(moneyInMachine);
    var message = 'Here is your change!!';
    $('#messages-box').val(message);
    setTimeout(showChangeGiven, 3000);
    }
}
function showChangeGiven(){
    $('#changeOutput').val('');
    $('#money-in').val('0.00');
    $('#messages-box').val('');
    $('#item-number').val('');
}