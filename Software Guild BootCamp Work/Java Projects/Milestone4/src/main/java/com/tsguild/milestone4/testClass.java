/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 19bgehrman
 */
public class testClass {

    public static void main(String[] args) {
        String oneDate = "01/10/2001";
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate localDate = LocalDate.parse(oneDate, formatInput);
        String date = localDate.format(formatOutput);
        String nameOfFile = "Orders_" + date + ".txt.";
        System.out.println(nameOfFile);
    }
}
