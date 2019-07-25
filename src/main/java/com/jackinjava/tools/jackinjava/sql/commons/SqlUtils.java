package com.jackinjava.tools.jackinjava.sql.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtils {

    public static ResultSet query(Connection connection, String sql){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            rs = (ResultSet)pstmt.executeQuery();
            return rs;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
