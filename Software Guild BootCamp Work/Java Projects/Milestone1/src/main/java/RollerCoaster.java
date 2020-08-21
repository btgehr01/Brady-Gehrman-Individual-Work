
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 19bgehrman
 */
public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }

        if (keepRiding.equals("n")) {
            System.out.println("Wow, that was FUN!");
            System.out.println("We looped that loop " + loopsLooped + " times!!");
        }
    }
    
    //to change yes in the conditional to "no" would mean we would have to ask
    //the user if he wanted to start first and then immplement an if statement for no
    //and a while statement for "yes"
    // if we used the boolean "no" in a while loop it would create an infinate looping system
    //unless we asked the user if they wanted to start the loop again

}
//there is no int before loopsLooped after we declared it because we have already declared
//and made space for the variable!!
