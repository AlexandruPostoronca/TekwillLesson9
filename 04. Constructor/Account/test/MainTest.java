import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final static String FIELD_ERR_TEMPLATE = "%s field should be of type %s";
    private final static String CLASS_ERR_TEMPLATE = "%s class should have exactly %s fields";
    private final static Map<String, String> FIELDS = Map.of(
            "balance", "long",
            "ownerName", "java.lang.String",
            "locked", "boolean"
    );
    private final static String className = "Account";
    private final static List<List<String>> CONSTRUCTORS_TYPES = List.of(
            List.of("long", "java.lang.String", "boolean")
    );

    @Test
    public void test() {
        try {
            Class<?> aClass = Class.forName(className);
            Field[] fields = aClass.getDeclaredFields();
            int size = FIELDS.size();

            checkConstructors(aClass.getConstructors());

            assertEquals(String.format(CLASS_ERR_TEMPLATE, className, size), size, fields.length);

            FIELDS.forEach((key, value) -> fieldTest(aClass, key, value));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class " + className + " was not found!");
        }
    }

    private void fieldTest(Class<?> aClass, String fieldName, String fieldType) {
        try {
            Field balance = aClass.getDeclaredField(fieldName);
            assertEquals(String.format(FIELD_ERR_TEMPLATE, fieldName, fieldType), fieldType, balance.getType().getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field " + fieldName + " was not found!");
        }
    }

    private void checkConstructors(Constructor<?>[] constructors) {
        assertEquals(CONSTRUCTORS_TYPES.size(), constructors.length);
        CONSTRUCTORS_TYPES.forEach(types -> {
            Constructor<?> constructor = getConstructorForTypes(constructors, types);
            assertEquals(types.size(), constructor.getParameterCount());
            for (int i = 0; i < types.size(); i++) {
                assertEquals(constructor.getParameters()[i].getType().getName(), types.get(i));
            }
        });
    }

    private static Constructor<?> getConstructorForTypes(Constructor<?>[] constructors, List<String> types) {
        return Arrays.stream(constructors).filter(c -> {
                    Parameter[] parameters = c.getParameters();
                    if (parameters.length != types.size()) {
                        return false;
                    }
                    for (int i = 0; i < types.size(); i++) {
                        if (!parameters[i].getType().getName().equals(types.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }).findAny()
                .orElseThrow(() -> new RuntimeException("No constructor with types " + String.join(" ", types)));
    }
}