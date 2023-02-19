package homework05.services;

import homework05.mvp.View;

import java.util.Arrays;
import java.util.List;

public interface EnumSelector {
    static <T> T selectFromInput(View view, Class<T> enumClass) {
        List<T> enumList = Arrays.asList(enumClass.getEnumConstants());
        String enumName = enumClass.getSimpleName();
        int length = enumList.size();
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Choose %s:%n", enumName));
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%d - %s%n", i, enumList.get(i)));
            }
            view.showMenu(sb.toString());
            int actionId = view.getIntegerFieldFromInput();
            if (actionId < 0 || actionId > length) continue;
            return enumList.get(actionId);
        }
    }
}
