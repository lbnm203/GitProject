package ss3_array.thuchanh;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a student name: ");
        String name = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(name)) {
                System.out.println("Postion " + name + " is " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Student " + name + " is not exist!");
        }
    }
}
