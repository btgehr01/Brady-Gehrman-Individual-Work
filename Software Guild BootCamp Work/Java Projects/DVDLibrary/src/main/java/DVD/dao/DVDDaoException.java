/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

/**
 *
 * @author 19bgehrman
 */
public class DVDDaoException extends Exception{
    public DVDDaoException(String message) {
        super(message);
    }

    public DVDDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
