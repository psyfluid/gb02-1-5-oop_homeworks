package homework05.services;

import homework05.models.Contact;
import homework05.models.Phonebook;

import java.io.FileWriter;
import java.io.IOException;

public class ExporterToCsv implements Exporter {

    public void save(String path, Phonebook phonebook) {
        String sep = ";";
        try (FileWriter fw = new FileWriter(path, false)) {
            fw.append("id;lastName;firstName;phone");
            for (int i = 0; i < phonebook.size(); i++) {
                Contact contact = phonebook.get(i);
                StringBuilder sb = new StringBuilder();
                for (String phone : contact.getPhones()) {
                    sb.append(i).append(sep);
                    sb.append(contact.lastName()).append(sep);
                    sb.append(contact.firstName()).append(sep);
                    sb.append(phone).append("%n");
                }
                fw.append(sb.toString());
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
