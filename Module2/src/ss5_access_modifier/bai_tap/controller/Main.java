package ss5_access_modifier.bai_tap.controller;

import ss5_access_modifier.bai_tap.entity.Circle;
import ss5_access_modifier.bai_tap.entity.Student;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Radius: " + c1.getRadius() + " - Color: " + c1.getColor());
        System.out.println("---------------------------------------------------------");

        Student s1 = new Student();
        s1.displayInfo();
        s1.setName("Mary");
        s1.setClasses("C05");
        s1.displayInfo();
    }
}
