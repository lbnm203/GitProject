package ss3_array.baitap;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String chars;

        while (true) {
            System.out.println("Enter a string: ");
            str = sc.nextLine();

            if (str.trim().isEmpty()) {
                System.out.println("Cant be empty!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter a char: ");
            chars = sc.nextLine();

            if (chars.trim().isEmpty()) {
                System.out.println("Cant be empty!");
            } else {
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chars.charAt(0)) {
                count++;
            }
        }

        System.out.println();
        System.out.println("Number of " + chars + " in " + str + " is " + count);
    }
}
