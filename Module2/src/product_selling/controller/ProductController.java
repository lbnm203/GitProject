package product_selling.controller;
import product_selling.common.exception.IdDuplicatedException;
import product_selling.entity.Product;
import product_selling.service.ProductAdminService;

import java.util.List;

public class ProductController {
    private ProductAdminService service = new ProductAdminService();

    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    public void addProduct(Product p) {
        service.addProduct(p);
    }

    public void deleteProduct(int id) {
        service.deleteProduct(id);
    }

    public void editProduct(int id, String name, String collection, double price) {
        service.editProduct(id, name, collection, price);
    }

    public boolean checkDuplicateId(int id) throws IdDuplicatedException {
        return service.isDuplicateId(id);
    }

    public Product findById(int id){
        return service.findById(id);
    }

}
