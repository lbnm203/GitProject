package ss13_search_algorithm.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter size of array: ");
        n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];

        System.out.println("Enter elements of array: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter element %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(arr);

        System.out.println("Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nEnter a value: ");
        int value = Integer.parseInt(sc.nextLine());

        int result = binarySearch(arr, 0, arr.length - 1, value);

        if (result == -1) {
            System.out.println("Not found!");
        } else {
            System.out.println("Found at position: " + result);
        }


    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) return -1;

        int middle = (left + right) / 2;

        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] > value) {
            return binarySearch(arr, left, middle - 1, value);
        } else {
            return binarySearch(arr, middle + 1, right, value);
        }
    }
}
