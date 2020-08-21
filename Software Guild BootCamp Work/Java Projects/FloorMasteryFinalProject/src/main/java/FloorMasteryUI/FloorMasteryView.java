/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryUI;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.ProductInfo;
import FloorMasteryDto.TaxInfo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryView {

    private final UserIO io;

    public FloorMasteryView(UserIO io) {
        this.io = io;
    }

    public int getMenuSelection(boolean isInProductionMode) {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders using an Order Date");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        if (isInProductionMode) {
            io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            io.print("I N    P R O D U C T I O N     M O D E");
            io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        } else {
            io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            io.print("I N    T R A I N I N G     M O D E");
            io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        }
        int menuSelection = io.readInt(" please pick from one of the above choices", 1, 6);

        return menuSelection;
    }

    public void showPersistenceError() {
        io.print("Problem Loading infomation from the file, the program will now shutdown/restart");
    }

    public String showAndGetFromProductList(List<ProductInfo> products) {
        String[] stringProducts = new String[products.size() + 1];
        for (int i = 0; i < products.size(); i++) {
            ProductInfo oneProduct = products.get(i);
            String productType = oneProduct.getProductType();
            BigDecimal costPerSquareFoot = oneProduct.getCostPerSquareFoot();
            BigDecimal laborCostPerSquareFoot = oneProduct.getLaborCostPerSquareFoot();
            BigDecimal totalCostPerSquareFoot = costPerSquareFoot.add(laborCostPerSquareFoot);
            stringProducts[i + 1] = productType;

            io.print((i + 1) + ".");
            io.print("Product Type: " + productType);
            io.print("Total Cost Per Square-Foot: $" + totalCostPerSquareFoot);

        }
        io.print("The Total Cost Per Square-Foot does account for labor and material costs");
        int productNumberChoice = io.readInt("Please pick a VALID product number for the product above that you would like to purchase!", 1, products.size());
        String wantedProductType = stringProducts[productNumberChoice];
        return wantedProductType;
    }

    public String showAndGetFromProductListForEdit(List<ProductInfo> products) {
        String[] stringProducts = new String[products.size() + 1];
        for (int i = 0; i < products.size(); i++) {
            ProductInfo oneProduct = products.get(i);
            String productType = oneProduct.getProductType();
            BigDecimal costPerSquareFoot = oneProduct.getCostPerSquareFoot();
            BigDecimal laborCostPerSquareFoot = oneProduct.getLaborCostPerSquareFoot();
            BigDecimal totalCostPerSquareFoot = costPerSquareFoot.add(laborCostPerSquareFoot);
            stringProducts[i + 1] = productType;

            io.print((i + 1) + ".");
            io.print("Product Type: " + productType);
            io.print("Total Cost Per Square-Foot: $" + totalCostPerSquareFoot);

        }
        io.print("The Total Cost Per Square-Foot does account for labor and material costs");
        int productNumberChoice = io.readInt("Please pick a VALID product number for the product above that you would like to now set the product type to!", 1, products.size());
        String wantedProductType = stringProducts[productNumberChoice];
        return wantedProductType;
    }

    public String getDateForDisplayOrder() {
        String wantedDate = io.readString("What date would you like to view the orders for? (MM/dd/yyyy)? type in q and press enter to return to Main Menu");
        if (!(wantedDate.equals("q"))) {
            boolean dateIsValid = this.validateDate(wantedDate);
            while (!(dateIsValid)) {
                io.print("Your inputed Date is invalid please revise");
                wantedDate = io.readString("Please enter a valid delivery date to display");
                dateIsValid = this.validateDate(wantedDate);
            }
        }
        return wantedDate;

    }

    public void showNoOrdersOnThatDate() {
        io.print("There are no orders in our database placed for that date ): ");
        io.readString("Please press enter to return to the main menu!");
    }

    public void displayOrdersFromAList(List<CustomerOrder> orderList) {
        for (CustomerOrder oneOrder : orderList) {
            String customerName = oneOrder.getCustomerName();
            int orderNumber = oneOrder.getOrderNumber();
            BigDecimal total = oneOrder.getTotal();
            LocalDate localDateWanted = oneOrder.getDate();
            DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String dateWanted = localDateWanted.format(formatOutput);
            String state = oneOrder.getState();
            String productType = oneOrder.getProductType();
            double area = oneOrder.getArea();
            io.print("Customer Name: " + customerName + " Order Number: " + orderNumber + " Total: $" + total);
            io.print("Product: " + productType + " Area: " + area + " sq ft");
            io.print("Promised For: " + dateWanted + " Will be Delivered to: " + state);
        }
        io.readString("Please press enter to return to the main menu after viewing your order!");
    }

    public double getOrderArea(ProductInfo productType) {
        double area = io.readDouble("What is the area of " + productType.getProductType() + " that you would like to purchase? (sq ft)");
        return area;
    }

    public String getDeliveryLocation(double area, ProductInfo productType, List<TaxInfo> taxInfoList) {
        String[] abrevArray = new String[taxInfoList.size() + 1];
        for (int i = 0; i < taxInfoList.size(); i++) {
            TaxInfo taxInfo = taxInfoList.get(i);
            String stateAbbreviation = taxInfo.getStateAbbreviation();
            abrevArray[i + 1] = stateAbbreviation;
            io.print((i + 1) + ". " + stateAbbreviation);
        }
        int intDeliveryState = io.readInt("Please enter the number next to the state abbreviation that you would like this " + area + " sq ft of " + productType.getProductType() + " be delivered to?", 1, taxInfoList.size());
        String deliveryStateAbrev = abrevArray[intDeliveryState];
        return deliveryStateAbrev;
    }

    public String getNewDeliveryLocationForEdit(List<TaxInfo> taxInfoList) {
        String[] abrevArray = new String[taxInfoList.size() + 1];
        for (int i = 0; i < taxInfoList.size(); i++) {
            TaxInfo taxInfo = taxInfoList.get(i);
            String stateAbbreviation = taxInfo.getStateAbbreviation();
            abrevArray[i + 1] = stateAbbreviation;
            io.print((i + 1) + ". " + stateAbbreviation);
        }
        int intDeliveryState = io.readInt("Please enter the number next to the state abbreviation that you would now like to set the delivery state as", 1, taxInfoList.size());
        String deliveryStateAbrev = abrevArray[intDeliveryState];
        return deliveryStateAbrev;
    }

    public String getWantedDeliveryDate() {
        String wantedDate = io.readString("On what date would you like this product delivered (MM/dd/yyyy)");
        boolean dateIsValid = this.validateDate(wantedDate);
        while (!(dateIsValid)) {
            io.print("Your inputed Date is invalid please revise");
            wantedDate = io.readString("Please enter a valid delivery date for add");
            dateIsValid = this.validateDate(wantedDate);
        }
        return wantedDate;
    }

    public String getCustomerName() {
        String customerName = io.readString("What name would you like this order to be associated with?");
        return customerName;
    }

    public boolean customerIsSureAboutTheirOrder(CustomerOrder soonAddedOrder) {
        boolean isSure;
        String customerName = soonAddedOrder.getCustomerName();
        BigDecimal total = soonAddedOrder.getTotal();
        LocalDate localDateWanted = soonAddedOrder.getDate();
        DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateWanted = localDateWanted.format(formatOutput);
        String state = soonAddedOrder.getState();
        String productType = soonAddedOrder.getProductType();
        double area = soonAddedOrder.getArea();
        io.print("Below is your order that You have constructed:");
        io.print("Customer Name: " + customerName + " Total: $" + total);
        io.print("Product: " + productType + " Area: " + area + " sq ft");
        io.print("Promised For: " + dateWanted + " Will be Delivered to: " + state);
        String confirmation = io.readString("Would you like us to add and save the order above to our database? (y/n)");
        if (confirmation.contains("y")) {
            isSure = true;
        } else {
            isSure = false;
        }
        return isSure;
    }

    public void displayOrderPlacedSucessBanner(CustomerOrder placedOrder) {
        int orderNumber = placedOrder.getOrderNumber();
        io.print("Order Was Placed!!(:");
        io.print("Your Order Number is: " + orderNumber + " Thank You for picking us to fufill your flooring needs!!");
        io.readString("Please press enter to return to the Main Menu!!");
    }

    public String getOrdersDateToRemove() {
        String date = io.readString("What is the date the order was supposed to be delivered on?");
        boolean dateIsValid = this.validateDate(date);
        while (!(dateIsValid)) {
            io.print("Your inputed Date is invalid please revise");
            date = io.readString("Please enter a valid delivery date for remove");
            dateIsValid = this.validateDate(date);
        }
        return date;
    }

    public int getOrdersNumberToRemove() {
        int removedOrderNumber = io.readInt("What is the order number of the order that you would like to removed! Type in 0 to return to the Main Menu");
        return removedOrderNumber;
    }

    public boolean askIfTheCustomerIsSure(CustomerOrder removedOrder) {
        boolean areSure = true;
        String answer = io.readString("Are you sure you would like Order number " + removedOrder.getOrderNumber() + " for " + removedOrder.getArea() + " sq ft of " + removedOrder.getProductType() + " to be removed from our database (y/n)");
        if (answer.contains("n")) {
            areSure = false;
        }
        return areSure;
    }

    public boolean askIfTheCustomerIsSure() {
        boolean wouldLikeToSave = true;
        String answer = io.readString("Would you like to SAVE your changes made before exiting our program? (y/n)");
        if (answer.contains("n")) {
            wouldLikeToSave = false;
        }
        return wouldLikeToSave;
    }

    public void displayRemovedSucess(CustomerOrder removedOrder) {
        io.print("Order number " + removedOrder.getOrderNumber() + " for " + removedOrder.getArea() + " sq ft of " + removedOrder.getProductType() + " was removed from our database");
        io.readString("Please press enter to be redirected to the main menu!");
    }

    public void showThatTheOrderDoesntExistInOurProgram() {
        io.print("Im sorry, an Order with that order number and delivery date doesn't exist within our program");
        io.readString("Press enter to be redirected to the main menu");
    }

    public void displayThatTheSaveWasSucessful() {
        io.readString("Your changes where all saved sucessfully!! Press enter to continue (:");
    }

    public int getOrderNumberForEdit() {
        int orderNumber = io.readInt("Please enter the order number for the order that you would like to edit? Type in 0 to return to the Main Menu");
        return orderNumber;
    }

    public String getDateForEdit() {
        String date = io.readString("Please enter the delivery date for the order that you would like to edit");
        boolean dateIsValid = this.validateDate(date);
        while (!(dateIsValid)) {
            io.print("Your inputed Date is invalid please revise");
            date = io.readString("Please enter a valid date to get a delivery date for edit");
            dateIsValid = this.validateDate(date);
        }
        return date;
    }

    public CustomerOrder editOrder(CustomerOrder orderToEdit, List<TaxInfo> stateList, List<ProductInfo> productList) {
        io.print("Our program will now go through each property of your order!!");
        io.print("If you would like to edit a piece of infomation simply type in what you would now like it to be!");
        io.print("If you don't want to change anything just press enter to keep that property the same!");
        io.readString("Please press enter to start the editing process!");
        String newName = io.readString("Order Name: " + orderToEdit.getCustomerName());
        if (!(newName.equals(""))) {
            orderToEdit.setCustomerName(newName);
        } else {
            io.print("We will leave the Customer Name as it was!!");
        }
        String newStateAbreviation = io.readString("Delivery State: " + orderToEdit.getState());
        if (!(newStateAbreviation.equals(""))) {
            boolean isValidStateAbreviation = this.validateDate(newStateAbreviation);
            while (!(isValidStateAbreviation)) {
                io.readString("The State Abreviation you entered is invalid, please press enter to fix it!");
                io.print("Here is a list of all of the state Abreivations that we deliver to");
                newStateAbreviation = this.getNewDeliveryLocationForEdit(stateList);
                isValidStateAbreviation = true;
            }
            orderToEdit.setState(newStateAbreviation);
        } else {
            io.print("We will leave the Delivery State as it was!!");
        }
        String newProductType = io.readString("Product Type: " + orderToEdit.getProductType());
        if (!(newProductType.equals(""))) {
            boolean isProductTypeValid = this.validateProductType(newProductType, productList);
            while (!(isProductTypeValid)) {
                io.readString("The product type you entered is invalid, please press enter to fix it!");
                io.print("Here is a list of all of the state Abreivations that we deliver to");
                newProductType = this.showAndGetFromProductListForEdit(productList);
                isProductTypeValid = true;
            }
            orderToEdit.setProductType(newProductType);
        } else {
            io.print("We will leave the Product Type as it was!!");
        }
        Double newArea = io.readDouble("Area: " + orderToEdit.getArea());
        if (!(newArea.equals(0.0))) {
            orderToEdit.setArea(newArea);
        } else {
            io.print("We will leave the Area as it was!!");
        }
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String newDate = io.readString("Date: " + orderToEdit.getDate().format(formatInput));
        if (!(newDate.equals(""))) {
            boolean dateIsValid = this.validateDate(newDate);
            while (!(dateIsValid)) {
                io.print("Your inputed Date is invalid please revise");
                newDate = io.readString("Please enter a valid date for edit");
                dateIsValid = this.validateDate(newDate);
            }
            LocalDate newLocalDate = LocalDate.parse(newDate, formatInput);
            orderToEdit.setDate(newLocalDate);
        } else {
            io.print("We will leave the Date as it was!!");
        }
        return orderToEdit;
    }

    public boolean wouldLikeToSaveEdit(CustomerOrder orderToEditWithPermission) {
        boolean wouldLikeToSaveEdit;
        String customerName = orderToEditWithPermission.getCustomerName();
        int orderNumber = orderToEditWithPermission.getOrderNumber();
        BigDecimal total = orderToEditWithPermission.getTotal();
        LocalDate localDateWanted = orderToEditWithPermission.getDate();
        DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateWanted = localDateWanted.format(formatOutput);
        String state = orderToEditWithPermission.getState();
        String productType = orderToEditWithPermission.getProductType();
        double area = orderToEditWithPermission.getArea();
        io.print("Your Order now looks like this: ");
        io.print("Customer Name: " + customerName + " Order Number: " + orderNumber + " Total: $" + total);
        io.print("Product: " + productType + " Area: " + area + " sq ft");
        io.print("Promised For: " + dateWanted + " Will be Delivered to: " + state);
        String changedWanted = io.readString("Are these changes correct and wanted to be saved? (y/n) If 'n' your changes will be discarded");
        if (changedWanted.contains("y")) {
            wouldLikeToSaveEdit = true;
        } else {
            wouldLikeToSaveEdit = false;
        }
        return wouldLikeToSaveEdit;
    }

    public boolean validateDate(String date) {
        boolean dateIsValid = true;
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            LocalDate.parse(date, formatInput);

        } catch (java.time.format.DateTimeParseException ex) {
            dateIsValid = false;
        }
        return dateIsValid;
    }

    public boolean validateStateAbreviation(String stateAbreviation, List<TaxInfo> stateList) {
        boolean isValidStateAbreviation = true;
        for (TaxInfo oneState : stateList) {
            String stateAbreviationFromList = oneState.getStateAbbreviation();
            if (stateAbreviation.equals(stateAbreviationFromList)) {
                isValidStateAbreviation = true;
            } else {
                isValidStateAbreviation = false;
            }
        }
        return isValidStateAbreviation;
    }

    public boolean validateProductType(String productType, List<ProductInfo> productList) {
        boolean isProductTypeValid = true;
        for (ProductInfo oneProduct : productList) {
            String oneProductType = oneProduct.getProductType();
            if (oneProductType.equals(productType)) {
                isProductTypeValid = true;
            } else {
                isProductTypeValid = false;
            }
        }
        return isProductTypeValid;
    }

    public void changesDiscarded() {
        io.print("Your changes were Discarded!!");
        io.readString("Please press enter to be redirected to the Main Menu!");
    }

    public void thankYou() {
        io.print("Thank you for using our Flooring Program for the SG Flooring Corporation!! Good-bye (:");
    }

    public void couldntSave() {
        io.print("COULDN'T SAVE DATA THE PROGRAM WILL NOW SHUT DOWN");
    }

    public void returningToMain() {
        io.print("RETURNING TO MAIN NOW (changes are not saved at the moment)");
        io.readString("Please press enter to continue!");
    }

    public void customerDoesntWantToSaveOrder() {
        io.print("RETURNING TO MAIN NOW (Order was not placed or saved)");
        io.readString("Please press enter to continue!");
    }

    public void showThatTheDateDoesntMatchTheObject() {
        io.print("The Date Doesn't Match The Order Number, cannot let you continue ): ");
    }

    public void inTrainingModeCannotSave() {
        io.print("Our program is In Training Mode Cannot Save!!");
        io.readString("Please press enter to continue");
    }

    public void orderIsNull() {
        io.print("Your order to add is null ):");
        io.readString("Press enter to return to the main menu, your order was not saved!!");
    }

    public void orderDateIsInThePast() {
        io.print("The order date is in the past!!");
        io.readString("Press enter to correct this (:");
    }

    public void orderNameWasLeftEmpty() {
        io.print("Order name was left empty :(");
        io.readString("Press enter to correct this!");
    }

    public void orderAreaValidationException() {
        io.print("The inputed order area is less than our minimum order size of 100 sqft.");
        io.readString("Press enter to correct this!");
    }

    public void unknownCommand() {
        io.print("UNKNOWN COMMAND (input out of bounds)");
    }
    //get number beside product type and or state
    //if statements for linking numbers to product type and or state with for loop
}
