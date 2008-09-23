package migrations.utils;

import migrations.adapters.SQLAdapter;

public class AdapterUtils {
    public static SQLAdapter getSQLAdapter() throws Exception {
        String database = PathUtils.getMigrationProperties().getString("adapter.database");
        return (SQLAdapter)Class.forName("com.migrations.adapters." + database + "_SQLAdapter").newInstance();
    }
}
