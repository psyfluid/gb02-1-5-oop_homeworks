package homework05.services;

import homework05.models.Contact;
import homework05.models.Phonebook;

import java.io.FileWriter;
import java.io.IOException;

public class ExporterToJson implements Exporter {

    private static String indent(int jsonLevel) {
        int tabSize = 2;
        return " ".repeat(jsonLevel * tabSize);
    }

    public boolean save(String path, Phonebook phonebook) {

        try (FileWriter fw = new FileWriter(path, false)) {
            fw.append("{\n");
            fw.append(indent(1));
            fw.append("\"phonebook\": [\n");
            int size = phonebook.size();
            for (int i = 0; i < size; i++) {
                Contact contact = phonebook.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(indent(2)).append("{\n");
                sb.append(indent(3)).append("\"id\": ").append(i).append(",\n");
                sb.append(indent(3)).append("\"lastName\": \"").append(contact.lastName()).append("\",\n");
                sb.append(indent(3)).append("\"firstName\": \"").append(contact.firstName()).append("\",\n");
                sb.append(indent(3)).append("\"phones\": [\n");
                int j = 0;
                for (String phone : contact.getPhones()) {
                    if (j++ > 0) sb.append(",\n");
                    sb.append(indent(4)).append("\"").append(phone).append("\"");
                }
                sb.append("\n");
                sb.append(indent(3)).append("]\n");
                sb.append(indent(2)).append("}");
                if (i < size - 1) sb.append(",");
                sb.append("\n");
                fw.append(sb.toString());
            }
            fw.append(indent(1));
            fw.append("]\n}");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
