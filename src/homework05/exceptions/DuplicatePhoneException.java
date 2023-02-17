package homework05.exceptions;

public class DuplicatePhoneException extends PhonebookException {
    public DuplicatePhoneException() {
        super("Phone number already added to the list");
    }
}
