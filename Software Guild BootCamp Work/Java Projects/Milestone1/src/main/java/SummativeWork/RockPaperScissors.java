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
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner myScanner;
        String input;
        int userInput;
        Random randomizer;
        int computer;
        String again = "yes";
        do {
            int wins = 0;
            int ties = 0;
            int loses = 0;
            System.out.println("How many rounds would you like to play? (1-10)");
            myScanner = new Scanner(System.in);
            input = myScanner.nextLine();
            userInput = Integer.parseInt(input);

            if (userInput > 10 || userInput < 1) {
                System.out.println("Your number of rounds is outside of the range (1-10)");
                continue;
            }
            for (int i = 1; i <= userInput; i++) {
                System.out.println("lets play rock paper scissors!!");
                System.out.println("Pick rock, paper, or scissors (lowercase)");
                input = myScanner.nextLine();
                randomizer = new Random();
                computer = randomizer.nextInt(3);

                if (computer == 0) {    //Scissors
                    if (input.equals("paper")) {
                        System.out.println("Scissors beats Paper");
                        System.out.println("You lost this round");
                        loses++;
                    } else if (input.equals("rock")) {
                        System.out.println("Rock beats Scissors");
                        System.out.println("You won this round!!");
                        wins++;
                    } else {
                        System.out.println("Scissors ties with Scissors");
                        System.out.println("You tied this round");
                        ties++;
                    }
                }
                if (computer == 1) { //Paper
                    if (input.equals("rock")) {
                        System.out.println("Paper beats Rock");
                        System.out.println("You lost this round");
                        loses++;
                    } else if (input.equals("scissors")) {
                        System.out.println("Scissors beats Paper");
                        System.out.println("You won this round!!");
                        wins++;
                    } else {
                        System.out.println("Paper ties Paper");
                        System.out.println("You tied this round");
                        ties++;
                    }
                }
                if (computer == 2) { //Rock
                    if (input.equals("scissors")) {
                        System.out.println("Rock beats Scissors");
                        System.out.println("You lost this round");
                        loses++;
                    } else if (input.equals("paper")) {
                        System.out.println("Paper beats Rock");
                        System.out.println("You won this round!!");
                        wins++;
                    } else {
                        System.out.println("Rock ties Rock");
                        System.out.println("You tied this round");
                        ties++;
                    }
                }
            }
            System.out.print("you won " + wins + " times!(:");
            System.out.print("you lost " + loses + " times!):");
            System.out.print("you tied " + ties + " times!/:");

            if (wins > loses) {
                System.out.println("You have won the game!!!");
            }
            if (loses > wins) {
                System.out.println("You have lost the game):");
            }
            if (loses == wins) {
                System.out.println("You have tied the other player!!");
            }
            System.out.println("Would you like to play again? (yes or no)");
            again = myScanner.nextLine();
        } while (again.equals("yes"));
        System.out.println("Thanks for playing!!");
    }
}
