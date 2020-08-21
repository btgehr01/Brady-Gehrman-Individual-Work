
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
public class AllTheTrivia {
    public static void main(String[] args) {
        int fact;
        int factTwo;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many cookies are in a bakers dozen??");
        fact = myScanner.nextInt();
        System.out.println("How many states are in the US??");
        factTwo = myScanner.nextInt();
        
        System.out.println("I didn't know there was " + factTwo + 
                " cookes in a bakers dozen of cookies!!" );
        System.out.println("I didn't know there are " + fact + " states in the US!!");
    }
 
}
