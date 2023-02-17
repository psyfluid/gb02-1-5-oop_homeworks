package homework05.services;

import homework05.models.Phonebook;

public interface Exporter {
    public void save(String path, Phonebook phonebook);
}
