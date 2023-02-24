from abc import abstractmethod

from phonebook.models.contact import Contact
from phonebook.services.my_json import MyJson


class Importer:
    @abstractmethod
    def load(self, path, phonebook):
        pass


class ImporterFromCsv(Importer):
    def load(self, path, phonebook):
        sep = ';'
        try:
            with open(path, 'r', encoding='utf-8') as f:
                lines = list(map(str.strip, f.readlines()))
                current_id = -1
                contact = None
                for line in lines:
                    if len(line) == 0 or line.startswith('id'):
                        continue
                    fields = line.split(sep)
                    new_id = int(fields[0])
                    if new_id != current_id:
                        if contact is not None:
                            phonebook.add(contact)
                        current_id = new_id
                        last_name = fields[1]
                        first_name = fields[2]
                        contact = Contact(first_name, last_name)
                    phone = fields[3]
                    if contact is not None:
                        contact.add_phone(phone)
                if contact is not None:
                    phonebook.add(contact)
            return True
        except (IOError, ValueError):
            return False


class ImporterFromJson(Importer):
    def load(self, path, phonebook):
        try:
            with open(path, 'r', encoding='utf-8') as f:
                json_string = f.read()
                json_object = MyJson().parse(json_string)
                root_value = json_object.get('root')
                phonebook_list = root_value.get('phonebook')
                for contact_dict in phonebook_list:
                    contact = Contact(contact_dict.get('first_name'), contact_dict.get('last_name'))
                    phones_list = contact_dict.get('phones')
                    for phone in phones_list:
                        if phone is None:
                            continue
                        contact.add_phone(phone)
                    phonebook.add(contact)
            return True
        except IOError:
            return False
