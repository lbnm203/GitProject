package ss3_array.baitap;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        do {
            System.out.println("Enter size of array: ");
            size = sc.nextInt();

            if (size < 1) {
                System.out.println("Enter again!");
            }
        } while (size < 1);

//        int[] arr = new int[size];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter Element %d: ", i + 1);
            arr.add(sc.nextInt());
        }

        System.out.println("The array is: ");
        System.out.print(arr);

        int number;
        System.out.println("Enter the number you want to insert: ");
        number = sc.nextInt();

        int index = -1;
        System.out.println("Enter the index you want to insert: ");
        index = sc.nextInt();

        if (index < 0 || index > arr.size()) {
            System.out.println("Cannot insert!");
        } else {
            arr.add(index, number);
            System.out.println("The array after inserting is: " + arr);
        }
    }
}
