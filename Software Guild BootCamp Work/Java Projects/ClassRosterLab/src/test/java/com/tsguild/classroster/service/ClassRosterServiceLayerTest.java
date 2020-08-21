/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.service;

import com.tsguild.classroster.dao.ClassRosterAuditDao;
import com.tsguild.classroster.dao.ClassRosterAuditDaoStubImpl;
import com.tsguild.classroster.dao.ClassRosterDao;
import com.tsguild.classroster.dao.ClassRosterDaoStubImpl;
import com.tsguild.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class ClassRosterServiceLayerTest {

    ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateStudentMethod() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        service.createStudent(student);

    }

    @Test
    public void testCreateStudentMethodDuplicateId() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        try {
            service.createStudent(student);
            fail("expected ClassRosterDuplicateId expection, was not thrown");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }

    }

    @Test
    public void testCreateStudentMethodInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        try {
            service.createStudent(student);
            fail("expected ClassRosterDataValidation Exception , was not thrown");
        } catch (ClassRosterDataValidationException e) {
            return;
        }

    }

    @Test
    public void testGetAllStudentMethod() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    @Test
    public void testGetStudentMethod() throws Exception {
        Student student = service.getStudent("0001");
        Assert.assertNotNull(student);
        student = service.getStudent("9999");
        Assert.assertNull(student);
    }

    @Test
    public void testRemoveStudentMethod() throws Exception {
        Student student = service.removeStudent("0001");
        Assert.assertNotNull(student);
        student = service.removeStudent("9999");
        Assert.assertNull(student);
    }

}
