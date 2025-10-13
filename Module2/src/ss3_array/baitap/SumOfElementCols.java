package ss3_array.baitap;

import java.util.Scanner;

public class SumOfElementCols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        while (true) {
            try {
                System.out.println("Enter size of array: ");
                size = Integer.parseInt(sc.nextLine());

                if (size < 1) {
                    System.out.println("Size must be greater than 0");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Enter interger only!");
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

        int targetCols;
        while (true) {
            try {
                System.out.println("Enter number of columns to be searched: ");
                targetCols = sc.nextInt();

                if (targetCols >= size || targetCols < 0) {
                    System.out.println("Columns must be greater than or equal to 0!");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Enter interger only!");
            }
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][targetCols];
        }
        System.out.println("Sum of element in column " + targetCols + " is: " + sum);


    }
}
