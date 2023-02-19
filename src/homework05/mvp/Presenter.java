package homework05.mvp;

import homework05.exceptions.DuplicateContactException;
import homework05.exceptions.DuplicatePhoneException;
import homework05.exceptions.InvalidPhoneException;
import homework05.exceptions.PhoneNotFoundException;
import homework05.services.FileFormat;

import java.util.Map;

public class Presenter {

    private final Model model;
    private final View view;

    public Presenter(View view, Map<FileFormat, String> paths) {
        this.view = view;
        model = new Model(paths);
    }

    public void loadFromFile(FileFormat fileFormat) {
        model.load(fileFormat);

        if (model.currentBook().size() > 0) {
            view.showMessage("Phone book loaded successfully");
        }
    }

    public boolean addContact() {
        try {
            model.addContact(view.getStringFieldFromInput("first name"), view.getStringFieldFromInput("last name"));
        } catch (DuplicateContactException e) {
            view.showMessage(e.getMessage());
            return false;
        }
        view.showMessage("Contact added successfully");
        return true;
    }

    public void removeContact() {
        model.currentBook().remove(model.currentContact());
        view.showMessage("Contact removed successfully");

        if (model.currentBook().size() > 0) {
            model.getContact(0);
        } else {
            model.setCurrentContact(null);
            view.showMessage("Phone book is empty");
        }
    }

    public void addPhone() {
        try {
            model.currentContact().addPhone(view.getStringFieldFromInput("phone number"));
            view.showMessage("Phone added successfully");
        } catch (InvalidPhoneException | DuplicatePhoneException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void removePhone() {
        try {
            model.currentContact().removePhone(view.getStringFieldFromInput("phone number"));
            view.showMessage("Phone removed successfully");
        } catch (InvalidPhoneException | PhoneNotFoundException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean getContact() {
        int id = getId();
        if (id < 0) {
            view.showMessage("Wrong value");
            return false;
        }
        model.getContact(id);
        return true;
    }

    private int getId() {
        view.inputPrompt("contact ID");
        return view.getIntegerFieldFromInput();
    }

    public boolean findContacts() {
        String name = view.getStringFieldFromInput("search string");
        int id;
        int numberOfContacts = model.findContacts(name);
        if (numberOfContacts > 1) {
            id = contactChoiceMenu();
        } else if (numberOfContacts == 1) {
            id = 0;
        } else {
            view.showMessage("Contacts not found");
            return false;
        }

        if (id >= 0) {
            setCurrentContactFromFound(0);
            return true;
        }
        view.showMessage("Wrong value");
        return false;
    }

    private int contactChoiceMenu() {
        view.showMessage(model.showFoundContacts());
        return getId();
    }

    public void saveToFile(FileFormat fileFormat) {
        String msg;
        if (model.save(fileFormat)) msg = "File successfully saved";
        else {
            msg = "Failed to save file";
        }
        view.showMessage(msg);
    }

    public void showPhonebook() {
        view.showMessage(model.showPhonebook());
    }

    public void setCurrentContactFromFound(int index) {
        model.setCurrentContact(model.foundContacts().get(index));
    }

    public void showCurrentContact() {
        view.showMessage(model.showCurrentContact());
    }

    public void newPhonebook() {
        model.newPhonebook();
    }

}
