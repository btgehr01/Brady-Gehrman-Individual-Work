/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingDao;

import Vending.Dto.Item;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class VendingDoaFileImplTest {

    public VendingDoaFileImplTest() {
    }
    VendingDao dao;

    @Before
    public void setUp() throws Exception {
        String testFile = "ven.txt";
        new FileWriter(testFile);
        dao = new VendingDoaFileImpl(testFile);
    }
//    private String name;
//    private BigDecimal cost;
//    private int calories;
//    private String slotID;
//    private int numOfItems;

    @Test
    public void testAddGetItemMethods() {
        String name = "chocolate";
        BigDecimal cost = new BigDecimal("1.50");
        int calories = 200;
        String slotID = "A3";
        int numOfItems = 10;

        Item chocolate = new Item(name, cost, calories, slotID, numOfItems);

        dao.addItem(chocolate);

        Item hopefullyChocolate = dao.getAnItem(chocolate.getSlotID());

        Assert.assertNotNull("making sure the returned item isn't null", hopefullyChocolate);
        Assert.assertEquals("Making sure the name hasn't changed", chocolate.getName(), hopefullyChocolate.getName());
        Assert.assertEquals("Making sure the cost hasn't changed", chocolate.getCost(), hopefullyChocolate.getCost());
        Assert.assertEquals("Making sure the calories hasn't changed", chocolate.getCalories(), hopefullyChocolate.getCalories());
        Assert.assertEquals("Making sure the slotID hasn't changed", chocolate.getSlotID(), hopefullyChocolate.getSlotID());
        Assert.assertEquals("Making sure the num of item hasn't changed", chocolate.getNumOfItems(), hopefullyChocolate.getNumOfItems());
    }

    @Test
    public void testGetAllItemMethods() {
        String name = "chocolate";
        BigDecimal cost = new BigDecimal("1.50");
        int calories = 200;
        String slotID = "A3";
        int numOfItems = 10;

        String name2 = "Reese";
        BigDecimal cost2 = new BigDecimal("1.50");
        int calories2 = 175;
        String slotID2 = "A2";
        int numOfItems2 = 10;

        Item chocolate = new Item(name, cost, calories, slotID, numOfItems);
        Item reese = new Item(name2, cost2, calories2, slotID2, numOfItems2);

        dao.addItem(chocolate);
        dao.addItem(reese);

        List<Item> itemList = dao.getAllItems();

        Assert.assertNotNull("making sure the list isn't null", itemList);
        Assert.assertEquals("making sure the item list has 2 items in it", 2, itemList.size());
        Assert.assertTrue("mking sure the list contains Chocolate", itemList.contains(chocolate));
        Assert.assertTrue("mking sure the list contains Reese", itemList.contains(reese));
    }

    @Test
    public void testUpdateAnItemMethods() {

        String name2 = "Reese";
        BigDecimal cost2 = new BigDecimal("1.50");
        int calories2 = 175;
        String slotID2 = "A2";
        int numOfItems2 = 10;

        String name = "chocolate";
        BigDecimal cost = new BigDecimal("1.50");
        int calories = 200;
        String slotID = "A3";
        int numOfItems = 10;

        Item reese = new Item(name2, cost2, calories2, slotID2, numOfItems2);
        Item newReese = new Item("Extra Most Reese", new BigDecimal("2.00"), 200, slotID2, numOfItems2);

        Item chocolate = new Item(name, cost, calories, slotID, numOfItems);
        Item newChocolate = new Item(name, cost, calories, "A5", 5);

        dao.addItem(reese);
        dao.addItem(chocolate);

        dao.updateAnItem(slotID2, newReese);
        dao.updateAnItem(slotID, newChocolate);

        Item updatedReese = dao.getAnItem(newReese.getSlotID());
        Item updatedChocolate = dao.getAnItem(newChocolate.getSlotID());

        Assert.assertNotSame("making sure the name changed", updatedReese.getName(), reese.getName());
        Assert.assertNotSame("making sure the cost changed", updatedReese.getCost(), reese.getCost());
        Assert.assertNotSame("making sure the calories changed", updatedReese.getCalories(), reese.getCalories());
        Assert.assertEquals("making sure the slotId is the same", updatedReese.getSlotID(), reese.getSlotID());
        Assert.assertEquals("making sure the inventory level is the same", updatedReese.getNumOfItems(), reese.getNumOfItems());

        Assert.assertEquals("making sure the name hasn't changed", updatedChocolate.getName(), chocolate.getName());
        Assert.assertEquals("making sure the cost hasn't changed", updatedChocolate.getCost(), chocolate.getCost());
        Assert.assertEquals("making sure the calories hasn't changed", updatedChocolate.getCalories(), chocolate.getCalories());
        Assert.assertNotSame("making sure the slotId is not the same", updatedChocolate.getSlotID(), chocolate.getSlotID());
        Assert.assertNotSame("making sure the inventory level is not the same", updatedChocolate.getNumOfItems(), chocolate.getNumOfItems());

    }

    @Test
    public void testRemoveItemMethods() {

        String name2 = "Reese";
        BigDecimal cost2 = new BigDecimal("1.50");
        int calories2 = 175;
        String slotID2 = "A2";
        int numOfItems2 = 10;

        String name = "chocolate";
        BigDecimal cost = new BigDecimal("1.50");
        int calories = 200;
        String slotID = "A3";
        int numOfItems = 10;

        Item reese = new Item(name2, cost2, calories2, slotID2, numOfItems2);

        Item chocolate = new Item(name, cost, calories, slotID, numOfItems);

        dao.addItem(reese);
        dao.addItem(chocolate);

        Item removedChocolate = dao.removeAnItem(slotID);

        Assert.assertEquals("making sure the cost hasn't changed", removedChocolate, chocolate);

        List<Item> listOfItems = dao.getAllItems();

        Assert.assertNotNull("making sure the list isn't null", listOfItems);
        Assert.assertEquals("making sure that there is only one tem left in the array", 1, listOfItems.size());
        Assert.assertTrue("making sure that reese is still in the list", listOfItems.contains(reese));
        Assert.assertFalse("making sure that chocolate was removed from the list", listOfItems.contains(chocolate));

        Item removedReese = dao.removeAnItem(slotID2);

        Assert.assertEquals("making sure that reese was the removed object", removedReese, reese);

        listOfItems = dao.getAllItems();

        Assert.assertTrue("making sure the list ofitems in now empty", listOfItems.isEmpty());
        Assert.assertFalse("making sure that reese is not still in the list", listOfItems.contains(reese));
        Assert.assertFalse("making sure that chocolate was removed from the list", listOfItems.contains(chocolate));

        Item hopefullyNullChocolate = dao.getAnItem(slotID);
        Item hopefullyNullReese = dao.getAnItem(slotID2);

        Assert.assertNull("making sure chocolate is not in the system anymore", hopefullyNullChocolate);
        Assert.assertNull("making sure chocolate is not in the system anymore", hopefullyNullReese);

    }

}
