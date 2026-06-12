package com.xworkz.missile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MissileInsert01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded Successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        String sqlQuery = "insert into missile_info values ('Agni4',4000,20,17000,'6.1M')";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Defence_db","root","root");

            statement = connection.createStatement();

            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
