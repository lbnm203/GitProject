package ss7_abstraction.bai_tap.resizeable.entity;
import ss7_abstraction.bai_tap.resizeable.service.Resizeable;

public class Square extends Rectangle implements Resizeable {
    private double side = 1.0;

    public Square() {

    }

    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
        this.side = side;
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        this.side = side;
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A square with side = " + side + " which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        side *= (1 + percent / 100);
        setSide(side);
    }
}

