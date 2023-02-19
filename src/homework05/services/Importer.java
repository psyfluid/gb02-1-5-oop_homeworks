package homework05.services;

import homework05.models.Phonebook;

public interface Importer {
    void load(String path, Phonebook phonebook);
}
