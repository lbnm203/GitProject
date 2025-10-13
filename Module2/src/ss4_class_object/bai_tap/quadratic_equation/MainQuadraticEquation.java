package ss4_class_object.bai_tap.quadratic_equation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = inputValue(sc, "Enter a: ");
        double b = inputValue(sc, "Enter b: ");
        double c = inputValue(sc, "Enter c: ");

        QuadraticEquation quadratic = new QuadraticEquation(a, b, c);

        if (quadratic.getDiscriminant() == 0) {
            System.out.println("The equation has one root " + quadratic.getRoot1() );
        } else if (quadratic.getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + quadratic.getRoot1() + " and " + quadratic.getRoot2());
        } else {
            System.out.println("The equation has no real roots");
        }
    }

    public static double inputValue(Scanner sc, String message) {
        double value;

        while (true) {
            try {
                System.out.println(message);
                value = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Enter exactly /double/ format!");
                sc.nextLine();
            }
        }

        return value;
    }
}
