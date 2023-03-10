package homework05.models;

import homework05.exceptions.DuplicateContactException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

public class Phonebook {
    private final ArrayList<Contact> contacts;
    private final HashMap<String, Contact> contactsMap;

    public Phonebook() {
        contacts = new ArrayList<>();
        contactsMap = new HashMap<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void add(Contact contact) throws DuplicateContactException {
        String fullName = contact.fullName();
        if (contactsMap.containsKey(fullName)) throw new DuplicateContactException();

        contacts.add(contact);
        contactsMap.put(fullName, contact);
        contacts.sort(Contact::compareTo);
    }

    public Contact get(int index) {
        Objects.checkIndex(index, this.size());
        return contacts.get(index);
    }

    public void remove(Contact contact) {
        contactsMap.remove(contact.fullName());
        contacts.remove(contact);
    }

    public void remove(int index) {
        Contact contact = contacts.get(index);
        this.remove(contact);
    }

    public List<Contact> find(String name) {
        List<Contact> foundContacts = new ArrayList<>();
        for (Entry<String, Contact> entry : contactsMap.entrySet()) {
            if (entry.getKey().contains(name)) {
                foundContacts.add(entry.getValue());
            }
        }
        return foundContacts;
    }

    public int size() {
        return contacts.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Phone book:\n");
        for (Contact contact : contacts) {
            sb.append(contact.toString());
        }
        return sb.toString();
    }
}
