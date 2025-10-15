package ss6_inheritance.bai_tap.point2D_point3D.controller;

import ss6_inheritance.bai_tap.point2D_point3D.entity.Point2D;
import ss6_inheritance.bai_tap.point2D_point3D.entity.Point3D;

public class Main {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(3.5F, 6.3F);
        System.out.println(p1);
        System.out.println("---------------------------------------------------------");

        Point3D p2 = new Point3D(3.5F, 6.3F, 1.2F);
        System.out.println(p2);
    }
}
