package homework05.exceptions;

public class PhoneNotFoundException extends PhonebookException {
    public PhoneNotFoundException() {
        super("Phone number is not found");
    }
}
