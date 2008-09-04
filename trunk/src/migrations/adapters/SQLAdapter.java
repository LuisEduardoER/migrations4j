package migrations.adapters;

import java.sql.Connection;

public abstract class SQLAdapter {
    
    public enum DataType { STRING, INTEGER, FLOAT, DECIMAL, DATETIME, TIMESTAMP, TIME, DATE, BINARY, BOOLEAN }   
    public enum IndexType { UNIQUE, FOREIGNKEY }
    
    protected Connection conn;
    
    public abstract void createTable(String tableName, String options);
    public abstract void dropTable(String tableName);
    public abstract void renameTable(String oldTableName, String newTableName);
    
    public abstract void addColumn(String tableName, String columnName, DataType type, ColumnOptions options);
    public abstract void renameColumn(String tableName, String oldColumnName, String newColumnName);
    public abstract void changeColumn(String tableName, String columnName, DataType type, ColumnOptions options);
    public abstract void removeColumn(String tableName, String columnName);
    
    public abstract void addIndex(String tableName, String indexName, String[] columnNames, IndexType type);
    public abstract void removeIndex(String tableName, String indexName);
    
    public abstract void execute(String sql);
    
    public class ColumnOptions {
        private boolean allowNull;
        private String defaultValue;
        private int limit;
        
        public ColumnOptions(boolean allowNull, String defaultValue, int limit) {
            this.allowNull = allowNull;
        }

        public boolean isAllowNull() {
            return allowNull;
        }

        public void setAllowNull(boolean allowNull) {
            this.allowNull = allowNull;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }
}