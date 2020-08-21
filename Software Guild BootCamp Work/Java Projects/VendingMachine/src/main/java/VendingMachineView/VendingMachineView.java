/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineView;

import Vending.Dto.ChangePurse;
import Vending.Dto.Item;
import VendingUI.UserIO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int menuSelection() {
        io.print("-------Main Menu-------");
        io.print("1. Purchase an item");
        io.print("2. Exit the vending machine");
        io.print("------------------------");

        return io.readInt("Please select from the above choices.");
    }

    public void showInventory(List<Item> itemList) {
        for (Item anItem : itemList) {
            String slotID = anItem.getSlotID();
            String nameOfItem = anItem.getName();
            BigDecimal cost = anItem.getCost();
            String stringCost = cost.toString();
            int numOfItems = anItem.getNumOfItems();
            io.print(numOfItems + " - " + nameOfItem + "--" + slotID + "--" + stringCost);
        }
    }

    public String getUserMoneyInput() {
        String userInput = io.readString("How much money have you to put into the machine to buy? (dollar.cents)");
        return userInput;
    }

    public String getAnItem() {
        String wantedSlotID = io.readString("What is the slotID of the item you would like to purchase?");
        return wantedSlotID;
    }

    public void ShowVendingInsufficientFundsException(BigDecimal userCashInput, BigDecimal costOfItem) {
        BigDecimal difference = costOfItem.subtract(userCashInput);
        io.print(" you need this much more money to purchase that item: " + difference);
    }

    public String userMoneyToAdd() {
        String addedMoney = io.readString("How much money have you added to your existing inputed money?");
        return addedMoney;
    }

    public void unknownItem() {
        io.print("Item is not included in our system at the moment, redirecting to the main menu!");
    }

    public void couldntSave() {
        io.print("Could not save the purchase/complete the purchase");
    }

    public void couldntLoadItems() {
        io.print("Couldn't load the items in the machine that are available");
    }

    public void unknownCommand() {
        io.print("Unknown Command!!");
        io.readString("Press Enter to be redirected to our main menu!");
    }

    public void displayExitBanner() {
        io.print("Good Bye, thank you for using our Vending Machine!!! (:");

    }

    public String keepGoing() {
        String keepGoing = io.readString("would you like to add money or get "
                + "your money back and return to the main menu? (add/coin return)");
        return keepGoing;
    }

    public void giveChange(ChangePurse change) {
        int dollars = change.getNumOfDollars();
        int quarters = change.getNumQuarters();
        int dimes = change.getNumOfDimes();
        int nickels = change.getNumOfNickels();
        int pennies = change.getNumOfPennies();

        io.print("Here is your change:");
        io.print("Dollars: " + dollars);
        io.print("Quarters: " + quarters);
        io.print("Dimes: " + dimes);
        io.print("Nickels: " + nickels);
        io.print("Pennies: " + pennies);

        io.readString("Redirecting to the main menu, Press Enter to continue!");

    }

    public void gettingChange() {
        io.print("We are getting your change pls wait (:");
    }
    public void noChangePutIntoTheMachine(){
        io.print("you have to put money into our vending machine before you can "
                + "select an item to purchase");
        io.readString("Redirecting you to the main menu, Press Enter to continue!");
    }
    public void purchaseSucessful(Item purchasedItem){
        String name = purchasedItem.getName();
        io.print("|||Purchase Sucessfull|||");
        io.print("Thank You for purchasing a " + name + " from our vending machine!(:");
    }
}
