package com.xworks.teacher;

import java.sql.*;

public class TeacherInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;

        String url = "jdbc:mysql://localhost:3306/Student_DB";
        String user = "root";
        String password = "root";
        String sqlQuery = "insert into teacher_info values(01,'swathi',30,'CSE','DBMS'),(02,'pooja',40,'CSE','network'),(03,'manja',21,'CSE','IOT')";


        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("The connection is established.");

            statement = connection.createStatement();
            System.out.println("The statement is:"+statement);

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
