package com.xworkz.device;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "insert into laptop_info values(1,'dell',7400,16,512),(2,'Asus',7100,16,512),(3,'victors',8200,16,512)";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Device_db","root","root");
            System.out.println("The connection is built successfully");

            statement = connection.createStatement();

            statement.execute(sqlQuery);
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
