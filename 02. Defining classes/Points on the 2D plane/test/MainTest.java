import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final static String FIELD_ERR_TEMPLATE = "%s field should be of type %s";
    private final static String CLASS_ERR_TEMPLATE = "%s class should have exactly %s fields";
    private final static Map<String, String> FIELDS = Map.of(
            "x", "float",
            "y", "float"
    );
    private final static String className = "Point2D";

    @Test
    public void test() {
        try {
            Class<?> aClass = Class.forName(className);
            Field[] fields = aClass.getDeclaredFields();
            int size = FIELDS.size();

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
}