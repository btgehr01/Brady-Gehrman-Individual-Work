
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
public class GuessMeMore {

    public static void main(String[] args) {
        int rounds = 0;
        boolean correct = false;
        int number;
        Random randomizer = new Random();
        number = randomizer.nextInt(201) - 100;
        Scanner input = new Scanner(System.in);
        System.out.println("I've picked a number (-100 thru 100)");
        System.out.println("------------------");
        System.out.println("guess my number (You get a max of 2 tries)!!");
        int guess = input.nextInt();
        System.out.println("your guess was " + guess);
        if (guess == number) {
            System.out.println("Wow, nice guess! That was it!");
            rounds++;
            correct = true;
        }
        if (guess < number) {
            System.out.println("Ha, nice try - too low!!");
            rounds++;
            correct = false;
        }
        if (guess > number) {
            System.out.println("Too bad, - too high!!");
            rounds++;
            correct = false;
        }

        while (rounds < 3 && correct == false){
            System.out.println("What is your last guess??");
            guess = input.nextInt();
            System.out.println("your guess was " + guess);
            if (guess == number) {
                System.out.println("Wow, nice guess! That was it!");
                rounds++;
                correct = true;
            }
            if (guess < number) {
                System.out.println("Ha, sorry - too low! I chose number " + number + " !!");
                rounds++;
                correct = false;
            }
            if (guess > number) {
                System.out.println("Too bad, - too high. I chose number " + number + " !!");
                rounds++;
                correct = false;
            }
        } 

        System.out.println("Thanks for playing!!(:");
    }
}
