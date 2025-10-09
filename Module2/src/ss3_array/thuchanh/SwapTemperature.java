package ss3_array.thuchanh;

import java.util.Scanner;

public class SwapTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double c, f;
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter temperature in Fahrenheit: ");
                    f = sc.nextDouble();
                    c = FToC(f);
                    System.out.println("Temperature in Celsius: " + c);
                    break;
                case 2:
                    System.out.println("Enter temperature in Celsius: ");
                    c = sc.nextDouble();
                    f = CToF(c);
                    System.out.println("Temperature in Fahrenheit: " + f);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);

    }

    public static double CToF(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double FToC(double f) {
        return (f - 32) * 5 / 9;
    }
}
