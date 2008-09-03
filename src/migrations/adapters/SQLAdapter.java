package migrations.adapters;

public abstract class SQLAdapter {
    public abstract void createTable();
    public abstract void dropTable();
    public abstract void renameTable();
    
    public abstract void addColumn();
    public abstract void renameColumn();
    public abstract void changeColumn();
    public abstract void removeColumn();
    
    public abstract void addIndex();
    public abstract void removeIndex();
    
    public abstract void execute();
}
