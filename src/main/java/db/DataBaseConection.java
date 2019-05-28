package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/beauty_salon"+
            "?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "3420683890015tolik";

    public static Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName ( JDBC_DRIVER );
            connection =DriverManager.getConnection ( DATABASE_URL,USER,PASSWORD );
            System.out.println ("OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace ();

        }
        return connection;
    }
}
