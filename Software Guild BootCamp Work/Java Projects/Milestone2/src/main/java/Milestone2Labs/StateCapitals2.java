/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class StateCapitals2 {

    public static void main(String[] args) {
        Map<String, Capital> newMap;
        newMap = new HashMap<>();

        newMap.put("Kentucky", new Capital("Frankfort", 27885, 14.6));
        newMap.put("Michigan", new Capital("Lansing", 116020, 36.68));
        newMap.put("Florida", new Capital("Tallahassee", 190894, 103.1));
        newMap.put("Alabama", new Capital("Montgomery", 200022, 162.2));
        newMap.put("Alaska", new Capital("Juneau", 32468, 3255.0));
        newMap.put("Arizona", new Capital("Phoenix"));
        newMap.put("Arkansas", new Capital("Little Rock"));
        newMap.put("Califonia", new Capital("Sacramento"));
        newMap.put("Colorado", new Capital("Denver"));
        newMap.put("Connecticut", new Capital("Hartford"));
        newMap.put("Delaware", new Capital("Dover"));
        newMap.put("Georgia", new Capital("Atlanta"));
        newMap.put("Hawaii", new Capital("Honolulu"));
        newMap.put("Idaho", new Capital("Boise"));
        newMap.put("Illinois", new Capital("SpringField"));
        newMap.put("Indiana", new Capital("Indianapolis"));
        newMap.put("Iowa", new Capital("Des Moines"));
        newMap.put("Kansas", new Capital("Topeka"));
        newMap.put("Louisiana", new Capital("Baton Rouge"));
        newMap.put("Maine", new Capital("Augusta"));
        newMap.put("Maryland", new Capital("Annapolis"));
        newMap.put("Massachusetts", new Capital("Boston"));
        newMap.put("Minnesota", new Capital("St. Paul"));
        newMap.put("Mississippi", new Capital("Jackson"));
        newMap.put("Missouri", new Capital("Jefferson City"));
        newMap.put("Montana", new Capital("Helena"));
        newMap.put("Nebraska", new Capital("Lincoln"));
        newMap.put("Nevada", new Capital("Carson City"));
        newMap.put("New Hampshire", new Capital("Concord"));
        newMap.put("New Jersey", new Capital("Trenton"));
        newMap.put("New Mexico", new Capital("Santa Fe"));
        newMap.put("New York", new Capital("Albany"));
        newMap.put("North Carolina", new Capital("Raleigh"));
        newMap.put("North Dakota", new Capital("Bismarck"));
        newMap.put("Ohio", new Capital("Columbus"));
        newMap.put("Oklahoma", new Capital("Oklahoma City"));
        newMap.put("Oregon", new Capital("Salem"));
        newMap.put("Pennsylvania", new Capital("Harrisburg"));
        newMap.put("Rhode Island", new Capital("Providence"));
        newMap.put("South Carolina", new Capital("Columbia"));
        newMap.put("South Dakota", new Capital("Pierre"));
        newMap.put("Tennessee", new Capital("Nashville"));
        newMap.put("Texas", new Capital("Austin"));
        newMap.put("Utah", new Capital("Salt Lake City"));
        newMap.put("Vermont", new Capital("Montpelier"));
        newMap.put("Virginia", new Capital("Richmond"));
        newMap.put("Washington", new Capital("Olympia"));
        newMap.put("West Virginia", new Capital("Charleston"));
        newMap.put("Wisconsin", new Capital("Madison"));
        newMap.put("Wyoming", new Capital("Cheyenne"));

        Set<String> keys = newMap.keySet();
        Collection<Capital> values = newMap.values();

        for (String state : keys) {
            Capital stateCapital = newMap.get(state);
            System.out.print(" - ");
            String name = stateCapital.getName();
            int population = stateCapital.getPopulation();
            double mileage = stateCapital.getSquareMileage();
            System.out.print(state + " - " + name + " | Pop: " + population
                    + " | Area: " + mileage + " sq. miles");
            System.out.println("");
        }
        System.out.println("Now only the big capitals!!");
        System.out.println("=============================");

        for (String bigState : keys) {
            Capital bigStateCapital = newMap.get(bigState);
            String name = bigStateCapital.getName();
            int population = bigStateCapital.getPopulation();
            double mileage = bigStateCapital.getSquareMileage();
            if (population > 150000) {
                System.out.print(" - ");
                System.out.print(bigState + " - " + name + " | Pop: " + population
                        + " | Area: " + mileage + " sq. miles");
                System.out.println("");
            }

        }
    }
}
//I first instiantiated a Hashmap called newMap and decided it would need a String as its keys and 
//a new Capital as its values. In my new Capitals object class I had 3 properties that are private:
//String name, int population, double squareMileage. Each of these properties have their appropriate 
//getters and setter that I will use later in this code. I then made constructors so that I could 
//immplement these new objects into my code. I took in the sting name of each capital as the constructors
//parameters. I had the constructors use the String name as the name of the capital and the rest I 
//used a randomizer to give the capitals random square mileage and population. To get the States and 
//the capital object to print out I used the same for loop before that took the set of keys called keys 
//and one by one put each key into a String called state. Then to get the value that belonged to the 
//key by using the newMap.get(state) to collect this I had to instantiate an object by saying
//Capital stateCapital. So then I had a new object for each key and I would use .get to get the 
//name, area, and population of each capital. To only print out the large population capitals I just
//immplemented an if statement in the enhanced for loop that would only print out the State name and its 
//cosecutive infomation if the population of the capital was greater than 150000 (used .get to get population).
    