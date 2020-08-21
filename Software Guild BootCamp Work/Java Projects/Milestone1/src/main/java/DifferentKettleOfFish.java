/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class DifferentKettleOfFish {

    public static void main(String[] args) {

        int fish;
        for (int i = 1; i <= 10; i++) {
            fish = i;
            if (fish == 3) {
                System.out.println("RED fish!");
            } else if (fish == 4) {
                System.out.println("BLUE fish!");
            } else {
                System.out.println(fish + " fish!");
            }
        }
    }
}
//I had to
//set fish to equal i and take out the fish++ at the bottom because 
//the for loop already did that for me
