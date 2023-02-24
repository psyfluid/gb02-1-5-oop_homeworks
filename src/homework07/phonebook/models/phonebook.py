from phonebook.exceptions.phonebook_exceptions import DuplicateContactException


class Phonebook:
    def __init__(self) -> None:
        self._contacts = []
        self._contacts_dict = {}

    @property
    def contacts(self):
        return self._contacts

    @property
    def size(self):
        return len(self._contacts)

    def add(self, contact):
        if contact.full_name in self._contacts_dict:
            raise DuplicateContactException

        self._contacts.append(contact)
        self._contacts_dict[contact.full_name] = contact
        self._contacts.sort()

    def get(self, index):
        return self._contacts[index]

    def remove(self, contact):
        del self._contacts_dict[contact.full_name]
        self._contacts.remove(contact)

    def find(self, name):
        return [v for k, v in self._contacts_dict.items() if k.find(name) >= 0]

    @property
    def phonebook_info(self):
        if self.size == 0:
            return 'Empty phone book'
        s = 'Phone book:\n'
        return s + ''.join(f'{contact.contact_info}\n' for contact in self._contacts)

    def __str__(self) -> str:
        return self.phonebook_info

    def __getitem__(self, item):
        return self._contacts[item]
