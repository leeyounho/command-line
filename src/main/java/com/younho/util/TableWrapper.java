package com.younho.util;

import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

public class TableWrapper {
    private Table table;

    public TableWrapper(String tableName) {
        this.table = Table.create(tableName);
    }

    public static TableWrapper create(String tableName) {
        return new TableWrapper(tableName);
    }

    public TableWrapper addColumns(Column<?>... cols) {
        this.table.addColumns(cols);
        return this;
    }
    
    public String toString(){
        return table.toString();
    }
}
