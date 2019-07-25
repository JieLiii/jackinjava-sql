package com.jackinjava.tools.jackinjava.sql.service;

import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;

import java.sql.ResultSet;

public interface ConnectionService {
    /**
     * 获取数据库
     *
     * @param dto
     * @return
     */
    ResultSet getDatabase(ConnectionDTO dto);
}
