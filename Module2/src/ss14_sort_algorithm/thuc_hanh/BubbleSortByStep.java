package ss14_sort_algorithm.thuc_hanh;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of array: ");
        size = Integer.parseInt(sc.nextLine());

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter element %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        boolean isSorted = true;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            isSorted = false;
            count++;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swap " + arr[j] + " and " + arr[j + 1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = true;
                }
            }

            if (isSorted == false) {
                System.out.println("Array is sorted and dont need to next pass");
                break;
            }

            System.out.println("Array is: ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
            System.out.println(count + " loop times");
        }
    }
}
