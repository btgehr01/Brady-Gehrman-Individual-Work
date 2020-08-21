/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author 19bgehrman
 */
public class HiddenNuts {

    public static void main(String[] args) {
        int nut;

        int[] hidingSpots = new int[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = 1;
        System.out.println("The nut has been hidden ...");

        for (int i = 0; i < hidingSpots.length; i++) {
            nut = hidingSpots[i];
            if (nut == 1) {
                System.out.println("Nut is in array number " + i);
            } 
            
            
        }

    }

}
