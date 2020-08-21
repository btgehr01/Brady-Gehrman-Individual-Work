
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
public class Opinionator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        int chooser;
        
        chooser = randomizer.nextInt(2);
        
        if(chooser == 0){
            System.out.println("I will walk my dog");
        }
        if(chooser == 1){
            System.out.println("I will play video games");
        }
            
    }
}
