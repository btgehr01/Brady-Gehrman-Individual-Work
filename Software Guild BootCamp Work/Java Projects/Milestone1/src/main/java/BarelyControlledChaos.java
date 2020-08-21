
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class BarelyControlledChaos {
  public static void main(String[] args) {

        String color = color();  // call color method here 
        String animal = animal();  // call animal method again here 
        String colorAgain = color();  // call color method again here 
        int weight = num(5, 200); // call number method, 
            // with a range between 5 - 200 
        int distance = num(10, 20); // call number method, 
            // with a range between 10 - 20 
        int number = num(10000, 20000);  // call number method, 
            // with a range between 10000 - 20000 
        int time = num(2, 6); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
public static int num(int one, int two){
Random randomizer = new Random();
int three = randomizer.nextInt(two - one) + one;
return three;
}
public static String animal(){
Random randomizer = new Random();
String animal = "lion";
int num = randomizer.nextInt(2);
if(num == 1){
    animal = "Hippo";
}
if(num == 0){
    animal = "Lion";
}
return animal;
}
public static String color(){
   Random randomizer = new Random();
String color = "blue";
int num = randomizer.nextInt(2);
if(num == 1){
    color = "red";
}
if(num == 0){
    color = "blue"; 
}
return color;
}
}

     


