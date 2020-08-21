/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingServiceLayer;

import Vending.Dto.ChangePurse;
import Vending.Dto.Item;
import VendingDao.VendingDao;
import VendingDao.VendingDaoStubFileImpl;
import java.math.BigDecimal;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class VendingServiceTest {

    private VendingService service;

    public VendingServiceTest() {
        VendingDao dao = new VendingDaoStubFileImpl();
        service = new VendingServiceFileImpl(dao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testGetAllItemsInMachineMethod() {
        List<Item> itemList = service.getAllItemsInMachine();
        assertEquals(1, itemList.size());
    }

    @Test
    public void testGetOneItemMethod() {
        Item item = service.getOneItem("A1");
        assertNotNull(item);
        item = service.getOneItem("A5");
        assertNull(item);
    }

    @Test
    public void testPurchaseItemMethodVendingInsufficientFundsException() throws VendingNoItemInventoryException, VendingPersistenceException, VendingInsufficientFundsException {
        BigDecimal userMoney = new BigDecimal("1.00");

        try {
            service.purchaseItem("A1", userMoney);
            fail("should throw an VendingInsufficientFundsException, but didn't");
        } catch (VendingInsufficientFundsException e) {
            return;
        }
        userMoney = new BigDecimal("1.50");
        try {
            ChangePurse change = service.purchaseItem("A1", userMoney);
            assertNotNull(change);
            //test not zero too
        } catch (VendingNoItemInventoryException e) {
            return;
        }
    }
    @Test
    public void testPurchaseItemMethodVendingNoItemInventoryException() throws VendingNoItemInventoryException, VendingPersistenceException, VendingInsufficientFundsException {
        BigDecimal userMoney = new BigDecimal("1.50");

        try {
            service.purchaseItem("A5", userMoney);
            fail("should throw an VendingNoItemInventoryException, but didn't");
        } catch (VendingNoItemInventoryException e) {
            return;
        }
        try {
            ChangePurse change = service.purchaseItem("A1", userMoney);
            assertNotNull(change);
        } catch (VendingNoItemInventoryException e) {
            return;
        }
    }
    @Test
    public void testLoadMachineMethod() throws VendingPersistenceException {
        service.loadMachine();
        List<Item> itemList = service.getAllItemsInMachine();
        Assert.assertEquals("making sure that the list has a size of 1", itemList.size(), 1);
    }
   
}
