/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dto;

import java.time.LocalDate;

/**
 *
 * @author 19bgehrman
 */
public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String rating;
    private String directorsName;
    private String studio;
    private int userRating;
    private String userNote;

    public DVD(){
        
    }

    public DVD(String title) {
        this.title = title;
    }

    public DVD(String title, LocalDate releaseDate, String rating, 
           String directorsName, String studio, int userRating, String userNote) 
    {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.directorsName = directorsName;
        this.studio = studio;
        this.userRating = userRating;
        this.userNote = userNote;
    }
    
    
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    
    
    
    
    
}
