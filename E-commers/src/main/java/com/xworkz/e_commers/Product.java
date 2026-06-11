package com.xworkz.e_commers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");

            String url = "jdbc:mysql://localhost:3306/E_commers";
            String user = "root";
            String password = "root";
            String sqlQ = "insert into customer_info values('Naga',103,24,2378,1349)";
            Connection con = DriverManager.getConnection(url,user,password);

            Statement statement = con.createStatement();

            statement.execute(sqlQ);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
