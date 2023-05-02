package databaseconnection;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    private static Connection conn = null;
    private static final String url ="jdbc:postgresql://localhost:5432/diyetOmat";
    private static final String user="postgres";
    private static final String password="12345";

    public static Connection connect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Database Bağlantısı başarılı");
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
