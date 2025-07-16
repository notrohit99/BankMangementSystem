package bankmangementsystem;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    public Conn(){
             try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementsystem", 
                "root", 
                "rohit2015"
            );

            // Create statement
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e);
        }
    }
    }

