/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.ProductInfo;
import FloorMasteryService.ProductPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class ProductInfoDaoFileImpl implements ProductInfoDao {
    
    private Map<String, ProductInfo> productsMap = new HashMap<>();
    
    final String FILE;

    public ProductInfoDaoFileImpl(String fileName) {
        this.FILE = fileName;
    }

    public ProductInfoDaoFileImpl() {
        this.FILE = "Data/Products.txt";
    }
    
    
    @Override
    public ProductInfo addProduct(ProductInfo product) {
        ProductInfo addedProduct = productsMap.put(product.getProductType(), product);
        return addedProduct;
    }
    
    @Override
    public void editProduct(String oldProductName, ProductInfo newProduct) {
        String newProductName = newProduct.getProductType();
        if (newProductName.equals(oldProductName)) {
            productsMap.replace(oldProductName, newProduct);
        } else {
            productsMap.remove(oldProductName);
            
            productsMap.put(newProductName, newProduct);
        }
    }
    
    @Override
    public ProductInfo getProduct(String productType) {
        ProductInfo gottenProduct = productsMap.get(productType);
        return gottenProduct;
    }
    
    @Override
    public List<ProductInfo> getAllProducts() {
        List<ProductInfo> productsList = new ArrayList();
        Collection<ProductInfo> allProducts = productsMap.values();
        for (ProductInfo oneProduct : allProducts) {
            productsList.add(oneProduct);
        }
        return productsList;
    }
    
    @Override
    public ProductInfo removeProduct(String productType) {
        ProductInfo removedProduct = productsMap.remove(productType);
        return removedProduct;
    }
    
    @Override
    public void loadAllProducts() throws ProductPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILE)));
        } catch (FileNotFoundException ex) {
            throw new ProductPersistenceException("Could not load data from the file", ex);
        }
        String currentLine;
        scanner.nextLine(); //skips first line of file
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            ProductInfo retrivedProductInfo = unMarshallProductInfo(currentLine);
            productsMap.put(retrivedProductInfo.getProductType(), retrivedProductInfo);
        }
        scanner.close();
    }
    
    private ProductInfo unMarshallProductInfo(String productInfoAsString) {
        ProductInfo unMarshallProduct = new ProductInfo();
        String[] productInfoParts = productInfoAsString.split(",");

        // ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
        String ProductType = productInfoParts[0];
        unMarshallProduct.setProductType(ProductType);
        
        String stringCostPerSquareFoot = productInfoParts[1];
        BigDecimal costPerSquareFoot = new BigDecimal(stringCostPerSquareFoot);
        unMarshallProduct.setCostPerSquareFoot(costPerSquareFoot);
        
        String stringLaborCostPerSquareFoot = productInfoParts[2];
        BigDecimal laborCostPerSquareFoot = new BigDecimal(stringLaborCostPerSquareFoot);
        unMarshallProduct.setLaborCostPerSquareFoot(laborCostPerSquareFoot);
        
        return unMarshallProduct;
    }
    
    @Override
    public void saveAllProducts() throws ProductPersistenceException {
        PrintWriter out;
        final String FILE_NAME = "Data/Products.txt";
        
        try {
            out = new PrintWriter(new FileWriter(FILE_NAME));
        } catch (IOException ex) {
            throw new ProductPersistenceException("could not save ProductInfo Data", ex);
        }
        out.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");
        List<ProductInfo> productList = this.getAllProducts();
        for (ProductInfo productToSave : productList) {
            String wholeItem = marshallProduct(productToSave);
            out.println(wholeItem);
            out.flush();
        }
        out.close();
    }
    
    private String marshallProduct(ProductInfo productToSave) {
        final String COMA = ",";
        String newOrderAsString;
        // ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
        newOrderAsString = productToSave.getProductType() + COMA;
        
        newOrderAsString += productToSave.getCostPerSquareFoot() + COMA;
        
        newOrderAsString += productToSave.getLaborCostPerSquareFoot();
        
        return newOrderAsString;
    }
    
}
