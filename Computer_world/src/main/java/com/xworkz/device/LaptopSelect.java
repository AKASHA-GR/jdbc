package com.xworkz.device;

import java.sql.*;

public class LaptopSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlQuery = "select* from laptop_info";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Device_db","root","root");
            System.out.println("The connection is established.");

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                System.out.println(resultSet.getInt("device_id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("price"));
                System.out.println(resultSet.getInt("Ram"));
                System.out.println(resultSet.getInt("Rom"));
                System.out.println("-----------------------------");
            }
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

            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
