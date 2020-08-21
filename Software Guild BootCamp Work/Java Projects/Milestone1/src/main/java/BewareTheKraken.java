
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
public class BewareTheKraken {

    public static void main(String[] args) {

        System.out.println("Already, get yer flippers & wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;
        String keepSwimming = "yes";
        Scanner input = new Scanner(System.in);

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while (depthDivedInFt < 36200 && keepSwimming.equals("yes")) {
            depthDivedInFt += 500;
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            if (depthDivedInFt == 500) {
                System.out.println("Ooo a clownfish");
            }
            if (depthDivedInFt == 1000) {
                System.out.println("Ooo a shark");
            }
            if (depthDivedInFt == 1500) {
                System.out.println("Ooo a catfish");
            }
            if (depthDivedInFt >= 20000) {
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            System.out.println("Do you want to stop swimming? (yes/no)");
            keepSwimming = input.nextLine();
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
//if we add while(true) the program loops till it gets to the depth of the kraken! 
//Without that break it would go on forever past the depth of the ocean