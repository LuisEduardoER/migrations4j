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
        
        if (args.length < 1)
            printHelp();
        
        switch (args.length) {
            case 1:
                
                    
                break;
            case 2:
                
                if (args[0].equalsIgnoreCase("generate-project"))
                    Generator.generateMigrationsProject(args[1]);
                    
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
