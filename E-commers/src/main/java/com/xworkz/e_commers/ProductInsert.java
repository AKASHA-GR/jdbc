package com.xworkz.e_commers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductInsert {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;

        try {

            String url = "jdbc:mysql://localhost:3306/E_commers";
            String user = "root";
            String password = "root";
            String sqlQ = "insert into customer_info values('Naga',103,24,2378,1349),('Ravi',104,20,2379,250),('naveen',105,21,2380,1000)";
            connection = DriverManager.getConnection(url,user,password);

            statement = connection.createStatement();

            statement.execute(sqlQ);

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
