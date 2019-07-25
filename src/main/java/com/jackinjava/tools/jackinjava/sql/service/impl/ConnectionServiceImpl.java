package com.jackinjava.tools.jackinjava.sql.service.impl;

import com.jackinjava.tools.jackinjava.sql.commons.ConnectionUtils;
import com.jackinjava.tools.jackinjava.sql.commons.SqlUtils;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;
import com.jackinjava.tools.jackinjava.sql.service.ConnectionService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    public ResultSet getDatabase(ConnectionDTO dto){
        Connection connection = ConnectionUtils.getConnection(dto);
        String sql = "show databases;";
        return SqlUtils.query(connection, sql);
    }
}
