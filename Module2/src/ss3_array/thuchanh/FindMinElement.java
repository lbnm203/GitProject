package ss3_array.thuchanh;

import java.util.Scanner;

public class FindMinElement {
    public static void main(String[] args) {
        int[] arr;
        int size;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the size of array: ");
            size = sc.nextInt();

            if (size < 1) {
                System.out.println("Enter again!");
            }
        } while (size < 1);

        arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            i++;
        }

        System.out.println("The array is: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println(" ");
        System.out.println("Min Element in Array: " + minValue(arr));
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
