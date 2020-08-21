/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class AppWithSwitch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double operandOne;
        double operandTwo;
        double awnser;
        String operation;
        String again = "yes";
        do {

            System.out.println("What operation would you like to use? "
                    + "(/ = div)(* = mult.)(- = sub.)(+ = add.)(exit = .)");
            operation = input.next();
            System.out.println("What is your first operand (num left side of operator)(num= num.0)?");
            operandOne = input.nextDouble();
            System.out.println("What is your second operand (num right side of operator)(num= num.0)? ");
            operandTwo = input.nextDouble();
            SimpleCalculator calc = new SimpleCalculator();
            switch (operation) {
                case ".":
                    System.out.println("Goodbye");
                    break;
                case "/":
                    awnser = calc.Division(operandOne, operandTwo);
                    System.out.println("The awnser is: " + awnser);
                    break;
                case "*":
                    awnser = calc.Multiplication(operandOne, operandTwo);
                    System.out.println("The awnser is: " + awnser);
                    break;
                case "+":
                    awnser = calc.Add(operandOne, operandTwo);
                    System.out.println("The awnser is: " + awnser);
                    break;
                case "-":
                    awnser = calc.Subtract(operandOne, operandTwo);
                    System.out.println("The awnser is: " + awnser);
                    break;
                default:
                    break;
            }
            System.out.println("Would you like to do more math on this calculator? (yes)(no)");
            again = input.next();

        } while (again.equals("yes"));
        System.out.println("Thank you for using this calculator!!(:");
    }
}
