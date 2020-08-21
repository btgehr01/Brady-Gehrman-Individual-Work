/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.dao;

import com.tsguild.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface ClassRosterDao {

    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given student
     * id if it exists, null otherwise
     */
    Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException;

    /**
     * Returns a String array containing the student ids of all students in the
     * roster.
     *
     * @return String array containing the ids of all the students in the roster
     */
    List<Student> getAllStudents()
            throws ClassRosterPersistenceException;

    /**
     * Returns the student object associated with the given student id. Returns
     * null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id, null if
     * no such student exists
     */
    Student getStudent(String studentId)
             throws ClassRosterPersistenceException;

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the student object that is being removed or null if there is no student
     * associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student was
     * associated with the given student id
     */
    Student removeStudent(String studentId)
            throws ClassRosterPersistenceException;
}

//This interface defines the methods that must be implemented by any class that 
//wants to play the role of DAO in the application.  We will implement a text 
//file-based DAO in the code-along.  You could imagine, however, an implementation 
//that only stored student data in memory, or one that stored student data in a database.  
//Each class would be different but all would implement that same interface, 
//ensuring that they are all well encapsulated.  Note that the ClassRosterController 
//only uses this interface to reference the DAO — it is completely unaware of the 
//implementation details.
