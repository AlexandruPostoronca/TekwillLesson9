import java.util.Arrays;

public class ArraySorting {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String[] array = scanner.next().split(" ");

        String[] array1 = sortArray(array);
    }

    /**
     * @param array unordered sequence of strings
     * @return ordered an array of strings
     */
    public static String[] sortArray(String[] array) {
        // write your code here
        String[] arrai1 = new String[array.length];
        Arrays.sort(array);
        for (String sort : array)
            arrai1 = array;

        return arrai1;
    }
}