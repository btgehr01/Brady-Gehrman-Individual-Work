/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import Vending.Dto.Item;
import VendingServiceLayer.VendingPersistenceException;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface VendingDao {

    public void loadAllItems()
            throws VendingPersistenceException;

    public void saveAllChanges()
            throws VendingPersistenceException;

    public Item addItem(Item anItem);

    public List<Item> getAllItems();

    public Item getAnItem(String slotID);

    public void updateAnItem(String oldSlotID, Item updatedItem);

    public Item removeAnItem(String slotID);
}
