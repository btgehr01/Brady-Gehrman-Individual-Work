/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;


/**
 *
 * @author 19bgehrman
 */
public class MainMethodUserIO {
   public static void main(String[] args) {
        
        UserIO yourUserIO = null;
        yourUserIO = new UserIOImplement();

        yourUserIO.print("WOW! That's a cool UserIO you've built.");
        
        String favColor = yourUserIO.readString("What's your favorite color? ");
        yourUserIO.print(favColor + " is a good one. Mine's peacock green.");

        int cats = yourUserIO.readInt("Okay, how many cats have you owned? ");
        yourUserIO.print(cats + " doesn't seem like THAT many cats. Huh.");
        
        double coffee = yourUserIO.readDouble("How many cups of coffee have you drank today? ");
        yourUserIO.print("Ha! Well I've drank " + (coffee + 3) + " cups!");
        
        long miles = yourUserIO.readLong("How many miles from the sun are we, do you think? ");
        yourUserIO.print(miles + " seems so very far away!");
        
        float airspeed = yourUserIO.readFloat("What is the airspeed velocity of an unladen swallow? ");
        yourUserIO.print("Heh. I thought it was only " + (airspeed / 4) + "!");
        
        int num = yourUserIO.readInt("Give me a number between 1 & 10 ...", 1, 10);
        yourUserIO.print(num + " - not bad! I would have picked 3.");
        
        double loveJava = yourUserIO.readDouble("On a scale of 0 to 100, how much do you love java? ", -100, 100);
        yourUserIO.print("Ha! " + loveJava + ", huh? I would have said 101!");
        
        long what = yourUserIO.readLong("Can you guess a number between -1000 and 1000? ", -1000, 1000);
        yourUserIO.print(what + " was right!");
        
        float chocolate = yourUserIO.readFloat("What is fraction of chocolate needed to make coffee taste like a mocha? (0 - 100%)",0, 100);
        if(chocolate > 70){
            yourUserIO.print((chocolate * 100) + "%! You must really like chocolate.");
        } else if(chocolate < 20) {
            yourUserIO.print("Only, " + (chocolate * 100) + "%?! You must be really sensitive to chocolate.");
        } else{
                yourUserIO.print("Interesting. " + (chocolate * 100) + "% is not what I would have chosen.");
        }
                
    }
     
}
