
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
public class ForTimesFor {
    public static void main(String[] args) {
        int timesTable;
        int points = 0;
        System.out.println("Which times table do you want to test yourself on??!"); 
        Scanner input = new Scanner(System.in);
        timesTable = input.nextInt();
        for(int i = 0; i <= 15; i++){
            
            System.out.println("What is " + timesTable + " * " + i);
            int humanAwnser = input.nextInt();
            int realAwnser = i * timesTable;
            if (humanAwnser == realAwnser){
                System.out.println("You got that times table right, one point "
                        + "is added to your score");
                points++;
            }
            else{
                System.out.println("Sorry, no the awnser is actually " + realAwnser );
            }
        }
        System.out.println("you got " + points + " correct overall!!(:");
        if(points < 7){
            System.out.println("You need to study more, you got "
                    + "less than 50% of those corect");
        }
        if(points > 14){
            System.out.println("Great job! You got more than 90% of those right!");
        }
    }
    
}
