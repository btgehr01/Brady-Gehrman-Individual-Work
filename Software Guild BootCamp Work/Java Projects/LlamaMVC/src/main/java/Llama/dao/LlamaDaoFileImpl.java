/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Llama.dao;

import Llama.dto.Llama;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author 19bgehrman
 */
public class LlamaDaoFileImpl implements LlamaDao {

    private Map<Integer, Llama> llamaHerd = new TreeMap<>();
    private String DELIMITER = "::";

    //single line of text for llama that will be put into a file
    public String marshallLlama(Llama llamaToTextify) {
        String llamaText = "";
        llamaText = llamaText + llamaToTextify.getId();
        llamaText += DELIMITER + llamaToTextify.getName();
        llamaText += DELIMITER + llamaToTextify.getAge();
        llamaText += DELIMITER + llamaToTextify.getWeight();
        return llamaText;
    }

    public void saveAllTheLlamas() throws IOException {
        //setip file first
        PrintWriter writer = new PrintWriter(new FileWriter("LlamaHerd.txt"));
//here we know we have a good witer!! bc they wouldve ran out if it wasnt

//get all the llmaas
        List<Llama> allDaLlamas = this.getAllLlamas();
        //iterate over the llamas
        for (Llama aLlama : allDaLlamas) {
            //for each llama
            //we need to marshall the llama
            String llamaText = this.marshallLlama(aLlama);
            writer.print(llamaText);
        }
        writer.flush();
        writer.close();
    }

    //un do the marshall, so we take in one line and take it back to become a llama
    public Llama unmarshallLlama(String aLlamaLine) {
        String[] llamaBits = aLlamaLine.split(DELIMITER);
        Llama blankLlama = new Llama();
        String llamaBitOne = llamaBits[0];
        int llamaId = Integer.parseInt(llamaBitOne);
        blankLlama.setId(llamaId);

        String llamaBitTwo = llamaBits[1];
        blankLlama.setName(llamaBitTwo);

        String llamaBitThree = llamaBits[2];
        int age = Integer.parseInt(llamaBitThree);
        blankLlama.setAge(age);

        String llamaBitFour = llamaBits[3];
        int weight = Integer.parseInt(llamaBitFour);
        blankLlama.setWeight(weight);

        return blankLlama;
    }

    public void readAllDaLlamas() throws FileNotFoundException {
        //open a scanner on the file
        //scanner takes in a buffered reader that takes in a fie reader
        Scanner fileParser = new Scanner(new BufferedReader(new FileReader("LlamaHerd.txt")));
        //now we have to break down the file
        //line by line
        while (fileParser.hasNextLine()) {
            String fileLine = fileParser.nextLine();
            Llama fileLlama = this.unmarshallLlama(fileLine);
            this.llamaHerd.put(fileLlama.getId(), fileLlama);
        }

    }

    @Override
    public Llama addLlama(Llama aLlama) {
        llamaHerd.put(aLlama.getId(), aLlama);
        return aLlama;
    }

    @Override
    public List<Llama> getAllLlamas() {

        Collection<Llama> allDaLlamas = llamaHerd.values();
        List<Llama> llamasInAList = new ArrayList<>(allDaLlamas);
        return llamasInAList;
    }

    @Override
    public Llama getLlama(int id) {
        Llama daLlama = llamaHerd.get(id);
        return daLlama;
    }

    @Override
    public void editLlama(int oldId, Llama llama) {
        //in the case that the old id and the new id are the same
        int currentID = llama.getId();
        if (currentID == oldId) {
            llamaHerd.replace(oldId, llama);
        } else {
            //oh no the ids are diffrent
            //remove the old one and put in the old one
            llamaHerd.remove(oldId);
            //store it under a new box
            llamaHerd.put(currentID, llama);
        }

    }

    @Override
    public Llama removeLlama(int id) {
        Llama removedLlama = llamaHerd.remove(id);
        return removedLlama;
    }

}
