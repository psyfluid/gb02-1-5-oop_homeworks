package homework05.models;

import homework05.exceptions.DuplicatePhoneException;
import homework05.exceptions.InvalidPhoneException;
import homework05.exceptions.PhoneNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;

public class Contact implements Comparable<Contact> {
    private final String lastName;
    private final String firstName;
    private ArrayList<String> phones;
    private HashSet<String> phonesHash;

    public Contact(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phones = new ArrayList<>();
        this.phonesHash = new HashSet<>();
    }

    public String lastName() {
        return lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String fullName() {
        String sb = lastName() + " " +
                firstName();
        return sb;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    @Override
    public int compareTo(Contact contact) {
        return lastName.compareToIgnoreCase(contact.lastName()) * 10 + firstName.compareToIgnoreCase(contact.firstName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return lastName.equals(contact.lastName) && firstName.equals(contact.firstName);
    }

    public void addPhone(String phone) throws InvalidPhoneException, DuplicatePhoneException {
        if (phonesHash.contains(phone)) throw new DuplicatePhoneException();
        if (!isValidPhone(phone)) throw new InvalidPhoneException();

        phones.add(phone);
        phonesHash.add(phone);
    }

    public void removePhone(String phone) throws InvalidPhoneException, PhoneNotFoundException {
        if (!isValidPhone(phone)) throw new InvalidPhoneException();
        if (!phonesHash.contains(phone)) throw new PhoneNotFoundException();

        phones.remove(phone);
        phonesHash.remove(phone);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\+\\d{11}");
    }

    private void getContactInfo(StringBuilder sb) {
        sb.append(String.format("%s %s\n", lastName, firstName));
        for (String phone : phones)
            sb.append("  ").append(phone).append("\n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getContactInfo(sb);
        return sb.toString();
    }

}
