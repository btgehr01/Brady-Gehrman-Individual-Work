/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SummativeWork;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class DogGenetics {

    public static void main(String[] args) {
        String dogName;
        Scanner myScanner;
        Random randomizer;
        randomizer = new Random();
        int percent;
        int[] breeds = new int[5];
        int percentChange = 0;

        System.out.println("What is the name of your dog?");
        myScanner = new Scanner(System.in);
        dogName = myScanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on "
                + dogName + "'s prestigious background right here...");
        System.out.println("");

        System.out.println(dogName + " is:");
        System.out.println("");
        for (int i = 0; i <= 3; i++) {
            percent = randomizer.nextInt(101 - percentChange);
            breeds[i] = percent;
            percentChange = (percentChange + percent);
        }
        breeds[4] = (100 - percentChange);

        System.out.println(breeds[0] + " % St. Bernard!");
        System.out.println(breeds[1] + " % Chihuahua!");
        System.out.println(breeds[2] + " % Huskey");
        System.out.println(breeds[3] + " % Common Cur!");
        System.out.println(breeds[4] + " % King Doberman!");

        System.out.println(" Wow, that's QUITE the dog!!:)");

    }

}
