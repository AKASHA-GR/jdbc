package com.xworkz.missile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MissileInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "insert into missile_info values ('Agni1',700,15,12000,'2.4M'),('Agni2',2000,20,17000,'4.1M'),('Agni3',3000,17,48000,'6M')";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Defence_db","root","root");
            System.out.println("The connection is build successfully.");

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
