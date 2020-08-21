/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FileWriting {
public static void main(String[] args) throws IOException {      
List<Llama> llamaHerd;
llamaHerd = new ArrayList<>();
Llama fred = new Llama("Fred", false, 11, 55.0, "black", "fuzzy");
Llama floyd = new Llama("Floyd", false, 5, 50.0, "black and grey", "extra fuzzy");
Llama secret = new Llama("Secret", false, 6, 55.0, "black and white", "extremley fuzzy");
Llama beebop = new Llama("Beebop", false, 11, 55.0, "black", "fuzzy");
Llama boo = new Llama("Boo", false, 3, 55.0, "black", "fluffy");

llamaHerd.add(fred);
llamaHerd.add(floyd);
llamaHerd.add(secret);
llamaHerd.add(beebop);
llamaHerd.add(boo);
llamaHerd.add(new Llama("Serrano", true, 12, 33.0, "Dark brown", "soooo fluffy"));
llamaHerd.add(new Llama("Dixie", false, 8, 33.0, "Dark brown", "The fluffiest"));

System.out.println("Here are all of the Llamas");

//enhanced for loop

String booAsString = marshallLlama(boo);
System.out.println(booAsString);
for(Llama oneLlama : llamaHerd){
String llamaAsString = marshallLlama(oneLlama);
System.out.println(llamaAsString);
}
   

//now lets persist out llamas
String fileName = "llamaHerd.txt";
FileWriter fileWriter = new FileWriter(fileName);
//now setup a PrintWriter

PrintWriter printWriter = new PrintWriter(fileWriter);
//now borrow the for loop from above

for(Llama oneLlama : llamaHerd){
String llamaAsString = marshallLlama(oneLlama);
printWriter.println(llamaAsString);
}

printWriter.flush();
printWriter.close();


//this doesnt work
//System.out.println("A llama: " + floyd);
}
public static String marshallLlama(Llama aLlama){
String delimiter = "::";
//name::age::woolLength::canDrive::woolType::woolColor
String llamaLine = "";
llamaLine = llamaLine + aLlama.getName();
llamaLine = llamaLine + delimiter;
llamaLine = llamaLine + aLlama.getAge() + delimiter;
llamaLine += aLlama.getWoolLength() + delimiter;
llamaLine += aLlama.isCanDrive() + delimiter;
llamaLine += aLlama.getWoolType() + delimiter;
llamaLine += aLlama.getWoolColor();
return llamaLine;

}
}
