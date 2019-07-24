package com.jackinjava.tools.jackinjava.sql.service;

import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;

import java.sql.Connection;

public interface ConnectionService {
    /**
     * 获取数据库连接对象
     *
     * @param dto
     * @return
     */
    Connection getConnection(ConnectionDTO dto);
}
