/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.ui;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class AddressBookView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Of Addresses");
        io.print("2. Add/Create Address");
        io.print("3. View/Get Address");
        io.print("4. Remove Address");
        io.print("5. Get Address Count");
        io.print("6. Exit");
        io.print("7. edit an Address");

        return io.readInt("Please select from the above choices.");
    }

    public void displayCreateStudentBanner() {
        io.print("=== Add Address ===");
    }

    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter the first name associated with the address");
        String lastName = io.readString("Please enter the last name associated with the address");
        String state = io.readString("Please enter the state");
        String city = io.readString("Please enter the city name");
        String streetAddress = io.readString("Please enter the street address");
        String zipCode = io.readString("Please enter the zipcode");
        Address newAddress = new Address();
        newAddress.setFirstName(firstName);
        newAddress.setLastName(lastName);
        newAddress.setState(state);
        newAddress.setCity(city);
        newAddress.setStreetAddress(streetAddress);
        newAddress.setZipcode(zipCode);
        return newAddress;
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Address successfully added.  Please hit enter to continue");
    }

    public void displayCount(int count) {
        io.print("The total number of addresses in the address book is: " + count);
        io.readString("Press enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayListOfAddresses(List<Address> list) {
        for (Address correspondingAddress : list) {
            String firstName = correspondingAddress.getFirstName();
            String lastName = correspondingAddress.getLastName();
            String wholeName = correspondingAddress.getFullName();
            String state = correspondingAddress.getState();
            String city = correspondingAddress.getCity();
            String streetAddress = correspondingAddress.getStreetAddress();
            String zipCode = correspondingAddress.getZipcode();

            io.print("|| " + wholeName + " : " + state + " : " + city + " : " + streetAddress
                    + " : " + zipCode + " ||");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public String getFullName() {
        String firstname = io.readString("Please give me the first name!");
        String lastName = io.readString("Please give me the last name!");
        Address address = new Address();
        address.setFirstName(firstname);
        address.setLastName(lastName);
        String fullName = address.getFullName();
        return fullName;
    }

    public void displayAddress(Address correspondingAddress) {
        if (correspondingAddress != null) {
            String firstName = correspondingAddress.getFirstName();
            String lastName = correspondingAddress.getLastName();
            String wholeName = correspondingAddress.getFullName();
            String state = correspondingAddress.getState();
            String city = correspondingAddress.getCity();
            String streetAddress = correspondingAddress.getStreetAddress();
            String zipCode = correspondingAddress.getZipcode();

            io.print("|| " + wholeName + " : " + state + " : " + city + " : " + streetAddress
                    + " : " + zipCode + " ||");
        } else {
            io.print("No such student in our system):");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }

    public void displayEditBanner() {
        io.print("=== Time to edit an address ===");
    }

    public Address editAddress(Address editAddress) {
        boolean keepEditing = true;
        while(keepEditing){
        io.print("edit Menu");
        io.print("1. edit first name");
        io.print("2. edit last name");
        io.print("3. edit state");
        io.print("4. edit city");
        io.print("5. edit street address");
        io.print("6. edit zipcode");
        io.print("7. done editing");
        int choice = io.readInt("Please select from the above choices.", 1, 7);
        switch(choice){
            case 1:
                String newFirstName = io.readString("What first name would you "
                        + "like to replace the existing one with");
                editAddress.setFirstName(newFirstName);
                break;
            case 2:
                String newLastName = io.readString("What last name would you "
                        + "like to replace the existing one with");
                editAddress.setLastName(newLastName);
                break;
            case 3:
                String newState = io.readString("What state do you reside in now?");
                editAddress.setState(newState);
                break;
            case 4:
                String newCity = io.readString("What city do you reside in now?");
                editAddress.setCity(newCity);
                break;
            case 5:
                String newStreetAddress = io.readString("What street address do you reside in now?");
                editAddress.setStreetAddress(newStreetAddress);
                break;
            case 6:
                String newZipCode = io.readString("What zipcode do you reside in now?");
                editAddress.setZipcode(newZipCode);
                break;
            case 7:
                keepEditing = false;
                break;
            default:
                io.print("number out of bounds");
        }
            io.print("Thank you for editing your address(:");
        }
        return editAddress;
    }
    public void displayEditedAddressPrompt(){
        io.print("Here is what the address looks like now!");
    }

    public void displayEditedBanner() {
        io.readString("Edit was saved and was sucessful. Press enter to continue");
    }

    public void displayExitBanner() {
        io.print("Good Bye, thank you for using our AddressBook!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}

    public AddressBookView(UserIO io) {
        this.io = io;
    }

}
