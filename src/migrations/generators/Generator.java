package migrations.generators;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import migrations.utils.AdapterUtils;
import migrations.utils.PathUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class Generator {
    
    public static File templatesDirectory = new File(Generator.class.getResource("templates").getFile());
    
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
    
    public static void generateMigration(String name) throws Exception {
        File projectDirectory = new File(System.getProperty("user.dir"));
        Configuration migrationsProps = PathUtils.getMigrationProperties();
        
        // Copy template
        File migrationXMLTemplate = new File(templatesDirectory.getPath() + File.separator + "generate_migration_xml.txt");
        String migrationXMLTemplateIn = FileUtils.readFileToString(migrationXMLTemplate);
        
        // Build filename
        String filename = getNextMigrationPrefix(projectDirectory) + "_" + name + ".xml";
        
        // Write new migration file
        File migrationXMLTemplateOut = new File(projectDirectory.getPath() + File.separator + filename);
        FileUtils.writeStringToFile(migrationXMLTemplateOut, migrationXMLTemplateIn);        
    }
    
    public static String getNextMigrationPrefix(File dir) throws Exception {
        int prefix = 0;
        FileFilter fileFilter = new WildcardFileFilter("*_*.xml");
        File[] files = dir.listFiles(fileFilter);
        Arrays.sort(files, NameFileComparator.NAME_INSENSITIVE_REVERSE);
        for (File file : files) {
            if (file.getName().matches("(\\d\\d\\d_).+"))
                prefix = Integer.parseInt(file.getName().split("_")[0]);
                break;
        }
        
        prefix++;
        
        if (prefix < 10)
            return String.valueOf("00" + prefix);
        else if (prefix < 100)
            return String.valueOf("0" + prefix);
        else
            return String.valueOf(prefix);
        
    }
}
