package ss2_loop_java.thuchanh;

import java.util.Scanner;

public class CreateMenu {
    public static void main(String[] args) {
        int choice = -1;

        Scanner sc = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("1. Draw a triangle");
            System.out.println("2. Draw a rectangle");
            System.out.println("3. Draw a square");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Drawing a triangle");
                    System.out.println("*");
                    System.out.println("**");
                    System.out.println("***");
                    System.out.println("****");
                    System.out.println("*****");
                    System.out.println("******");
                    break;
                case 2:
                    System.out.println("Drawing a rectangle");
                    System.out.println("* * * * * * *");
                    System.out.println("* * * * * * *");
                    System.out.println("* * * * * * *");
                    break;
                case 3:
                    System.out.println("Drawing a square");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
