/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.dao;

/**
 *
 * @author 19bgehrman
 */
public class ClassRosterPersistenceException extends Exception{
    
public ClassRosterPersistenceException(String message) {
	        super(message);
	    }
	    
	    public ClassRosterPersistenceException(String message, Throwable cause) {
	        super(message, cause);
	    }
	        
}
//This is the error class for our application.  It extends Exception.