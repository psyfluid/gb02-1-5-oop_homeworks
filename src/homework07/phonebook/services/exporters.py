from abc import abstractmethod


class Exporter:
    @abstractmethod
    def save(self, path, phonebook):
        pass


class ExporterToCsv(Exporter):
    def save(self, path, phonebook):
        sep = ';'
        try:
            with open(path, 'w', encoding='utf-8') as f:
                txt = 'id;last_name;first_name;phone\n' + ''.join(
                    f'{i};{v.last_name};{v.first_name};{phone}\n'
                    for i, v in enumerate(phonebook.contacts)
                    for phone in v.phones
                )
                f.write(txt)
                return True
        except IOError:
            return False


class ExporterToJson(Exporter):
    def save(self, path, phonebook):
        tab = '  '
        try:
            with open(path, 'w', encoding='utf-8') as f:
                txt = '{\n' + tab
                txt += '"phonebook": [\n'
                size = phonebook.size
                for i, contact in enumerate(phonebook.contacts):
                    txt += tab * 2 + '{\n'
                    txt += f'{tab * 3}"id": {i},\n'
                    txt += f'{tab * 3}"last_name": "{contact.last_name}",\n'
                    txt += f'{tab * 3}"first_name": "{contact.first_name}",\n'
                    txt += f'{tab * 3}"phones": [\n'
                    for j, phone in enumerate(contact.phones):
                        if j > 0:
                            txt += ',\n'
                        txt += f'{tab * 4}"{phone}"'
                    txt += f'\n{tab * 3}]\n'
                    txt += tab * 2 + '}'
                    if i < size - 1:
                        txt += ','
                    txt += '\n'
                txt += tab + ']\n}'
                f.write(txt)
                return True
        except IOError:
            return False
