package ss7_abstraction.bai_tap.colorable.controller;

import ss7_abstraction.bai_tap.colorable.entity.Circle;
import ss7_abstraction.bai_tap.colorable.entity.Rectangle;
import ss7_abstraction.bai_tap.colorable.entity.Shape;
import ss7_abstraction.bai_tap.colorable.entity.Square;
import ss7_abstraction.bai_tap.colorable.service.Colorable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(4.0);

        for (Shape shape: shapes) {
            System.out.println(shape);

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println("-------------------------");
        }
    }
}
