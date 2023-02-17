package homework05.exceptions;

import com.sun.jdi.InternalException;

public abstract class PhonebookException extends InternalException {
    protected PhonebookException() {
    }

    protected PhonebookException(String s) {
        super(s);
    }
}
