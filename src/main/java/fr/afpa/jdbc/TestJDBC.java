package fr.afpa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";
            String user = "hbstudent";
            String pass = "afpa123";
        try{
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
