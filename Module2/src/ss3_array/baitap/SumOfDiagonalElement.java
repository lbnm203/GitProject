package ss3_array.baitap;

import java.util.Scanner;

public class SumOfDiagonalElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        while (true) {
            try {
                System.out.println("Enter size of array: ");
                size = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Enter again!");
                sc.next();
            }
        }

        double[][] matrix = new double[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (true) {
                    try {
                        System.out.printf("Enter element (%d, %d): ", i, j);
                        matrix[i][j] = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter interger only!");
                    }
                }
            }
        }

        System.out.println("The array is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        System.out.println("Sum of diagonal element is: " + sum);

    }
}
