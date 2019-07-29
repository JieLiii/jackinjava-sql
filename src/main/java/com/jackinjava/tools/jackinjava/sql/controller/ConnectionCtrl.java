package com.jackinjava.tools.jackinjava.sql.controller;

import com.jackinjava.tools.jackinjava.sql.commons.ConnectionUtils;
import com.jackinjava.tools.jackinjava.sql.commons.SqlUtils;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionVO;
import com.jackinjava.tools.jackinjava.sql.model.Node;
import com.jackinjava.tools.jackinjava.sql.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/connection")
public class ConnectionCtrl {
    @Autowired
    private ConnectionService connectionService;

    private static Connection connection;

    @PostMapping("buildConnect")
    @ResponseBody
    public List<Node> buildConnect(@RequestBody ConnectionVO connectionVO) {
        connection = ConnectionUtils.getConnection(new ConnectionDTO(connectionVO));
        return SqlUtils.queryDatabaseOrTables(connection, "show databases;");
    }

    @GetMapping("get-tables")
    @ResponseBody
    public List<Node> getTables(@RequestParam String databaseName){
        String sql = "select table_name from information_schema.tables where table_schema='?' and table_type='base table';";
        String newSql = sql.replace("?", databaseName);
        return SqlUtils.queryDatabaseOrTables(connection, newSql);
    }

    @GetMapping("get-columns")
    @ResponseBody
    public List<Node> getColumns(@RequestParam String databaseName,@RequestParam String tableName){
        String sql = "select column_name, data_type, character_maximum_length from information_schema.columns where table_schema='1' and table_name='2';";
        String newSql = sql.replace("1", databaseName).replace("2", tableName);
        List<Node> list = SqlUtils.queryDatabaseOrTables(connection, newSql);
        list.stream().forEach(node ->{
            node.setLeaf(true);
        });
        return list;
    }

    @GetMapping("index")
    public String index() {
        return "buildConnection";
    }
}