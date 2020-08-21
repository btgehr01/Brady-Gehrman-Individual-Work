/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 19bgehrman
 */
public class Monster {

    private int health;
    private int experience;
    private String name;
    private List loot;
    private Armor armor;
    private Weapon weapon;
    private String description;

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

    public List getLoot() {
        return loot;
    }

    public void setLoot(List loot) {
        this.loot = loot;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Monster() {
        this.armor = null;
        this.description = "big and ugly";
        this.experience = 0;
        this.health = 10;
        this.loot = new ArrayList();
        this.name = "Cleo";
        this.weapon = null;
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

    public boolean attack(Goblin hero) {
        int damageGonnaDo;
        if (weapon == null) {
            System.out.println(this.name + " lashes out with his fists");

            damageGonnaDo = 1;
        } else {
            System.out.println(this.name + " goes to strike with a " + this.weapon.getName());
            damageGonnaDo = this.weapon.strike();
        }
        int damageDone = hero.takeDamage(damageGonnaDo);
        System.out.println(this.name + " deals " + damageDone + " to " + hero.getName());
        return hero.isDead();
    }

}
