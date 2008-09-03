package migrations.utils;

import migrations.adapters.SQLAdapter;
import org.apache.commons.configuration.Configuration;

public class AdapterUtils {
    public static SQLAdapter getSQLAdapter() throws Exception {
        Configuration config = PathUtils.getMigrationProperties();
        String database = config.getString("adapter.database");
        Class klass = Class.forName("com.migrations.adapters." + database + "_SQLAdapter");
        return (SQLAdapter)klass.newInstance();
    }
}
