import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
    public void simpleTest() {
        Main.main(new String[0]);
        String expectedOutput = String.join(System.lineSeparator(), "123456", "1000", "demo-user", "Alexander", "Schmidt");
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}