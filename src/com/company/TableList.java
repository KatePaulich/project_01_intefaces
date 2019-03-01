package com.company;

import com.company.Table;

import java.util.ArrayList;
import java.util.List;

public class TableList {
    private List<Table> tableList;

    public TableList(){
        tableList = new ArrayList<>();
    }

    private void addTableList(Table table){
        tableList.add(table);
    }

    public List<Table> getTableList(){
        return tableList;
    }

    public void addTable(Table newTable){
            addTableList(newTable);
    }
}
