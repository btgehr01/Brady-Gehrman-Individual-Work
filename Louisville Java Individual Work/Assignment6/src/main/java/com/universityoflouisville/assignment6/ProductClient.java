/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment6;

import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class ProductClient {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Product[] userSpecifiedProduct = new Product[10];
        
        boolean validProductAdded;
        String userWantsToContinue = "y";
        int numOfProductsInArray = 0;
        
        System.out.println("Please add your products to our list, maximum of 10 products allowed in the list");
        for(int i = 0; userWantsToContinue.equals("y") && i < 10; i++){
            System.out.println("|*|Create a new product menu|*|");
            
            if(i == 9 ){
                System.out.println("Last Product that can be entered into out list!");
            }
            
            System.out.println("Please enter the product's 4 digit number");
            String productNum = scan.next();
            
            System.out.println("Please enter the product's price. Price must be greater than $1.25 but less than $3.01 (ex. 1.50)");
            String stringPrice = scan.next();
            double price = Double.parseDouble(stringPrice);
            
            do{
                Scanner scan1 = new Scanner(System.in);
                try {
                    Product productToAdd = new Product(productNum, price);
                    userSpecifiedProduct[i] = productToAdd;
                    numOfProductsInArray++;
                    validProductAdded = true;
                } catch (ProductNumException exception1) {
                    validProductAdded = false;
                    System.out.println("Please Enter a VALID 4 digit product number below");
                    productNum = scan1.next();
                } catch (ProductPriceException exception2) {
                    validProductAdded = false;
                    System.out.println("Please Enter a VALID product price between $1.25 and $3.01");
                    String sPrice = scan1.next();
                    price = Double.parseDouble(sPrice);
                } 
                                       
            }while(!validProductAdded); 
            
            
            System.out.println("Product added Successfully to our list :)");
            
            if(i != 9){
            System.out.println("Would you like to add another product to our list? (y/n)");
            userWantsToContinue = scan.next();
            }
           
        }
        
        System.out.println("\nHere is your list of products:\n");
        for(int j = 0; j < numOfProductsInArray; j++){
            System.out.println(userSpecifiedProduct[j]);
        }
        
    }
}
