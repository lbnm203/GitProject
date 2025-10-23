package ss11_stack_queue.bai_tap.convert_array.controller;

import ss11_stack_queue.bai_tap.convert_array.entity.CheckPalindromeUsingQueue;
import ss11_stack_queue.bai_tap.convert_array.entity.ConvertArrayUsingStack;
import ss11_stack_queue.bai_tap.convert_array.entity.ConvertDicimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        String arr2 = "I love Java";

        System.out.println("Array before convert: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nArray after convert: ");
        ConvertArrayUsingStack.convertArray(arr);

        System.out.println("\n\nString before convert: ");
        System.out.println(arr2);

        System.out.println("\nString after convert: ");
        ConvertArrayUsingStack.convertStringArray(arr2);

        System.out.println("\n============================");
        System.out.println("Converting Dicimal to Binary");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a number to convert: ");
        int number = Integer.parseInt(sc.nextLine());

        String resultBinary = ConvertDicimalToBinary.convertToBinary(number);
        System.out.println("The binary of " + number + " is: " + resultBinary);

        System.out.println("\n============================");
        System.out.println("\nCheck Polindrome: ");
        System.out.println("Enter a string to check: ");
        String str = sc.nextLine();
        boolean resultPalindrome = CheckPalindromeUsingQueue.checkPalindrome(str);

        if (resultPalindrome) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is not a palindrome!");
        }
    }
}
