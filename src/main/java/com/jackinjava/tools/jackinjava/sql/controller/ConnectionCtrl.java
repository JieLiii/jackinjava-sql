package com.jackinjava.tools.jackinjava.sql.controller;

import com.jackinjava.tools.jackinjava.sql.model.ConnectionDTO;
import com.jackinjava.tools.jackinjava.sql.model.ConnectionVO;
import com.jackinjava.tools.jackinjava.sql.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;

@Controller
@RequestMapping("/connection")
public class ConnectionCtrl {
    @Autowired
    private ConnectionService connectionService;

    @GetMapping("findDatabase")
    @ResponseBody
    public ResultSet findDatabase(ConnectionVO connectionVO) {
        return connectionService.getDatabase(new ConnectionDTO(connectionVO));
    }

    @GetMapping("index")
    public String index(){
        return "buildConnection";
    }
}