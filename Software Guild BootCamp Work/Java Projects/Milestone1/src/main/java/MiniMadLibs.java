
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
public class MiniMadLibs {
    
    public static void main(String[] args) {
       
    String noun;
    String adj; 
    String noun2; 
    int number;
    String adj2; 
    String pnoun;
    String pnoun2;
    String pnoun3;
    String verb;
    String pverb; 
    
    Scanner myScanner = new Scanner(System.in);
    
    System.out.println("Lets Play MadLibs");
        System.out.println("give me a noun");
        noun = myScanner.nextLine();
        System.out.println("give me a adjetive");
        adj = myScanner.nextLine();
        System.out.println("give me another noun");
        noun2 = myScanner.nextLine();
        System.out.println("give me a number");
        number = myScanner.nextInt();
        System.out.println("give me aother adjetive");
        adj2 = myScanner.nextLine();
        System.out.println("give me a plural noun");
        pnoun = myScanner.nextLine();
        System.out.println("give me another plural noun");
        pnoun2 = myScanner.nextLine();
        System.out.println("give me another plural noun");
        pnoun3 = myScanner.nextLine();
        System.out.println("give me a present tense verb");
        verb = myScanner.nextLine();
        System.out.println("give me the same verb but in past tense");
        pverb = myScanner.nextLine();
        
        System.out.println("Now let me mad libs it!!");
        System.out.println("-------------------------");
        
        System.out.println("" + noun + ": the " + adj + " frontier. These are the voyages of the starship " + noun2);
        System.out.println("It's " + number + " year mission to explore strange " + adj2 + pnoun);
        System.out.println(", to seek out" + adj + pnoun2 + " and " + adj + pnoun3);
        System.out.println(", to boldly" + verb + "where no one has" + pverb + "before!");
        

    
    
    
    
    
    }
}
