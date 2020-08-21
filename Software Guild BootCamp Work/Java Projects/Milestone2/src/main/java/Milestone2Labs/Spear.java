/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.Random;

/**
 *
 * @author 19bgehrman
 */
public class Spear implements Weapon {

    @Override
    public int strike() {
    Random randomizer = new Random();
    int roll = randomizer.nextInt(20) + 1;
    if (roll == 20){
        return 100;
    }
    else{
       int damage = randomizer.nextInt(50) + 25;
       return damage;
    }
    }

    @Override
    public String getName() {
    return "Mighty Spear";    
    }

    @Override
    public String getDescription() {
    return "very pointy spear";
    }

    @Override
    public int getValue() {
    return 50; //coin value    
    }
    
}
