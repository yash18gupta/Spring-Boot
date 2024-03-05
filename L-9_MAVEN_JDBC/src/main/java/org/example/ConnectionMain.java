package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMain {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","yash");

            System.out.println("Database con: "+con);

            String query = "CREATE database IF NOT EXISTS jdbl61";
            Statement stmt = con.createStatement();

            stmt.execute(query);

            System.out.println("Database created successfully!");
            con.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
