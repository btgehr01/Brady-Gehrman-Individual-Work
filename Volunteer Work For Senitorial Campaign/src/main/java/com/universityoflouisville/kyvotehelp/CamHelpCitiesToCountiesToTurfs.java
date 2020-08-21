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
public class CamHelpCitiesToCountiesToTurfs {
    
    private static Map<String, String> mapOfCitiesToCounties = new HashMap<>();
    private static Map<ArrayList<String>, String> mapOfCountiesToTurfs = new HashMap<>();
    private static ArrayList<String> countiesInOrder = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        
     String stringFromFile;
     Scanner fileScan1;
     Scanner fileScan2;
     Scanner fileScan3;
     
     
    fileScan1 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CitiesToCounties.txt"));  
    
    while(fileScan1.hasNextLine()){
        stringFromFile = fileScan1.nextLine();
        loadCityToCountyMap(stringFromFile);
    }
    
    fileScan2 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CamHelp.txt"));
    
    int countMissed = 0;
    System.out.println("Corresponding Counties");
    while(fileScan2.hasNextLine()){
        boolean foundACountyFromACity = false;
        stringFromFile = fileScan2.nextLine();
        Set<String> keySetOfCities = mapOfCitiesToCounties.keySet();
        
        for(String city : keySetOfCities){
            if(stringFromFile.equals(city)){
                String county = mapOfCitiesToCounties.get(city);
                countiesInOrder.add(county);
                System.out.println(county);
                foundACountyFromACity = true;
            }
        }
        
        if(!foundACountyFromACity){
            countMissed++;
            countiesInOrder.add("");
            System.out.println("");
        }
        
    }
    
        System.out.println("Missed: " + countMissed + " cities");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\n\n\n");
        System.out.println("-------------------------------------------------------------------------------------------------");
    
    fileScan3 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CountiesToTurf.txt"));
    
    while(fileScan3.hasNextLine()){
        stringFromFile = fileScan3.nextLine();
        loadCountyToTurfMap(stringFromFile);
    }
    countMissed = 0;
    Set<ArrayList<String>> keySetOfCounties = mapOfCountiesToTurfs.keySet();
    
    for(String countyInList : countiesInOrder){
        boolean foundTurf = false;
        for(ArrayList<String> countyListInMap: keySetOfCounties){
            for(String countyInListInMap : countyListInMap){
                if(countyInListInMap.equals(countyInList)){
                    foundTurf = true;
                    String turf = mapOfCountiesToTurfs.get(countyListInMap);
                    System.out.println(turf);
                }
            }
        }
        if(!foundTurf){
        countMissed++;
        System.out.println("");    
        }
        
    }
    
    System.out.println("Missed: " + countMissed + " turfs");
    
    }
    
    public static void loadCityToCountyMap(String lineFromFile){
        String city;
        String county;
        String[] tokens = lineFromFile.split(" ");
        
        int length = tokens.length;
        
        switch (length) {
            case 2:
                county = tokens[1];
                city = tokens[0];
                break;
            case 3:
                county = tokens[2];
                city = tokens[0] + " " + tokens[1];
                break;
            case 4:
                county = tokens[3];
                city = tokens[0] + " " + tokens[1] + " " + tokens[2];
                break;
            default:
                county = "Not Possible";
                city = "Not Possible";
                break;
        }
            
        mapOfCitiesToCounties.put(city, county);
       
    }
    
    
    public static void loadCountyToTurfMap(String lineFromFile){
        ArrayList<String> countiesInATurf = new ArrayList<>();
        String turf;
        
        String[] tokens = lineFromFile.split(", ");
        
        turf = tokens[0];
        
        for (int i = 1; i < tokens.length; i++) {
            countiesInATurf.add(tokens[i]);
        }
        
        
        mapOfCountiesToTurfs.put(countiesInATurf, turf);
    }
        
}
