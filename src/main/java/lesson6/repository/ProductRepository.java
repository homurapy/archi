package lesson6.repository;

import lesson6.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private static Map<Long, Product> productMap = new HashMap();

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public Product getProduct(Long key) {
        return productMap.get(key);
    }
}
