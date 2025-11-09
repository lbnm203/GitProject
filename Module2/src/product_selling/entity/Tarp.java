package product_selling.entity;

public class Tarp extends Product{
    private double numberOfMeters;

    public Tarp(int id, String name, String collection, double price, double numberOfMeters) {
        super(id, name, collection, price, ProductType.Bat);
        this.numberOfMeters = numberOfMeters;
    }

    public Tarp(int id, String name, String collection, double price, double numberOfMeters, String description) {
        super(id, name, collection, price, ProductType.Bat, description);
        this.numberOfMeters = numberOfMeters;
    }

    public double getNumberOfMeters() {
        return numberOfMeters;
    }

    public void setNumberOfMeters(double numberOfMeters) {
        this.numberOfMeters = numberOfMeters;
    }

    @Override
    public String toString() {
        return "Bạt {" + toStringBody() + " numberOfMeters: " + numberOfMeters + "}";
    }

    @Override
    public String toCsv() {
        return String.join(",", "Bat",
                String.valueOf(getId()), getName(), getCollection(), String.valueOf(getPrice()),
                String.valueOf(numberOfMeters), getDescription());
    }
}
