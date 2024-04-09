import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class BigIntegerConverterTest {

    @Test
    public void testGetBigInteger() {
        // Test edge cases
        assertEquals(BigInteger.ZERO, BigIntegerConverter.getBigInteger("0"));
        assertEquals(BigInteger.ONE, BigIntegerConverter.getBigInteger("1"));
        assertEquals(BigInteger.TEN, BigIntegerConverter.getBigInteger("10"));
        assertEquals(BigInteger.valueOf(Long.MAX_VALUE), BigIntegerConverter.getBigInteger(String.valueOf(Long.MAX_VALUE)));
        assertEquals(BigInteger.valueOf(Long.MIN_VALUE), BigIntegerConverter.getBigInteger(String.valueOf(Long.MIN_VALUE)));
        assertEquals(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE),
                BigIntegerConverter.getBigInteger(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE).toString()));
        // Test positive numbers
        assertEquals(new BigInteger("123456789"), BigIntegerConverter.getBigInteger("123456789"));
        assertEquals(new BigInteger("987654321"), BigIntegerConverter.getBigInteger("987654321"));
        assertEquals(new BigInteger("99999999999999999999999999999999999999999999999999"), BigIntegerConverter.getBigInteger("99999999999999999999999999999999999999999999999999"));

        // Test negative numbers
        assertEquals(new BigInteger("-123456789"), BigIntegerConverter.getBigInteger("-123456789"));
        assertEquals(new BigInteger("-987654321"), BigIntegerConverter.getBigInteger("-987654321"));
        assertEquals(new BigInteger("-99999999999999999999999999999999999999999999999999"), BigIntegerConverter.getBigInteger("-99999999999999999999999999999999999999999999999999"));
    }
}