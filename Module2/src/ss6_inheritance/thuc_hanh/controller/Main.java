package ss6_inheritance.thuc_hanh.controller;

import ss6_inheritance.thuc_hanh.entity.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println(s1);

        Shape s2 = new Shape("red", false);
        System.out.println(s2);
        System.out.println("--------------------------------");

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        Circle c2 = new Circle(3.5, "papari", false);
        System.out.println(c2);
        System.out.println("-------------------------------");

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(3.5, 5.5);
        System.out.println(rectangle);

        rectangle = new Rectangle(3.5, 5.5, "papari", false);
        System.out.println(rectangle);
        System.out.println("------------------------------------");

        Square square = new Square();
        System.out.println(square);

        square = new Square(3.5);
        System.out.println(square);

        square = new Square(5.5, "papari", false);
        System.out.println(square);
        System.out.println("-------------------------------------------");

        Scanner sc = new Scanner(System.in);

        double side1 = inputNumber(sc, "Enter side 1: ");
        double side2 = inputNumber(sc, "Enter side 2: ");
        double side3 = inputNumber(sc, "Enter side 3: ");

        System.out.println("Enter color");
        String color = sc.next();

        Triangle triangle = new Triangle(side1, side2, side3, color);
        System.out.println(triangle);
    }

    public static double inputNumber(Scanner sc, String message) {
        double number = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(message);
            if (sc.hasNextDouble()) {
                number = sc.nextDouble();
                if (number > 0) {
                    isValid = true;
                } else {
                    System.out.println("Enter number greater than 0!");
                }
            } else {
                System.out.println("Enter double number only!");
                sc.next();
            }
        }
        return number;
    }
}
