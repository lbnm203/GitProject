package ss5_access_modifier.bai_tap.entity;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle() {

    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }


}
