package homework05.mvp;

import homework05.models.Contact;
import homework05.models.Phonebook;
import homework05.services.*;

import java.util.List;
import java.util.Map;

public class Model {

    private final Map<FileFormat, String> paths;
    private Phonebook currentBook;
    private Contact currentContact;
    private List<Contact> foundContacts;
    private Importer importer;
    private Exporter exporter;

    public Model(Map<FileFormat, String> paths) {
        newPhonebook();
        this.paths = paths;
    }

    public void load(FileFormat fileFormat) {
        if (fileFormat == FileFormat.CSV) {
            importer = new ImporterFromCsv();
        } else if (fileFormat == FileFormat.JSON) {
            importer = new ImporterFromJson();
        }
        importer.load(paths.get(fileFormat), this.currentBook);
    }

    public boolean save(FileFormat fileFormat) {
        if (fileFormat == FileFormat.CSV) {
            exporter = new ExporterToCsv();
        } else if (fileFormat == FileFormat.JSON) {
            exporter = new ExporterToJson();
        }
        return exporter.save(paths.get(fileFormat), this.currentBook);
    }

    public void newPhonebook() {
        currentBook = new Phonebook();
    }

    public Phonebook currentBook() {
        return this.currentBook;
    }

    public void addContact(String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName);
        this.currentBook.add(contact);
        setCurrentContact(contact);
    }

    public Contact currentContact() {
        return this.currentContact;
    }

    public void setCurrentContact(Contact currentContact) {
        this.currentContact = currentContact;
    }

    public void getContact(int id) {
        setCurrentContact(this.currentBook.get(id));
    }

    public int findContacts(String name) {
        this.foundContacts = this.currentBook.find(name);
        return this.foundContacts.size();
    }

    public List<Contact> foundContacts() {
        return foundContacts;
    }

    public String showPhonebook() {
        if (this.currentBook.size() == 0) return "Phone book is empty";
        return this.currentBook.toString();
    }

    public String showCurrentContact() {
        return this.currentContact.toString();
    }

    public String showFoundContacts() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : this.foundContacts) {
            sb.append(contact.toString());
        }
        return sb.toString();
    }

}