package homework05.ui;

import homework05.Config;
import homework05.mvp.Presenter;
import homework05.mvp.View;
import homework05.services.EnumSelector;
import homework05.services.FileFormat;

import java.util.Map;
import java.util.Map.Entry;

public class App {
    static View view;
    static Presenter presenter;
    static FileFormat fileFormat;

    private App() {
    }

    public static void mainMenu() {
        view = new ConsoleView();
        presenter = new Presenter(view, Config.paths());
        fileFormat = FileFormat.CSV;

        StringBuilder sb = menuBuilder("Choose action: \n", Config.mainMenu());

        while (true) {
            view.showMenu(sb.toString());
            int actionId = view.getIntegerFieldFromInput();
            switch (actionId) {
                case 1 -> presenter.showPhonebook();
                case 2 -> presenter.loadFromFile(fileFormat);
                case 3 -> presenter.saveToFile(fileFormat);
                case 4 -> presenter.newPhonebook();
                case 5 -> {
                    if (presenter.addContact()) {
                        contactMenu();
                    }
                }
                case 6 -> {
                    if (presenter.getContact()) {
                        contactMenu();
                    }
                }
                case 7 -> {
                    if (presenter.findContacts()) {
                        contactMenu();
                    }
                }
                case 8 -> fileFormat = EnumSelector.selectFromInput(view, FileFormat.class);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void contactMenu() {
        presenter.showCurrentContact();

        StringBuilder sb = menuBuilder("Choose contact action: \n", Config.contactMenu());

        while (true) {
            view.showMenu(sb.toString());
            int actionId = view.getIntegerFieldFromInput();
            switch (actionId) {
                case 1 -> presenter.addPhone();
                case 2 -> presenter.removePhone();
                case 3 -> {
                    presenter.removeContact();
                    return;
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    private static StringBuilder menuBuilder(String str, Map<Integer, String> contactMenu) {
        StringBuilder sb = new StringBuilder(str);
        for (Entry<Integer, String> entry : contactMenu.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return sb;
    }
}
