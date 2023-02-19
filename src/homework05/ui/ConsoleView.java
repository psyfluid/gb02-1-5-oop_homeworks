package homework05.ui;

import homework05.mvp.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner iScanner;

    public ConsoleView() {
        iScanner = new Scanner(System.in);
    }

    @Override
    public void showString(String s) {
        System.out.print(s);
    }

    @Override
    public void inputPrompt(String field) {
        showString(String.format("Input %s: ", field));
    }

    @Override
    public void showMessage(String s) {
        showString(String.format("%s%n%n", s));
    }

    @Override
    public void showMenu(String s) {
        showString(String.format("%s%n", s));
    }

    @Override
    public Integer getIntegerFieldFromInput() {
        String idString = iScanner.nextLine();

        try {
            return Integer.parseInt(idString);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public String getStringFieldFromInput(String field) {
        inputPrompt(field);
        return iScanner.nextLine();
    }

}
