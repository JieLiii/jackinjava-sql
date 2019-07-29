package com.jackinjava.tools.jackinjava.sql.model;

public class ColumnNode extends Node {
    private String dataType;
    private Integer length;

    public ColumnNode(String name, String dataType, Integer length) {
        super(name);
        this.dataType = dataType;
        this.length = length;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
