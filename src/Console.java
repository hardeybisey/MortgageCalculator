import java.util.Scanner;

public class Console {
    private final static Scanner scanner = new Scanner(System.in);

    public static double readValue(String parameter, double min, double max) {
        System.out.print(parameter + ": ");
        int value = scanner.nextInt();
        while (value < min || value >= max) {
            System.out.println("Enter a value between " + min + " and " + max);
            System.out.print(parameter + ": ");
            value = scanner.nextInt();
        }
        return value;
    }
}
