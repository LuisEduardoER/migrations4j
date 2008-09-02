package migrations.utils;

import java.io.File;

public class PathUtils {
    
    public static String javaFriendlyPath(String path) {
        if (File.separator.equals("\\"))
            path = path.replaceAll("\\\\", "\\\\\\\\");
        return path;
    }
    
}
