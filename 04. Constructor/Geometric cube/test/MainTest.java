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
    public void returnsCorrectCuboidStringForValidInput() {
        simpleTest("Cuboid(w=2, h=3, l=4)", "2 3 4");
    }

    @Test
    public void returnsCorrectCuboidStringForZeroWidth() {
        simpleTest("Cuboid(w=0, h=5, l=6)", "0 5 6");
    }

    @Test
    public void returnsCorrectCuboidStringForNegativeInput() {
        simpleTest("Cuboid(w=-2, h=3, l=4)", "-2 3 4");
    }

    @Test
    public void returnsCorrectCuboidStringForMaxInput() {
        simpleTest("Cuboid(w=2147483647, h=2147483647, l=2147483647)", "2147483647 2147483647 2147483647");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}