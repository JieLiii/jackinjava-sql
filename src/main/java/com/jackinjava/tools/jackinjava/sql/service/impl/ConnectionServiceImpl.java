package com.jackinjava.tools.jackinjava.sql.service.impl;

import com.jackinjava.tools.jackinjava.sql.service.ConnectionService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionServiceImpl implements ConnectionService {
    @Override
    public void initDatabaseDriver(String driverName){
        try {
            Class.forName(driverName);
        }catch (ClassNotFoundException e){

        }
    }

    @Override
    public void buildConnection(String url, String userName, String password){
        try {
            DriverManager.getConnection(url, userName, password);
        }catch (SQLException e){
        }
    }
}
