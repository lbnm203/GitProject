package ss1_Introduction_Java.ThucHanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float height;
        float width;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a height: ");
        height = sc.nextFloat();

        System.out.println("Enter a width: ");
        width = sc.nextFloat();

        float area = height * width;
        System.out.println("The area of the rectangle is: " + area);

    }
}
