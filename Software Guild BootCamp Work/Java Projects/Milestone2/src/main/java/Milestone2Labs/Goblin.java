package Milestone2Labs;

import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 19bgehrman
 */
public class Goblin {

    private int health;
    private int experience;
    private String name;
    private List inventory;
    private Armor armor;
    private Weapon weapon;

    public Goblin(String name) {
        this.armor = new IronArmor(); //have to instantiate the interface - 
        //the interface is just the job des. with no code to do those methods
        this.experience = 0;
        this.health = 100;
        this.inventory = new ArrayList(); //an array list (person doing the job) is a list(job)
        this.weapon = new Sword();
        this.name = name;
    }//constructors

    public boolean attack(Monster foe) {
        int damageGonnaDo;
        if (weapon == null) {
            System.out.println(this.name + " lashes out with his green fists");
            damageGonnaDo = 3;
        } else {
            System.out.println(this.name + " goes to strike with a " + this.weapon.getName());
            damageGonnaDo = this.weapon.strike();
        }
        int damageDone = foe.takeDamage(damageGonnaDo);
        System.out.println(this.name + " deals " + damageDone + " to " + foe.getName());
        return foe.isDead();
    }

    public int takeDamage(int damage) {
        int damageGonnaTake = damage;
        if (this.armor != null) {
            damageGonnaTake = this.armor.protect(damage);
        }
        this.health = this.health - damageGonnaTake;
        if (this.health < 0) {
            this.health = 0;
        }
        return damageGonnaTake;
    }

    public boolean isDead() {
        return this.health < 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getInventory() {
        return inventory;
    }

    public void setInventory(List inventory) {
        this.inventory = inventory;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
