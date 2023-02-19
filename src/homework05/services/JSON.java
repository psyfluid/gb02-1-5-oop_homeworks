package homework05.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSON {
    private static int index;
    private static int length;

    private JSON() {
    }

    public static Map<String, Object> parse(String value) {
        index = 0;
        length = value.length();
        Map<String, Object> jsonObject = new LinkedHashMap<>();
        jsonObject.put("root", jsonRead(value.strip()));
        return jsonObject;
    }

    private static Object jsonRead(String value) {
        jsonSkipWhitespace(value);
        String symbol = value.substring(index, index + 1);
        switch (symbol) {
            case "\"":
                index++;
                return jsonReadString(value);
            case "[":
                index++;
                return jsonReadArray(value);
            case "{":
                index++;
                return jsonReadObject(value);
            case "n":
                if ("null".equals(value.substring(index, index + 4))) {
                    return null;
                }
                break;
            case "t":
                if ("true".equals(value.substring(index, index + 4))) {
                    return true;
                }
                break;
            case "f":
                if ("false".equals(value.substring(index, index + 5))) {
                    return false;
                }
                break;
            default:
                return jsonReadNumber(value);
        }

        return null;
    }

    private static void jsonSkipWhitespace(String value) {
        while (Character.isWhitespace(value.charAt(index))) index++;
    }

    private static Object jsonReadNumber(String value) {
        int startIndex = index;
        while ("-+0123456789.".indexOf(value.charAt(index)) > 0) index++;
        try {
            String stringNumber = value.substring(startIndex, index);
            if (stringNumber.indexOf(".") > 0) return Double.parseDouble(stringNumber);
            return Integer.parseInt(stringNumber);
        } catch (Exception e) {
            return null;
        }
    }

    private static Object jsonReadObject(String value) {
        jsonSkipWhitespace(value);
        Map<String, Object> jsonObject = new LinkedHashMap<>();
        while (index < length) {
            String elementKey = (String) jsonRead(value);
            String symbol = value.substring(index, ++index);
            if (symbol.equals(":")) {
                jsonObject.put(elementKey, jsonRead(value));
            }
            jsonSkipWhitespace(value);
            symbol = value.substring(index, ++index);
            if (symbol.equals("}")) {
                return jsonObject;
            } else if (symbol.equals(",")) {
                jsonSkipWhitespace(value);
            }
        }
        return jsonObject;
    }

    private static List<Object> jsonReadArray(String value) {
        jsonSkipWhitespace(value);
        List<Object> arrayList = new ArrayList<>();
        while (index < length) {
            arrayList.add(jsonRead(value));
            jsonSkipWhitespace(value);
            String symbol = value.substring(index, ++index);
            if (symbol.equals("]")) {
                return arrayList;
            } else if (symbol.equals(",")) {
                jsonSkipWhitespace(value);
            }
        }
        return arrayList;
    }

    private static String jsonReadString(String value) {
        int startIndex = index;
        int endIndex = value.indexOf("\"", startIndex);
        index = endIndex + 1;
        return value.substring(startIndex, endIndex);
    }

}
