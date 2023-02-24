from phonebook.exceptions.phonebook_exceptions import DuplicateContactException, DuplicatePhoneException, \
    InvalidPhoneException, PhoneNotFoundException
from phonebook.mvp.model import Model


class Presenter:
    def __init__(self, view, paths) -> None:
        self._view = view
        self._model = Model(paths)

    def add_contact(self):
        try:
            self._model.add_contact(self._view.get_string_field_from_input('first name'),
                                    self._view.get_string_field_from_input('last name'))
        except DuplicateContactException as ex:
            self._view.show_message(ex)
            return False
        self._view.show_message('Contact added successfully')
        return True

    def remove_contact(self):
        try:
            self._model.current_book.remove(self._model.current_contact)
            self._view.show_message('Contact removed successfully')
        except (KeyError, IndexError) as ex:
            self._view.show_message('Failed to remove contact')
            self._view.show_message(ex)

    def add_phone(self):
        try:
            self._model.current_contact.add_phone(self._view.get_string_field_from_input('phone number'))
            self._view.show_message('Phone added successfully')
        except (InvalidPhoneException, DuplicatePhoneException) as ex:
            self._view.show_message(ex)

    def remove_phone(self):
        try:
            self._model.current_contact.remove_phone(self._view.get_string_field_from_input('phone number'))
            self._view.show_message('Phone removed successfully')
        except (InvalidPhoneException, PhoneNotFoundException) as ex:
            self._view.show_message(ex)

    def get_contact(self):
        index = self.get_id()
        if index < 0:
            self._view.show_message('Wrong value')
            return False
        try:
            self._model.get_contact(index)
        except IndexError as ex:
            self._view.show_message(ex)
            return False
        return True

    def get_id(self):
        self._view.input_prompt('contact ID')
        return self._view.get_int_from_input()

    def find_contacts(self):
        name = self._view.get_string_field_from_input('search string')
        number_of_contacts = self._model.find_contacts(name)
        if number_of_contacts > 1:
            index = self.contact_choice_menu()
        elif number_of_contacts == 1:
            index = 0
        else:
            self._view.show_message('Contacts not found')
            return False

        if 0 <= index < number_of_contacts:
            self.set_current_contact_from_found(index)
            return True

        self._view.show_message('Wrong value')
        return False

    def contact_choice_menu(self):
        self._view.show_message(self._model.show_found_contacts())
        return self.get_id()

    def set_current_contact_from_found(self, index):
        self._model.current_contact = self._model.found_contacts[index]

    def show_phonebook(self):
        self._view.show_string(self._model.show_phonebook())

    def show_current_contact(self):
        self._view.show_string(self._model.show_current_contact())

    def new_phonebook(self):
        self._model.new_phonebook()

    def load_from_file(self, file_format):
        if self._model.load(file_format):
            msg = 'Phone book loaded successfully'
        else:
            msg = 'Failed to load phone book'
        self._view.show_message(msg)

    def save_to_file(self, file_format):
        if self._model.save(file_format):
            msg = 'File successfully saved'
        else:
            msg = 'Failed to save file'
        self._view.show_message(msg)
