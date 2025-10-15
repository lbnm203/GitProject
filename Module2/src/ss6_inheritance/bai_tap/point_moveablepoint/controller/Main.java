package ss6_inheritance.bai_tap.point_moveablepoint.controller;

import ss6_inheritance.bai_tap.point_moveablepoint.entity.MovablePoint;
import ss6_inheritance.bai_tap.point_moveablepoint.entity.Point;
import ss6_inheritance.thuc_hanh.entity.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(3.5F, 6.3F);
        System.out.println(p);
        System.out.println("---------------------------------------------------------");

        MovablePoint mp = new MovablePoint(3.5F, 6.3F, 120F, 150F);
        System.out.println(mp);

        mp.move();
        System.out.println(mp);
    }
}
