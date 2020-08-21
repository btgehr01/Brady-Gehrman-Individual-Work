/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachine;

import VendingController.VendingController;
import VendingDao.VendingDao;
import VendingDao.VendingDoaFileImpl;
import VendingMachineView.VendingMachineView;
import VendingServiceLayer.VendingService;
import VendingServiceLayer.VendingServiceFileImpl;
import VendingUI.UserIO;
import VendingUI.UserIOConsoleImpl;

/**
 *
 * @author 19bgehrman
 */
public class Vendingapp {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingDao myDao = new VendingDoaFileImpl();
        VendingService myService = new VendingServiceFileImpl(myDao);
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingController controller = new VendingController(myView, myService);
        controller.run();
    }
}
