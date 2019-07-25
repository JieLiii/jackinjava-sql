package com.jackinjava.tools.jackinjava.sql.commons;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtils {
    private static DataSource dataSource;
    private static Properties properties;

    static {
        try {
            //加载配置文件
            properties.load(ConnectionUtils.class.getResourceAsStream("/src/main/resources/druid.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource(ConnectionDTO dto) {
        properties.setProperty("driverClassName", dto.getDriverName());
        properties.setProperty("url", dto.getUrl());
        properties.setProperty("username", dto.getConnectionVO().getUserName());
        properties.setProperty("password", dto.getConnectionVO().getPassword());
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection(ConnectionDTO dto) {
        try {
            return getDataSource(dto).getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
