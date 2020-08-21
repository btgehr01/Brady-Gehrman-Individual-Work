/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brady Gehrman
 */
public class CreateFile {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\Assignment3\\src\\main\\java\\com\\universityoflouisville\\KYVoteHelp\\Cam.txt");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CreateFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
