/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary;

import DVD.controller.DVDLibraryController;
import DVD.dao.DVDDao;
import DVD.dao.DVDDaoFileImpl;
import DVD.ui.DVDLibraryView;
import DVD.ui.UserIO;
import DVD.ui.UserIOConsoleImpl;

/**
 *
 * @author 19bgehrman
 */
public class DVDapp {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDDao myDao = new DVDDaoFileImpl();
        DVDLibraryController control = 
                new DVDLibraryController(myView, myDao);
        control.run();
    }
}
