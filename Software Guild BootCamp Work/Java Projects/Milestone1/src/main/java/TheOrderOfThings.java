/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class TheOrderOfThings {

    public static void main(String[] args) {

        double number;
        String opinion;
        String size; 
        String age;
        String shape; 
        String color; 
        String origin;
        String material; 
        String purpose;
        String noun;

        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "platinum";
        purpose = "good";
        noun = "dragons";

        // Using the + with strings, doesn't add it concatenates! (sticks them together)
        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape + " " + color +
                " " + origin + " " + material + " " + purpose + " " + noun);
    }
}
