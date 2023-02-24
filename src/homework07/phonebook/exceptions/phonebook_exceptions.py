class PhonebookException(Exception):
    pass


class DuplicateContactException(PhonebookException):
    def __init__(self) -> None:
        super().__init__('The contact already added to the phone book')


class DuplicatePhoneException(PhonebookException):
    def __init__(self) -> None:
        super().__init__('Phone number already added to the list')


class InvalidPhoneException(PhonebookException):
    def __init__(self) -> None:
        super().__init__('Invalid phone number format')


class PhoneNotFoundException(PhonebookException):
    def __init__(self) -> None:
        super().__init__('Phone number is not found')
