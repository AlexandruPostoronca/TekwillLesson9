import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainTest {
    private static final String FIELD_ERR_TEMPLATE = "%s field should be of type %s";
    private static final String CLASS_ERR_TEMPLATE = "%s class should have exactly %s fields";
    private static final String CLASS_NAME = "Phone";
    private static final Map<String, String> FIELDS = Map.of(
            "ownerName", "java.lang.String",
            "countryCode", "java.lang.String",
            "cityCode", "java.lang.String",
            "number", "java.lang.String"
    );
    private static final List<List<String>> CONSTRUCTORS_TYPES = List.of(
            List.of("java.lang.String", "java.lang.String"),
            List.of("java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String")
    );

    @Test
    public void test() {
        try {
            Class<?> aClass = Class.forName(CLASS_NAME);
            Field[] fields = aClass.getDeclaredFields();
            int size = FIELDS.size();
            assertEquals(String.format(CLASS_ERR_TEMPLATE, CLASS_NAME, size), size, fields.length);
            FIELDS.forEach((key, value) -> fieldTest(aClass, key, value));

            checkConstructors(aClass.getConstructors());
            checkAllConstructor();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class " + CLASS_NAME + " was not found!");
        }
    }

    private void checkAllConstructor() {
        Phone p1 = new Phone("John", "123");
        assertEquals("John", p1.ownerName);
        assertNull(p1.countryCode);
        assertNull(p1.cityCode);
        assertEquals("123", p1.number);

        Phone p2 = new Phone("John", "123", "456", "789");
        assertEquals("John", p2.ownerName);
        assertEquals("123", p2.countryCode);
        assertEquals("456", p2.cityCode);
        assertEquals("789", p2.number);
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