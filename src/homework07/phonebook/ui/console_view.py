from phonebook.mvp.view import View


class ConsoleView(View):

    def show_string(self, text: str) -> None:
        print(text, end='')

    def show_message(self, text: str) -> None:
        print(text, end='\n\n')

    def show_menu(self, text: str) -> None:
        self.show_string(f'\n{text}')

    def input_prompt(self, field: str) -> None:
        self.show_string(f'Input {field}: ')

    def get_int_from_input(self) -> int:
        try:
            return int(input())
        except ValueError:
            return -1

    def get_string_field_from_input(self, field: str) -> str:
        self.input_prompt(field)
        return input()
