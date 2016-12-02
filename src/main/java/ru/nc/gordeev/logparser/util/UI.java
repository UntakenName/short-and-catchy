package ru.nc.gordeev.logparser.util;


import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        new ConfigurationManager(new StorageConfigurator(),new ParsingConfigurator(),new DateConfigurator())
                .setInitialConfigurations();
        System.out.println("Greetings!\nType \"help\" for available commands.");
        Scanner scanner = new Scanner(System.in);
        String line;
        interaction: while (true) {
            System.out.println("You're in the main section.");
            line = scanner.nextLine();
            switch (line.toLowerCase()) {
                case "help":
                    System.out.println("Type:\n/path/ - specify the path to parse a .log file and put it in the library;\n" +
                            "count - to enter the count section;\n"+
                            "print - to enter print section;\n" +
                            "config - to enter configuration section;\n" +
                            "exit - to finish the session.");
                    break;
                case "count":
                    System.out.println("You're in the count section.\nType \"help\" for available commands. ");
                    count: while (true){
                        line = scanner.nextLine();
                        switch (line.toLowerCase()) {
                            case "help":
                                System.out.println("Type:\n/path/ - specify the file to count lines in (when parsed into library);\n" +
                                        "all - to count the number of files in the library;\n" +
                                        "print - to print paths to all the parsed files in the library;;\n" +
                                        "back - to return to the main section;\n" +
                                        "exit - to finish the session.");
                                break;
                            case "all":
                                new DataManager().countFiles();
                                break;
                            case "print":
                                new DataManager().showAll();
                                break;
                            case "back":
                                break count;
                            case "exit":
                                System.out.println("Good bye!");
                                break interaction;
                            default:
                                new DataManager().countLines(line);
                        }
                    }
                    break;
                case "print":
                    System.out.println("You're in the print section.\nType \"help\" for available commands. ");
                    print: while (true){
                        line = scanner.nextLine();
                        switch (line.toLowerCase()) {
                            case "help":
                                System.out.println("Type:\n/path/ - specify the file to print onto the console (when parsed into library);\n" +
                                        "all - to print paths to all the parsed files in the library;\n" +
                                        "back - to return to the main section;\n" +
                                        "exit - to finish the session.");
                                break;
                            case "all":
                                new DataManager().showAll();
                                break;
                            case "back":
                                break print;
                            case "exit":
                                System.out.println("Good bye!");
                                break interaction;
                            default:
                                new DataManager().show(line);
                        }
                    }
                    break;
                case "config":
                    System.out.println("You're in the configuration section.\nType \"help\" for available commands. ");
                    config: while (true) {
                        line = scanner.nextLine();
                        switch (line.toLowerCase()) {
                            case "help":
                                System.out.println("Type:\n/path/ - specify the file to get configuration from;\n" +
                                        "default - to return to default configurations;\n" +
                                        "print - to print current configurations;\n"+
                                        "back - to return to the main section;\n" +
                                        "exit - to finish the session.");
                                break;
                            case "default":
                                new ConfigurationManager(new StorageConfigurator(),new ParsingConfigurator(),new DateConfigurator())
                                        .setInitialConfigurations();
                                System.out.println("Initial configurations have been applied.");
                                break;
                            case "print":
                                System.out.println(new ConfigurationManager().getCurrentConfigurations());
                                break;
                            case "back":
                                break config;
                            case "exit":
                                System.out.println("Good bye!");
                                break interaction;
                            default:
                                new ConfigurationManager(new StorageConfigurator(),new ParsingConfigurator(),new DateConfigurator())
                                        .setConfigurations(line);
                        }
                    }
                    break;
                case "exit":
                    System.out.println("Good bye!");
                    break interaction;
                default:{
                    new LogParser().parseFile(line);
                }
            }
        }
    }
}
