package ss3_array.baitap;

import java.util.Scanner;

public class MergeTwoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size1;
        int size2;

        do {
            System.out.println("Enter size of array 1: ");
            size1 = sc.nextInt();

            if (size1 < 1) {
                System.out.println("Enter again!");
            }
        } while (size1 < 1);

        int[] arr1 = new int[size1];

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("Enter Element " + (i + 1) + ": ");
            arr1[i] = sc.nextInt();
        }

        do {
            System.out.println("Enter size of array 2: ");
            size2 = sc.nextInt();

            if (size2 < 1) {
                System.out.println("Enter again!");
            }
        } while (size2 < 1);

        int[] arr2 = new int[size2];

        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("Enter Element " + (i + 1) + ": ");
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println(" ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        int[] arr3 = new int[arr1.length + arr2.length];

        for (int i = 0; i < size1; i++) {
            arr3[i] = arr1[i];
        }

        for (int i = 0; i < size2; i++) {
            arr3[size1 + i] = arr2[i];
        }

        System.out.println(" ");
        System.out.println("Array after merge: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }



    }
}
