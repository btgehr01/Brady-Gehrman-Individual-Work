/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryService;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.ProductInfo;
import FloorMasteryDto.TaxInfo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface FloorMasteryService {
    public void loadAllOrders() 
            throws ProductPersistenceException, TaxInfoPersistenceException, OrderPersistenceException, ProductionModePersistenceException;
    public void SaveAllChanges()
            throws OrderPersistenceException;
    public CustomerOrder getOneOrder(int orderNum);
    public List<CustomerOrder> getAllOrders(LocalDate date);
    public CustomerOrder addOrder(CustomerOrder customerOrder)throws OrderValidationExceptionNull, OrderDateValidationException,
            OrderNameValidationException, OrderAreaValidationException; //valadate the data now
    public ProductInfo getProduct(String productName);
    public List<ProductInfo> getAllProducts();
    public List<TaxInfo> getAllTaxInfo();
    public TaxInfo getTaxInfo(String stateAbbreviation);
    public boolean getProductionMode();
    public CustomerOrder removedOrder(int orderNumber);
    public void editOrder(int oldOrderNumber, CustomerOrder newCustomerOrder, LocalDate oldDate);
}
