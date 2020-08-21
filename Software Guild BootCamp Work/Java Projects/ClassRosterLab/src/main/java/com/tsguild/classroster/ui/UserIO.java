/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.classroster.ui;

/**
 *
 * @author 19bgehrman
 */
public interface UserIO {

    void print(String message);

    String readString(String msgPrompt);

    int readInt(String msgPrompt);

    int readInt(String msgPrompt, int min, int max);

    double readDouble(String msgPrompt);

    double readDouble(String msgPrompt, double min, double max);

    float readFloat(String msgPrompt);

    float readFloat(String msgPrompt, float min, float max);

    long readLong(String msgPrompt);

    long readLong(String msgPrompt, long min, long max);

}
