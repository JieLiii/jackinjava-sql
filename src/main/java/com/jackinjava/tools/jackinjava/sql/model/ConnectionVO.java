package com.jackinjava.tools.jackinjava.sql.model;

public class ConnectionVO {
    private String databaseType;
    private String host;
    private String port;
    private String database;
    private String userName;
    private String password;

    protected String getDatabaseType() {
        return databaseType;
    }

    protected void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    protected String getHost() {
        return host;
    }

    protected void setHost(String host) {
        this.host = host;
    }

    protected String getPort() {
        return port;
    }

    protected void setPort(String port) {
        this.port = port;
    }

    protected String getDatabase() {
        return database;
    }

    protected void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
