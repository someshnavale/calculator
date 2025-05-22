package com.calculator;

import java.util.Scanner;

/**
 * A simple command-line calculator application.
 */
public class CalculatorApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        boolean running = true;
        
        System.out.println("Simple Calculator");
        System.out.println("----------------");
        System.out.println("Operations: add, subtract, multiply, divide, exit");
        
        while (running) {
            try {
                System.out.print("\nEnter operation: ");
                String operation = scanner.nextLine().trim().toLowerCase();
                
                if (operation.equals("exit")) {
                    running = false;
                    System.out.println("Calculator shutting down. Goodbye!");
                    continue;
                }
                
                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());
                
                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());
                
                double result;
                
                switch (operation) {
                    case "add":
                        result = calculator.add(num1, num2);
                        System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, result);
                        break;
                    case "subtract":
                        result = calculator.subtract(num1, num2);
                        System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, result);
                        break;
                    case "multiply":
                        result = calculator.multiply(num1, num2);
                        System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, result);
                        break;
                    case "divide":
                        try {
                            result = calculator.divide(num1, num2);
                            System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, result);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Unknown operation. Please try again.");
                        break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
