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
public class OrderValidationExceptionNull extends Exception{
    public OrderValidationExceptionNull(String message) {
        super(message);
    }

    public OrderValidationExceptionNull(String message, Throwable cause) {
        super(message, cause);
    } 
}
