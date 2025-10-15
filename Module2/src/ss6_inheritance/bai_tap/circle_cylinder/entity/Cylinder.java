package ss6_inheritance.bai_tap.circle_cylinder.entity;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder() {

    }

    public Cylinder(double radius, String color,double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * super.getRadius() * super.getRadius() * this.height;
    }

    @Override
    public String toString() {
        return "A cylinder with radius: " + super.getRadius() + " and height: " + height + " and color " + super.getColor();
    }
}
