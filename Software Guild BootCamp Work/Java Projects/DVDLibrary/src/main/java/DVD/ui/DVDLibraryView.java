package DVD.ui;

import DVD.dto.DVD;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 19bgehrman
 */
public class DVDLibraryView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD to the collection");
        io.print("2. Remove DVD from the collection");
        io.print("3. Search for a DVD to View/get its infomation");
        io.print("4. List Of DVD titles in the collection");
        io.print("5. edit a DVD in the collection");
        io.print("6. Exit the collection of DVDs program");

        return io.readInt("Please select from the above choices.");
    }

    public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title associated with the DVD");
        String releaseDate = io.readString("Please enter the release date associated with the DVD (MM/dd/yyyy)");
        String rating = io.readString("Please enter the MPAA rating of the DVD");
        String directorsName = io.readString("Please enter the directors name");
        String studio = io.readString("Please enter the studio associated with this DVD");
        int userRating = io.readInt("Please enter your rating out of 10 for this movie that will be stored in this system");
        String userNote = io.readString("Please eneter a note for others to see about this movie");
        DVD newDVD = new DVD();
        newDVD.setTitle(title);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate releaseTime = LocalDate.parse(releaseDate,format);
        newDVD.setReleaseDate(releaseTime);
        newDVD.setRating(rating);
        newDVD.setDirectorsName(directorsName);
        newDVD.setStudio(studio);
        newDVD.setUserRating(userRating);
        newDVD.setUserNote(userNote);
        return newDVD;
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully added.  Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD Titles ===");
    }

    public void displayListOfDVDTitles(List<String> list) {
        for (String correspondingDVDTitle : list) {
            io.print(correspondingDVDTitle);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayListedStudent() {
        io.print("Those are the DVDs in our collection");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public String getTitleToRemove(List<String> dvdTitles) {
        List<String> editDVD = new ArrayList<>();
        String mistype;
        String DVDToFind = "";
        do {
            String partialTitle = io.readString("What DVD would you like to remove from our system (by title)");
            for (String title : dvdTitles) {
                if (title.contains(partialTitle)) {
                    io.print("| " + title + " |");
                    editDVD.add(title);
                }
            }
            io.print("Search results above!");
            mistype = io.readString("Did you mistype/would like to seach again? (yes)(no)");

        } while (mistype.equals("yes"));

        if (editDVD.size() > 1) {
            for (String titles : editDVD) {
                io.print(titles);
            }
            String realTitle = io.readString("What specific DVD would you like to remove in our system from the above choices(by title)");
            for (String title : editDVD) {
                if (title.equals(realTitle)) {
                    DVDToFind = title;
                }
            }
        } else if (editDVD.size() == 1) {
            for (String DVD : editDVD) {
                DVDToFind = DVD;
            }
        } else {
            io.print("Your DVD is not included in our system yet.");
            DVDToFind = null;
        }

        return DVDToFind;
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Please hit enter to continue.");
    }

    public void displayEditBanner() {
        io.print("=== Time to edit a DVD ===");
    }

    public String getTitleToEdit(List<String> dvdTitles) {
        List<String> editDVD = new ArrayList<>();
        String mistype;
        String DVDToFind = "";
        do {
            String partialTitle = io.readString("What DVD would you like to edit from our system (by title)");
            for (String title : dvdTitles) {
                if (title.contains(partialTitle)) {
                    io.print("| " + title + " |");
                    editDVD.add(title);
                }
            }
            io.print("Search results above!");
            mistype = io.readString("Did you mistype/would like to search again? (yes)(no)");

        } while (mistype.equals("yes"));

        if (editDVD.size() > 1) {
            for (String titles : editDVD) {
                io.print(titles);
            }
            String realTitle = io.readString("What specific DVD would you like to edit in our system from the above choices(by title)");
            for (String title : editDVD) {
                if (title.equals(realTitle)) {
                    DVDToFind = title;
                }
            }
        } else if (editDVD.size() == 1) {
            for (String DVD : editDVD) {
                DVDToFind = DVD;
            }
        } else {
            io.print("Your DVD is not included in our system yet.");
            DVDToFind = null;
        }

        return DVDToFind;
    }

    public DVD editDVD(DVD editDVD) {
        boolean keepEditing = true;
        while (keepEditing) {
            io.print("Edit Menu");
            io.print("1. edit a title of a DVD");
            io.print("2. edit a release date for a DVD");
            io.print("3. edit a MPAA rating for a DVD");
            io.print("4. edit a directors name for a DVD");
            io.print("5. edit the studio of a DVD");
            io.print("6. edit your user rating of a DVD");
            io.print("7. edit your user note of a DVD");
            io.print("8. done editing");
            int choice = io.readInt("Please select from the above choices.", 1, 8);
            switch (choice) {
                case 1:
                    String newTitle = io.readString("What first title would you "
                            + "like to replace the existing one with");
                    editDVD.setTitle(newTitle);
                    break;
                case 2:
                    String newReleaseDate = io.readString("What is the new release date?");
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate releaseDate = LocalDate.parse(newReleaseDate,format);
                    editDVD.setReleaseDate(releaseDate);
                    break;
                case 3:
                    String newRating = io.readString("What is the new MPAA rating of the DVD");
                    editDVD.setRating(newRating);
                    break;
                case 4:
                    String newDirector = io.readString("Who is the new director of the movie now?");
                    editDVD.setDirectorsName(newDirector);
                    break;
                case 5:
                    String newStudio = io.readString("What is the new studio that fully created this movie");
                    editDVD.setStudio(newStudio);
                    break;
                case 6:
                    String newUserRating = io.readString("What would you like to change your rating to?");
                    editDVD.setRating(newUserRating);
                    break;
                case 7:
                    String userNote = io.readString("What would you like to change your note to?");
                    editDVD.setUserNote(userNote);
                    break;
                case 8:
                    keepEditing = false;
                    break;
                default:
                    io.print("number out of bounds");
            }
        }
        io.print("Thank you for editing your address(:");

        return editDVD;
    }

    public void displayDVD(DVD correspondingDVD) {
        if (correspondingDVD != null) {
            String title = correspondingDVD.getTitle();
            LocalDate releaseDate = correspondingDVD.getReleaseDate();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String stringReleaseDate = releaseDate.format(format);
            String rating = correspondingDVD.getRating();
            String directorsName = correspondingDVD.getDirectorsName();
            String studio = correspondingDVD.getStudio();
            int userRating = correspondingDVD.getUserRating();
            String userNote = correspondingDVD.getUserNote();

            io.print("Title: " + title);
            io.print("Release Date: " + stringReleaseDate);
            io.print("MPAA rating: " + rating);
            io.print("Directors Name: " + directorsName);
            io.print("studio: " + studio);
            io.print("User rating: " + userRating);
            io.print("User Note/review: " + userNote);
        } else {
            io.print("No such DVD in our system):");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditedDVDPrompt() {
        io.print("Here is what the address looks like now!");
    }

    public String getTitleToView(List<String> dvdTitles) {
        List<String> editDVD = new ArrayList<>();
        String mistype;
        String DVDToFind = "";
        do {
            String partialTitle = io.readString("What DVD would you like to view from our system (by title)");
            for (String title : dvdTitles) {
                if (title.contains(partialTitle)) {
                    io.print("| " + title + " |");
                    editDVD.add(title);
                }
            }
            io.print("Search results above!");
            mistype = io.readString("Did you mistype/would like to search again? (yes)(no)");

        } while (mistype.equals("yes"));

        if (editDVD.size() > 1) {
            for (String titles : editDVD) {
                io.print(titles);
            }
            String realTitle = io.readString("What specific DVD would you like to view in our system from the above choices(by title)");
            for (String title : editDVD) {
                if (title.equals(realTitle)) {
                    DVDToFind = title;
                }
            }
        } else if (editDVD.size() == 1) {
            for (String DVD : editDVD) {
                DVDToFind = DVD;
            }
        } else {
            io.print("Your DVD is not included in our system yet.");
            DVDToFind = null;
        }

        return DVDToFind;
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayExitBanner() {
        io.print("Good Bye, thank you for using our DVD Library!!! ");
        io.print("If you added infomation it will be saved for the next person to view!(:");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

}
