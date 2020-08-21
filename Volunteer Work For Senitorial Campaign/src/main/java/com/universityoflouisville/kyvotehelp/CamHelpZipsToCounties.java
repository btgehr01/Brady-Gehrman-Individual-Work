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
public class CamHelpZipsToCounties {
    private static Map<String, String> mapOfZipsToCounties = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\zipsToCounties.txt"));
        while(fileScan.hasNext()){
            String nextLine = fileScan.nextLine();
            loadZipToCountyMap(nextLine);
        }
        
        Scanner fileScan2 = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\KYVoteHelp\\src\\main\\java\\com\\universityoflouisville\\kyvotehelp\\CamHelp.txt"));
        boolean foundAMatch;
        int missed = 0;
        while(fileScan2.hasNextLine()){
            foundAMatch = false;
            String zipCode = fileScan2.nextLine();
            Set<String> allZips = mapOfZipsToCounties.keySet();
            for(String zip : allZips){
                if(zip.equals(zipCode)){
                    foundAMatch = true;
                    String countyFromZipCode = mapOfZipsToCounties.get(zip);
                    System.out.println(countyFromZipCode);
                }
            }
            if(!foundAMatch){
                missed++;
                System.out.println("");
            }
        }
        System.out.println("Missed: " + missed);
    }
    public static void loadZipToCountyMap(String lineFromFile){
        String[] tokens = lineFromFile.split(" ");
        String zipCode = tokens[0];
        String county = tokens[1];
        mapOfZipsToCounties.put(zipCode, county);
    }
}
