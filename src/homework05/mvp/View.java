package homework05.mvp;

public interface View {
    String getFirstName();

    void setFirstName(String value);

    String getLastName();

    void setLastName(String value);

    void showMessage(String s);

    int getId();

    String getSearchString();

    String getPhone();
}
