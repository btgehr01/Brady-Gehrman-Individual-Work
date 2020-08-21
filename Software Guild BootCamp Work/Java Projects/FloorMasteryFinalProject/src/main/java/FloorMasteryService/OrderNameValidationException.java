/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryService;

/**
 *
 * @author 19bgehrman
 */
public class OrderNameValidationException extends Exception {
   public OrderNameValidationException(String message) {
        super(message);
    }

    public OrderNameValidationException(String message, Throwable cause) {
        super(message, cause);
    }  
    
}
