/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class GoblinGame {

    public static Random randomizer; //dont want multiple scanner or random, messes up!
    public static Scanner userInput;

    public static void main(String[] args) {
        randomizer = new Random();
        userInput = new Scanner(System.in);
        boolean keepPlaying = true;
        int floors = 5;
        int steps = 10;

        welcomeBanner(); //welcome message

        Goblin hero = makeNewGoblin();
        floorLoop: //loop labeled
        while (keepPlaying) {  //outer loop is per floor
            floorInfo(hero, floors);
            stepLoop:
            for (int i = 0; i < steps; i++) { //inner loop is per steps
                Monster foe = makeNewMonster();
                System.out.println("you take a step towards the exit..");
                System.out.println("but oh no! A " + foe.getName() + " has appeared!");
                boolean didGoblinWin = fightWithWeapons(hero, foe);
                if (didGoblinWin) {
                    System.out.println("you take a quick rest");
                    int goblinHealth = hero.getHealth();
                    hero.setHealth(goblinHealth++);
                } else {
                    System.out.println("You lost ):");
                    keepPlaying = false;
                    break floorLoop;
                }
            }
            System.out.println("You go to climb the stairs leading to the next floor...");
            if (floors > 1) {
                System.out.println("Go to climb the stairs");
                System.out.println("Another floor of the dugeon awaits you!");
                floors--;
            } else {
                System.out.println("YOU HAVE ESCAPED");
                keepPlaying = false;
                break floorLoop;
            }
        }
        if (isHeroDead(hero)) {
            System.out.println("Game over!!");
        } else {
            System.out.println("You won!!");
        }

    }

    //non-static for objects
    //static for the class and only one
    public static void welcomeBanner() {
        System.out.println("****                                    ****");
        System.out.println("**** Welcome to the Goblin Dungeon Game ****");
        System.out.println("****            version 1.0             ****");
    }

    public static boolean isHeroDead(Goblin hero) {
        int heroHealth = hero.getHealth();
        if (heroHealth < 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMonsterDead(Monster foe) {
        if (foe.getHealth() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Goblin makeNewGoblin() {
        System.out.println("Tell me the name of your brave goblin!!");
        String goblinName = userInput.nextLine();
        Goblin ourHero = new Goblin(goblinName);
        return ourHero;
    }

    public static Monster makeNewMonster() {
        int randomNum = randomizer.nextInt(10);
        Monster enemy = null;
        switch (randomNum) {
            case 0: // Giant BumbleBee
            case 1: //Giant BumbleBee had double the chance now
                enemy = new Monster();
                enemy.setName("Giant BumbleBee");
                enemy.setDescription("An enormous buzzing bee");
                enemy.setExperience(10);
                enemy.setHealth(5);
                break;

            default:
                enemy = new Monster();
        }
        return enemy;
    }

    public static void floorInfo(Goblin hero, int floorsLeft) {
        System.out.println("you have " + floorsLeft + " floors left.");
        System.out.println("And have " + hero.getHealth() + " health left.");
        System.out.println("........... PRESS ENTER TO CONTINUE");
        userInput.nextLine();
    }

    public static boolean fightWithWeapons(Goblin hero, Monster foe) {
        while (!hero.isDead() && !foe.isDead()) {
            hero.attack(foe);
            foe.attack(hero);
        }
        System.out.println("....press enter to continue");
        userInput.nextLine();
        boolean heroDied = !hero.isDead();
        return heroDied;
    }

    public static boolean fight(Goblin hero, Monster foe) {
        while (!isHeroDead(hero) && !isMonsterDead(foe)) {
            int heroDamage = randomizer.nextInt(5) + 1;
            int monsterDamage = randomizer.nextInt(2) + 1;

            System.out.println("Our hero " + hero.getName()
                    + " strikes for " + heroDamage + "!!!");

            System.out.println("The " + foe.getName()
                    + " strikes back for " + monsterDamage + "!!");
            int heroHP = hero.getHealth();
            
            heroHP = heroHP - monsterDamage;
            hero.setHealth(heroHP);

            int monsterHP = foe.getHealth();
            heroHP = monsterHP - heroDamage;
            foe.setHealth(heroHP);
        }
        if (!isHeroDead(hero) && isMonsterDead(foe)) {
            System.out.println("YOU won the fight");
            return true;
        } else {
            System.out.println("YOU have fallen");
            return false;
        }

    }
}
