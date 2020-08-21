/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import Vending.Dto.Item;
import VendingServiceLayer.VendingPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class VendingDoaFileImpl implements VendingDao {
    
    private Map<String, Item> itemsMap = new HashMap<>();
    final String DELIMITER = "::";
    final String txt;
    public VendingDoaFileImpl(){
        txt = "ven.txt";
    }

    public VendingDoaFileImpl(String txt) {
        this.txt = txt;
    }
    
    
    @Override
    public void loadAllItems() throws VendingPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(txt)));
        } catch (FileNotFoundException ex) {
            throw new VendingPersistenceException("Could not load data from the file", ex);
        }
        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            Item retrivedItem = unMarshallItem(currentLine);
            itemsMap.put(retrivedItem.getSlotID(), retrivedItem);
        }
        scanner.close();
    }
    
    @Override
    public void saveAllChanges() throws VendingPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(txt));
        } catch (IOException ex) {
            throw new VendingPersistenceException("could not save Vending Machine Data", ex);
        }
        List<Item> itemList = this.getAllItems();
        for (Item itemToSave : itemList) {
            String wholeItem = marshallItem(itemToSave);
            out.println(wholeItem);
            out.flush();
        }
        out.close();
    }
    
    @Override
    public Item addItem(Item anItem) {
        String slotID = anItem.getSlotID();
        Item addedItem = itemsMap.put(slotID, anItem);
        return addedItem;
    }
    
    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        Collection<Item> allItems = itemsMap.values();
        for (Item anItem : allItems) {
            itemList.add(anItem);
        }
        return itemList;
    }
    
    @Override
    public Item getAnItem(String slotID) {
        Item gottenItem = itemsMap.get(slotID);
        return gottenItem;
    }
    
    @Override
    public void updateAnItem(String oldSlotID, Item updatedItem) {
        String newSlotID = updatedItem.getSlotID();
        if (newSlotID.equals(oldSlotID)) {
            itemsMap.replace(newSlotID, updatedItem);
        } else {
            itemsMap.remove(oldSlotID);
            
            itemsMap.put(newSlotID, updatedItem);
        }
    }
    
    @Override
    public Item removeAnItem(String slotID) {
        Item removedItem = itemsMap.remove(slotID);
        return removedItem;
        
    }
    
    private String marshallItem(Item anItem) {
        String itemInLongString;
        //slotID, Name, Cost, Calories, numOfItems

        itemInLongString = anItem.getSlotID() + DELIMITER;
        
        itemInLongString += anItem.getName() + DELIMITER;
        
        itemInLongString += anItem.getCost() + DELIMITER;
        
        itemInLongString += anItem.getCalories() + DELIMITER;
        
        itemInLongString += anItem.getNumOfItems();
        
        return itemInLongString;
    }
    
    private Item unMarshallItem(String itemInLongString) {
        Item anItem = new Item();
        String[] itemTokens;

        //slotID, Name, Cost, Calories, numOfItems
        itemTokens = itemInLongString.split(DELIMITER);
        
        String slotID = itemTokens[0];
        anItem.setSlotID(slotID);
        
        String name = itemTokens[1];
        anItem.setName(name);
        
        String stringCost = itemTokens[2];
        BigDecimal cost = new BigDecimal(stringCost);
        anItem.setCost(cost);
        
        String stringCalories = itemTokens[3];
        int calories = Integer.parseInt(stringCalories);
        anItem.setCalories(calories);
        
        String stringNumOfItems = itemTokens[4];
        int numOfItems = Integer.parseInt(stringNumOfItems);
        anItem.setNumOfItems(numOfItems);
        
        return anItem;
    }
    
}
