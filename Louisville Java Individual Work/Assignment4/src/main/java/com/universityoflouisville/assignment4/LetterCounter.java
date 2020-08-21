/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment4;

import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class LetterCounter {
    public static void main(String[] args) {
        String wantToContinue;
        do{
            
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] corespondingLetterOccurances = new int[26];
       
        
        System.out.println("Please enter a sentence that ends with a puncuation mark:");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        char[] sentenceToCharArray = sentence.toCharArray();
        
        for(int i = 0; sentenceToCharArray[i] != '.'; i++){
            for(int j = 0; j < chars.length; j++){
                if(Character.toLowerCase(sentenceToCharArray[i]) == Character.toLowerCase(chars[j])){
                    corespondingLetterOccurances[j]++;
                    break;
                }
            }
        }
        
        for(int i = 0; i < corespondingLetterOccurances.length; i++){
            if(corespondingLetterOccurances[i] > 0){
                System.out.println(chars[i] + "'s count: " + corespondingLetterOccurances[i]);
            }
        }
        
        System.out.println("Would you like to repeat? (y/n)");
        wantToContinue = scan.nextLine();
        
        }while(wantToContinue.equals("y")); 
        
        System.out.println("Thanks for using our letter counter!! (: ");
    }
}
