package com.xworks.teacher;

import java.sql.*;

public class TeacherSelect {
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
        String sqlQuery = "SELECT* from teacher_info";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_DB","root","root");
            System.out.println("Connection established.");

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);


            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getString("department"));
                System.out.println(resultSet.getString("subject"));
                System.out.println("___________________________________");
                System.out.println();

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
