import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMain {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","yash");
            System.out.println("Connection created");
            Statement statement = connection.createStatement();

            String sqlCreate = "CREATE DATABASE jbdl61";
            statement.execute(sqlCreate);
            System.out.println("Database created successfully!");
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
