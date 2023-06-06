package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static Connection conn = null;
    private static final String url ="jdbc:postgresql://localhost:5432/otomat";
    private static final String user="postgres";
    private static final String password="root";
    public static Connection connect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static Connection getConn() {
        if (conn ==null){
            return connect();
        }
        return conn;
    }
    public static void setConn(Connection conn) {
        DatabaseConnect.conn = conn;
    }
}
