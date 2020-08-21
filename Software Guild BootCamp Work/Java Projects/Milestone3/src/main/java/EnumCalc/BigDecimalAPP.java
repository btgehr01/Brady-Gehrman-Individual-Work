/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumCalc;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class BigDecimalAPP {
   public static void main(String[] args) {
       String keepGoing;
       do{
        BigDecimalMath math = new BigDecimalMath();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my integer calculator!");
        System.out.println("What operation would you like to do?");
        String operation = input.nextLine().toUpperCase();
        MathOperatorEnum operator = MathOperatorEnum.valueOf(operation);
        System.out.println("format: operand 1 " + operation + " operand2");
        System.out.println("What is the first number operand that you would like use");
        String operandOne = input.nextLine();
        BigDecimal op1 = new BigDecimal(operandOne);
        System.out.println("What number would you like to use as your second operand");
        String operandTwo = input.nextLine();
        BigDecimal op2 = new BigDecimal(operandTwo);
        BigDecimal answer = math.calculate(operator, op1, op2);
        System.out.println("The answer is: " + answer);
        System.out.println("Thank you for using my integer calculator");
        
           System.out.println("Would you like to do another calculation (yes)(no)");
           keepGoing = input.nextLine();
       }while(keepGoing.contains("yes"));
       
       System.out.println("GoodBye!!");
    }    
}
