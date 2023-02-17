package homework05.services;

import homework05.models.Contact;
import homework05.models.Phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ImporterFromJson implements Importer {
    @Override
    public void load(String path, Phonebook phonebook) {
        try {
            Path fileName = Path.of(path);
            String jsonString = Files.readString(fileName);
            Map<String, Object> jsonObject = JSON.parse(jsonString);

            StringBuilder builder = new StringBuilder();

            Object rootValue = jsonObject.get("root");
            if (rootValue instanceof List<?>) {
                for (Map contactMap : (List<Map>) rootValue) {
                    Contact contact = new Contact((String) contactMap.get("lastName"), (String) contactMap.get("firstName"));
                    List<String> phonesList = (List<String>) contactMap.get("phones");
                    for (String phone : phonesList) {
                        contact.addPhone(phone);
                    }
                    phonebook.add(contact);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
