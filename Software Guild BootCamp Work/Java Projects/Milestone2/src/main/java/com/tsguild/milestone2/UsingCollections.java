/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2;

import Milestone2Labs.Goblin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class UsingCollections {
    public static void main(String[] args) {
        //list of everyones names
        List<String> newList = new ArrayList<>(); 
//ArrayList is an immplementation of the interface List, you cannot intantiate an interface
        newList.add("Ty");
        newList.add("Nathaniel");
        newList.add("Josh");
        newList.add("TJ");
        newList.add("Austyn");
        newList.add("Devin");
        newList.add("Brady");
        newList.add("Kavont");
        newList.add("James");
        newList.add("Kegan");
        newList.add("Ms. Mayfeild");
        newList.add("Anthony");
        
        System.out.println("There are this many names in my list: " + newList.size());
        
        for (int i = 0; i < newList.size(); i= i + 2) { //every other name
            String name = newList.get(i);
            System.out.println(name);
        }
        System.out.println("Every name now!");
        for (int i = 0; i < newList.size(); i++) { //every name
            String name = newList.get(i);
            System.out.println(name);
        }
        //enhanced for loops
        for(String names : newList){
            System.out.println(names);
        }
        List<Goblin> someGobbos
                = new ArrayList<>();
        Goblin goblinBob = new Goblin("Bob");
        someGobbos.add(goblinBob);
        someGobbos.add(new Goblin("Mary-Sue"));
        someGobbos.add(new Goblin("Joe"));
        someGobbos.add(new Goblin("Sam"));
        someGobbos.add(new Goblin("Bartholomew"));
        someGobbos.add(new Goblin("Gobbs"));
        
        System.out.println(" there are this many goblin names: " + someGobbos.size());
        for(Goblin goblin: someGobbos){
            String name = goblin.getName();
            System.out.println(name);
        }
        System.out.println("Now we only want big, cool names to print out!!");
          for(Goblin goblin: someGobbos){
            String name = goblin.getName();
            if(name.length() > 4)
            System.out.println(name);
        }
        
        
    }
 
}
