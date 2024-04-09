import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testWithExistingElement() {
        simpleTest("1", "1 3 5 7 9\n3");
    }

    @Test
    public void testWithNonExistingElement() {
        simpleTest("-3", "1 3 5 7 9\n4");
    }

    @Test
    public void testWithOneElement() {
        simpleTest("0", "1\n1");
    }

    @Test
    public void testWithMultipleOccurrences() {
        simpleTest("3", "1 2 2 2 4 6 8 9\n2");
    }

    @Test
    public void testWithOddNumberOfElements() {
        simpleTest("3", "1 3 5 7 9 11 13\n7");
    }

    @Test
    public void testWithEvenNumberOfElements() {
        simpleTest("-6", "1 3 5 7 9 11\n10");
    }

    @Test
    public void testOneElementArray() {
        simpleTest("0", "5\n5");
    }

    @Test
    public void testKeySmallerThanAllElements() {
        simpleTest("-1", "1 2 3 4 5\n-1");
    }

    @Test
    public void testKeyGreaterThanAllElements() {
        simpleTest("-6", "1 2 3 4 5\n10");
    }

    @Test
    public void testKeyNotInArray() {
        simpleTest("-3", "1 3 5 7 9\n4");
    }

    @Test
    public void testKeyInArrayOddLength() {
        simpleTest("2", "1 2 3 4 5 6 7\n3");
    }

    @Test
    public void testKeyInArrayEvenLength() {
        simpleTest("4", "1 2 3 4 5 6\n5");
    }


    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}