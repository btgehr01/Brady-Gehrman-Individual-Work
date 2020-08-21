/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.kyvotehelp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Brady Gehrman
 */
public class CamHelpCountiesToTurfs {
    private static final Map<ArrayList<String>, String> mapOfCountiesToTurfs = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String stringFromFile;
        Scanner fileScan3 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CountiesToTurf.txt"));
    
    while(fileScan3.hasNext()){
        stringFromFile = fileScan3.nextLine();
        loadCountyToTurfMap(stringFromFile);
    }
    
    
    Scanner fileScan2 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CamHelp.txt"));
    
    int countMissed = 0;
    
    while(fileScan2.hasNextLine()){
        
        stringFromFile = fileScan2.nextLine();
        Set<ArrayList<String>> keySetOfListsOfCountiesForAllTurfs = mapOfCountiesToTurfs.keySet();
        boolean foundTurf = false;
        
        for(ArrayList<String> listOfCountiesToTurf : keySetOfListsOfCountiesForAllTurfs){
            for(String county : listOfCountiesToTurf){
                if(county.equals(stringFromFile)){
                    foundTurf = true;
                    String turf = mapOfCountiesToTurfs.get(listOfCountiesToTurf);
                    System.out.println(turf);
                }
            }
        }
        
        if(!foundTurf){
        countMissed++;
        System.out.println("");    
        }
        
    }
        System.out.println("Missed: " + countMissed);
    
    }
    
    
    public static void loadCountyToTurfMap(String lineFromFile){
        ArrayList<String> countiesInATurf = new ArrayList<>();
        String turf;
        
        String[] tokens = lineFromFile.split(", ");
        
        turf = tokens[0];
        
        for (int i = 1; i < tokens.length; i++) {
            // System.out.println(turf + " " + tokens[i]);
            countiesInATurf.add(tokens[i]);
        }
        
        
        mapOfCountiesToTurfs.put(countiesInATurf, turf);
    }
    
}
