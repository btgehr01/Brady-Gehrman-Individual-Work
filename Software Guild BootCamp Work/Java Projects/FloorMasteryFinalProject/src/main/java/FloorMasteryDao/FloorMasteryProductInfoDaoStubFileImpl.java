/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.ProductInfo;
import FloorMasteryService.ProductPersistenceException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryProductInfoDaoStubFileImpl implements ProductInfoDao{
    
        String productType = "Wood";
        BigDecimal costPerSquareFoot = new BigDecimal("4.00");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.00");
        List<ProductInfo> productList = new ArrayList();
        ProductInfo introProduct;

    public FloorMasteryProductInfoDaoStubFileImpl() {
         introProduct = new ProductInfo(productType, costPerSquareFoot, laborCostPerSquareFoot);
         productList.add(introProduct);
    }
    
    

    @Override
    public ProductInfo addProduct(ProductInfo product) {
        if (product.equals(introProduct)) {
            return product;
        } else {
            return null;
        }
    }
    

    @Override
    public void editProduct(String oldProductName, ProductInfo newProduct) {
        if(newProduct.equals(introProduct)){
            
        }else{
            newProduct.equals(introProduct);
        }
    }

    @Override
    public ProductInfo getProduct(String productType) {
        if(productType.equals(introProduct.getProductType())){
            return introProduct;
        }else{
            return null;
        }
    }

    @Override
    public List<ProductInfo> getAllProducts() {
        return productList;
    }

    @Override
    public ProductInfo removeProduct(String productType) {
       if(productType.equals(introProduct.getProductType())){
            return introProduct;
        }else{
            return null;
        } 
    }

    @Override
    public void loadAllProducts() throws ProductPersistenceException {
        
    }

    @Override
    public void saveAllProducts() throws ProductPersistenceException {
        
    }
    
}
