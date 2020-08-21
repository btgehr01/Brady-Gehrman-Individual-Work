/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryService.OrderPersistenceException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface FloorMasteryDao {
   
    public CustomerOrder addOrder(CustomerOrder order);
    public void editOrder(int oldOrderNumber, CustomerOrder newCustomerOrder, LocalDate oldDate);
    public CustomerOrder getOrder(int orderNum);
    public List<CustomerOrder> getAllOrders(LocalDate date);
    public List<CustomerOrder> getAllOrders();
    public List<LocalDate> getAllDates();
    public CustomerOrder removeOrder(int orderNum);
    public void loadAllOrders() throws OrderPersistenceException;
    public void saveAllChanges() throws OrderPersistenceException;
    
    
    
}
