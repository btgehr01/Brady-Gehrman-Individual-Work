/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import Vending.Dto.Item;
import VendingServiceLayer.VendingPersistenceException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class VendingDaoStubFileImpl implements VendingDao{
    
    Item onlyItem;
    List <Item> itemList = new ArrayList<>();
    
    public VendingDaoStubFileImpl(){
        onlyItem = new Item();
        onlyItem.setName("Snickers");
        onlyItem.setCost(new BigDecimal("1.50"));
        onlyItem.setSlotID("A1");
        onlyItem.setNumOfItems(10);
        onlyItem.setCalories(150);
        
        itemList.add(onlyItem);
    }

    @Override
    public void loadAllItems() throws VendingPersistenceException {
        
    }

    @Override
    public void saveAllChanges() throws VendingPersistenceException {
        
    }

    @Override
    public Item addItem(Item anItem) {
        if(anItem.getSlotID().equals(onlyItem.getSlotID())){
            return onlyItem;
        } else{
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemList;
    }

    @Override
    public Item getAnItem(String slotID) {
        if(slotID.equals(onlyItem.getSlotID())){
            return onlyItem;
        } else{
            return null;
        }
    }

    @Override
    public void updateAnItem(String oldSlotID, Item updatedItem) {
        if(updatedItem.equals(onlyItem)){
            
        }else{
            onlyItem.equals(updatedItem);
        }
    }

    @Override
    public Item removeAnItem(String slotID) {
        if(slotID.equals(onlyItem.getSlotID())){
            return onlyItem;
        } else{
            return null;
        }
    }
    
}
