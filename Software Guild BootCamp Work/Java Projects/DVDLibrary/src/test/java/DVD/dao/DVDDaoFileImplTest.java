/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class DVDDaoFileImplTest {

    public DVDDaoFileImplTest() {
    }
    DVDDao dao;

    @Before
    public void setUp() throws Exception {
        String testFile = "dvd_test.txt";
        new FileWriter(testFile); // Just use the FileWriter to blank the file
        dao = new DVDDaoFileImpl(testFile);
    }

//    private String title;
//    private LocalDateTime releaseDate;
//    private String rating;
//    private String directorsName;
//    private String studio;
//    private int userRating;
//    private String userNote;
    @Test
    public void testAddGetDVDMethod() throws DVDDaoException { //persistence exception
        String title = "Lion King";
        String releaseDate = "1994-06-15";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime = LocalDate.parse(releaseDate, format);
        String rating = "G";
        String directorsName = "Roger Allers";
        String studio = "Walt Disney Pictures";
        int userRating = 10;
        String userNote = "Great movie for young kids who like adventures and learning!!";

        DVD lionKing = new DVD(title, releaseTime, rating, directorsName, studio, userRating, userNote);

        dao.addDVD(title, lionKing);

        DVD hopefullyRecievedLionKingDVD = dao.getDVD(title);

        //chack that the gotten dvd and the added dvd are equal
        Assert.assertEquals("testing to make sure that the dvd's titles are correct", lionKing.getTitle(), hopefullyRecievedLionKingDVD.getTitle());
        Assert.assertEquals("testing to make sure that the dvd's releaseTimes are equal", lionKing.getReleaseDate(), hopefullyRecievedLionKingDVD.getReleaseDate());
        Assert.assertEquals("testing to make sure that the dvd's ratings are equal", lionKing.getRating(), hopefullyRecievedLionKingDVD.getRating());
        Assert.assertEquals("testing to make sure that the dvd's director names are equal", lionKing.getDirectorsName(), hopefullyRecievedLionKingDVD.getDirectorsName());
        Assert.assertEquals("testing to make sure that the dvd's studios are equal", lionKing.getStudio(), hopefullyRecievedLionKingDVD.getStudio());
        Assert.assertEquals("testing to make sure that the dvd's userratings are equal", lionKing.getUserRating(), hopefullyRecievedLionKingDVD.getUserRating());
        Assert.assertEquals("testing to make sure that the dvd's user notes are equal", lionKing.getUserNote(), hopefullyRecievedLionKingDVD.getUserNote());

    }

    @Test
    public void testAddGetAllDVDsMethod() throws DVDDaoException { //persistence exception
        String title = "Lion King";
        String releaseDate = "1994-06-15";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime = LocalDate.parse(releaseDate, format);
        String rating = "G";
        String directorsName = "Roger Allers";
        String studio = "Walt Disney Pictures";
        int userRating = 10;
        String userNote = "Great movie for young kids who like adventures and learning!!";

        String title2 = "Incredables";
        String releaseDate2 = "2004-11-05";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime2 = LocalDate.parse(releaseDate2, formatter);
        String rating2 = "G";
        String directorsName2 = "Brad Bird";
        String studio2 = "Walt Disney Pictures";
        int userRating2 = 10;
        String userNote2 = "Great movie for young kids who like adventures and learning!!";

        DVD lionKing = new DVD(title, releaseTime, rating, directorsName, studio, userRating, userNote);
        DVD incredables = new DVD(title2, releaseTime2, rating2, directorsName2, studio2, userRating2, userNote2);

        dao.addDVD(title2, incredables);
        dao.addDVD(title, lionKing);
        
        List<String> dvdTitlesList = dao.getAllDVDs();
        
        Assert.assertNotNull("checking to make sure that the dvd title list isn't null", dvdTitlesList);
        Assert.assertEquals("making sure the list has two dvds inside of it", 2, dvdTitlesList.size());
        
        Assert.assertTrue("making sure the list contains Lion King", dvdTitlesList.contains(title));
        Assert.assertTrue("making sure the list contains incredables", dvdTitlesList.contains(title2));
        

    }
    @Test
    public void testAddGetAllDVDsOutOfMapMethod() throws DVDDaoException { //persistence exception
        String title = "Lion King";
        String releaseDate = "1994-06-15";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime = LocalDate.parse(releaseDate, format);
        String rating = "G";
        String directorsName = "Roger Allers";
        String studio = "Walt Disney Pictures";
        int userRating = 10;
        String userNote = "Great movie for young kids who like adventures and learning!!";

        String title2 = "Incredables";
        String releaseDate2 = "2004-11-05";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime2 = LocalDate.parse(releaseDate2, formatter);
        String rating2 = "G";
        String directorsName2 = "Brad Bird";
        String studio2 = "Walt Disney Pictures";
        int userRating2 = 10;
        String userNote2 = "Great movie for young kids who like adventures and learning!!";

        DVD lionKing = new DVD(title, releaseTime, rating, directorsName, studio, userRating, userNote);
        DVD incredables = new DVD(title2, releaseTime2, rating2, directorsName2, studio2, userRating2, userNote2);

        dao.addDVD(title2, incredables);
        dao.addDVD(title, lionKing);
        
        List<DVD> dvdTitlesList = dao.getAllDVDsOutOfMap();
        
        Assert.assertNotNull("checking to make sure that the dvd title list isn't null", dvdTitlesList);
        Assert.assertEquals("making sure the list has two dvds inside of it", 2, dvdTitlesList.size());
        
        Assert.assertTrue("making sure the list contains Lion King", dvdTitlesList.contains(lionKing));
        Assert.assertTrue("making sure the list contains incredables", dvdTitlesList.contains(incredables));
        

    }
    @Test
    public void testEditDVDMethod() throws DVDDaoException { //persistence exception
        String title = "Lion King";
        String releaseDate = "1994-06-15";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime = LocalDate.parse(releaseDate, format);
        String rating = "G";
        String directorsName = "Roger Allers";
        String studio = "Walt Disney Pictures";
        int userRating = 10;
        String userNote = "Great movie for young kids who like adventures and learning!!";

        String title2 = "Incredables";
        String releaseDate2 = "2004-11-05";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime2 = LocalDate.parse(releaseDate2, formatter);
        String rating2 = "G";
        String directorsName2 = "Brad Bird";
        String studio2 = "Walt Disney Pictures";
        int userRating2 = 10;
        String userNote2 = "Great movie for young kids who like adventures and learning!!";

        DVD lionKing = new DVD(title, releaseTime, rating, directorsName, studio, userRating, userNote);
        DVD incredables = new DVD(title2, releaseTime2, rating2, directorsName2, studio2, userRating2, userNote2);
        
        DVD newLionKing = new DVD(title, releaseTime, "PG-13", directorsName, studio, 9, userNote);
        DVD newIncredables = new DVD("Super Awesome Superpower Family", releaseTime2, rating2, directorsName2, studio2, 9, userNote2);

        dao.addDVD(title2, incredables);
        dao.addDVD(title, lionKing);
        
        dao.editDVD(title, newLionKing);
        dao.editDVD(title2, newIncredables);
        
        //make sure Lion King was changed
        Assert.assertEquals("checking to make sure that the Lion King title has remained unchanged", title, newLionKing.getTitle());
        Assert.assertEquals("testing to make sure that the Lion King releaseTime has remained unchanged ", releaseTime, newLionKing.getReleaseDate());
        Assert.assertNotSame("testing to make sure that the updated Lion King's ratings has changed", rating, newLionKing.getRating());
        Assert.assertEquals("testing to make sure that the Lion King director name has remained unchanged", directorsName, newLionKing.getDirectorsName());
        Assert.assertEquals("testing to make sure that the Lion King studio has remained unchanged", studio, newLionKing.getStudio());
        Assert.assertNotSame("testing to make sure that the Lion king userrating has changed", userRating, newLionKing.getUserRating());
        Assert.assertEquals("testing to make sure that the Lion King uerNote hasn't changed", userNote, newLionKing.getUserNote());

        //make sure incredables was changed
        Assert.assertNotSame("checking to make sure that the updated Incredables title has changed", title2, newIncredables.getTitle());
        Assert.assertEquals("testing to make sure that the Incredables releaseTime has remained unchanged ", releaseTime2, newIncredables.getReleaseDate());
        Assert.assertEquals("testing to make sure that the Incredables's rating hasn't changed", rating2, newIncredables.getRating());
        Assert.assertEquals("testing to make sure that the Incredables director name has remained unchanged", directorsName2, newIncredables.getDirectorsName());
        Assert.assertEquals("testing to make sure that the Incredables studio has remained unchanged", studio2, newIncredables.getStudio());
        Assert.assertNotSame("testing to make sure that the Incredables userrating has changed", userRating2, newIncredables.getUserRating());
        Assert.assertEquals("testing to make sure that the Incredables uerNote hasn't changed", userNote2, newIncredables.getUserNote());

        
    }
    @Test
    public void testRemoveDVDMethod() throws DVDDaoException { //persistence exception
        String title = "Lion King";
        String releaseDate = "1994-06-15";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime = LocalDate.parse(releaseDate, format);
        String rating = "G";
        String directorsName = "Roger Allers";
        String studio = "Walt Disney Pictures";
        int userRating = 10;
        String userNote = "Great movie for young kids who like adventures and learning!!";

        String title2 = "Incredables";
        String releaseDate2 = "2004-11-05";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate releaseTime2 = LocalDate.parse(releaseDate2, formatter);
        String rating2 = "G";
        String directorsName2 = "Brad Bird";
        String studio2 = "Walt Disney Pictures";
        int userRating2 = 10;
        String userNote2 = "Great movie for young kids who like adventures and learning!!";

        DVD lionKing = new DVD(title, releaseTime, rating, directorsName, studio, userRating, userNote);
        DVD incredables = new DVD(title2, releaseTime2, rating2, directorsName2, studio2, userRating2, userNote2);

        dao.addDVD(title2, incredables);
        dao.addDVD(title, lionKing);
        
        DVD removedLionKing= dao.removeDVD(title);
        
        Assert.assertEquals("making sure it removed the lion King", lionKing, removedLionKing);
        
        List<DVD> dvdListWithoutLionKingHopefully = dao.getAllDVDsOutOfMap();
        
        Assert.assertNotNull("checking to make sure that the dvd title list isn't null", dvdListWithoutLionKingHopefully);
        Assert.assertEquals("making sure the list has two dvds inside of it", 1, dvdListWithoutLionKingHopefully.size());
        
        Assert.assertFalse("making sure the list doesn't contains Lion King anymore", dvdListWithoutLionKingHopefully.contains(lionKing));
        Assert.assertTrue("making sure the list contains incredables", dvdListWithoutLionKingHopefully.contains(incredables));
        
        DVD removedIncredables = dao.removeDVD(title2);
        
        Assert.assertEquals("making sure it removed the incredables DVD", incredables, removedIncredables);
        
        List<DVD> dvdListWithoutLionKingAndIncredablesHopefully = dao.getAllDVDsOutOfMap();
        //make sure the list id now empty
        Assert.assertTrue("making sure the list is now empty", dvdListWithoutLionKingAndIncredablesHopefully.isEmpty());
        
        DVD lionKingHopefullyNull = dao.getDVD(title);
        DVD incredablesHopefullyNull = dao.getDVD(title2);
        
        Assert.assertNull("Making sure that the lion king is no longer in memory", lionKingHopefullyNull);
        Assert.assertNull("Making sure that the incredables is no longer in memory", incredablesHopefullyNull);
        
        
    }
}
