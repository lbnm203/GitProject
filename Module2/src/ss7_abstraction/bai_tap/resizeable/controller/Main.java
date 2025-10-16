package ss7_abstraction.bai_tap.resizeable.controller;

import ss7_abstraction.bai_tap.resizeable.entity.Circle;
import ss7_abstraction.bai_tap.resizeable.entity.Rectangle;
import ss7_abstraction.bai_tap.resizeable.entity.Square;
import ss7_abstraction.bai_tap.resizeable.service.Resizeable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(4.0);

        for (Resizeable shape: shapes) {
            double percent = 1.0 + random.nextInt(100);
            System.out.println("Increase by " + percent + "%:");

            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println("Area Circle before: " + circle.getArea());
                circle.resize(percent);
                System.out.println("Area Circle after: " + circle.getArea());
            } else if (shape instanceof Rectangle && !(shape instanceof Square)) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Area Retangle before: " + rectangle.getArea());
                rectangle.resize(percent);
                System.out.println("Area Retangle after: " + rectangle.getArea());
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println("Area Square before: " + square.getArea());
                square.resize(percent);
                System.out.println("Area Square after: " + square.getArea());
            }

            System.out.println("-------------------------");
        }
    }
}
