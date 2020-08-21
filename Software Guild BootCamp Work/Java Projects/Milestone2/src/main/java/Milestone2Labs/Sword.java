/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

/**
 *
 * @author 19bgehrman
 */
public class Sword implements Weapon{

    @Override
    public int strike() {
        return 10;
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public String getDescription() {
        return "A sharpness 4 Diamond sword";
    }

    @Override
    public int getValue() {
        return 5;
    }
    
}
