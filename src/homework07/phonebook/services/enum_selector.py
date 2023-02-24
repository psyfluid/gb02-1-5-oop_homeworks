class EnumSelector:
    @staticmethod
    def select_from_input(view, enum_class):
        enum_len = len(enum_class)
        enum_menu = f'Choose {enum_class.__name__}:\n'
        enum_menu += ''.join(f'{i} - {v.name}\n' for i, v in enumerate(enum_class))
        enum_list = list(enum_class)
        while True:
            view.show_menu(enum_menu)
            action_id = view.get_int_from_input()
            if action_id < 0 or action_id > enum_len:
                continue
            return enum_list[action_id]
