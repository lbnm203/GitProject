package ss6_inheritance.bai_tap.circle_cylinder.controller;

import ss6_inheritance.bai_tap.circle_cylinder.entity.Circle;
import ss6_inheritance.bai_tap.circle_cylinder.entity.Cylinder;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.5, "orange");
        System.out.println(c1);

        Cylinder c2 = new Cylinder(4.5, "blue", 2.0);
        System.out.println(c2);
    }
}
