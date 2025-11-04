package product_selling.entity;

enum ProductType { Bao, Bat }

public class Product {
    private int id;
    private String name;
    private String collection;
    private double price;
    protected final ProductType type;

    public Product(int id, String name, String collection, double price, ProductType type) {
        this.id = id;
        this.name = name;
        this.collection = collection;
        this.price = price;
        this.type = type;
    }

    public ProductType getType() {
        return type;
    }

    public String label() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected String toStringBody() {
        return "type =" + type + ", id =" + id + ", name =" + name + ", collection =" + collection + ", price =" + price;
    }

    @Override
    public String toString() {
        return "Product{" + toStringBody() + "}";
    }

    public String toCsv() {
        return String.join(",", "PRODUCT", String.valueOf(getId()), getName(), getCollection(), String.valueOf(getPrice()));
    }
}
