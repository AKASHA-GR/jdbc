package com.xworkz.transaction;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    public static void main(String[] args) {

        try {
            //first step: Loading and Registering the Driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully");

            //Second Step: Building connection
            String url = "jdbc:mysql://localhost:3306/payment";
            String username = "root";
            String password = "root";
            String sqlQuery = "insert into payment_info values(67687390,'Akasha',22,'Savings',600,2026)";
            Connection connect = null;
            Statement statement = null;

            try {
                connect = DriverManager.getConnection(url,username,password);
                System.out.println("Connection is successful.");

                // creat statement
                statement = connect.createStatement();

                // execute statement
                statement.execute(sqlQuery);
                System.out.println("Data inserted successfully");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //Third Step: Build statement





        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
