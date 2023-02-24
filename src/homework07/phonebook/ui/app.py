from phonebook import config
from phonebook.config import FileFormat
from phonebook.mvp.presenter import Presenter
from phonebook.services.enum_selector import EnumSelector
from phonebook.ui.console_view import ConsoleView


def menu_builder(text, menu):
    return text + ''.join(f'{k} - {v}\n' for k, v in menu.items())


class App:
    def __init__(self) -> None:
        self.view = ConsoleView()
        self.file_format = FileFormat.CSV
        self.presenter = Presenter(self.view, config.paths())

    def main_menu(self):
        menu = menu_builder('Choose action: \n', config.main_menu())

        while True:
            self.view.show_menu(menu)
            action_id = self.view.get_int_from_input()
            match action_id:
                case 1:
                    self.presenter.show_phonebook()
                case 2:
                    self.presenter.load_from_file(self.file_format)
                case 3:
                    self.presenter.save_to_file(self.file_format)
                case 4:
                    self.presenter.new_phonebook()
                case 5:
                    if self.presenter.add_contact():
                        self.contact_menu()
                case 6:
                    if self.presenter.get_contact():
                        self.contact_menu()
                case 7:
                    if self.presenter.find_contacts():
                        self.contact_menu()
                case 8:
                    self.file_format = EnumSelector.select_from_input(self.view, FileFormat)
                case 0:
                    return

    def contact_menu(self):
        self.presenter.show_current_contact()
        menu = menu_builder('Choose contact action: \n', config.contact_menu())
        while True:
            self.view.show_menu(menu)
            action_id = self.view.get_int_from_input()
            match action_id:
                case 1:
                    self.presenter.add_phone()
                case 2:
                    self.presenter.remove_phone()
                case 3:
                    self.presenter.remove_contact()
                    return
                case 4:
                    return
