import java.util.Scanner;

public class ConsoleCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN; // Not a Number to indicate invalid result
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice = 0;

        System.out.println("=== Java Console Calculator ===");

        do {
            System.out.print("Enter first number: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a valid number: ");
                scanner.next(); // discard invalid input
            }
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Enter second number: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a valid number: ");
                scanner.next();
            }
            double num2 = scanner.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    result = divide(num1, num2);
                    if (Double.isNaN(result)) {
                        continue; // skip printing result and asking to repeat
                    }
                    break;
                default:
                    System.out.println("Invalid operator! Please use +, -, *, or /.");
                    continue;
            }

            System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);

            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = scanner.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Calculator closed.");
        scanner.close();
    }
}
