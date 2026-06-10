package com.xworkz.histry;

public class History {
    public static void main(String[] args) {

        try {
            //first step: Loading the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
