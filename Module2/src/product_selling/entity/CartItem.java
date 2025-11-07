package product_selling.entity;

public class CartItem {
    private Product product;
    private double quantity;

    public CartItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x %d = %.2f", product, quantity, getTotalPrice());
    }

    public String toCsv() {
        return product.toCsv() + "," + quantity;
    }
}
