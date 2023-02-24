from phonebook import config
from phonebook.config import FileFormat
from phonebook.models.contact import Contact
from phonebook.models.phonebook import Phonebook
from phonebook.services.exporters import Exporter, ExporterToCsv, ExporterToJson
from phonebook.services.importers import Importer, ImporterFromCsv, ImporterFromJson


class Model:
    def __init__(self, paths) -> None:
        self._paths = paths
        self._current_book = Phonebook()
        self._current_contact = None
        self._found_contacts = []

    def new_phonebook(self):
        self._current_book = Phonebook()

    @property
    def current_book(self):
        return self._current_book

    @property
    def current_contact(self):
        return self._current_contact

    @current_contact.setter
    def current_contact(self, contact):
        self._current_contact = contact

    def add_contact(self, first_name, last_name):
        contact = Contact(first_name, last_name)
        self._current_book.add(contact)
        self.current_contact = contact

    def get_contact(self, index):
        self.current_contact = self._current_book.get(index)

    def find_contacts(self, name):
        self._found_contacts = self._current_book.find(name)
        return len(self._found_contacts)

    @property
    def found_contacts(self):
        return self._found_contacts

    def show_phonebook(self):
        return self._current_book.phonebook_info

    def show_current_contact(self):
        return self._current_contact.contact_info

    def show_found_contacts(self):
        return ''.join(f'{contact.contact_info}\n' for contact in self._found_contacts)

    def load(self, file_format):
        importer = Importer()
        if file_format == FileFormat.CSV:
            importer = ImporterFromCsv()
        elif file_format == FileFormat.JSON:
            importer = ImporterFromJson()
        return importer.load(config.paths().get(file_format), self._current_book)

    def save(self, file_format):
        exporter = Exporter()
        if file_format == FileFormat.CSV:
            exporter = ExporterToCsv()
        elif file_format == FileFormat.JSON:
            exporter = ExporterToJson()
        return exporter.save(config.paths().get(file_format), self._current_book)
