package homework05;

import homework05.services.FileFormat;

import java.util.Map;

public class Config {
    public static Map<FileFormat, String> paths;

    static {
        paths = Map.of(FileFormat.CSV, "phonebook.csv", FileFormat.JSON, "phonebook.json");
    }
}
