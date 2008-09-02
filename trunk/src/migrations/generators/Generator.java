package migrations.generators;

import java.io.File;
import migrations.utils.PathUtils;
import org.apache.commons.io.FileUtils;

public class Generator {
    
    public static void generateProject(String name) throws Exception{
        // Create project directory based on name passed in
        File projectDirectory = new File(System.getProperty("user.dir") + File.separator + name);
        projectDirectory.mkdir();
        
        // Create sql, model, mapping file directories.
        File sqlDirectory = new File(projectDirectory.getPath() + File.separator + "sql");
        sqlDirectory.mkdir();
        File modelDirectory = new File(projectDirectory.getPath() + File.separator + "model");
        modelDirectory.mkdir();
        File mappingDirectory = new File(projectDirectory.getPath() + File.separator + "mapping");
        mappingDirectory.mkdir();

        // Create migrations.properties file based on copy in templates directory.
        File templatesDirectory = new File(Generator.class.getResource("templates").getFile());
        File migrationsPropertiesTemplate = new File(templatesDirectory.getPath() + File.separator + "generate_migrations_properties.txt");
        String migrationsPropsIn = FileUtils.readFileToString(migrationsPropertiesTemplate);
        
        // Parse for dynamic data placeholders
        migrationsPropsIn = migrationsPropsIn.replaceAll("\\{sql_path}", PathUtils.javaFriendlyPath(sqlDirectory.getAbsolutePath()));
        migrationsPropsIn = migrationsPropsIn.replaceAll("\\{model_path}", PathUtils.javaFriendlyPath(modelDirectory.getAbsolutePath()));
        migrationsPropsIn = migrationsPropsIn.replaceAll("\\{mapping_path}", PathUtils.javaFriendlyPath(mappingDirectory.getAbsolutePath()));
        migrationsPropsIn = migrationsPropsIn.replaceAll("\\{project_name}", name);
        
        // Write new migrations.properties file
        File migrationsPropsOut = new File(projectDirectory.getPath() + File.separator + "migrations.properties");
        FileUtils.writeStringToFile(migrationsPropsOut, migrationsPropsIn);
    }
    
    public static void generateMigration(String name) {
        
    }
}
