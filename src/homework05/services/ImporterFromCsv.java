package homework05.services;

import homework05.models.Contact;
import homework05.models.Phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImporterFromCsv implements Importer {
    @Override
    public void load(String path, Phonebook phonebook) {
        String sep = ";";
        try (FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            int id = -1;
            Contact contact = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("id")) continue;
                String[] contactString = line.split(sep);
                int idNew = Integer.parseInt(contactString[0]);
                if (idNew != id) {
                    if (contact != null) phonebook.add(contact);
                    id = idNew;
                    String lastName = contactString[1];
                    String firstName = contactString[2];
                    contact = new Contact(firstName, lastName);
                }
                String phone = contactString[3];
                if (contact != null) contact.addPhone(phone);
            }
            if (contact != null) phonebook.add(contact);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
