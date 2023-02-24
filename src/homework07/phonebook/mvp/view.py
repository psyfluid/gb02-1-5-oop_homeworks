from abc import abstractmethod


class View:

    @abstractmethod
    def show_string(self, text: str) -> None:
        pass

    @abstractmethod
    def show_message(self, text: str) -> None:
        pass

    @abstractmethod
    def show_menu(self, text: str) -> None:
        pass

    @abstractmethod
    def input_prompt(self, field: str) -> None:
        pass

    @abstractmethod
    def get_int_from_input(self) -> int:
        pass

    @abstractmethod
    def get_string_field_from_input(self, field: str) -> str:
        pass
