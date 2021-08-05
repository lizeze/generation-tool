package com.github.lizeze.generationtool.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzz
 */
@Data
public class TableTreeVO {


    public TableTreeVO() {

        this.tables = new ArrayList<>();
    }

    public TableTreeVO(String dbName) {
        this.dbName = dbName;
        this.tables = new ArrayList<>();
    }

    private String dbName;

    private List<TableInfoVO> tables;


}
