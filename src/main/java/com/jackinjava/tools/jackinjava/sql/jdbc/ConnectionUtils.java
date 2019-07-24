package com.jackinjava.tools.jackinjava.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static void initDatabaseDriver(String driverName){
        try {
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection buildConnection(String url, String userName, String password){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
