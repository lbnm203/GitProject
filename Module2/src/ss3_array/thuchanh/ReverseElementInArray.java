package ss3_array.thuchanh;

import java.util.Scanner;

public class ReverseElementInArray {
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the size of array: ");
            size = sc.nextInt();

            if (size > 20) {
                System.out.println("The size of array must be less than 20");
            }
        } while (size > 20);

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

        for (int j = 0; j < arr.length / 2; j++) {
            int temp = arr[j];
            arr[j] = arr[arr.length - j - 1];
            arr[arr.length - j - 1] = temp;
        }

        System.out.println();
        System.out.println("Reverse array is: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

    }
}
