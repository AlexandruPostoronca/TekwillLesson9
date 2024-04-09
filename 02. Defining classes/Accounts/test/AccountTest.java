import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private final static String FIELD_ERR_TEMPLATE = "%s field should be of type %s";

    @Test
    public void test() throws NoSuchFieldException {
        Account account = new Account();
        Class<? extends Account> aClass = account.getClass();
        Field[] fields = aClass.getDeclaredFields();

        assertEquals(aClass.getName() + " class should have exactly 3 fields.", 3, fields.length);

        String template = "%s field should be of type %s";

        fieldTest(aClass, "balance", "long");
        fieldTest(aClass, "ownerName", "java.lang.String");
        fieldTest(aClass, "locked", "boolean");
    }

    private void fieldTest(Class<?> aClass, String fieldName, String fieldType) throws NoSuchFieldException {
        Field balance = aClass.getDeclaredField(fieldName);
        assertEquals(String.format(FIELD_ERR_TEMPLATE, fieldName, fieldType), fieldType, balance.getType().getName());
    }

}