/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class WorkWithStrings {

    /* 
    ** Take a noVowelWord, and change it so that it is a shout. 
    ** If there are any quiet letters, make them LOUD!
    **
    ** Ex:
    ** yell( "Hello there." ) ->  "HELLO THERE."
    ** yell( "shhhhhhhhhhhh" ) ->  SHHHHHHHHHHHH
    ** yell( "AAaAAAaAAAaaAAHHHH" ) ->  "AAAAAAAAAAAAAAHHHH"
     */
    public static String yell(String word) {
        String yelledWord;
        if (!(word == null)) {
            yelledWord = word.toUpperCase();
        } else {
            yelledWord = null;
        }
        return yelledWord;

    }

    /* 
    ** Triple your String input and return it! 
    ** However, make the first instance lowercase, the second uppercase, 
    ** and third and final lowercase - just to mix things up!
    **
    ** Ex:
    ** tripleIt( "Llama" ) ->  "llamaLLAMAllama"
    ** tripleIt( "ha" ) ->  "haHAha"
    ** tripleIt( "Beetlejuice" ) ->  "beetlejuiceBEETLEJUICEbeetlejuice"
     */
    public static String tripleIt(String theString) {
        String tripledWord;
        if (!(theString == null)) {
            tripledWord = theString.toLowerCase() + theString.toUpperCase()
                    + theString.toLowerCase();
        } else {
            tripledWord = null;
        }
        return tripledWord;
    }

    /* 
    ** Take a noVowelWord, and remove all its vowels and return!
    **
    ** Ex:
    ** removeTheVowels( "truncate" ) ->  "trnct"
    ** removeTheVowels( "squashed" ) ->  "sqshd"
    ** removeTheVowels( "compressed" ) ->  "cmprssd"
     */
    public static String removeTheVowels(String word) {
        String wordWithoutVowels;
        if (!(word == null)) {
            char[] characters = word.toCharArray();
            wordWithoutVowels = removeVowels(characters);
        } else {
            wordWithoutVowels = null;
        }
        return wordWithoutVowels;

    }

    /* 
    ** Given a phrase string - turn the whole thing around! Return the original, but totally backwards to forwards!
    **
    ** Ex:
    ** simpleReverse( "fun times" ) ->  "semit nuf"
    ** simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
    ** simpleReverse( "hannah" ) ->  "hannah"
     */
    public static String simpleReverse(String phrase) {
        String reversedWord = "";
        if (!(phrase == null)) {
            char[] characters = phrase.toCharArray();
            for (int i = characters.length - 1; i >= 0; i--) {
                reversedWord = reversedWord + characters[i];
            }
        } else {
            reversedWord = null;
        }
        return reversedWord;
    }

    /* 
    ** Take in a phrase that has many words separated by spaces. 
    ** Return the longest noVowelWord that you can find within the phrase - 
    ** don't forget, hyphenated words are allowed! 
    ** If there is a tie, return the first instance of a noVowelWord of that size.
    **
    ** Ex:
    ** longestWord( "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple" ) ->  "perspiration"
    ** longestWord( "All well-established principles should be periodically challenged" ) ->  "well-established"
    ** longestWord( "Never argue with the data" ) ->  "Never"
     */
    public static String longestWord(String aPhrase) {
        String longestWordInThePhrase = "";
        int maxLength = 0;
        if (!(aPhrase == null)) {
            String[] words = aPhrase.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (i == 0) {
//                words[i] = words[i].replace('-',' ');
                    maxLength = words[i].length();
                    longestWordInThePhrase = words[i];
                } else {
//                words[i] = words[i].replace('-',' ');
                    int length = words[i].length();
                    if (length > maxLength) {
                        maxLength = length;
                        longestWordInThePhrase = words[i];
                    }
                }

            }
        } else {
            longestWordInThePhrase = null;
        }
        return longestWordInThePhrase;
    }

    public static String removeVowels(char[] letters) {
        String noVowelWord = "";
        for (int i = 0; i < letters.length; i++) {
            Character c = letters[i];
            String characterLowerCase = c.toString().toLowerCase();
            switch (characterLowerCase) {
                case "a":
                    break;
                case "e":
                    break;
                case "i":
                    break;
                case "o":
                    break;
                case "u":
                    break;
                default:
                    noVowelWord += characterLowerCase;

            }
        }
        return noVowelWord;

    }
}
