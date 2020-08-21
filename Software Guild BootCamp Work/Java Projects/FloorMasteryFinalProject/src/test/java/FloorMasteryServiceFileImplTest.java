/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FloorMasteryDao.FloorMasteryDao;
import FloorMasteryDao.FloorMasteryDaoStubFileImpl;
import FloorMasteryDao.FloorMasteryProductInfoDaoStubFileImpl;
import FloorMasteryDao.FloorMasteryProductionDaoStubFileImpl;
import FloorMasteryDao.FloorMasteryTaxInfoDaoStubFileImpl;
import FloorMasteryDao.ProductInfoDao;
import FloorMasteryDao.ProductionDao;
import FloorMasteryDao.TaxInfoDao;
import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.ProductInfo;
import FloorMasteryDto.TaxInfo;
import FloorMasteryService.FloorMasteryService;
import FloorMasteryService.FloorMasteryServiceFileImpl;
import FloorMasteryService.OrderAreaValidationException;
import FloorMasteryService.OrderDateValidationException;
import FloorMasteryService.OrderNameValidationException;
import FloorMasteryService.OrderValidationExceptionNull;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryServiceFileImplTest {

    private FloorMasteryService service;

    public FloorMasteryServiceFileImplTest() {
        FloorMasteryDao dao = new FloorMasteryDaoStubFileImpl();
        ProductInfoDao productDao = new FloorMasteryProductInfoDaoStubFileImpl();
        TaxInfoDao taxDao = new FloorMasteryTaxInfoDaoStubFileImpl();
        ProductionDao productionDao = new FloorMasteryProductionDaoStubFileImpl();
        //instantiate four daos
        //need four stub daos
        service = new FloorMasteryServiceFileImpl(dao, productDao, taxDao, productionDao);
        //and test pass-through methods
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
    public void testCreateOrder() throws Exception {
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
        service.addOrder(order);
    }

    @Test
    public void testOrderAreaException() throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {
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

        order.setArea(1.00);
        order.setOrderNumber(orderNumber);

        try {
            service.addOrder(order);
            fail("Expected OrderAreaValidationException was not thrown.");
        } catch (OrderAreaValidationException e) {
            return;
        }

    }

    @Test
    public void testOrderDateExceptionPriorDate() throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {
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

        String badDate = "06/20/2008";
        date = LocalDate.parse(badDate, formatInput);
        order.setDate(date);
        order.setOrderNumber(orderNumber);

        try {
            service.addOrder(order);
            fail("Expected OrderDateValidationException was not thrown.");
        } catch (OrderDateValidationException e) {
            return;
        }

    }

    @Test
    public void testOrderDateExceptionBadInput() throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {

        String badDate = "0/20/20";
        String stringDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(badDate);
            fail("Expected OrderDateValidationException was not thrown.");
        } catch (ParseException ex) {
            return;
        }

    }

    @Test
    public void testOrderNameException() throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {
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

        order.setCustomerName("");
        order.setOrderNumber(orderNumber);

        try {
            service.addOrder(order);
            fail("Expected OrderNameValidationException was not thrown.");
        } catch (OrderNameValidationException e) {
            return;
        }
    }

    @Test
    public void testOrderValidationException() throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {
        CustomerOrder order = new CustomerOrder();
        try {
            service.addOrder(order);
            fail("Expected OrderValidationExceptionNull was not thrown.");
        } catch (OrderValidationExceptionNull e) {
            return;
        }
    }

    @Test
    public void testGetAllProducts() {
        List<ProductInfo> productList = service.getAllProducts();
        Assert.assertEquals("Making sure thats the product from the stub file exists", 1, productList.size());
    }

    @Test
    public void testGetAllTaxInfo() {
        List<TaxInfo> taxList = service.getAllTaxInfo();
        Assert.assertEquals("Making sure thats the tax from the stub file exists", 1, taxList.size());
    }

    @Test
    public void TestGetAnOrder() {
        String stringDate = "01/05/2019";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        List<CustomerOrder> orderList = service.getAllOrders(date);
        Assert.assertEquals("Making sure thats the order from the stub file exists", 1, orderList.size());
    }

    @Test
    public void TestGetProductionMode() {
        boolean production = service.getProductionMode();
        Assert.assertEquals("Making sure the true from the stubFile has passed through", production, true);
    }

    @Test
    public void TestGetTaxInfo() {
        String stateAbbreviation = "KY";
        TaxInfo taxInfo = service.getTaxInfo(stateAbbreviation);
        Assert.assertNotNull("Making sure that the taxInfo was gotten", taxInfo);
    }

    @Test
    public void TestGetProduct() {
        String productType = "Wood";
        ProductInfo product = service.getProduct(productType);
        Assert.assertNotNull("Making sure that the product was gotten", product);
    }

    @Test
    public void TestGetOrder() {
        int orderNumber = 01;
        CustomerOrder order = service.getOneOrder(orderNumber);
        Assert.assertNotNull("Making sure that the order was gotten", order);
    }

    @Test
    public void TestRemoveOrder() {
        int orderNumber = 01;
        CustomerOrder removedOrder = service.removedOrder(orderNumber);
        Assert.assertNotNull("Hopefully not null order bc of stub", removedOrder);
    }

    @Test
    public void testEditOrder() {
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

        CustomerOrder newCustomerOrder = new CustomerOrder("Bobby", stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        order.setOrderNumber(orderNumber);

        service.editOrder(orderNumber, newCustomerOrder, date);
        
        CustomerOrder editedOrder = service.getOneOrder(orderNumber);

        Assert.assertNotSame("Making sure the edited order went through and the orders are now not equal", order, editedOrder);
    }

}
