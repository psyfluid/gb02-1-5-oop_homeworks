package homework05.ui;

import homework05.mvp.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner iScanner;

    public ConsoleView() {
        iScanner = new Scanner(System.in);
    }

    @Override
    public String getFirstName() {
        System.out.printf("First name: ");
        return iScanner.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("First name: %s%n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("Last name: ");
        return iScanner.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("Last name: %s%n", value);
    }

    @Override
    public void showMessage(String s) {
        System.out.printf("%s%n%n", s);
    }

    @Override
    public int getId() {
        System.out.printf("Input contact ID: ");
        String idString = iScanner.nextLine();

        try {
            return Integer.parseInt(idString);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public String getSearchString() {
        System.out.printf("Input search string: ");
        return iScanner.nextLine();
    }

    @Override
    public String getPhone() {
        System.out.printf("Input phone number: ");
        return iScanner.nextLine();
    }
}
