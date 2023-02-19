package homework05.mvp;

public interface View {

    void showString(String s);

    void showMessage(String s);

    void showMenu(String s);

    void inputPrompt(String field);

    Integer getIntegerFieldFromInput();

    String getStringFieldFromInput(String field);

}
