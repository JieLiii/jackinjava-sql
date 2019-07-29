package com.jackinjava.tools.jackinjava.sql.model;

public class ConnectionDTO {
    private ConnectionVO connectionVO;
    private String driverName;
    private String url;
    private static final String MYSQL_NAME = "MySQL";
    private static final String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private ConnectionDTO() {
    }

    public ConnectionDTO(ConnectionVO connectionVO) {
        this.connectionVO = connectionVO;
    }

    public String getDriverName() {
        switch (this.connectionVO.getDatabaseType()) {
            case MYSQL_NAME:
                return MYSQL_DRIVER_NAME;
            default:
                return null;
        }
    }

    public String getUrl() {
        StringBuilder builder = new StringBuilder("jdbc:");
        switch (this.connectionVO.getDatabaseType()) {
            case MYSQL_NAME:
                builder.append("mysql://");
                break;
        }
        builder.append(this.connectionVO.getHost()).append(":");
        builder.append(this.connectionVO.getPort()).append("/");
        builder.append(this.connectionVO.getDatabase()).append("?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        return builder.toString();
    }

    public ConnectionVO getConnectionVO() {
        return connectionVO;
    }
}
