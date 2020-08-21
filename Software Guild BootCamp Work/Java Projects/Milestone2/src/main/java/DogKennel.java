/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class DogKennel {
    public static void main(String[] args) {
        
        Dog charles;
        charles = new Dog();
        System.out.println("WE HAVE CHARLES!");
        System.out.println("This is his name: "
        + charles.getName()
        );
        
        Dog sushiDog = new Dog("Sushi", 8, 55.0);
        System.out.println("My dog" + sushiDog.getName());
        System.out.println(" is " + sushiDog.getWeight() + " lbs.");
        
        System.out.println("Charles are you there?!");
        charles.bark();
        
        System.out.println("Hey Sushi are you there?!");
        charles.bark();
        
                
    }
}
