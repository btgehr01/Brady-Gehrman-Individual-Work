/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook;

import AddressBook.controller.AddressBookController;
import AddressBook.dao.AddressBookDaoFileImpl;
import AddressBook.dao.AddressDao;
import AddressBook.ui.AddressBookView;
import AddressBook.ui.UserIO;
import AddressBook.ui.UserIOConsoleImpl;


/**
 *
 * @author 19bgehrman
 */
public class AddressApp {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressDao myDao = new AddressBookDaoFileImpl();
        AddressBookController control = 
                new AddressBookController(myView, myDao);
        control.run();
    }

}
