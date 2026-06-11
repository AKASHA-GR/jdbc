import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {

            String url = "jdbc:mysql://localhost:3306/Student_DB";
            String user = "root";
            String password = "root";
            String sqlq = "insert into Student_info values(002,'Akasha',22,'cse',2026)";

            Connection con =  DriverManager.getConnection(url,user,password);

            Statement statement = con.createStatement();

            statement.execute(sqlq);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
