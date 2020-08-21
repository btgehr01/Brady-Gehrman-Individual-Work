/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class FileReading {
    public static void main(String[] args) throws FileNotFoundException {
    String llamaAsString = "Fred::11::55.0::false::fuzzy::black";
    
    
    Llama fred = unmarshallLlama(llamaAsString);
        System.out.println("I reconstituted Fred!");
        System.out.println("Fred's age is: " + fred.getAge());
        
        
        System.out.println("Lets bring the whole herd in!!");
        
        List<Llama> llamaHerd = new ArrayList<>();
        String fileName = "llamaHerd.txt";
        FileReader fileReader = new FileReader(fileName);
        //now lets read the file
        BufferedReader reader = new BufferedReader(fileReader);
        //now lets parse the file
        Scanner scanner = new Scanner(reader);
        
        while(scanner.hasNextLine()){
            String llamaLine = scanner.nextLine();
            Llama theLlama = unmarshallLlama(llamaLine);
            llamaHerd.add(theLlama);
            
        }
        scanner.close();
        
        System.out.println("I read the file and found: " + llamaHerd.size() +
                " llamas in it!! ");
        
        for(Llama nextLlama : llamaHerd){
            
        }
        
    }
    
    
    public static Llama unmarshallLlama(String llamaAsString){
        //name :: age :: woolLength :: canDrive :: woolType :: woolColor
        Llama aNewLlama = new Llama();
        String delimiter = "::";
        String[] llamaBits = llamaAsString.split(delimiter);
        String llamaname = llamaBits[0];
        aNewLlama.setName(llamaname);
        aNewLlama.setWoolType(llamaBits[4]);
        aNewLlama.setWoolColor(llamaBits[5]);
        
        //however some things ren't strings
        String llamaAgeAsString = llamaBits[1];
        int llamaAge = Integer.parseInt(llamaAgeAsString);
        aNewLlama.setAge(llamaAge);
        
        aNewLlama.setCanDrive(Boolean.parseBoolean(llamaBits[3]));
        
        aNewLlama.setWoolLength(Double.parseDouble(llamaBits[2]));
        return aNewLlama;
    }
}
