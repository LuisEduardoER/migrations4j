package com.migrations.adapters;

import java.sql.Connection;
import migrations.adapters.SQLAdapter;

public class sqlserver_SQLAdapter extends SQLAdapter {
    public sqlserver_SQLAdapter() {
        //super(conn);
    }
    
    public void createTable(String tableName, String options) {}
    public void dropTable(String tableName) {}
    public void renameTable(String oldTableName, String newTableName) {}
    
    public void addColumn(String tableName, String columnName, DataType type, ColumnOptions options){}
    public void renameColumn(String tableName, String oldColumnName, String newColumnName){}
    public void changeColumn(String tableName, String columnName, DataType type, ColumnOptions options){}
    public void removeColumn(String tableName, String columnName){}
    
    public void addIndex(String tableName, String indexName, String[] columnNames, IndexType type){}
    public void removeIndex(String tableName, String indexName){}
    
    public void execute(String sql){}
}
