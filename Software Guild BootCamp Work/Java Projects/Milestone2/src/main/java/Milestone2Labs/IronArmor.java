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
public class IronArmor implements Armor {

    private int hits = 5;

    @Override
    public int protect(int damage) {
        if (hits > 0) {
            hits--;
            return damage - 20;
        } else {
            return damage;
        }
    }

    @Override
    public String getName() {
        return "Iron Armor";
    }

    @Override
    public String getDescription() {
        return "Heavy and Thick Iron Armor";
    }

    @Override
    public int getValue() {
        return 30;
    }
}
