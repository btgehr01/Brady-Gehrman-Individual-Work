/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryService;

import FloorMasteryDao.FloorMasteryDao;
import FloorMasteryDao.ProductInfoDao;
import FloorMasteryDao.ProductionDao;
import FloorMasteryDao.TaxInfoDao;
import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.ProductInfo;
import FloorMasteryDto.TaxInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryServiceFileImpl implements FloorMasteryService {

    private final FloorMasteryDao orderDao;
    private final ProductInfoDao productDao;
    private final TaxInfoDao taxDao;
    private final ProductionDao productionDao;

    public FloorMasteryServiceFileImpl(FloorMasteryDao floorDao, ProductInfoDao productDao, TaxInfoDao taxDao, ProductionDao productionDao) {
        this.orderDao = floorDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
        this.productionDao = productionDao;
    }

    @Override
    public void loadAllOrders() throws ProductPersistenceException, TaxInfoPersistenceException, OrderPersistenceException, ProductionModePersistenceException {
        productDao.loadAllProducts();
        taxDao.loadAllTaxInfo();
        orderDao.loadAllOrders();
        productionDao.loadProductionMode();
        //could throw exceptions
    }

    @Override
    public boolean getProductionMode() {
        boolean isInProductionMode = productionDao.getProductionMode();
        return isInProductionMode;
    }

    @Override
    public void SaveAllChanges() throws OrderPersistenceException {
        orderDao.saveAllChanges();
    }

    @Override
    public CustomerOrder getOneOrder(int orderNum) {
        CustomerOrder customerOrder = orderDao.getOrder(orderNum);
        return customerOrder;
        //could return null
    }

    @Override
    public List<CustomerOrder> getAllOrders(LocalDate date) {
        List<CustomerOrder> listOfOrders = orderDao.getAllOrders(date);
        return listOfOrders;
        //could return null
    }

    @Override
    public CustomerOrder removedOrder(int orderNumber) {
        CustomerOrder removedOrder = orderDao.removeOrder(orderNumber);
        return removedOrder;
    }

    @Override
    public void editOrder(int oldOrderNumber, CustomerOrder newCustomerOrder, LocalDate oldDate) {
        orderDao.editOrder(oldOrderNumber, newCustomerOrder, oldDate);
    }

    @Override
    public TaxInfo getTaxInfo(String stateAbbreviation) {
        TaxInfo taxInfo = taxDao.getTaxInfo(stateAbbreviation);
        return taxInfo;
    }

    @Override
    public ProductInfo getProduct(String productName) {
        ProductInfo product = productDao.getProduct(productName);
        return product;
    }

    @Override
    public List<ProductInfo> getAllProducts() {
        List<ProductInfo> productsList = productDao.getAllProducts();
        return productsList;
    }

    @Override
    public List<TaxInfo> getAllTaxInfo() {
        List<TaxInfo> taxInfoList = taxDao.getAllOfTheTaxInfo();
        return taxInfoList;
    }

    @Override
    public CustomerOrder addOrder(CustomerOrder customerOrder) throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException {
        this.validateOrder(customerOrder);
        this.validateOrderDate(customerOrder);
        this.validateOrderName(customerOrder);
        this.validateOrderArea(customerOrder);
        //order is valid
        int orderNum = this.getOrderNumForOrder();
        customerOrder.setOrderNumber(orderNum);
        orderDao.addOrder(customerOrder);
        return customerOrder;
    }

    private int getOrderNumForOrder() {
        List<CustomerOrder> orderList = orderDao.getAllOrders();
        int maxOrderNum = 0;
        for (CustomerOrder oneOrder : orderList) {
            int orderNum = oneOrder.getOrderNumber();
            if (orderNum > maxOrderNum) {
                maxOrderNum = orderNum;
            }
        }
        int orderNumForNextOrder = maxOrderNum + 1;
        return orderNumForNextOrder;
    }

    private void validateOrder(CustomerOrder customerOrder) throws OrderValidationExceptionNull {
        if (customerOrder == null || customerOrder.toString().isEmpty()) {
            throw new OrderValidationExceptionNull("Order to add is null");
        }
    }

    private void validateOrderDate(CustomerOrder customerOrder) throws OrderDateValidationException {
        LocalDate nowDate = LocalDate.now();
        LocalDate orderDate = customerOrder.getDate();
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = orderDate.format(formatInput);
        String stringDateFormat = "MM/dd/yyyy";
        if (orderDate == null) {
            throw new OrderDateValidationException("Order date is null!");
        }
        if (nowDate.isAfter(orderDate)) {
            throw new OrderDateValidationException("Order date is not in the future!");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            //make sure to check the format and 
        } catch (ParseException ex) {
            throw new OrderDateValidationException("Order date is not a valid date!");
        }

    }

    private void validateOrderName(CustomerOrder customerOrder) throws OrderNameValidationException {
        String customername = customerOrder.getCustomerName();
        if (customername.isEmpty()) {
            throw new OrderNameValidationException("Order name was left blank!");
        }
    }

    private void validateOrderArea(CustomerOrder customerOrder) throws OrderAreaValidationException {
        double area = customerOrder.getArea();
        if (area < 100) {
            throw new OrderAreaValidationException("Order area is less than the minimum order size!");
        }
    }

}
