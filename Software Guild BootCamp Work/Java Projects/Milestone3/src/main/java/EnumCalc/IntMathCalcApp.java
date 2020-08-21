/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumCalc;

import com.tsguild.milestone3.MathOperator;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class IntMathCalcApp {
public static void main(String[] args) {
        IntMath math = new IntMath();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my integer calculator!");
        System.out.println("What operation would you like to do?");
        String operation = input.nextLine().toUpperCase();
        MathOperator operator = MathOperator.valueOf(operation);
        System.out.println("format: operand 1 " + operation + " operand2");
        System.out.println("What is the first integer operand that you would like use");
        String operandOne = input.nextLine();
        int operand1 = Integer.parseInt(operandOne);
        System.out.println("What integer you would you like to use as your second operand");
        String operandTwo = input.nextLine();
        int operand2 = Integer.parseInt(operandTwo);
        int answer = math.calculate(operator, operand1, operand2);
        System.out.println("The answer is: " + answer);
        System.out.println("Thank you for using my integer calculator");
    }   
}
