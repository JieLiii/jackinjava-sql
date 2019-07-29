package com.jackinjava.tools.jackinjava.sql.model;

import java.util.List;

public class Node {
    private String name;
    private List<Node> tables;
    private Boolean leaf = false;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, List<Node> tables) {
        this.name = name;
        this.tables = tables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getTables() {
        return tables;
    }

    public void setTables(List<Node> tables) {
        this.tables = tables;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}
