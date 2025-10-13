package ss3_array.baitap;

import java.util.Scanner;

public class FindMinIn2DimsArray {
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

        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                while (true) {
                    try {
                        System.out.printf("Enter element (%d, %d): ", i, j);
                        arr[i][j] = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter interger only!");
                    }
                }
            }
        }

        System.out.println("The array is: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] min = findMin(arr);
        System.out.println("Min Element in Array: " + min[0] + " in position (" + min[1] + ", " + min[2] + ")");
    }

    public static int[] findMin(int[][] arr) {
        int row = 0;
        int col = 0;
        int min = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[] {min, row, col};
    }
}
