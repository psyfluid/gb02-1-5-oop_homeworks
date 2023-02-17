package homework05.services;

import homework05.models.Phonebook;

public interface Importer {
    public void load(String path, Phonebook phonebook);
}
