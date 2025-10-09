package ss3_array.thuchanh;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr;
        int size;

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

        System.out.println(" ");
        int max = arr[0];
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        System.out.println("Max Element in Array: " + max + " in position " + i);

    }
}
