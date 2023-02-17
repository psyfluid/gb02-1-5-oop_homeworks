package homework05.services;

import homework05.models.Contact;
import homework05.models.Phonebook;

import java.io.FileWriter;
import java.io.IOException;

public class ExporterToJson implements Exporter {

    public void save(String path, Phonebook phonebook) {

        try (FileWriter fw = new FileWriter(path, false)) {
            fw.append("{\n");
            fw.append("  \"phonebook\": [\n");
            int size = phonebook.size();
            for (int i = 0; i < size; i++) {
                Contact contact = phonebook.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append("    ").append("{\n");
                sb.append("      ").append("\"id\": ").append(i).append(",\n");
                sb.append("      ").append("\"lastName\": \"").append(contact.lastName()).append("\",\n");
                sb.append("      ").append("\"firstName\": \"").append(contact.firstName()).append("\",\n");
                sb.append("      ").append("\"phones\": [\n");
                int j = 0;
                for (String phone : contact.getPhones()) {
                    if (j++ > 0) sb.append(",\n");
                    sb.append("        ").append("\"").append(phone).append("\"");
                }
                sb.append("      ").append("]\n");
                sb.append("    ").append("}");
                if (i < size - 1) sb.append(",");
                sb.append("\n");
                fw.append(sb.toString());
            }
            fw.append("  ]\n}");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
