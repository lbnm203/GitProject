package ss3_array.baitap;

import java.util.Scanner;

public class FindMaxIn2DimsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        while (true) {
            try {
                System.out.println("Enter number of rows: ");
                rows = Integer.parseInt(sc.nextLine());

                System.out.println("Enter number of columns: ");
                cols = Integer.parseInt(sc.nextLine());

                if (rows < 1 || cols < 1) {
                    System.out.println("Enter number of rows and columns must be greater than 0!");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Enter interger only!");
            }
        }

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (true) {
                    try {
                        System.out.printf("Enter element (%d, %d): ", i, j);
                        matrix[i][j] = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter float only!");
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

        double[] result = findMax(matrix);
        System.out.println("Max Element in Array: " + result[0] + " in position (" + (int) result[1] + ", " + (int) result[2] + ")");

    }

    public static double[] findMax(double[][] arr) {
        double max = arr[0][0];
        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new double[]{max, row, col};
    }
}
