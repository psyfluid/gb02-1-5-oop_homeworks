package homework05.mvp;

import homework05.services.FileFormat;

import java.util.Map;

public class Presenter {

    private Model model;
    private View view;

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

    public boolean add() {
        model.addContact(view.getLastName(), view.getFirstName());
        view.showMessage("Contact added successfully");
        return true;
    }

    public void remove() {
        model.currentBook().remove(model.currentContact());
        view.showMessage("Contact removed successfully");

        if (model.currentBook().size() >= 0) {
            model.getContact(0);
        } else {
            model.setCurrentContact(null);
            view.showMessage("Phone book is empty");
        }
    }

    public void addPhone() {
        model.currentContact().addPhone(view.getPhone());
    }

    public void removePhone() {
        model.currentContact().removePhone(view.getPhone());
    }

    public boolean getContact() {
        int id = view.getId();
        if (id < 0) {
            view.showMessage("Wrong value");
            return false;
        }
        model.getContact(id);
        return true;
    }

    public boolean findContacts() {
        String name = view.getSearchString();
        int id = -1;
        int numberOfContacts = model.findContacts(name);
        if (numberOfContacts > 0) {
            id = contactChoiceMenu();
        } else if (numberOfContacts == 0) {
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
        return view.getId();
    }

    public void saveToFile(FileFormat fileFormat) {
        model.save(fileFormat);
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
