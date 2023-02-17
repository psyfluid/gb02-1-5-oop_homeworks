package homework05.exceptions;

public class DuplicateContactException extends PhonebookException {
    public DuplicateContactException() {
        super("The contact already added to the phone book");
    }
}
