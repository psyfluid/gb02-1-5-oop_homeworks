import re

from phonebook.exceptions.phonebook_exceptions import *


class Contact:
    def __init__(self, first_name, last_name):
        self._first_name = first_name
        self._last_name = last_name
        self._phones = []
        self._phones_hash = set()

    @property
    def first_name(self):
        return self._first_name

    @property
    def last_name(self):
        return self._last_name

    @property
    def full_name(self):
        return f'{self._first_name} {self._last_name}'

    @property
    def phones(self):
        return self._phones

    def add_phone(self, phone):
        if phone in self._phones_hash:
            raise DuplicatePhoneException
        if not self.is_valid_phone(phone):
            raise InvalidPhoneException

        self._phones.append(phone)
        self._phones_hash.add(phone)

    def remove_phone(self, phone):
        if not self.is_valid_phone(phone):
            raise InvalidPhoneException
        if phone not in self._phones_hash:
            raise PhoneNotFoundException

        self._phones.remove(phone)
        self._phones_hash.remove(phone)

    @property
    def contact_info(self):
        info = self.full_name
        if self._phones:
            info += '\n'
        for phone in self._phones:
            info += f'  {phone}\n'
        return info

    @staticmethod
    def is_valid_phone(phone):
        return bool(re.match(r"\+\d{11}", phone))

    def __repr__(self) -> str:
        return f'Contact({self.full_name})'

    def __str__(self) -> str:
        return self.contact_info

    def __eq__(self, o: object) -> bool:
        if self is o:
            return True
        if o is None or not isinstance(o, self.__class__):
            return False
        return self.full_name == o.full_name

    def __lt__(self, o):
        return self.first_name < o.first_name if self.last_name == o.last_name else self.last_name < o.last_name

    def __le__(self, o):
        return self.first_name <= o.first_name if self.last_name == o.last_name else self.last_name <= o.last_name
