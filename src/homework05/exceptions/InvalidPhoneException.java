package homework05.exceptions;

public class InvalidPhoneException extends PhonebookException {
    public InvalidPhoneException() {
        super("Invalid phone number format");
    }
}
