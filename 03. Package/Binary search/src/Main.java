import java.util.Arrays;
import java.util.Scanner;

class Main {
    //do not change this method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int element = Integer.parseInt(scanner.nextLine().trim());
        int result = callBinarySearch(list, element);
        System.out.println(result);
    }

    /**
     * @param nums ordered a sequence of integers
     * @param key  an element for searching
     * @return index of a key or a negative value
     */
    public static int callBinarySearch(int[] nums, int key) {
        // write your code here
        int a = Arrays.binarySearch(nums, key);
        return a;
    }
}