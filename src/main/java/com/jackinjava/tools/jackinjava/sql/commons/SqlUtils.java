package com.jackinjava.tools.jackinjava.sql.commons;

import com.jackinjava.tools.jackinjava.sql.model.ColumnNode;
import com.jackinjava.tools.jackinjava.sql.model.Node;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUtils {

    public static List<Node> queryDatabaseOrTables(Connection connection, String sql){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Node> list = new ArrayList<>();
        try{
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            while (rs.next()) {
                if(count > 1){
                    list.add(new ColumnNode(rs.getString("column_name"),rs.getString("data_type"),rs.getInt("character_maximum_length")));
                }else{
                    list.add(new Node(rs.getString(1)));
                }
            }
            ConnectionUtils.close(pstmt);
            ConnectionUtils.close(rs);
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
