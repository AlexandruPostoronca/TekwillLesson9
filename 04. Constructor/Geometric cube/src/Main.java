import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int length = scanner.nextInt();
        GeometricCuboid cuboid=new GeometricCuboid(width,height,length);

        // creating an instance

        System.out.println(cuboid.toString());
    }
}

