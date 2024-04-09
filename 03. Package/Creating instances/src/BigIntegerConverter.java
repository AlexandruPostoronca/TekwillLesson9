public class BigIntegerConverter {

    /**
     * @param number string representing the number
     * @return BigInteger instance
     */
    public static Number getBigInteger(String number) {
        java.math.BigInteger numer = new java.math.BigInteger(number);
        return numer;
    }
}