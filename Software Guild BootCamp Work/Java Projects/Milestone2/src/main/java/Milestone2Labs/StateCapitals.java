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
public class StateCapitals {

    public static void main(String[] args) {
        Map<String, String> newMap = new HashMap<>();
        newMap.put("Kentucky", "Frankfort");
        newMap.put("Michigan", "Lansing");
        newMap.put("Florida", "Tallahassee");
        newMap.put("Alabama", "Montgomery");
        newMap.put("Alaska", "Juneau");
        newMap.put("Arizona", "Phoenix");
        newMap.put("Arkansas", "Little Rock");
        newMap.put("Califonia", "Sacramento");
        newMap.put("Colorado", "Denver");
        newMap.put("Connecticut", "Hartford");
        newMap.put("Delaware", "Dover");
        newMap.put("Georgia", "Atlanta");
        newMap.put("Hawaii", "Honolulu");
        newMap.put("Idaho", "Boise");
        newMap.put("Illinois", "SpringField");
        newMap.put("Indiana", "Indianapolis");
        newMap.put("Iowa", "Des Moines");
        newMap.put("Kansas", "Topeka");
        newMap.put("Louisiana", "Baton Rouge");
        newMap.put("Maine", "Augusta");
        newMap.put("Maryland", "Annapolis");
        newMap.put("Massachusetts", "Boston");
        newMap.put("Minnesota", "St. Paul");
        newMap.put("Mississippi", "Jackson");
        newMap.put("Missouri", "Jefferson City");
        newMap.put("Montana", "Helena");
        newMap.put("Nebraska", "Lincoln");
        newMap.put("Nevada", "Carson City");
        newMap.put("New Hampshire", "Concord");
        newMap.put("New Jersey", "Trenton");
        newMap.put("New Mexico", "Santa Fe");
        newMap.put("New York", "Albany");
        newMap.put("North Carolina", "Raleigh");
        newMap.put("North Dakota", "Bismarck");
        newMap.put("Ohio", "Columbus");
        newMap.put("Oklahoma", "Oklahoma City");
        newMap.put("Oregon", "Salem");
        newMap.put("Pennsylvania", "Harrisburg");
        newMap.put("Rhode Island", "Providence");
        newMap.put("South Carolina", "Columbia");
        newMap.put("South Dakota", "Pierre");
        newMap.put("Tennessee", "Nashville");
        newMap.put("Texas", "Austin");
        newMap.put("Utah", "Salt Lake City");
        newMap.put("Vermont", "Montpelier");
        newMap.put("Virginia", "Richmond");
        newMap.put("Washington", "Olympia");
        newMap.put("West Virginia", "Charleston");
        newMap.put("Wisconsin", "Madison");
        newMap.put("Wyoming", "Cheyenne");

        System.out.println(newMap.size());
        Set<String> keys = newMap.keySet();
        Collection<String> values = newMap.values();
        System.out.println("STATES:\n"
                + "=======");
        for (String state : keys) {
            System.out.println(state);
        }
        System.out.println("CAPITALS:\n"
                + "=========");
        for (String capital : values) {
            System.out.println(capital);
        }
        System.out.println("STATE/CAPITAL PAIRS:\n"
                + "====================");
        for (String currentState : keys) {
            System.out.print(currentState);
            String currentCapital = newMap.get(currentState);
            System.out.print(" - ");
            System.out.print(currentCapital);
            System.out.println("");
        }

    }

}

//In the beginning of my code I instantiated my HashMap and I put 
//the state name as the key and the state capitol as the value of the key.
//I did this for all of the states. Then I got a keySet of the keys and named it 
//keys (line 73). Then I captured all of the values in a collection called values.
//I then created a enhanced for loop to put each keyset value into a String varible named
//state. Then I had the console print out every state. I also had a for loop to use the collection
//values I got and put each one of those in a string named capital. I had the program then print out
//each of the capitals. Then I used another for loop that used the keyset I used before to put each
//key into a String called currentState. These strings were printed out and then a dash was printed out
//after them to later connect the state and the capital. I then used the currentState String to 
//get its value or capital that the currentState key contained. These Capitals were then put into a variable called currentCapital
//and printed out after the dash.
