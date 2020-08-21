/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;

import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class UserIOImplement implements UserIO {

    private Scanner input = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        String prompt = input.next();
        return prompt;
    }

    @Override
    public int readInt(String msgPrompt) {
        System.out.println(msgPrompt);
        String integer = input.next();
        int num = Integer.parseInt(integer);
        return num;
    }

    @Override
    public int readInt(String msgPrompt, int min, int max) {
        boolean keepGoing = false;
        System.out.println(msgPrompt);
        System.out.println("This is the minimum value: " + min);
        System.out.println("This is the maximum value: " + max);
        int number = input.nextInt();
        while (max < number || number < min) {
            do {
                System.out.println("Your number is not inside of the range!");
                System.out.println(msgPrompt);
                System.out.println("This is the minimum value: " + min);
                System.out.println("This is the maximum value: " + max);
                number = input.nextInt();
                if (max < number || number < min) {
                    keepGoing = true;
                }
            } while (keepGoing);
        }
        return number;
    }

    @Override
    public double readDouble(String msgPrompt) {
        System.out.println(msgPrompt);
        double number = input.nextDouble();
        return number;
    }

    @Override
    public double readDouble(String msgPrompt, double min, double max) {
    boolean keepGoing = false;
        System.out.println(msgPrompt);
        System.out.println("This is the minimum value: " + min);
        System.out.println("This is the maximum value: " + max);
        double number = input.nextDouble();
        while (max < number || number < min) {
            do {
                System.out.println("Your number is not inside of the range!");
                System.out.println(msgPrompt);
                System.out.println("This is the minimum value: " + min);
                System.out.println("This is the maximum value: " + max);
                number = input.nextInt();
                if (max < number || number < min) {
                    keepGoing = true;
                }
            } while (keepGoing);
        }
        return number;    
    }

    @Override
    public float readFloat(String msgPrompt) {
        System.out.println(msgPrompt);
        float num = input.nextFloat();
        return num;
    }

    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        boolean keepGoing = false;
        System.out.println(msgPrompt);
        System.out.println("This is the minimum value: " + min);
        System.out.println("This is the maximum value: " + max);
        float number = input.nextFloat();
        while (max < number || number < min) {
            do {
                System.out.println("Your number is not inside of the range!");
                System.out.println(msgPrompt);
                System.out.println("This is the minimum value: " + min);
                System.out.println("This is the maximum value: " + max);
                number = input.nextInt();
                if (max < number || number < min) {
                    keepGoing = true;
                }
            } while (keepGoing);
        }
        return number;    
    }

    @Override
    public long readLong(String msgPrompt) {
        System.out.println(msgPrompt);
        long num = input.nextLong();
        return num;
    }

    @Override
    public long readLong(String msgPrompt, long min, long max) {
    boolean keepGoing = false;
        System.out.println(msgPrompt);
        System.out.println("This is the minimum value: " + min);
        System.out.println("This is the maximum value: " + max);
        long number = input.nextLong();
        while (max < number || number < min) {
            do {
                System.out.println("Your number is not inside of the range!");
                System.out.println(msgPrompt);
                System.out.println("This is the minimum value: " + min);
                System.out.println("This is the maximum value: " + max);
                number = input.nextInt();
                if (max < number || number < min) {
                    keepGoing = true;
                }
            } while (keepGoing);
        }
        return number;       
    }

}
