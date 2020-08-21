
import java.util.Random;
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
public class GuessMeFinally {
  public static void main(String[] args) {
        boolean correct = false;
        int number;
        Random randomizer = new Random();
        number = randomizer.nextInt(201) - 100;
        Scanner input = new Scanner(System.in);
        System.out.println("I've picked a number (-100 thru 100)");
        System.out.println("------------------");
        System.out.println("guess my number!!");
        int guess = input.nextInt();
        System.out.println("your guess was " + guess);
        if (guess == number) {
            System.out.println("Wow, nice guess! That was it!");
            correct = true;
        }
        if (guess < number) {
            System.out.println("Ha, nice try - too low!!");
            correct = false;
        }
        if (guess > number) {
            System.out.println("Too bad, - too high!!");
            correct = false;
        }

        while (correct == false){
            System.out.println("What is your next guess??");
            guess = input.nextInt();
            System.out.println("your guess was " + guess);
            if (guess == number) {
                System.out.println("Finally, it's about time you got it!");
                correct = true;
            }
            if (guess < number) {
                System.out.println("Ha, sorry - too low. Try again");
                correct = false;
            }
            if (guess > number) {
                System.out.println("Too bad, - too high. Try again");
                correct = false;
            }
        } 

        System.out.println("Thanks for playing!!(:");
    }  
}
