/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.ProductInfo;
import FloorMasteryService.ProductPersistenceException;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface ProductInfoDao {
    public ProductInfo addProduct(ProductInfo product);
    public void editProduct(String oldProductName, ProductInfo newProduct);
    public ProductInfo getProduct(String productType);
    public List<ProductInfo> getAllProducts();
    public ProductInfo removeProduct(String productType);
    public void loadAllProducts() throws ProductPersistenceException;
    public void saveAllProducts() throws ProductPersistenceException;
}
