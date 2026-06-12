package com.xworkz.device;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "update laptop_info set Ram = 32 where device_id = 3";


        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Device_db","root","root");
            System.out.println("The connected successfully.");

            statement = connection.createStatement();

            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
