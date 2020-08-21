/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class DVDDaoFileImpl implements DVDDao {

    private Map<String, DVD> DVDMap = new HashMap<>();
    public final String DVD_FILE; //A static method belongs to the class and a non-static method belongs to an object of a class
    public static final String DELIMITER = "::";
    
    public DVDDaoFileImpl(){
        DVD_FILE = "dvd_test.txt";
    }

    public DVDDaoFileImpl(String DVD_FILE) {
        this.DVD_FILE = DVD_FILE;
    }
    

    @Override
    public DVD addDVD(String title, DVD a) throws DVDDaoException {
        loadDVDs();
        DVD newDVD = DVDMap.put(title, a);
        writeDVDs();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoException {
        DVD removedDVD = new DVD();
        loadDVDs();
        if (title  != null){
        if (DVDMap.containsKey(title)) {
                removedDVD = DVDMap.remove(title);
            } else {
                removedDVD = null;
            }
        }
        else{
            removedDVD = null;
        }
        writeDVDs();
        return removedDVD;
    }

    @Override
    public void editDVD(String oldTitle, DVD editedDVD) throws DVDDaoException {
        String newTitle = editedDVD.getTitle();
        if (oldTitle.equals(newTitle)) {
            DVDMap.replace(newTitle, editedDVD);
        } else {
            //the titles are not the same so lets remove the old one from the map
            DVDMap.remove(oldTitle);

            DVDMap.put(newTitle, editedDVD);
        }
        this.writeDVDs();
    }

    @Override
    public List<String> getAllDVDs() throws DVDDaoException {
        List<String> DVDList = new ArrayList<>();
        loadDVDs();
        Set<String> DVDCollection = DVDMap.keySet();
        for (String DVDFromMap : DVDCollection) {
            DVDList.add(DVDFromMap);
        }
        return DVDList;
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoException {
        loadDVDs();
        DVD dvd = DVDMap.get(title);
        return dvd;
    }
   @Override
    public List<DVD> getAllDVDsOutOfMap() throws DVDDaoException {
        List<DVD> DVDList = new ArrayList<>();
        loadDVDs();
        Collection<DVD> DVDs = DVDMap.values();
        for (DVD currentDVD : DVDs) {
            DVDList.add(currentDVD);
        }
        return DVDList;
    }

    private void loadDVDs() throws DVDDaoException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            DVD currentDVD = unmarshallDVD(currentLine);

            DVDMap.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private void writeDVDs() throws DVDDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDDaoException(
                    "Could not save student data.", e);
        }

        List<DVD> DVDList = this.getAllDVDsOutOfMap();
        for (DVD currentDVD : DVDList) {
            // write the DVD object to the file
            String DVDAsText = marshallDVD(currentDVD);
            // write the DVD object to the file
            out.println(DVDAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    private String marshallDVD(DVD dvd) {

        String DVDAsText = dvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:
        // 
        DVDAsText += dvd.getReleaseDate() + DELIMITER;

        // 
        DVDAsText += dvd.getRating() + DELIMITER;

        DVDAsText += dvd.getDirectorsName() + DELIMITER;

        DVDAsText += dvd.getStudio() + DELIMITER;

        DVDAsText += dvd.getUserRating() + DELIMITER;

        DVDAsText += dvd.getUserNote();

        // We have now turned a DVD to text! Return it!
        return DVDAsText;

    }

    private DVD unmarshallDVD(String stringDVDFromFile) {

        String[] DVDTokens = stringDVDFromFile.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        // Which we can then use to create a new DVD object to satisfy
        // the requirements of the Student constructor.
        DVD DVDFromFile = new DVD();

        // However, there are 6 remaining tokens that need to be set into the
        // new DVD objects. Do this manually by using the appropriate setters.
        // Index 1 - Title
        DVDFromFile.setTitle(DVDTokens[0]);

        // Index 2 - RD
        String RD = (DVDTokens[1]);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate releaseDate = LocalDate.parse(RD,format);
        DVDFromFile.setReleaseDate(releaseDate);

        // Index 3 - rating
        DVDFromFile.setRating(DVDTokens[2]);
        //DN
        DVDFromFile.setDirectorsName(DVDTokens[3]);
        //Studio
        DVDFromFile.setStudio(DVDTokens[4]);
        //UserRating
        String rating = DVDTokens[5];
        int userRating = Integer.parseInt(rating);
        DVDFromFile.setUserRating(userRating);
        //UserNote
        DVDFromFile.setUserNote(DVDTokens[6]);

        // We have now created a DVD! Return it!
        return DVDFromFile;
    }

}
