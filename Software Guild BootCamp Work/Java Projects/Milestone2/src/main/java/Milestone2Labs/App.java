/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import UserIO.UserIO;
import UserIO.UserIOImplement;

/**
 *
 * @author 19bgehrman
 */
public class App {

    public static void main(String[] args) {
        
        double operandOne;
        double operandTwo;
        double awnser;
        String operation;
        String again = "yes";
        UserIO yourUserIO;
        yourUserIO = new UserIOImplement();

        do {

            operation = yourUserIO.readString("What operation would you like to use? "
                    + "(/ = div)(* = mult.)(- = sub.)(+ = add.)(exit = .)");

            if (operation.equals(".")) {
                yourUserIO.print("Goodbye!");
            } else {
                operandOne = yourUserIO.readDouble("What is your first operand (num left side of operator)(num= num.0)?");
                operandTwo = yourUserIO.readDouble("What is your second operand (num right side of operator)(num= num.0)? ");
                SimpleCalculator calc = new SimpleCalculator();
                if (operation.equals("*")) {
                    awnser = calc.Multiplication(operandOne, operandTwo);
                    yourUserIO.print("The awnser is: " + awnser);
                }
                if (operation.equals("/")) {
                    awnser = calc.Division(operandOne, operandTwo);
                    yourUserIO.print("The awnser is: " + awnser);
                }
                if (operation.equals("-")) {
                    awnser = calc.Subtract(operandOne, operandTwo);
                    yourUserIO.print("The awnser is: " + awnser);
                }
                if (operation.equals("+")) {
                    awnser = calc.Add(operandOne, operandTwo);
                    yourUserIO.print("The awnser is: " + awnser);
                }
                again = yourUserIO.readString("Would you like to do more math on this calculator? (yes)(no)");
            }
        } while (again.equals("yes"));
        yourUserIO.print("Thank you for using this calculator!!(:");
    }
}
//Overall now my app looks much cleaner and it is not as tightly coupled.
//Te UserIO class was not that are to immplement into my code (figurativley).
//