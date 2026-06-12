package com.xworkz.missile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MissileUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "update missile_info set Hight = 30 where Name = 'Agni3'";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Defence_db","root","root");
            System.out.println("The connection is build successfully.");

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
