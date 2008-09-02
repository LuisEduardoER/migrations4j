package migrations.generators;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Generator {
    public static void generateMigrationsProject(String name) throws Exception{
        // Create project directory based on name passed in
        File projectDirectory = new File(System.getProperty("user.dir") + File.separator + name);
        projectDirectory.mkdir();

        // Create migrations.properties file based on copy in templates directory.
        File templatesDirectory = new File(Generator.class.getResource("templates").getFile());
        File migrationsPropertiesTemplate = new File(templatesDirectory.getPath() + File.separator + "generate_migrations_properties.txt");
        String migrationsPropsIn = FileUtils.readFileToString(migrationsPropertiesTemplate);
        File migrationsPropsOut = new File(projectDirectory.getPath() + File.separator + "migrations.properties");
        FileUtils.writeStringToFile(migrationsPropsOut, migrationsPropsIn);
        
        // Create sql, model, mapping file directories.
        new File(projectDirectory.getPath() + File.separator + "sql").mkdir();
        new File(projectDirectory.getPath() + File.separator + "model").mkdir();
        new File(projectDirectory.getPath() + File.separator + "mapping").mkdir();
    }
}
