package migrations.utils;

import java.io.File;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PathUtils {
    
    public static String javaFriendlyPath(String path) {
        if (File.separator.equals("\\"))
            path = path.replaceAll("\\\\", "\\\\\\\\");
        return path;
    }
    
    public static Configuration getMigrationProperties() throws Exception{
        File projectDirectory = new File(System.getProperty("user.dir"));
        File migrationsProps = new File(projectDirectory.getPath() + File.separator + "migrations.properties");
        
        if (!migrationsProps.exists())
            throw new Exception("ERROR: migrations.properties not found in current directory.");

        return new PropertiesConfiguration(migrationsProps);
    }
    
}
