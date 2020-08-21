
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
public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name;
        String color;
        String food;
        double favNum;
               
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your name?!!");   
        name = myScanner.nextLine();
        System.out.println( name + " is a cool name!");
        System.out.println("My name is Brady Gehrman");
        System.out.println("What is your favorite color?");
        color = myScanner.nextLine();
        System.out.println(color + " is also my favorite color!");
        System.out.println("What is your favorite food");
        food = myScanner.nextLine();
        System.out.println( food + " is so good!!");
        System.out.println("What is your favorite number");
        favNum = myScanner.nextDouble();
        System.out.println("I have " + favNum + " pets!! No Way?!!");
    }
}
//Create a program that uses taken user input in a conversation. 
//First ask the user for their name. Then display that name, and 
//tell them yours (or your AI's name!) Ask them for their favorite 
//color. Then display that, but in a conversational way. Do the same 
//thing with favorite food and number, and then say goodbye