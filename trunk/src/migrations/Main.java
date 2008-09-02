 package migrations;

import migrations.generators.Generator;

public class Main {

    public static void main(String[] args) {
        try {
            parseArguments(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void parseArguments(String[] args) throws Exception {
        
        switch (args.length) {
            case 1:
                
                if (args[0].equalsIgnoreCase("migrate"))
                    Migrator.migrate("latest");
                
                else if (args[0].equalsIgnoreCase("generate-sql-scripts"))
                    System.out.println("Not yet implimneted!");
                    
                else if (args[0].equalsIgnoreCase("generate-model-classes"))
                    System.out.println("Not yet implimneted!");
                    
                else if (args[0].equalsIgnoreCase("generate-mapping-files"))    
                    System.out.println("Not yet implimneted!");
                    
                break;
            case 2:
                
                if (args[0].equalsIgnoreCase("migrate"))
                    Migrator.migrate(args[1]);
                
                else if (args[0].equalsIgnoreCase("generate-project"))
                    Generator.generateProject(args[1]);
                
                else if (args[0].equalsIgnoreCase("generate-migration"))
                    Generator.generateMigration(args[1]);

                break;
            default:
                printHelp();
        }

    }
    
    public static void printHelp() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("** USAGE INSTRUCTIONS: **");
        
        System.out.println(sb.toString());
    }

}
