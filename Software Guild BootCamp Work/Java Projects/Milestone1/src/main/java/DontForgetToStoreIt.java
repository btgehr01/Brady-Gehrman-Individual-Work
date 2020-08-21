
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
public class DontForgetToStoreIt {
    public static void main(String[] args) {

        int meaningOfLifeAndEverything;
        double pi = 3.14159;
        String cheese;
        String color;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Give me pi to at least 5 decimals: ");
        String num = inputReader.nextLine();
        pi = Double.parseDouble(num);
        
        System.out.println("What is the meaning of life, the universe & everything (number)? ");
        String num2 = inputReader.nextLine();
        meaningOfLifeAndEverything = Integer.parseInt(num2);

        System.out.println("What is your favorite kind of cheese? ");
        cheese = inputReader.nextLine();
     
        System.out.println("Do you like the color red or blue more? ");
        color = inputReader.nextLine();

            System.out.println("Ooh, " 
                 + color + " " + cheese + " cheese sounds delicious!");
            System.out.println("The circumference of life is " 
                 + ( 2 * pi * meaningOfLifeAndEverything));
    }
}
