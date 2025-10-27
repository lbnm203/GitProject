package ss13_search_algorithm.bai_tap;

import java.util.Scanner;

public class AlgorithmComplexity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.nextLine();

        int[] frequentChar = new int[255];
        for (int i = 0; i < str.length(); i++) {
            int ascii = (int) str.charAt(i);
            frequentChar[ascii]++;
        }

        int max = 0;
        char character = (char) 255;
        for (int i = 0; i < 255; i++) {
            if (frequentChar[i] > max) {
                max = frequentChar[i];
                character = (char) i;
            }
        }
        System.out.println("frequency character: " + character + " with frequency: " + max);
    }
}
