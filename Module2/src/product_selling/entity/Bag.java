package product_selling.entity;

public class Bag extends Product{
    private int numberOfItems;


    public Bag(int id, String name, String collection, double price, int numberOfItems) {
        super(id, name, collection, price, ProductType.Bao);
        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public String toString() {
        return "Bao {" + toStringBody() + " numberOfItems: " + numberOfItems + "}";
    }

    @Override
    public String toCsv() {
        return String.join(",", "Bao",
                String.valueOf(getId()), getName(), getCollection(), String.valueOf(getPrice()),
                String.valueOf(numberOfItems));
    }
}
