/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment6;

import java.text.NumberFormat;

/**
 *
 * @author Brady Gehrman
 */
public class Product {
    private String productNum;
    private double price;

    public Product(String productNum, double price) throws ProductNumException, ProductPriceException{
        if(productNum.length() > 4){
          throw new ProductNumException("Product Number must be four digits");
        }else if(price <= 1.25 || price > 3.00){
          throw new ProductPriceException("Price must be greater than $1.25 but less than or equal to $3.00");
        }
        this.productNum = productNum;
        this.price = price;
    }
    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) throws ProductNumException {
        if(productNum.length() < 4){
          throw new ProductNumException("Product Number must be four digits");
        }
        this.productNum = productNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ProductPriceException {
        if(price <= 1.25 || price > 3.00){
          throw new ProductPriceException("Price must be greater than $1.25 but less than or equal to $3.00");
        }
        this.price = price;
    }
    
    @Override
    public String toString(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String output = "Product Number: " + this.productNum;
        output += "  Product Price: " + format.format(this.price);
        return output;
    }
    
    
    
}
