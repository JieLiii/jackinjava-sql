package com.jackinjava.tools.jackinjava.sql.service.impl;

import com.jackinjava.tools.jackinjava.sql.jdbc.ConnectionUtils;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;
import com.jackinjava.tools.jackinjava.sql.service.ConnectionService;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    public Connection getConnection(ConnectionDTO dto){
        ConnectionUtils.initDatabaseDriver(dto.getDriverName());
        return ConnectionUtils.buildConnection(dto.getUrl(), dto.getConnectionVO().getUserName(), dto.getConnectionVO().getPassword());
    }
}
