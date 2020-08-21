/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryService.OrderPersistenceException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryDaoStubFileImpl implements FloorMasteryDao {

    List<CustomerOrder> orderList = new ArrayList<>();
    List<LocalDate> dateList = new ArrayList<>();
    CustomerOrder oneOrder;

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

    public FloorMasteryDaoStubFileImpl() {
        oneOrder = new CustomerOrder(customerName, stateAbbreviation, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);
        oneOrder.setOrderNumber(orderNumber);
        orderList.add(oneOrder);
        dateList.add(oneOrder.getDate());
    }

    @Override
    public CustomerOrder addOrder(CustomerOrder order) {
        if (order.equals(oneOrder)) {
            return order;
        } else {
            return null;
        }
    }

    @Override
    public void editOrder(int oldOrderNumber, CustomerOrder newCustomerOrder, LocalDate oldDate) {
        if(newCustomerOrder.equals(oneOrder)){
            
        }else{
            oneOrder.equals(newCustomerOrder);
        }
    }

    @Override
    public CustomerOrder getOrder(int orderNum) {
        if(orderNum == oneOrder.getOrderNumber()){
            return oneOrder;
        }else{
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getAllOrders(LocalDate date) {
        if(date.equals(oneOrder.getDate())){
            return orderList;
        }else{
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        return orderList;
    }

    @Override
    public List<LocalDate> getAllDates() {
        return dateList;
    }

    @Override
    public CustomerOrder removeOrder(int orderNum) {
        if(orderNum == oneOrder.getOrderNumber()){
            return oneOrder;
        }else{
            return null;
        }
    }

    @Override
    public void loadAllOrders() throws OrderPersistenceException {
        
    }

    @Override
    public void saveAllChanges() throws OrderPersistenceException {
        
    }

}
