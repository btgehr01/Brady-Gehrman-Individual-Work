/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FloorMasteryDao.FloorMasteryDao;
import FloorMasteryDao.FloorMasteryDaoFileImpl;
import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.TaxInfo;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class FlooringMasteryDaoFileImplTest {

    public FlooringMasteryDaoFileImplTest() {
    }
    FloorMasteryDao dao;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        String testFile = "Orders.txt";
        new FileWriter(testFile);
        dao = new FloorMasteryDaoFileImpl(testFile);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestAddGetOrder() {

        int orderNumber = 01;
        String customerName = "TJ";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        String productType = "Laminate";
        double area = 200;
        BigDecimal costPerSquareFoot = new BigDecimal("1.75");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.15");
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);

        CustomerOrder order = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);

        dao.addOrder(order);

        CustomerOrder gottenOrder = dao.getOrder(orderNumber);

        Assert.assertNotNull("Making sure the gotten taxinfo isn't null", gottenOrder);
        Assert.assertEquals("Making sure the order number hasn't changed", gottenOrder.getOrderNumber(), order.getOrderNumber());
        Assert.assertEquals("Making sure the customer name hasn't changed", gottenOrder.getCustomerName(), order.getCustomerName());
        Assert.assertEquals("Making sure the state abbreviation hasn't changed", gottenOrder.getState(), order.getState());
        Assert.assertEquals("Making sure the tax rate hasn't changed", gottenOrder.getTaxRate(), order.getTaxRate());
        Assert.assertEquals("Making sure the productType hasn't changed", gottenOrder.getProductType(), order.getProductType());
        Assert.assertEquals("Making sure the area hasn't changed", gottenOrder.getArea(), order.getArea(), .01);
        Assert.assertEquals("Making sure the costPerSquareFoot hasn't changed", gottenOrder.getCostPerSquareFoot(), order.getCostPerSquareFoot());
        Assert.assertEquals("Making sure the laborCostPerSquareFoot hasn't changed", gottenOrder.getLaborCostPerSquareFoot(), order.getLaborCostPerSquareFoot());
        Assert.assertEquals("Making sure the materialCost hasn't changed", gottenOrder.getMaterialCost(), order.getMaterialCost());
        Assert.assertEquals("Making sure the laborCost hasn't changed", gottenOrder.getLaborCost(), order.getLaborCost());
        Assert.assertEquals("Making sure the tax hasn't changed", gottenOrder.getTax(), order.getTax());
        Assert.assertEquals("Making sure the date hasn't changed", gottenOrder.getDate(), order.getDate());
        Assert.assertEquals("Making sure the total hasn't changed", gottenOrder.getTotal(), order.getTotal());

    }

    @Test
    public void TestGetAllOrders() {
        int orderNumber = 01;
        String customerName = "TJ";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        String productType = "Laminate";
        double area = 200.00;
        BigDecimal costPerSquareFoot = new BigDecimal("1.75");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.15");
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        
        int orderNumber2 = 02;
        String customerName2 = "Nat";
        String stateAbbreviation2 = "KY";
        BigDecimal taxRate2 = new BigDecimal("6.00");
        String productType2 = "Wood";
        double area2 = 500.00;
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.00");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("3.15");
        String stringDate2 = "01/09/2019";
        DateTimeFormatter formatInput2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date2 = LocalDate.parse(stringDate2, formatInput2);

        CustomerOrder order = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);
        
        CustomerOrder order2 = new CustomerOrder(customerName2, stateAbbreviation2, taxRate2, productType2,
                area2, costPerSquareFoot2, laborCostPerSquareFoot2, date2);
        order2.setOrderNumber(orderNumber2);

        dao.addOrder(order);
        dao.addOrder(order2);

        List<CustomerOrder> listOfAllOrders = dao.getAllOrders();

        Assert.assertNotNull("makng sure the List isnt null", listOfAllOrders);
        Assert.assertEquals("making sure that there are 2 objects in the list", 2, listOfAllOrders.size());
        Assert.assertTrue("making sure order is included in the system", listOfAllOrders.contains(order));
        Assert.assertTrue("making sure order2 is included in the system", listOfAllOrders.contains(order2));
        
        List<CustomerOrder> listOfOrdersOnDate = dao.getAllOrders(date);
        
        Assert.assertNotNull("makng sure the List isnt null", listOfOrdersOnDate);
        Assert.assertEquals("making sure that there is 1 object in the list", 1, listOfOrdersOnDate.size());
        Assert.assertTrue("making sure order is included in the system", listOfOrdersOnDate.contains(order));
        Assert.assertFalse("making sure order2 is not included in the system", listOfOrdersOnDate.contains(order2));
        
        List<CustomerOrder> listOfOrdersOnDate2 = dao.getAllOrders(date2);
        
        Assert.assertNotNull("makng sure the List isnt null", listOfOrdersOnDate2);
        Assert.assertEquals("making sure that there is 1 object in the list", 1, listOfOrdersOnDate2.size());
        Assert.assertFalse("making sure order is inot ncluded in the system", listOfOrdersOnDate2.contains(order));
        Assert.assertTrue("making sure order2 is included in the system", listOfOrdersOnDate2.contains(order2));
    }
    
    @Test
    public void TestGetAllDatesForOrder() {
        int orderNumber = 01;
        String customerName = "TJ";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        String productType = "Laminate";
        double area = 200.00;
        BigDecimal costPerSquareFoot = new BigDecimal("1.75");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.15");
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        
        int orderNumber2 = 02;
        String customerName2 = "Nat";
        String stateAbbreviation2 = "KY";
        BigDecimal taxRate2 = new BigDecimal("6.00");
        String productType2 = "Wood";
        double area2 = 500.00;
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.00");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("3.15");
        String stringDate2 = "01/09/2019";
        DateTimeFormatter formatInput2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date2 = LocalDate.parse(stringDate2, formatInput2);

        CustomerOrder order = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);
        
        CustomerOrder order2 = new CustomerOrder(customerName2, stateAbbreviation2, taxRate2, productType2,
                area2, costPerSquareFoot2, laborCostPerSquareFoot2, date2);
        order2.setOrderNumber(orderNumber2);

        dao.addOrder(order);
        dao.addOrder(order2);
        
        List<LocalDate> dateList = dao.getAllDates();
        
        Assert.assertNotNull("makng sure the List isnt null", dateList);
        Assert.assertEquals("making sure that there are 2 dates in the list", 2, dateList.size());
        Assert.assertTrue("making sure date is included in the system", dateList.contains(date));
        Assert.assertTrue("making sure date2 is included in the system", dateList.contains(date2));
        
    }
    @Test
    public void TestUpdateProduct() {
        int orderNumber = 01;
        String customerName = "TJ";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        String productType = "Laminate";
        double area = 200.00;
        BigDecimal costPerSquareFoot = new BigDecimal("1.75");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.15");
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        
        int orderNumber2 = 02;
        String customerName2 = "Nat";
        String stateAbbreviation2 = "KY";
        BigDecimal taxRate2 = new BigDecimal("6.00");
        String productType2 = "Wood";
        double area2 = 500.00;
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.00");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("3.15");
        String stringDate2 = "01/09/2019";
        DateTimeFormatter formatInput2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date2 = LocalDate.parse(stringDate2, formatInput2);

        CustomerOrder order = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);
        
        CustomerOrder newOrder = new CustomerOrder("James", "CA", new BigDecimal("25.00"), productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        newOrder.setOrderNumber(orderNumber);
        
        CustomerOrder order2 = new CustomerOrder(customerName2, stateAbbreviation2, taxRate2, productType2,
                area2, costPerSquareFoot2, laborCostPerSquareFoot2, date2);
        order2.setOrderNumber(orderNumber2);
        
        CustomerOrder newOrder2 = new CustomerOrder(customerName2, stateAbbreviation2, taxRate2, "Carpet",
                600.00, new BigDecimal("5.00"), new BigDecimal("6.00"), date);
        newOrder2.setOrderNumber(orderNumber2);

        dao.addOrder(order);
        dao.addOrder(order2);

        dao.editOrder(orderNumber, newOrder, date);
        dao.editOrder(orderNumber2, newOrder2, date); //use other date for the previous order

        CustomerOrder editedOrder = dao.getOrder(orderNumber);
        CustomerOrder editedOrder2 = dao.getOrder(orderNumber2);

        Assert.assertNotNull("Making sure the gotten order isn't null", editedOrder);
        Assert.assertEquals("Making sure the order number hasn't changed", editedOrder.getOrderNumber(), order.getOrderNumber());
        Assert.assertNotEquals("Making sure the customer name has changed", editedOrder.getCustomerName(), order.getCustomerName());
        Assert.assertNotEquals("Making sure the state abbreviation has changed", editedOrder.getState(), order.getState());
        Assert.assertNotEquals("Making sure the tax rate has changed", editedOrder.getTaxRate(), order.getTaxRate());
        Assert.assertEquals("Making sure the productType hasn't changed", editedOrder.getProductType(), order.getProductType());
        Assert.assertEquals("Making sure the area hasn't changed", editedOrder.getArea(), order.getArea(), .01);
        Assert.assertEquals("Making sure the costPerSquareFoot hasn't changed", editedOrder.getCostPerSquareFoot(), order.getCostPerSquareFoot());
        Assert.assertEquals("Making sure the laborCostPerSquareFoot hasn't changed", editedOrder.getLaborCostPerSquareFoot(), order.getLaborCostPerSquareFoot());
        Assert.assertEquals("Making sure the materialCost hasn't changed", editedOrder.getMaterialCost(), order.getMaterialCost());
        Assert.assertEquals("Making sure the laborCost hasn't changed", editedOrder.getLaborCost(), order.getLaborCost());
        Assert.assertNotEquals("Making sure the tax has changed", editedOrder.getTax(), order.getTax());
        Assert.assertEquals("Making sure the date hasn't changed", editedOrder.getDate(), order.getDate());
        Assert.assertNotEquals("Making sure the total has changed", editedOrder.getTotal(), order.getTotal());

        Assert.assertNotNull("Making sure the gotten order isn't null", editedOrder2);
        Assert.assertEquals("Making sure the order number hasn't changed", editedOrder2.getOrderNumber(), order2.getOrderNumber());
        Assert.assertEquals("Making sure the customer name hasn't changed", editedOrder2.getCustomerName(), order2.getCustomerName());
        Assert.assertEquals("Making sure the state abbreviation hasn't changed", editedOrder2.getState(), order2.getState());
        Assert.assertEquals("Making sure the tax rate hasn't changed", editedOrder2.getTaxRate(), order2.getTaxRate());
        Assert.assertNotEquals("Making sure the productType has changed", editedOrder2.getProductType(), order2.getProductType());
        Assert.assertNotEquals("Making sure the area has changed", editedOrder2.getArea(), order2.getArea(), .01);
        Assert.assertNotEquals("Making sure the costPerSquareFoot has changed", editedOrder2.getCostPerSquareFoot(), order2.getCostPerSquareFoot());
        Assert.assertNotEquals("Making sure the laborCostPerSquareFoot has changed", editedOrder2.getLaborCostPerSquareFoot(), order2.getLaborCostPerSquareFoot());
        Assert.assertNotEquals("Making sure the materialCost has changed", editedOrder2.getMaterialCost(), order2.getMaterialCost());
        Assert.assertNotEquals("Making sure the laborCost has changed", editedOrder2.getLaborCost(), order2.getLaborCost());
        Assert.assertNotEquals("Making sure the tax has changed", editedOrder2.getTax(), order2.getTax());
        Assert.assertNotEquals("Making sure the date has changed", editedOrder2.getDate(), order2.getDate());
        Assert.assertNotEquals("Making sure the total has changed", editedOrder2.getTotal(), order2.getTotal());
    }

    @Test
    public void TestRemoveProduct() {
        int orderNumber = 01;
        String customerName = "TJ";
        String stateAbbreviation = "KY";
        BigDecimal taxRate = new BigDecimal("6.00");
        String productType = "Laminate";
        double area = 200.00;
        BigDecimal costPerSquareFoot = new BigDecimal("1.75");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.15");
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        
        int orderNumber2 = 02;
        String customerName2 = "Nat";
        String stateAbbreviation2 = "KY";
        BigDecimal taxRate2 = new BigDecimal("6.00");
        String productType2 = "Wood";
        double area2 = 500.00;
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.00");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("3.15");
        String stringDate2 = "01/09/2019";
        DateTimeFormatter formatInput2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date2 = LocalDate.parse(stringDate2, formatInput2);

        CustomerOrder order = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);
        
        CustomerOrder order2 = new CustomerOrder(customerName2, stateAbbreviation2, taxRate2, productType2,
                area2, costPerSquareFoot2, laborCostPerSquareFoot2, date2);
        order.setOrderNumber(orderNumber2);
        

        dao.addOrder(order);
        dao.addOrder(order2);

        CustomerOrder removedOrder = dao.removeOrder(orderNumber);

        org.junit.Assert.assertEquals("making sure the order was the removed object", removedOrder, order);

        List<CustomerOrder> orderList = dao.getAllOrders();

        org.junit.Assert.assertNotNull("making sure the list isn't null", orderList);
        org.junit.Assert.assertEquals("making sure that there is only one object left in the array", 1, orderList.size());
        org.junit.Assert.assertTrue("making sure that order2 is still in the list", orderList.contains(order2));
        org.junit.Assert.assertFalse("making sure that order was removed from the list", orderList.contains(order));

        CustomerOrder removedOrder2 = dao.removeOrder(orderNumber2);

        org.junit.Assert.assertEquals("making sure that product2 was the removed object", removedOrder2, order2);

        orderList = dao.getAllOrders();

        org.junit.Assert.assertTrue("making sure the list of TaxInfo in now empty", orderList.isEmpty());
        org.junit.Assert.assertFalse("making sure that taxInfo is not still in the list", orderList.contains(order));
        org.junit.Assert.assertFalse("making sure that taxInfo2 was removed from the list", orderList.contains(order2));

        CustomerOrder hopefullyNullOrder = dao.getOrder(orderNumber);
        CustomerOrder hopefullyNullOrder2 = dao.getOrder(orderNumber2);

        org.junit.Assert.assertNull("making sure that order is not in the system anymore", hopefullyNullOrder);
        org.junit.Assert.assertNull("making sure that order2 is not in the system anymore", hopefullyNullOrder2);

    }

}
