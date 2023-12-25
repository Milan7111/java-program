import java.util.Scanner;

public class GCD {
    // Function to calculate GCD using Euclidean algorithm
    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers from the user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate and display the GCD
        int gcd = calculateGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
