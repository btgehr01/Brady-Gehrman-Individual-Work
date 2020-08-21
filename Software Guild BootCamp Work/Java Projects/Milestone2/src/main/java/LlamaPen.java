
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
public class LlamaPen {
    public static void main(String[] args) {
        Llama llamaOne = new Llama();
        int num1 = llamaOne.getNumLegs();
        String color1 = llamaOne.getWoolColor();
        
        System.out.println("your first llama has " + num1 + " legs");
        System.out.println("your first llama has " + color1 + " fur");
            
        Llama llamaTwo = new Llama(4, "blue", "extra fuzzy", 3);
        int num2= llamaTwo.getNumLegs();
        String color2 = llamaTwo.getWoolColor();
        System.out.println("your other llama has " + num2 + " legs");
        System.out.println("your other llama has " + color2 + " fur");
        
        
        Scanner myScanner = new Scanner(System.in);
       
       
        System.out.println("How many legs does your llama have?");
        int numLegs = myScanner.nextInt();
        System.out.println("Tell me about its wool!");
        String woolType = myScanner.next();
        System.out.println("What color is it?");
        String color = myScanner.next();
        System.out.println("How old is it?");
        int age = myScanner.nextInt();
        
        Llama llamaThree = new Llama();
        llamaThree.setNumLegs(numLegs);
        llamaThree.setWoolType(woolType);
        llamaThree.setWoolColor(color);
        llamaThree.setYearsOld(age);
        
        System.out.println(numLegs);
        System.out.println(woolType);
        System.out.println(color);
        System.out.println(age);
        
        Llama frankenLlama = new Llama();
        frankenLlama.setNumLegs(5);
        frankenLlama.setWoolType(llamaOne.getWoolType());
        frankenLlama.setWoolColor(llamaThree.getWoolColor());
        frankenLlama.setYearsOld(llamaTwo.getYearsOld());
        
        frankenLlama = new Llama(5, llamaOne.getWoolType(), llamaThree.getWoolColor(), llamaTwo.getYearsOld());
        
        System.out.println("I am the strangest llama:");
        System.out.println("It has:");
        System.out.println( frankenLlama.getWoolColor() + " " 
                + frankenLlama.getWoolType() + " wool");
        System.out.println(frankenLlama.getNumLegs() + " legs and "
        + "is " + frankenLlama.getYearsOld() + " years old!!");
        
        
    }
}
