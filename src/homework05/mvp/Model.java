package homework05.mvp;

import homework05.models.Contact;
import homework05.models.Phonebook;
import homework05.services.*;

import java.util.List;
import java.util.Map;

public class Model {

    private Phonebook currentBook;
    private Contact currentContact;
    private List<Contact> foundContacts;
    private Map<FileFormat, String> paths;
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

    public void save(FileFormat fileFormat) {
        if (fileFormat == FileFormat.CSV) {
            exporter = new ExporterToCsv();
        } else if (fileFormat == FileFormat.JSON) {
            exporter = new ExporterToJson();
        }
        exporter.save(paths.get(fileFormat), this.currentBook);
    }

    public void newPhonebook() {
        currentBook = new Phonebook();
    }

    public Phonebook currentBook() {
        return this.currentBook;
    }

    public void addContact(String lastName, String firstName) {
        Contact contact = new Contact(lastName, firstName);
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