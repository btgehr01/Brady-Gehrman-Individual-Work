
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
public class GuessMyNumber {
    public static void main(String[] args) {
        int number = 12;
        Scanner input = new Scanner(System.in); 
        System.out.println("I've picked a number");
        System.out.println("------------------");
        System.out.println("guess my number!!");
        int guess =input.nextInt();
        System.out.println("your guess was " + guess);
        if(guess == number){
        System.out.println("Wow, nice guess! That was it!");
    }
        if(guess < number){
        System.out.println("Ha, nice try - too low! I chose number " + number + " !!");
    }
        if(guess > number){
            System.out.println("Too bad, way too high. I chose number " + number + " !!" );
        }
        
        
        
        
        
        
    }
}
