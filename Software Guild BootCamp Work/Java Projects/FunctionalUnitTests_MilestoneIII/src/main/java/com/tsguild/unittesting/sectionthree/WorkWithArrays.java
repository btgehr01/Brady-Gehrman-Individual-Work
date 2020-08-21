/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ahill
 */
public class WorkWithArrays {

    /* 
    ** Given an array of ints, find and return the maximum value.
    **
    ** Ex:
    ** maxOfArray( {1}  ) ->  1
    ** maxOfArray( {3,4,5}  ) ->  5
    ** maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
     */
    public static int maxOfArray(int[] numbers) {
        int maxNum = 0;
        if (numbers.length != 0) {
            maxNum = numbers[0];
            for (int number : numbers) {
                if (number >= maxNum) {
                    maxNum = number;
                }
            }
        }
        return maxNum;
    }

    /* 
    ** Given a integer and an array of ints, times each number in the array by the multiplier.
    **
    ** Ex:
    ** multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
    ** multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
    ** multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     */
    public static int[] multiplyAll(int multiplier, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * multiplier;
        }
        return numbers;
    }

    /* 
    ** Given an array of words turn it into a single camelCased phrase. 
    ** Lower case the first words, capitalize the first letter (but only the first) of the rest.
    **
    ** Ex:
    ** camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
    ** camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
    ** camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
     */
    public static String camelCaseIt(String[] words) {
        String sentence = "";
        String oneWord;
        if (words == null) {
            return null;
        }
        if (words.length == 0) {
            return "";
        }
        for (int i = 0; i < words.length; i++) {
            oneWord = words[i].toLowerCase();
            if (!(i == 0)) {
                oneWord = "";
                String[] letters = words[i].split("");
                for (int c = 0; c < letters.length; c++) {
                    if (c == 0) {
                        letters[c] = letters[c].toUpperCase();
                    } else {
                        letters[c] = letters[c].toLowerCase();
                    }
                }
                for (int a = 0; a < letters.length; a++) {
                    oneWord = oneWord += letters[a];
                }
            }
            sentence = sentence += oneWord;

        }

        return sentence;

    }

    /* 
    ** Given an array of colors, return the one that occurs the most often. 
    ** If there are multiples that share 'most common', return the one that came first in the list.
    **
    ** Ex:
    ** mostCommonColor( {"Red", "Blue", "Red", "Blue", "Red", "Blue", "Red"}  ) ->  "Red"
    ** mostCommonColor( {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red"}  ) ->  "Violet"
    ** mostCommonColor( {"Green", "Green", "Green", "Green", "Green", "Red", "Green"}  ) ->  "Green"
     */
    public static String mostCommonColor(String[] colors) {
        String maxColor = "";
        int maxColorAmount = 0;
        Map<String, Integer> mapOfColorAmounts = new HashMap<>();
        mapOfColorAmounts.put("Red", 0);
        mapOfColorAmounts.put("Orange", 0);
        mapOfColorAmounts.put("Yellow", 0);
        mapOfColorAmounts.put("Green", 0);
        mapOfColorAmounts.put("Blue", 0);
        mapOfColorAmounts.put("Violet", 0);
        mapOfColorAmounts.put("Indigo", 0);

        for (String color : colors) {
            if (color.equals("Red")) {
                int recentAmount = mapOfColorAmounts.get("Red");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Red", recentAmount);
            }
            if (color.equals("Orange")) {
                int recentAmount = mapOfColorAmounts.get("Orange");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Orange", recentAmount);
            }
            if (color.equals("Yellow")) {
                int recentAmount = mapOfColorAmounts.get("Yellow");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Yellow", recentAmount);
            }
            if (color.equals("Green")) {
                int recentAmount = mapOfColorAmounts.get("Green");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Green", recentAmount);
            }
            if (color.equals("Blue")) {
                int recentAmount = mapOfColorAmounts.get("Blue");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Blue", recentAmount);
            }
            if (color.equals("Violet")) {
                int recentAmount = mapOfColorAmounts.get("Violet");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Violet", recentAmount);
            }
            if (color.equals("Indigo")) {
                int recentAmount = mapOfColorAmounts.get("Indigo");
                recentAmount = recentAmount + 1;
                mapOfColorAmounts.replace("Indigo", recentAmount);
            }
        }
        Set<String> diffrentColors = mapOfColorAmounts.keySet();
        for (String color : diffrentColors) {
            int colorAmount = mapOfColorAmounts.get(color);
            if (colorAmount == maxColorAmount) {
                for (int i = 0; i < colors.length; i++) {
                    if (colors[i].equals(maxColor)) {
                        break;
                    }
                    if (colors[i].equals(color)) {
                        maxColorAmount = colorAmount;
                        maxColor = color;
                        break;
                    }
                }
            }
            if (colorAmount > maxColorAmount) {
                maxColorAmount = colorAmount;
                maxColor = color;
            }
        }
        return maxColor;

    }

    /* 
    ** Given an array of doubles, return the biggest number of the lot ... as if the decimal had gone missing!
    **
    ** Ex:
    ** pointFree( [1.1, .22]  ) ->  22
    ** pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
    ** pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     */
    public static int pointFree(double[] numbers) {
        String wholeNumber = "";
        int greatestNum = 0;
        int intNum;
        for (int i = 0; i < numbers.length; i++) {
            double num = numbers[i];
            String number = Double.toString(num);
            number = number.replace('.', ':');
            String[] numberArray = number.split(":");
            for (int a = 0; a < numberArray.length; a++) {
                wholeNumber = wholeNumber += numberArray[a];
            }
            intNum = Integer.parseInt(wholeNumber);
            if (i == 0) {
                greatestNum = intNum;
            } else if (intNum >= greatestNum) {
                greatestNum = intNum;
            }
            wholeNumber = "";
        }

        return greatestNum;
    }

}
