// Do not change the code below
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Object obj = "null".equals(scanner.nextLine()) ? null : new Object();
            System.out.println(solution.printIsNull(obj));

        }
    }
}