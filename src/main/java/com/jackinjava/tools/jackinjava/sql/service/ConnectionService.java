package com.jackinjava.tools.jackinjava.sql.service;

public interface ConnectionService {
    /**
     * 初始化驱动
     *
     * @param driverName
     */
    void initDatabaseDriver(String driverName);

    /**
     * 建立连接
     *
     * @param url
     * @param userName
     * @param password
     */
    void buildConnection(String url, String userName, String password);
}
