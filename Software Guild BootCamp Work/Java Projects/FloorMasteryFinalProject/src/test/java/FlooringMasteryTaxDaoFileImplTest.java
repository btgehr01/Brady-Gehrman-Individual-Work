/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FloorMasteryDao.TaxInfoDao;
import FloorMasteryDao.TaxInfoDaoFileImpl;
import FloorMasteryDto.TaxInfo;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class FlooringMasteryTaxDaoFileImplTest {
    
    public FlooringMasteryTaxDaoFileImplTest() {
    }
    TaxInfoDao dao;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        String fileName = "TaxInfo.txt";
        new FileWriter(fileName);
        dao = new TaxInfoDaoFileImpl(fileName);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestAddGetTaxInfo() {
        String stateName = "Kentucky";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");

        TaxInfo taxInfo = new TaxInfo(stateAbbreviation, stateName, taxRate);

        dao.addTaxInfo(taxInfo);

        TaxInfo gottenTaxInfo = dao.getTaxInfo(stateAbbreviation);

        Assert.assertNotNull("Making sure the gotten taxinfo isn't null", gottenTaxInfo);
        Assert.assertEquals("Making sure the stateAbbreviation hasn't changed", gottenTaxInfo.getStateAbbreviation(), taxInfo.getStateAbbreviation());
        Assert.assertEquals("Making sure the stateName hasn't changed", gottenTaxInfo.getStateName(), taxInfo.getStateName());
        Assert.assertEquals("Making sure the taxRate hasn't changed", gottenTaxInfo.getTaxRate(), taxInfo.getTaxRate());
    }

    @Test
    public void TestGetAllTaxInfo() {
        String stateName = "Kentucky";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        
        String stateName2 = "California";
        String stateAbbreviation2 = "CA";
        BigDecimal taxRate2 = new BigDecimal("25.00"); 

        TaxInfo taxInfo = new TaxInfo(stateAbbreviation, stateName, taxRate);
        TaxInfo taxInfo2 = new TaxInfo(stateAbbreviation2, stateName2, taxRate2);

        dao.addTaxInfo(taxInfo);
        dao.addTaxInfo(taxInfo2);

        List<TaxInfo> productsList = dao.getAllOfTheTaxInfo();

        Assert.assertNotNull("makng sure the List isnt null", productsList);
        Assert.assertEquals("making sure that there are 2 objects in the list", 2, productsList.size());
        Assert.assertTrue("making sure taxInfo is included in the system", productsList.contains(taxInfo));
        Assert.assertTrue("making sure taxInfo2 is included in the system", productsList.contains(taxInfo2));
    }

    @Test
    public void TestUpdateTaxInfo() {
        String stateName = "Kentucky";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        
        String stateName2 = "California";
        String stateAbbreviation2 = "CA";
        BigDecimal taxRate2 = new BigDecimal("25.00"); 

        TaxInfo taxInfo = new TaxInfo(stateAbbreviation, stateName, taxRate);
        TaxInfo updatedTaxInfo = new TaxInfo("KY!", "Tucky", taxRate);
        
        TaxInfo taxInfo2 = new TaxInfo(stateAbbreviation2, stateName2, taxRate2);
        TaxInfo updatedTaxInfo2 = new TaxInfo(stateAbbreviation2, stateName2, new BigDecimal("26.00"));

        dao.addTaxInfo(taxInfo);
        dao.addTaxInfo(taxInfo2);

        dao.editTaxInfo(stateAbbreviation, updatedTaxInfo);
        dao.editTaxInfo(stateAbbreviation2, updatedTaxInfo2);

        TaxInfo editedTaxInfo = dao.getTaxInfo("KY!");
        TaxInfo editedTaxInfo2 = dao.getTaxInfo(stateAbbreviation2);

        org.junit.Assert.assertNotSame("making sure the stateAbbreviation changed", editedTaxInfo.getStateAbbreviation(), taxInfo.getStateAbbreviation());
        org.junit.Assert.assertNotSame("making sure the stateName changed", editedTaxInfo.getStateName(), taxInfo.getStateName());
        org.junit.Assert.assertEquals("making sure the taxRate didn't changed", editedTaxInfo.getTaxRate(), taxInfo.getTaxRate());

        org.junit.Assert.assertSame("making sure the stateAbbreviation hasn't changed", editedTaxInfo2.getStateAbbreviation(), taxInfo2.getStateAbbreviation());
        org.junit.Assert.assertSame("making sure the stateName hasn't changed", editedTaxInfo2.getStateName(), taxInfo2.getStateName());
        org.junit.Assert.assertNotEquals("making sure the taxRate has changed", editedTaxInfo2.getTaxRate(), taxInfo2.getTaxRate());
    }

    @Test
    public void TestRemoveTaxInfo() {
        String stateName = "Kentucky";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        
        String stateName2 = "California";
        String stateAbbreviation2 = "CA";
        BigDecimal taxRate2 = new BigDecimal("25.00"); 

        TaxInfo taxInfo = new TaxInfo(stateAbbreviation, stateName, taxRate);
        
        TaxInfo taxInfo2 = new TaxInfo(stateAbbreviation2, stateName2, taxRate2);

        dao.addTaxInfo(taxInfo);
        dao.addTaxInfo(taxInfo2);
        
        TaxInfo removedTaxInfo = dao.removeTaxInfo(stateAbbreviation);

        org.junit.Assert.assertEquals("making sure the product was the removed object", removedTaxInfo, taxInfo);

        List<TaxInfo> listOfTaxInfo = dao.getAllOfTheTaxInfo();

        org.junit.Assert.assertNotNull("making sure the list isn't null", listOfTaxInfo);
        org.junit.Assert.assertEquals("making sure that there is only one tem left in the array", 1, listOfTaxInfo.size());
        org.junit.Assert.assertTrue("making sure that taxInfo2 is still in the list", listOfTaxInfo.contains(taxInfo2));
        org.junit.Assert.assertFalse("making sure that taxInfo was removed from the list", listOfTaxInfo.contains(taxInfo));

        TaxInfo removedTaxInfo2 = dao.removeTaxInfo(stateAbbreviation2);

        org.junit.Assert.assertEquals("making sure that product2 was the removed object", removedTaxInfo2, taxInfo2);

        listOfTaxInfo = dao.getAllOfTheTaxInfo();

        org.junit.Assert.assertTrue("making sure the list of TaxInfo in now empty", listOfTaxInfo.isEmpty());
        org.junit.Assert.assertFalse("making sure that taxInfo is not still in the list", listOfTaxInfo.contains(taxInfo));
        org.junit.Assert.assertFalse("making sure that taxInfo2 was removed from the list", listOfTaxInfo.contains(taxInfo2));

        TaxInfo hopefullyNullTaxInfo = dao.getTaxInfo(stateAbbreviation);
        TaxInfo hopefullyNullTaxInfo2 = dao.getTaxInfo(stateAbbreviation2);

        org.junit.Assert.assertNull("making sure that TaxInfo is not in the system anymore", hopefullyNullTaxInfo);
        org.junit.Assert.assertNull("making sure that TaxInfo2 is not in the system anymore", hopefullyNullTaxInfo2);

    }

    
}
