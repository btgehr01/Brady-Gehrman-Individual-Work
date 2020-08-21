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
public class TaxInfoPersistenceException extends Exception{
    public TaxInfoPersistenceException(String message) {
        super(message);
    }

    public TaxInfoPersistenceException(String message, Throwable cause) {
        super(message, cause);
    } 
}
