package script.java注解;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerializer {

    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Map<String, String> jsonElements = new HashMap<>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                jsonElements.put(getSerializedKey(field), (String)field.get(object));
            }
        }
        return toJsonString(jsonElements);
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }

    private static String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet().stream().map(
                entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\""
        ).collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }


}
