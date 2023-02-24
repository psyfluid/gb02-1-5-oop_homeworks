from collections import OrderedDict
from enum import Enum


class FileFormat(Enum):
    CSV = 'csv'
    JSON = 'json'


def paths():
    return {FileFormat.CSV: 'phonebook.csv', FileFormat.JSON: 'phonebook.json'}


def main_menu():
    return OrderedDict({
        1: 'Show phone book',
        2: 'Load phone book',
        3: 'Save phone book',
        4: 'New phone book',
        5: 'Add contact',
        6: 'Open contact by id',
        7: 'Find contact by name',
        8: 'Choose file format (default: csv)',
        0: 'Exit',
    })


def contact_menu():
    return OrderedDict({
        1: 'Add phone',
        2: 'Delete phone',
        3: 'Delete contact',
        4: 'Return to main menu',
    })
