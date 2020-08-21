/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.kyvotehelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Brady Gehrman
 */
public class CamHelpNamesToVoterID {
    private static Map<String, String> mapOfNamesToVoterID = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\nameToVoterID.txt"));
        while(fileScan.hasNext()){
            String nextLine = fileScan.nextLine();
            loadNamesToVoterIDMap(nextLine);
        }
        
        Scanner fileScan2 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CamHelp.txt"));
        boolean foundAMatch;
        int missed = 0;
        while(fileScan2.hasNextLine()){
            foundAMatch = false;
            String fullName = fileScan2.nextLine();
            Set<String> allNames = mapOfNamesToVoterID.keySet();
            for(String name : allNames){
                if(name.equals(fullName)){
                    foundAMatch = true;
                    String voterIdFromFullName = mapOfNamesToVoterID.get(name);
                    System.out.println(voterIdFromFullName);
                }
            }
            if(!foundAMatch){
                missed++;
                System.out.println("");
            }
        }
        System.out.println("Missed: " + missed);
        
        
        
        
    }
    private static void loadNamesToVoterIDMap(String lineFromFile){
        String[] tokens = lineFromFile.split(" ");
        String name = tokens[0] + " " + tokens[1];
        String userid = tokens[2];
        mapOfNamesToVoterID.put(name, userid);
    } 
}
