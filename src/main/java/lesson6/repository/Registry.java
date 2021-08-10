package lesson6.repository;

import lesson6.sql.ConnectionService;
import lesson6.sql.ProductMapper;

public class Registry {
    private static Registry instance = new Registry();
    public static Registry getInstance() {
        return instance;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    protected ProductRepository productRepository = new ProductRepository();

}
