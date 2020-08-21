/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.controller;

import DVD.dao.DVDDao;
import DVD.dao.DVDDaoException;
import DVD.dto.DVD;
import DVD.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDDao dao;

    public void run() {
        try {
            boolean keepGoing = true;
            while (keepGoing) {
                int menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        searchOrGetDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();

                }
            }
            displayExitBanner();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDDaoException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    public void removeDVD() throws DVDDaoException {
        view.displayRemoveDVDBanner();
        List<String> list = dao.getAllDVDs();
        String title = view.getTitleToRemove(list);
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void searchOrGetDVD() throws DVDDaoException {
        List<String> list = dao.getAllDVDs();
        String title = view.getTitleToView(list);
        DVD searchedDVD = dao.getDVD(title);
        view.displayDVD(searchedDVD);
    }

    private void listDVDs() throws DVDDaoException {
        view.displayDisplayAllBanner();
        List<String> list = dao.getAllDVDs();
        view.displayListOfDVDTitles(list);
        view.displayListedStudent();
    }

    public void editDVD() throws DVDDaoException {
        view.displayEditBanner();
        List<String> dvdNames = dao.getAllDVDs();
        String title = view.getTitleToEdit(dvdNames);
        DVD dvd = dao.getDVD(title);
        DVD editedDVD = view.editDVD(dvd);
        dao.editDVD(title, editedDVD);
        view.displayEditedDVDPrompt();
        view.displayDVD(editedDVD);
    }

    private void displayExitBanner() {
        view.displayExitBanner();
    }

    public DVDLibraryController(DVDLibraryView myView, DVDDao myDao) {
        this.dao = myDao;
        this.view = myView;
    }
}
