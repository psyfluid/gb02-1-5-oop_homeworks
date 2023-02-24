from collections import OrderedDict


class MyJson:

    def __init__(self):
        self._index = 0
        self._length = 0

    def parse(self, value):
        self._length = len(value)
        json_object = OrderedDict()
        json_object['root'] = self._json_read(value.strip())
        return json_object

    def _json_read(self, value):
        self._json_skip_whitespace(value)
        symbol = value[self._index]
        match symbol:
            case '"':
                self._index += 1
                return self._json_read_string(value)
            case '[':
                self._index += 1
                return self._json_read_array(value)
            case '{':
                self._index += 1
                return self._json_read_object(value)
            case 'n':
                if value[self._index:4] == 'null':
                    return None
            case 't':
                if value[self._index:4] == 'true':
                    return True
            case 'f':
                if value[self._index:5] == 'false':
                    return False
            case _:
                self._json_read_number(value)

    def _json_skip_whitespace(self, value):
        while value[self._index].isspace():
            self._index += 1

    def _json_read_string(self, value):
        start_index = self._index
        end_index = value.find('"', start_index)
        self._index = end_index + 1
        return value[start_index:end_index]

    def _json_read_array(self, value):
        self._json_skip_whitespace(value)
        array = []
        while self._index < self._length:
            array.append(self._json_read(value))
            self._json_skip_whitespace(value)
            symbol = value[self._index]
            self._index += 1
            if symbol == ',':
                self._json_skip_whitespace(value)
            elif symbol == ']':
                return array
        return array

    def _json_read_object(self, value):
        self._json_skip_whitespace(value)
        json_object = OrderedDict()
        while self._index < self._length:
            element_key = self._json_read(value)
            symbol = value[self._index]
            self._index += 1
            if symbol == ':':
                json_object[element_key] = self._json_read(value)
            self._json_skip_whitespace(value)
            symbol = value[self._index]
            self._index += 1
            if symbol == ',':
                self._json_skip_whitespace(value)
            elif symbol == '}':
                return json_object
        return json_object

    def _json_read_number(self, value):
        start_index = self._index
        while value[self._index] in '-+0123456789.':
            self._index += 1
        try:
            str_number = value[start_index:self._index]
            return float(str_number) if str_number.find('.') > 0 else int(str_number)
        except ValueError:
            return None
