package ss2_loop_java.baitap;

import java.util.Scanner;

public class ShowAllShape {
    public static void main(String[] arg) {
        int choice = -1;

        Scanner sc = new Scanner(System.in);

        while (choice != 4) {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Drawing a rectangle");
                    printRectangle(3, 5);
                    break;
                case 2:
                    System.out.println("Drawing a square triangle");
                    printSquareTriangle(5);
                    break;
                case 3:
                    System.out.println("Drawing an isosceles triangle");
                    printIsoscelesTriangle(5);
                    break;

                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void printSquareTriangle(int n) {
        System.out.println("Square Triangle Bottom Left");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("Square Triangle Bottom Right");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("Square Triangle Top Right");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("Square Triangle Top Left");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printRectangle(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printIsoscelesTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= 2 * i - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
