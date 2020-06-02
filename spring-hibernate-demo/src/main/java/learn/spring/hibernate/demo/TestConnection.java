package learn.spring.hibernate.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    static String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    static String user = "hbstudent";
    static String password = "hbstudent";

    public static void main(String[] args) {
        System.out.println("Connecting to the database");
        try {
            Connection con = DriverManager.getConnection(jdbcURL, user, password);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection successful");
    }

}
