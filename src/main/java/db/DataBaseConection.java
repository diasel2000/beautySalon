package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DataBaseConection {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/beauty_salon"+
            "?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "3420683890015tolik";
    private static final Logger LOG = Logger.getLogger(DataBaseConection.class);

    public static Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName ( JDBC_DRIVER );
            connection =DriverManager.getConnection ( DATABASE_URL,USER,PASSWORD );
            LOG.debug("Connection ОК " + connection);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error("Some problem with connection to DB \n" + e);
        }
        return connection;
    }
}
