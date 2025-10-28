package ss14_sort_algorithm.bai_tap;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter the size of array: ");
        size = Integer.parseInt(sc.nextLine());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        insertionSort(arr);

        System.out.println("Array after sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    public static void insertionSort(int[] arr) {
        int pos;
        int x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;

            while (pos > 0 && arr[pos - 1] > x) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
    }
}
