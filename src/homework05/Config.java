package homework05;

import homework05.services.FileFormat;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Config {

    private static final Map<FileFormat, String> paths;
    private static final Map<Integer, String> mainMenu;
    private static final Map<Integer, String> contactMenu;

    static {
        paths = Map.of(FileFormat.CSV, "phonebook.csv", FileFormat.JSON, "phonebook.json");

        mainMenu = new LinkedHashMap<>();
        mainMenu.put(1, "Show phone book");
        mainMenu.put(2, "Load phone book");
        mainMenu.put(3, "Save phone book");
        mainMenu.put(4, "New phone book");
        mainMenu.put(5, "Add contact");
        mainMenu.put(6, "Open contact by id");
        mainMenu.put(7, "Find contact by name");
        mainMenu.put(8, "Choose file format (default: csv)");
        mainMenu.put(0, "Exit");

        contactMenu = new LinkedHashMap<>();
        contactMenu.put(1, "Add phone");
        contactMenu.put(2, "Delete phone");
        contactMenu.put(3, "Delete contact");
        contactMenu.put(4, "Return to main menu");
    }

    private Config() {
    }

    public static Map<FileFormat, String> paths() {
        return paths;
    }

    public static Map<Integer, String> mainMenu() {
        return mainMenu;
    }

    public static Map<Integer, String> contactMenu() {
        return contactMenu;
    }

}
