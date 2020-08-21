/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.controller;

import AddressBook.dao.AddressDao;
import AddressBook.dao.AddressDaoException;
import AddressBook.dto.Address;
import AddressBook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class AddressBookController {

    private AddressBookView view;
    private AddressDao dao;

    public void run() {

        boolean keepGoing = true;
        try {
            while (keepGoing) {
                int menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listAddresses();
                        break;
                    case 2:
                        addAddress();
                        break;
                    case 3:
                        getAddress();
                        break;
                    case 4:
                        removeAddress();
                        break;
                    case 5:
                        addressCount();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    case 7:
                        editAddress();
                        break;
                    default:
                        view.displayUnknownCommandBanner();

                }

            }
            view.displayExitBanner();
        } catch (AddressDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listAddresses() throws AddressDaoException {
        view.displayDisplayAllBanner();
        List<Address> list = dao.getAllAddresses();
        view.displayListOfAddresses(list);
    }

    private void addAddress() throws AddressDaoException {
        view.displayCreateStudentBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getFullName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void getAddress() throws AddressDaoException {
        view.displayDisplayStudentBanner();
        String fullName = view.getFullName();
        Address address = dao.getAddress(fullName);
        view.displayAddress(address);
    }

    public void removeAddress() throws AddressDaoException {
        view.displayRemoveStudentBanner();
        String fullName = view.getFullName();
        dao.removeAddress(fullName);
        view.displayRemoveStudentBanner();
    }

    private void addressCount() throws AddressDaoException {
        int count = dao.getCount();
        view.displayCount(count);
    }

    public void editAddress() throws AddressDaoException {
        view.displayEditBanner();
        String fullName = view.getFullName();
        Address soonNewAddress = dao.getAddress(fullName);
        Address editedAddress = view.editAddress(soonNewAddress);
        dao.editAddress(fullName, editedAddress);
        view.displayEditedAddressPrompt();
        view.displayAddress(editedAddress);
        view.displayEditedBanner();
    }

    public AddressBookController(AddressBookView myView, AddressDao myDao) {
        this.dao = myDao;
        this.view = myView;
    }
}
