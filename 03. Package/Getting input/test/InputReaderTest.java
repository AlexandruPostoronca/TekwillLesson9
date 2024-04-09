import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {

    @Test
    public void testTestString() {
        simpleTest("Test", "The input string: Test");
    }

    @Test
    public void testEmptyString() {
        simpleTest("\n", "The input string: ");
    }

    @Test
    public void testBasicString() {
        simpleTest("Hello, world!", "The input string: Hello, world!");
    }

    @Test
    public void testMultiLineInput() {
        simpleTest("Line 1\nLine 2\nLine 3", "The input string: Line 1");
    }

    private void simpleTest(String in, String expected) {
        InputStream inputStream = new ByteArrayInputStream(in.getBytes());
        System.setIn(inputStream);
        assertEquals(expected, InputReader.getString());
    }
}