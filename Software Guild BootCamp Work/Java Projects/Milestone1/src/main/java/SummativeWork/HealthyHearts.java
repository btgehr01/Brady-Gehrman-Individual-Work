/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SummativeWork;

import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class HealthyHearts {

    public static void main(String[] args) {
        int age;
        int maxRate;
        double smallTarget;
        double bigTarget;
        long max;
        long min;
        Scanner myScanner;

        System.out.println("What is your age??!");
        myScanner = new Scanner(System.in);
        age = myScanner.nextInt();
        maxRate = (220 - age);
        smallTarget = (maxRate * 0.5);
        min = Math.round(smallTarget);
        bigTarget = (maxRate * .85);
        max = Math.round(bigTarget);
        System.out.println("Your maximum heart rate should be " + maxRate
                + " beats per minute");
        System.out.println("Your target HR Zone is " + min + " - " + max
                + " beats per minute");
    }

}
