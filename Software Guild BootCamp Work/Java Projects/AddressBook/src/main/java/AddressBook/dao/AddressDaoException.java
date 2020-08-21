/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

/**
 *
 * @author 19bgehrman
 */
public class AddressDaoException extends Exception{

    public AddressDaoException(String message) {
        super(message);
    }

    public AddressDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
