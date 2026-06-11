package com.xworkz.e_commers;

import java.sql.*;

public class ProductSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "select* from customer_info";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/E_commers","root","root");
            System.out.println("The connection is built successfully.");

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("customer_id"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getInt("product_id"));
                System.out.println(resultSet.getInt("amount"));
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
