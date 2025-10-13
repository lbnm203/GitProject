package ss4_class_object.bai_tap.fan;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean isOn;
    private String color;
    private double radius;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public String getColor() {
        return this.color;
    }

    public double getRadius() {
        return this.radius;
    }

    public Fan() {
        this.speed = SLOW;
        this.isOn = false;
        this.color = "blue";
        this.radius = 5;
    }

    public String toString() {
        if (this.isOn) {
            return "Fan is on - speed: " + this.speed + " - color: " + this.color + " - radius: " + this.radius;
        } else {
            return "Fan is off - color: " + this.color + " - radius: " + this.radius;
        }
    }
}
