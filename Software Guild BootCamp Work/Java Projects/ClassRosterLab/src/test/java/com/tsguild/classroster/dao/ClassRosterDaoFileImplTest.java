/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.dao;

import com.tsguild.classroster.dto.Student;
import java.io.FileWriter;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class ClassRosterDaoFileImplTest {

    ClassRosterDao testDao;

    public ClassRosterDaoFileImplTest() {
    }

    @Before
    public void setUp() throws Exception {
        String testFile = "testroster.txt";
        new FileWriter(testFile); // Just use the FileWriter to blank the file
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetStudent() throws Exception {
        // Create our method test inputs
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        //  Add the student to the DAO
        testDao.addStudent(studentId, student);
        // Get the student from the DAO
        Student retrievedStudent = testDao.getStudent(studentId);

        // Check the data is equal
        assertEquals("Checking student id.", student.getStudentId(), retrievedStudent.getStudentId());
        assertEquals("Checking student first name.", student.getFirstName(), retrievedStudent.getFirstName());
        assertEquals("Checking student last name.", student.getLastName(), retrievedStudent.getLastName());
        assertEquals("Checking student cohort.", student.getCohort(), retrievedStudent.getCohort());
    }

    @Test
    public void testAddGetAllStudents() throws Exception {
        // Create our first student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        // Add both our students to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // Retrieve the list of all students within the DAO
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull("The list of students must not be null", allStudents);
        assertEquals("List of students should have 2 students.", 2, allStudents.size());

        // Then the specifics
        assertTrue("The list of students should include Ada.", testDao.getAllStudents().contains(firstStudent));
        assertTrue("The list of students should include Charles.", testDao.getAllStudents().contains(secondStudent));

    }

    public void testRemoveStudent() throws Exception {
        // Create two new students
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1945");

        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1945");

        // Add both to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // remove the first student - Ada
        Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());

        // Check that the correct object was removed.
        assertEquals("The removed student should be Ada.", removedStudent, firstStudent);

        // Get all the students
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull("All students list should be not null.", allStudents);
        assertEquals("All students should only have 1 student.", 1, allStudents.size());

        // Then the specifics
        assertFalse("All students should NOT include Ada.",
                allStudents.contains(firstStudent));
        assertTrue("All students should NOT include Charles.",
                allStudents.contains(secondStudent));

        // Remove the second student
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());
        // Check that the correct object was removed.
        assertEquals("The removed student should be Charles.", removedStudent, secondStudent);

        // retrieve all of the students again, and check the list.
        allStudents = testDao.getAllStudents();

        // Check the contents of the list - it should be empty
        assertTrue("The retrieved list of students should be empty.", allStudents.isEmpty());

        // Try to 'get' both students by their old id - they should be null!
        Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
        assertNull("Ada was removed, should be null.", retrievedStudent);

        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull("Charles was removed, should be null.", retrievedStudent);

    }

}
