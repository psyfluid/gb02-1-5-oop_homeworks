package homework05.ui;

import homework05.Config;
import homework05.mvp.Presenter;
import homework05.mvp.View;
import homework05.services.FileFormat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static View view;
    static Presenter presenter;
    static FileFormat fileFormat;

    public static void mainMenu() {
        view = new ConsoleView();
        presenter = new Presenter(view, Config.paths);
        fileFormat = FileFormat.CSV;

        try (Scanner iScanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Choose action: ");
                System.out.println("1 - Show phone book");
                System.out.println("2 - Load phone book");
                System.out.println("3 - Save phone book");
                System.out.println("4 - New phone book");
                System.out.println("5 - Add contact");
                System.out.println("6 - Open contact by id");
                System.out.println("7 - Find contact by name");
                System.out.println("8 - Choose file format (default: csv)");
                System.out.println("0 - Exit");

                String action = iScanner.next();
                switch (action) {
                    case "1" -> presenter.showPhonebook();
                    case "2" -> presenter.loadFromFile(fileFormat);
                    case "3" -> presenter.saveToFile(fileFormat);
                    case "4" -> presenter.newPhonebook();
                    case "5" -> {
                        if (presenter.add()) {
                            contactMenu(iScanner);
                        }
                    }
                    case "6" -> {
                        if (presenter.getContact()) {
                            contactMenu(iScanner);
                        }
                    }
                    case "7" -> {
                        if (presenter.findContacts()) {
                            contactMenu(iScanner);
                        }
                    }
                    case "8" -> fileFormat = enumChoice(iScanner, FileFormat.class);
                    case "0" -> {
                        return;
                    }
                }
            }
        }
    }

    private static void contactMenu(Scanner iScanner) {
        presenter.showCurrentContact();
        while (true) {
            System.out.println("Choose contact action: ");
            System.out.println("1 - Add phone");
            System.out.println("2 - Delete phone");
            System.out.println("3 - Delete contact");
            System.out.println("4 - Return to main menu");

            String action = iScanner.next();
            switch (action) {
                case "1" -> presenter.addPhone();
                case "2" -> presenter.removePhone();
                case "3" -> {
                    presenter.remove();
                    return;
                }
                case "4" -> {
                    return;
                }
            }
        }
    }

    private static <T> T enumChoice(Scanner iScanner, Class<T> enumClass) {
        List<T> enumList = Arrays.asList(enumClass.getEnumConstants());
        String enumName = enumClass.getSimpleName();
        int length = enumList.size();
        while (true) {
            System.out.printf("Choose %s:%n", enumName);
            for (int i = 0; i < length; i++) {
                System.out.printf("%d - %s%n", i, enumList.get(i));
            }

            String action = iScanner.next();
            int actionId;
            try {
                actionId = Integer.parseInt(action);
            } catch (NumberFormatException e) {
                continue;
            }

            if (actionId < 0 || actionId > length) continue;

            return enumList.get(actionId);
        }
    }


}
