/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.service;

import com.tsguild.classroster.dao.ClassRosterPersistenceException;
import com.tsguild.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface ClassRosterServiceLayer {
    
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, //throw if the id is a duplicate id
            ClassRosterDataValidationException, //throw if id or the name is left blank
            ClassRosterPersistenceException; //throw if there is an issue with the Dao
            
    public List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    public Student getStudent(String studentId) throws ClassRosterPersistenceException;
    
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException;
    
    
}
