package four_basic_arithmetic_operations;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Perform operations
        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double Multiplication = num1 * num2;
        double quotient = num1 / num2;

        // Display results
        System.out.println("Addtion: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + Multiplication);

        // Check for division by zero
        if (num2 != 0) {
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
}
