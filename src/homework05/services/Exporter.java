package homework05.services;

import homework05.models.Phonebook;

public interface Exporter {
    boolean save(String path, Phonebook phonebook);
}
