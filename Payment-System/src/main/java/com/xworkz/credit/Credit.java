package com.xworkz.credit;

public class Credit {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
