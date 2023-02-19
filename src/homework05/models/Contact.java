package homework05.models;

import homework05.exceptions.DuplicatePhoneException;
import homework05.exceptions.InvalidPhoneException;
import homework05.exceptions.PhoneNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private final String lastName;
    private final String firstName;
    private final ArrayList<String> phones;
    private final HashSet<String> phonesHash;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        return firstName() + " " + lastName();
    }

    public List<String> getPhones() {
        return phones;
    }

    @Override
    public int compareTo(Contact contact) {
        return lastName.compareToIgnoreCase(contact.lastName()) * 10
                + firstName.compareToIgnoreCase(contact.firstName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return lastName.equals(contact.lastName) && firstName.equals(contact.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
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

    private String getContactInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(fullName());
        if (phones.size() > 0) sb.append("\n");
        for (String phone : phones)
            sb.append("  ").append(phone).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return getContactInfo();
    }

}
