package ss3_array.baitap;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter the size of array: ");
            size = sc.nextInt();

            if (size < 1) {
                System.out.println("Enter again!");
            }
        } while (size < 1);

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("The array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int number;
        System.out.println(" ");
        System.out.println("Enter the number of element you want to delete: ");
        number = sc.nextInt();

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                System.out.println("Deleted element is in position: " + i);
                break;
            }
        }

        if (index == -1) {
            System.out.println("The number is not found in the array!");
        } else {
            for (int j = index; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }

            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
        }
    }
}
