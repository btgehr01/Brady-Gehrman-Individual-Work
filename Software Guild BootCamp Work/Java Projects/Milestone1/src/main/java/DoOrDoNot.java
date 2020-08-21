
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
public class DoOrDoNot {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;

        //do {
          //  iDidIt = true;
            //break;
        //} while (doIt);
       while(doIt){
           iDidIt = true;
           break;      
       }
        
        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }

    }
}
//if I tell it to not do it it prints out that it did it anyways or that ti didn'd do anything!
//if I tell it to do it, it does it
//replaced the do while loop with the while loop, now the code will not always do it 
//because of the do while loop, and it will always follow what you say to do!
