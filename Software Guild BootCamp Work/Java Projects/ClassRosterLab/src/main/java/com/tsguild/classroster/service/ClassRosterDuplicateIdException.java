/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.service;

/**
 *
 * @author 19bgehrman
 */
public class ClassRosterDuplicateIdException extends Exception{
    
    public ClassRosterDuplicateIdException (String message){
    super(message);
}
    public ClassRosterDuplicateIdException (String message, Throwable cause){
    super(message, cause);
}
    
}
